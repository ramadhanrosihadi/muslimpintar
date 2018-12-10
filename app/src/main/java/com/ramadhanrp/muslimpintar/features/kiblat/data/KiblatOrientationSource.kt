package com.ramadhanrp.muslimpintar.features.kiblat.data

import android.hardware.Sensor
import android.hardware.SensorManager
import com.ramadhanrp.muslimpintar.core.Constants
import com.ramadhanrp.muslimpintar.core.di.scopes.AppScoped
import com.ramadhanrp.muslimpintar.features.kiblat.reactiveSensor.ReactiveSensor
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@AppScoped
class KiblatOrientationSource @Inject constructor(reactiveSensor: ReactiveSensor){
    val mReactiveSensor: ReactiveSensor = reactiveSensor
    var currentPosition: GeoPosition = Constants.GEOPOSITION_SURABAYA
    var destinationPosition: GeoPosition = Constants.GEOPOSITION_KAABA

    var lastDestinationAzimuth: Float = 0.0f
    var lastNorthPoleAzimuth: Float = 0.0f

    var mGravity = FloatArray(3)
    var mGeomagnetic = FloatArray(3)
    var R = FloatArray(9)
    var I = FloatArray(9)
    val alpha = 0.97f

    fun getOrientation(): Flowable<KiblatOrientation>{
        println("KiblatOrientationSource getOrientation")
        return mReactiveSensor.observeSensors(
            Sensor.TYPE_ACCELEROMETER,
            Sensor.TYPE_MAGNETIC_FIELD,
            SensorManager.SENSOR_DELAY_GAME,
            null,
            BackpressureStrategy.BUFFER)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap{
                val compassOrientation = KiblatOrientation()
                when(it.sensor.type){
                    Sensor.TYPE_ACCELEROMETER -> {
                        for (x in 0..mGravity.size) mGravity[x] = alpha * mGravity[x] + (1-alpha) * it.values[0]
                    }
                    Sensor.TYPE_MAGNETIC_FIELD -> {
                        for (x in 0..mGeomagnetic.size) mGeomagnetic[x] = alpha * mGeomagnetic[x] + (1-alpha) * it.values[0]
                    }
                }
                if (SensorManager.getRotationMatrix(R,I,mGravity,mGeomagnetic)){
                    val orientation = FloatArray(3)
                    SensorManager.getOrientation(R, orientation)

                    val azimuth = ((Math.toDegrees(orientation[0].toDouble())+360)%360).toFloat()
                    compassOrientation.lastNorthPoleDirection = lastNorthPoleAzimuth
                    compassOrientation.northPoleDirection = azimuth
                    lastNorthPoleAzimuth = azimuth

                    val destinationAzimuth = bearing(currentPosition.latitude,currentPosition.longitude,
                        destinationPosition.latitude,destinationPosition.longitude)
                    compassOrientation.destinationDirection = destinationAzimuth.toFloat()
                    compassOrientation.lastDestinationDirection = lastDestinationAzimuth
                    lastDestinationAzimuth = destinationAzimuth.toFloat()

                }
                Flowable.just(compassOrientation)
            }

    }

    fun bearing(startLat: Double, startLng: Double, endLat: Double, endLng: Double): Double {
        val latitude1 = Math.toRadians(startLat)
        val latitude2 = Math.toRadians(endLat)
        val longDiff = Math.toRadians(endLng - startLng)
        val y = Math.sin(longDiff) * Math.cos(latitude2)
        val x = Math.cos(latitude1) * Math.sin(latitude2) - Math.sin(latitude1) * Math.cos(latitude2) * Math.cos(longDiff)
        return (Math.toDegrees(Math.atan2(y, x)) + 360) % 360
    }

}