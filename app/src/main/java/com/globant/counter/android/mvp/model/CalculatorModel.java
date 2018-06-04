package com.globant.counter.android.mvp.model;

public class CalculatorModel {

    public int calculate(int firstNumber, String operationType, int secondNumber) throws Exception {
        switch (operationType) {
            case "+":
                return firstNumber + secondNumber;
            default:
                throw new Exception("Operation Not Supported");
        }
    }

}
