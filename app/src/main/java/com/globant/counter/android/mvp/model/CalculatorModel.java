package com.globant.counter.android.mvp.model;

public class CalculatorModel {

    public int calculate(int firstNumber, String operationType, int secondNumber) throws Exception {
        OperationInterface operation = new SumOperationClass();
        // will be a list of operations
        if (operationType.equals(operation.getOperationType())) {
            return operation.calculate(firstNumber, secondNumber);
        }
        throw new Exception("Operation Not Supported");
    }

}
