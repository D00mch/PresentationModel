package com.example.dumchev.presentationmodel.presentation.start

import com.example.dumchev.presentationmodel.presentation.base.IPresentationModel
import io.reactivex.Observable
import io.reactivex.functions.Consumer

interface IStartPresentationModel : IPresentationModel {

    val message: Observable<Int>
    val goToSecondCommand: Observable<Unit>
    val luckyNumbers: Observable<List<Int>>
    val bgColor: Observable<Int>

    val screenTouch: Consumer<Unit>
    val nextButtonPressed: Consumer<Unit>
}