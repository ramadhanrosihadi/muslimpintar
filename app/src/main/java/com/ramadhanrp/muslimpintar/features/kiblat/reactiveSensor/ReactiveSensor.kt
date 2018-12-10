package com.ramadhanrp.muslimpintar.features.kiblat.reactiveSensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import android.os.Handler
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableOnSubscribe

class ReactiveSensor constructor(context: Context){
    val sensorManager: SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val sensors: List<Sensor> get() = sensorManager.getSensorList(Sensor.TYPE_ALL)

    fun hasSensor(sensorType: Int): Boolean{
        return sensorManager.getDefaultSensor(sensorType) != null
    }

    fun observeSensors(sensorType1: Int,
                       sensorType2: Int,
                       samplingPeriodInUs: Int,
                       handler: Handler? = null,
                       strategy: BackpressureStrategy = BackpressureStrategy.BUFFER) : Flowable<SensorEvent>{
        if (!hasSensor(sensorType1)) return Flowable.error(Exception("Sensors with id = $sensorType1 are not available on this device"))
        if (!hasSensor(sensorType2)) return Flowable.error(Exception("Sensors with id = $sensorType2 are not available on this device"))
        val sensor1 = sensorManager.getDefaultSensor(sensorType1)
        val sensor2 = sensorManager.getDefaultSensor(sensorType2)

        val wrapper  = SensorEventListenerWrapper()
        val listener = wrapper.create()

        return Flowable.create(FlowableOnSubscribe<SensorEvent> { emitter ->
            wrapper.emitter = emitter
            sensorManager.registerListener(listener,sensor1,samplingPeriodInUs,handler)
            sensorManager.registerListener(listener,sensor2,samplingPeriodInUs,handler)
        },strategy).doOnCancel { sensorManager.unregisterListener(listener) }
    }
}