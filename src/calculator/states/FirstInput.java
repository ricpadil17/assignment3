package calculator.states;

import calculator.CalculatorContext;

public class FirstInput extends CalculatorState{

    private static FirstInput theOnlyOne;

    private FirstInput() {
        name = "FIRST INPUT STATE";
    }

    public synchronized static FirstInput instance() {
        if (theOnlyOne == null) {
            theOnlyOne = new FirstInput();
        }
        return theOnlyOne;
    }

    public void processInput(CalculatorContext calc){
        calc.c = calc.problem.charAt(calc.pointer);
        calc.pointer ++;

        if(calc.ApprovedNumberBuildingDigits.contains(Character.getNumericValue(calc.c))){
            changeState(calc,DigitBuilding.instance());
        }
        else if(calc.ApprovedNumberBuildingOperators.contains(calc.c)){
            changeState(calc,SecondInitialInput.instance());
        }
        else if(calc.c == '='){
            changeState(calc,EndState.instance());
        }
        else {
            calc.errorMessage = "INCORRECT INPUT \'" + calc.c + "\'. Expected a Digit [0-9] or Operators '+','-'.";
            changeState(calc,ErrorState.instance());
        }
    }

    public void printState(CalculatorContext calc){
        System.out.println("FIRST INPUT STATE");
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
