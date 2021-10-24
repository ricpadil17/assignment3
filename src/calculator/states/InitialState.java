package calculator.states;

import calculator.CalculatorContext;

public class InitialState extends  CalculatorState{

    private static InitialState theOnlyOne;

    private InitialState() {
        name = "INITIAL STATE";
    }

    public synchronized static InitialState instance() {
        if (theOnlyOne == null) {
            theOnlyOne = new InitialState();
        }
        return theOnlyOne;
    }

    public void processInput(CalculatorContext calc){
        calc.c = calc.problem.charAt(calc.pointer);
        calc.n = Character.getNumericValue(calc.c);

        calc.pointer ++;

        if(calc.ApprovedFirstDigit.contains(Character.getNumericValue(calc.c))){
            changeState(calc,FirstInput.instance());
        }
        else{
            calc.errorMessage = "INCORRECT INPUT \'" + calc.c + "\' FOR THE INITIAL VALUE OF THE NUMBER. Expected a Digit [1-9]";
            changeState(calc,ErrorState.instance());
        }
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
