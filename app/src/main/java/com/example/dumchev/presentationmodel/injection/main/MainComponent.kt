package com.example.dumchev.presentationmodel.injection.main

import com.example.dumchev.presentationmodel.presentation.start.MainActivity
import dagger.Subcomponent


@MainScope
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {

    fun inject(activity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        fun mainModule(module: MainModule): MainComponent.Builder
        fun build(): MainComponent
    }
}