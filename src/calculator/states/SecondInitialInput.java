package calculator.states;

import calculator.CalculatorContext;

public class SecondInitialInput extends CalculatorState{
    private static SecondInitialInput theOnlyOne;

    private SecondInitialInput() {
        name = "SECOND INITIAL INPUT STATE";

    }

    public synchronized static SecondInitialInput instance() {
        if (theOnlyOne == null) {
            theOnlyOne = new SecondInitialInput();
        }
        return theOnlyOne;
    }

    public void processInput(CalculatorContext calc){

        //calculate total
        calc.t = calc.t+calc.p*calc.n;

        //adjust polarity
        if(calc.c == '+'){
            calc.p = 1;
        }
        else if(calc.c == '-'){
            calc.p = -1;
        }

        calc.c = calc.problem.charAt(calc.pointer);
        calc.n = Character.getNumericValue(calc.c);
        calc.pointer++;

        if(calc.ApprovedFirstDigit.contains(Character.getNumericValue(calc.c))){
            changeState(calc,FirstInput.instance());
        }
        else if(calc.c == '='){
            calc.errorMessage = "ERROR: \'" + calc.c + "\' EOF symbol encountered. Expected beginning of a new number";
            changeState(calc,ErrorState.instance());
        }
        else{
            calc.errorMessage = "INCORRECT INPUT \'" + calc.c + "\' FOR THE INITIAL VALUE OF A NUMBER. Expected a Digit [1-9]";
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
