package com.example.dumchev.presentationmodel.presentation.start

import com.example.dumchev.presentationmodel.R
import com.example.dumchev.presentationmodel.data.IRepository
import com.example.dumchev.presentationmodel.injection.main.MainScope
import com.example.dumchev.presentationmodel.presentation.base.BasePresentationModel
import com.jakewharton.rxrelay2.BehaviorRelay
import com.jakewharton.rxrelay2.PublishRelay
import com.jakewharton.rxrelay2.Relay
import javax.inject.Inject

@MainScope
class StartPresentationModel @Inject constructor(
        repo: IRepository<Int>) : BasePresentationModel(), IStartPresentationModel {

    override val message: Relay<Int> = PublishRelay.create()
    override val goToSecondScreenCommand: Relay<Unit> = PublishRelay.create()
    override val luckyNumbers: Relay<List<Int>> = BehaviorRelay.create()
    override val bgColor: Relay<Int> = BehaviorRelay.create()
    override val screenTouch: Relay<Unit> = PublishRelay.create()
    override val nextButtonPressed: Relay<Unit> = PublishRelay.create()

    init {
        message.accept(R.string.presenter_created)
        bgColor.accept(R.color.colorPrimary)
        repo.provide().bind { numbers -> luckyNumbers.accept(numbers) }

        screenTouch.bind { message.accept(R.string.screen_touch) }
        nextButtonPressed.bind { goToSecondScreenCommand.accept(Unit) }
    }

    override fun bind() {
        message.accept(R.string.view_attached)
    }
}