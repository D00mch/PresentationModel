package com.example.dumchev.presentationmodel.injection.main

import com.example.dumchev.presentationmodel.presentation.start.MainActivity
import com.example.dumchev.presentationmodel.presenter.start.Main2Activity
import dagger.Subcomponent


@MainScope
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {

    fun inject(activity: MainActivity)
    fun inject(activity: Main2Activity)

    @Subcomponent.Builder
    interface Builder {
        fun mainModule(module: MainModule): MainComponent.Builder
        fun build(): MainComponent
    }
}