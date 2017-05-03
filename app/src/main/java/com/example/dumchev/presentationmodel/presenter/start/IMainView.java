package com.example.dumchev.presentationmodel.presenter.start;

import java.util.List;

public interface IMainView {

    void showMessage(int stringRes);

    void goToSecondScreen();

    void showLuckNumbers(List<Integer> numbers);

    void setBgColor(int bgColor);
}
