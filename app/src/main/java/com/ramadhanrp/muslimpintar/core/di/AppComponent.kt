package com.ramadhanrp.muslimpintar.core.di

import android.app.Application
import com.ramadhanrp.muslimpintar.core.App
import com.ramadhanrp.muslimpintar.core.di.scopes.AppScoped
import com.ramadhanrp.muslimpintar.features.kiblat.data.KiblatRepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@AppScoped
@Component(modules = [
AppModule::class,
KiblatRepositoryModule::class
])
interface AppComponent: AndroidInjector<App>{

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): AppComponent.Builder
        fun build(): AppComponent
    }
}