package com.globant.counter.android.util.bus.observers;

public abstract class EqualsButtonPressedObserver extends BusObserver<EqualsButtonPressedObserver.EqualsButton> {
    public EqualsButtonPressedObserver() {
        super(EqualsButton.class);
    }

    public static class EqualsButton {
        public int firstNumber;
        public String operationType;
        public int secondNumber;

        public EqualsButton(int firstNumber, String operationType, int secondNumber) {
            this.firstNumber = firstNumber;
            this.operationType = operationType;
            this.secondNumber = secondNumber;
        }
    }
}