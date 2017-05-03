package com.example.dumchev.presentationmodel.presentation.start

import com.example.dumchev.presentationmodel.R
import com.example.dumchev.presentationmodel.data.IRepository
import com.example.dumchev.presentationmodel.injection.main.MainScope
import com.example.dumchev.presentationmodel.presentation.base.BasePresentationModel
import com.jakewharton.rxrelay2.BehaviorRelay
import com.jakewharton.rxrelay2.PublishRelay
import com.jakewharton.rxrelay2.Relay
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import javax.inject.Inject

@MainScope
class StartPresentationModel @Inject constructor(
        repo: IRepository<Int>) : BasePresentationModel(), IStartPresentationModel {

    // single event
    private val messageRelay: Relay<Int> = PublishRelay.create()
    private val goToSecondRelay: Relay<Unit> = PublishRelay.create()
    private val screenTouchRelay: Relay<Unit> = PublishRelay.create()
    private val nextButtonRelay: Relay<Unit> = PublishRelay.create()

    // persisting events
    private val luckyNumbersRelay: Relay<List<Int>> = BehaviorRelay.create()
    private val bgColorRelay: Relay<Int> = BehaviorRelay.create()

    init {
        messageRelay.accept(R.string.presenter_created)
        bgColorRelay.accept(R.color.colorPrimary)
        repo.provide().bind { numbers -> luckyNumbersRelay.accept(numbers) }

        screenTouchRelay.bind { messageRelay.accept(R.string.screen_touch) }
        nextButtonRelay.bind { goToSecondRelay.accept(Unit) }
    }


    override fun bind() {
        messageRelay.accept(R.string.view_attached)
    }

    // api
    override val message: Observable<Int> = messageRelay
    override val goToSecondCommand: Observable<Unit> = goToSecondRelay
    override val luckyNumbers: Observable<List<Int>> = luckyNumbersRelay
    override val bgColor: Observable<Int> = bgColorRelay
    override val screenTouch: Consumer<Unit> = screenTouchRelay
    override val nextButtonPressed: Consumer<Unit> = nextButtonRelay
}