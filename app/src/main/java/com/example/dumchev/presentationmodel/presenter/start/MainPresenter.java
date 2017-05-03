package com.example.dumchev.presentationmodel.presenter.start;

import android.support.annotation.NonNull;

import com.example.dumchev.presentationmodel.R;
import com.example.dumchev.presentationmodel.data.IRepository;
import com.example.dumchev.presentationmodel.injection.main.MainScope;
import com.example.dumchev.presentationmodel.presenter.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;


@MainScope
public class MainPresenter extends BasePresenter<IMainView, MainViewState> {

    private final IRepository<Integer> repository;

    @Inject
    public MainPresenter(@NonNull final MainViewState viewState, IRepository<Integer> repository) {
        super(viewState);
        this.repository = repository;

        viewState.showMessage(R.string.presenter_created);
        viewState.setBgColor(R.color.colorPrimary);
        bindViewAction(repository.provide(), new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) throws Exception {
                viewState.showLuckNumbers(integers);
            }
        });
    }

    @Override
    public void bind(@NonNull IMainView iMainView) {
        super.bind(iMainView);
        viewState.showMessage(R.string.view_attached);
    }

    void screenTouch() {
        viewState.showMessage(R.string.screen_touch);
    }

    void nextButtonPressed() {
        viewState.goToSecondScreen();
    }
}
