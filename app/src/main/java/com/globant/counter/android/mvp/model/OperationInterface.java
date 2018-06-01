package com.globant.counter.android.mvp.model;

public interface OperationInterface {
    String getOperationType();
    int calculate(int a, int b);
}
