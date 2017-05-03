package com.example.dumchev.presentationmodel.injection.common

import com.example.dumchev.presentationmodel.injection.main.MainComponent
import javax.inject.Singleton

@Singleton
@dagger.Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun mainComponentBuilder(): MainComponent.Builder
}