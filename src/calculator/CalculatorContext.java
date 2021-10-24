package calculator;

import calculator.states.*;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorContext {

    CalculatorState state;
    public String problem;
    public int pointer;
    public char c;
    public int n;
    public int t;
    public int p;
    public ArrayList<Integer> ApprovedFirstDigit = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5,6,7,8,9));
    public ArrayList<Integer> ApprovedNumberBuildingDigits = new ArrayList<>(Arrays.asList(0,1, 2, 3, 4, 5,6,7,8,9));
    public ArrayList<Character> ApprovedNumberBuildingOperators = new ArrayList<>(Arrays.asList('+','-'));
    public String errorMessage;


    public CalculatorContext() {
        state = InitialState.instance();
        pointer = 0;
        c = 48;
        n = 0;
        t = 0;
        p = 1;
        errorMessage = "";
    }

    public void changeState(CalculatorState s) {
        state = s;
    }

    public void solve(String input) {
        problem = input;

        System.out.println("Problem to solve is " + problem + "\n");

        while(pointer < problem.length()+1){
            state.printState(this);
            state.processInput(this);
        }
    }
}
