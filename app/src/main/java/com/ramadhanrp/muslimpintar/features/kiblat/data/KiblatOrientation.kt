package com.ramadhanrp.muslimpintar.features.kiblat.data

data class KiblatOrientation(
    var northPoleDirection: Float = 0.0f,
    var lastNorthPoleDirection: Float = 0.0f,
    var destinationDirection: Float = 0.0f,
    var lastDestinationDirection: Float = 0.0f
)