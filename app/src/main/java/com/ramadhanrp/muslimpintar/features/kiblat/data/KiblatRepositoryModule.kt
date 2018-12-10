package com.ramadhanrp.muslimpintar.features.kiblat.data

import com.ramadhanrp.muslimpintar.core.di.scopes.AppScoped
import com.ramadhanrp.muslimpintar.features.kiblat.data.KiblatOrientationDataSource
import com.ramadhanrp.muslimpintar.features.kiblat.data.KiblatOrientationSource
import com.ramadhanrp.muslimpintar.features.kiblat.data.KiblatOrientationSourceModule
import com.ramadhanrp.muslimpintar.features.kiblat.reactiveSensor.ReactiveSensor
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(KiblatOrientationSourceModule::class))

class KiblatRepositoryModule{
    @Provides
    @AppScoped
    internal fun provideCompassOrientationSource(reactiveSensor: ReactiveSensor): KiblatOrientationSource {
        return KiblatOrientationSource(reactiveSensor)
    }

}