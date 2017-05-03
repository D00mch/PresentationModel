package com.example.dumchev.presentationmodel.data

import io.reactivex.Observable

class NumbersRepo : IRepository<Int> {

    override fun provide(): Observable<List<Int>> {
        return Observable.just(listOf(1, 3, 7, 13, 27, 73))
    }
}