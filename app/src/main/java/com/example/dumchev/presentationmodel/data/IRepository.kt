package com.example.dumchev.presentationmodel.data

import io.reactivex.Observable

interface IRepository<T> {
    fun provide(): Observable<List<T>>
}