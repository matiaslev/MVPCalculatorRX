package com.globant.counter.android.mvp.model;

public class SumOperationClass implements OperationInterface{
    @Override
    public String getOperationType() {
        return "+";
    }

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
