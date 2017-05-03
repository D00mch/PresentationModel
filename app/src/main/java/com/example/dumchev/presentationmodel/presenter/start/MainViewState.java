package com.example.dumchev.presentationmodel.presenter.start;

import com.example.dumchev.presentationmodel.presenter.base.BaseViewState;

import java.util.List;

/**
 * TODO: Add description
 *
 * @author dumchev on 04.05.17.
 */

public class MainViewState extends BaseViewState<IMainView> implements IMainView {

    private int color = -1;
    private List<Integer> numbers;

    @Override
    public void restore() {
        if (view == null) return;
        if (color > 0) view.setBgColor(color);
        if (numbers != null) view.showLuckNumbers(numbers);
    }

    @Override
    public void showMessage(int stringRes) {
        if (view != null) view.showMessage(stringRes);
    }

    @Override
    public void goToSecondScreen() {
        if (view != null) view.goToSecondScreen();

    }

    @Override
    public void showLuckNumbers(List<Integer> numbers) {
        this.numbers = numbers;
        if (numbers != null) view.showLuckNumbers(numbers);
    }

    @Override
    public void setBgColor(int bgColor) {
        color = bgColor;
        if (view != null) view.setBgColor(bgColor);
    }
}
