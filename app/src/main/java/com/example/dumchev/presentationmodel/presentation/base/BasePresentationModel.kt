package com.example.dumchev.presentationmodel.presentation.base

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

/**
 * TODO: Add description
 *
 * @author dumchev on 04.05.17.
 */
abstract class BasePresentationModel : IPresentationModel{
    private val subscriptions = CompositeDisposable()

    override fun unbind() {
        subscriptions.clear()
    }

    fun <T> Observable<T>.bind(action: (T) -> Unit) {
        subscriptions.add(subscribe(action, { e -> println("base error handling, $e")}))
    }
}