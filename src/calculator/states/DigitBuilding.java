package calculator.states;

import calculator.CalculatorContext;

public class DigitBuilding extends CalculatorState{
    private static DigitBuilding theOnlyOne;

    private DigitBuilding() {
        name = "DIGIT BUILDING STATE";

    }

    public synchronized static DigitBuilding instance() {
        if (theOnlyOne == null) {
            theOnlyOne = new DigitBuilding();
        }
        return theOnlyOne;
    }

    public void processInput(CalculatorContext calc){
        calc.n = calc.n*10+Character.getNumericValue(calc.c);
        changeState(calc,FirstInput.instance());
    }

    public void printState(CalculatorContext calc){
        System.out.println(name);
        System.out.printf("C = %s, ", calc.c);
        System.out.printf("N = %s, ", calc.n);
        System.out.printf("T = %s, ", calc.t);
        System.out.printf("P = %s\n", calc.p);
        System.out.println("----------------------------------\n");
    }

    public void changeState(CalculatorContext calc, CalculatorState s){
        calc.changeState(s);
    }
}
