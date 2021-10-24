package calculator.states;

import calculator.CalculatorContext;

public class CalculatorState{

    protected String name;

    public CalculatorState(){}

    public void processInput(CalculatorContext c){}

    public void printState(CalculatorContext c){
    }

    public void changeState(CalculatorContext c, CalculatorState s){}
}
