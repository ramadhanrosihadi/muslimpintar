package com.ramadhanrp.muslimpintar.features.kiblat.data

import com.ramadhanrp.muslimpintar.core.di.scopes.AppScoped
import com.ramadhanrp.muslimpintar.features.kiblat.data.GeoPosition
import com.ramadhanrp.muslimpintar.features.kiblat.data.KiblatOrientation
import com.ramadhanrp.muslimpintar.features.kiblat.data.KiblatOrientationDataSource
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

@AppScoped
class KiblatRepository
@Inject constructor(val kiblatOrientationDataSource: KiblatOrientationDataSource)
    : KiblatOrientationDataSource{

    override fun getKiblatOrientation(): Flowable<KiblatOrientation> {
        return kiblatOrientationDataSource.getKiblatOrientation()
    }

    override fun getDestinationPosition(): Single<GeoPosition> {
        return kiblatOrientationDataSource.getDestinationPosition()
    }

    override fun updateDestinationPosition(geoPosition: GeoPosition) {
        kiblatOrientationDataSource.updateDestinationPosition(geoPosition)
    }

    override fun updateCurrentPosition(geoPosition: GeoPosition) {
        kiblatOrientationDataSource.updateCurrentPosition(geoPosition)
    }

}