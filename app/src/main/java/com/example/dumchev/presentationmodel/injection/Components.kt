package com.example.dumchev.presentationmodel.injection

import com.example.dumchev.presentationmodel.injection.common.AppComponent
import com.example.dumchev.presentationmodel.injection.common.DaggerAppComponent
import com.example.dumchev.presentationmodel.injection.main.MainComponent

object Components {

    private val appComponent: AppComponent by lazy { DaggerAppComponent.builder().build() }

    private var mainComponent: MainComponent? = null

    fun mainComponent(): MainComponent = mainComponent ?:
            appComponent.mainComponentBuilder().build().apply { mainComponent = this }
}