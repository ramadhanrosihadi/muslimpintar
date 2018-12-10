package com.ramadhanrp.muslimpintar.features.kiblat

import android.arch.lifecycle.ViewModel
import com.ramadhanrp.muslimpintar.features.kiblat.data.GeoPosition
import com.ramadhanrp.muslimpintar.features.kiblat.data.KiblatOrientation
import com.ramadhanrp.muslimpintar.features.kiblat.data.KiblatRepository
import io.reactivex.Flowable
import io.reactivex.Single

class KiblatViewModel constructor(val kiblatRepository: KiblatRepository): ViewModel(){

    fun getKiblatOrientation(): Flowable<KiblatOrientation>{
        return kiblatRepository.getKiblatOrientation()
    }

    fun getDestinationPosition(): Single<GeoPosition>{
        return kiblatRepository.getDestinationPosition()
    }
}