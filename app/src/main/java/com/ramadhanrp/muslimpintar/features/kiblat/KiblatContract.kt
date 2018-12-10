package com.ramadhanrp.muslimpintar.features.kiblat

import com.ramadhanrp.muslimpintar.core.base.BaseView
import com.ramadhanrp.muslimpintar.features.kiblat.data.GeoPosition
import com.ramadhanrp.muslimpintar.features.kiblat.data.KiblatOrientation

interface KiblatContract{
    interface View: BaseView{
        fun updateDirections(kiblatOrientation: KiblatOrientation)
    }
}