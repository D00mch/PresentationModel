package com.example.dumchev.presentationmodel.presenter.start;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dumchev.presentationmodel.R;
import com.example.dumchev.presentationmodel.injection.Components;

import java.util.List;

import javax.inject.Inject;

public class Main2Activity extends AppCompatActivity implements IMainView {

    @Inject MainPresenter presenter;

    private RelativeLayout rootLayout;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Components.INSTANCE.mainComponent().inject(this);
        setContentView(R.layout.activity_main);

        rootLayout = (RelativeLayout) findViewById(R.id.rootLayout);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.nextButtonPressed();
            }
        });

        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.screenTouch();
            }
        });
    }

    @Override
    public void showMessage(int stringRes) {
        showSnack(getString(stringRes));
    }

    @Override
    public void goToSecondScreen() {
        showSnack("about to go to next screen");
    }

    public void showSnack(String msg) {
        Snackbar.make(rootLayout, msg, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showLuckNumbers(List<Integer> numbers) {
        textView.setText(numbers.toString());
    }

    @Override
    public void setBgColor(int bgColor) {
        rootLayout.setBackgroundColor(getResources().getColor(bgColor));
    }
}
