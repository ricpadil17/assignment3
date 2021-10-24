package calculator.states;

import calculator.CalculatorContext;

public class EndState extends CalculatorState{
    private static EndState theOnlyOne;

    private EndState() {
        name = "END STATE";

    }

    public synchronized static EndState instance() {
        if (theOnlyOne == null) {
            theOnlyOne = new EndState();
        }
        return theOnlyOne;
    }

    public void processInput(CalculatorContext calc){
        calc.t = calc.t+calc.p*calc.n;
        System.out.println("Problem: " + calc.problem);
        System.out.println("Solution: " + calc.t + "\n\n\n\n\n");
        calc.pointer++;
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
