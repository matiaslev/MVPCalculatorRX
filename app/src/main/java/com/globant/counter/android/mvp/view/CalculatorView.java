package com.globant.counter.android.mvp.view;

import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

import com.globant.counter.android.R;
import com.globant.counter.android.util.bus.observers.EqualsButtonPressedObserver;
import com.globant.counter.android.util.bus.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculatorView extends ActivityView {

    @BindView(R.id.editText_first_number) TextView editTextFirstNumber;
    @BindView(R.id.editText_operation) TextView editTextOperation;
    @BindView(R.id.editText_second_number) TextView editTextSecondNumber;

    public CalculatorView(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void showResult(String result) {
        Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.button_equals)
    public void equalsButtonPressed() {
        RxBus.post(new EqualsButtonPressedObserver.EqualsButton(
                Integer.parseInt(editTextFirstNumber.getText().toString()),
                editTextOperation.getText().toString(),
                Integer.parseInt(editTextSecondNumber.getText().toString()
        )));
    }

}
