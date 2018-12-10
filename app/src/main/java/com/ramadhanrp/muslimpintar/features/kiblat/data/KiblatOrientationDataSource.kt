package com.ramadhanrp.muslimpintar.features.kiblat.data

import io.reactivex.Flowable
import io.reactivex.Single

interface KiblatOrientationDataSource{
    fun getKiblatOrientation(): Flowable<KiblatOrientation>
    fun getDestinationPosition(): Single<GeoPosition>
    fun updateDestinationPosition(geoPosition: GeoPosition)
    fun updateCurrentPosition(geoPosition: GeoPosition)
}