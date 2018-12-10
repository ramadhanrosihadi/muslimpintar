package com.ramadhanrp.muslimpintar.features.kiblat.data

import android.app.Application
import com.ramadhanrp.muslimpintar.core.di.scopes.AppScoped
import com.ramadhanrp.muslimpintar.features.kiblat.reactiveSensor.ReactiveSensor
import dagger.Module
import dagger.Provides

@Module
class KiblatOrientationSourceModule{
    @AppScoped
    @Provides
    internal fun provideReactiveSensors(context: Application): ReactiveSensor {
        return ReactiveSensor(context)
    }
}