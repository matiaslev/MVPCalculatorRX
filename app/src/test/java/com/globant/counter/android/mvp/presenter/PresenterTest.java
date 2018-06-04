package com.globant.counter.android.mvp.presenter;

import com.globant.counter.android.mvp.model.CalculatorModel;
import com.globant.counter.android.mvp.view.CalculatorView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PresenterTest {

    private CalculatorPresenter presenter;
    @Mock
    CalculatorModel model;
    @Mock
    CalculatorView view;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new CalculatorPresenter(model, view);
    }

    @Test
    public void shouldSum() throws Exception {
        int firstNumber = 12;
        int secondNumber = 12;
        String operationType = "+";
        when(model.calculate(firstNumber, operationType, secondNumber)).thenReturn(24);
        presenter.onEqualsButtonPressed(firstNumber, operationType, secondNumber);
        verify(model).calculate(firstNumber, operationType, secondNumber);
        verify(view).showResult("24");
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldWarnWrongOperations() throws Exception {
        int firstNumber = 12;
        int secondNumber = 12;
        String operationType = "wrong";
        when(model.calculate(firstNumber, operationType, secondNumber))
                .thenThrow(new Exception("Operation Not Supported"));
        presenter.onEqualsButtonPressed(firstNumber, operationType, secondNumber);
        verify(model).calculate(firstNumber, operationType, secondNumber);
        verify(view).showResult("Operation Not Supported");
        verifyNoMoreInteractions(view);
    }

}