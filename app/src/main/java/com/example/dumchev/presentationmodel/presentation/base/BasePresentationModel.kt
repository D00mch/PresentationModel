package com.example.dumchev.presentationmodel.presentation.base

import com.example.dumchev.presentationmodel.addTo
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * TODO: Add description
 *
 * @author dumchev on 04.05.17.
 */
abstract class BasePresentationModel : IPresentationModel {
    private val subscriptions = CompositeDisposable()

    override fun unbind() {
        subscriptions.clear()
    }

    protected fun <T> Observable<T>.bind(action: (T) -> Unit) {
        subscribeOn(Schedulers.io())
                .subscribe(action, { onError(it) })
                .addTo(subscriptions)
    }

    private fun onError(e: Throwable) = println("base error handling, $e")

}