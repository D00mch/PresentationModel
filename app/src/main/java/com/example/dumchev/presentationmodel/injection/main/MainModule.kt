package com.example.dumchev.presentationmodel.injection.main

import com.example.dumchev.presentationmodel.data.IRepository
import com.example.dumchev.presentationmodel.data.NumbersRepo
import com.example.dumchev.presentationmodel.presenter.start.MainViewState
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @MainScope
    fun provideRepo(): IRepository<Int> = NumbersRepo()

    @Provides
    @MainScope
    fun provideViewState(): MainViewState = MainViewState()
}
