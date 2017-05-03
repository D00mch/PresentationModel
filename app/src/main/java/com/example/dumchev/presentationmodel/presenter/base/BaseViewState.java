package com.example.dumchev.presentationmodel.presenter.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @author jagger on 18.04.17.
 */

public abstract class BaseViewState<View> {

    @Nullable
    protected View view;

    public void bindView(@NonNull View view) {
        this.view = view;
    }

    public void unbindView() {
        view = null;
    }

    public abstract void restore();
}
