package calculator.states;

import calculator.CalculatorContext;

public class ErrorState extends CalculatorState{
    private static ErrorState theOnlyOne;

    private ErrorState() {
        name = "ERROR STATE";

    }

    public synchronized static ErrorState instance() {
        if (theOnlyOne == null) {
            theOnlyOne = new ErrorState();
        }
        return theOnlyOne;
    }

    public void processInput(CalculatorContext calc){
        calc.pointer = calc.problem.length()+1;
    }

    public void printState(CalculatorContext calc){
        System.out.println("ERROR STATE");
        System.out.println("ERROR MESSAGE: " + calc.errorMessage);
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
