package com.globant.counter.android.mvp.presenter;

import android.app.Activity;

import com.globant.counter.android.mvp.model.CalculatorModel;
import com.globant.counter.android.mvp.view.CalculatorView;
import com.globant.counter.android.util.bus.RxBus;
import com.globant.counter.android.util.bus.observers.EqualsButtonPressedObserver;

public class CalculatorPresenter {

    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorPresenter(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void onEqualsButtonPressed(int firstNumber, String operation, int secondNumber) {
        try {
            int result = model.calculate(firstNumber, operation, secondNumber);
            view.showResult(String.valueOf(result));
        } catch (Exception e) {
            view.showResult(e.getMessage());
        }
    }

    public void register() {
        Activity activity = view.getActivity();

        if (activity==null){
            return;
        }

        RxBus.subscribe(activity, new EqualsButtonPressedObserver() {
            @Override
            public void onEvent(EqualsButton value) {
                onEqualsButtonPressed(value.firstNumber, value.operationType, value.secondNumber);
            }
        });

    }

    public void unregister() {
        Activity activity = view.getActivity();

        if (activity==null){
            return;
        }
        RxBus.clear(activity);
    }
}
