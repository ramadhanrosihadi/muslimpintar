package com.ramadhanrp.muslimpintar.features.kiblat.reactiveSensor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import io.reactivex.FlowableEmitter

class SensorEventListenerWrapper {

    var emitter: FlowableEmitter<SensorEvent>? = null

    fun create(): SensorEventListener {

        return object : SensorEventListener {

            override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) { }

            override fun onSensorChanged(sensorEvent: SensorEvent) {
                emitter?.onNext(sensorEvent)
            }

        }
    }

}