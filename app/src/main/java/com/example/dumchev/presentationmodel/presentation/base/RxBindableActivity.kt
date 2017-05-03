package com.example.dumchev.presentationmodel.presentation.base

import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer

/**
 * TODO: Add description
 *
 * @author dumchev on 03.05.17.
 */
abstract class RxBindableActivity<Model : IPresentationModel> : AppCompatActivity() {

    abstract protected val model: Model
    private val subscriptions by lazy { CompositeDisposable() }

    override fun onStart() {
        super.onStart()
        model.bind()
        model.onBind()
    }

    override fun onStop() {
        super.onStop()
        subscriptions.clear()
        model.unbind()
    }

    abstract protected fun Model.onBind()

    protected fun <T> Observable<T>.bindLogic(consumer: Consumer<T>) {
        subscriptions.add(this.subscribe(consumer))
    }

    protected fun <T> Observable<T>.bind(consumer: (T) -> Unit) {
        subscriptions.add(this.subscribe(consumer))
    }
}