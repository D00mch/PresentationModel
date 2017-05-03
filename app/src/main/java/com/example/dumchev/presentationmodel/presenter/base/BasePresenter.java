package com.example.dumchev.presentationmodel.presenter.base;

import android.support.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author jagger on 17.04.17.
 */

public abstract class BasePresenter<View, ViewState extends BaseViewState<View>> {

    @NonNull
    protected ViewState viewState;

    private final CompositeDisposable viewBasedSubscriptions = new CompositeDisposable();

    public BasePresenter(@NonNull ViewState viewState) {
        this.viewState = viewState;
    }

    public void bind(@NonNull View view) {
        viewState.bindView(view);
        viewState.restore();
    }

    public void unbind() {
        viewBasedSubscriptions.clear();
        viewState.unbindView();
    }

    protected <T> void bindViewAction(@NotNull Observable<T> observable,
                                      @NotNull Consumer<T> onNext) {
        viewBasedSubscriptions.add(observable.subscribeOn(Schedulers.io())
                                             .observeOn(AndroidSchedulers.mainThread())
                                             .subscribe(onNext));
    }
}
