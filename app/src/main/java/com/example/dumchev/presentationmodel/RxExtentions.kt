package com.example.dumchev.presentationmodel

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


fun Disposable.addTo(subscriptions: CompositeDisposable) = subscriptions.add(this)

fun String.funf() {
    println("fdsf")
}

fun Bob() {

}