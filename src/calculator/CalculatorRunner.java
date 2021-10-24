package calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalculatorRunner {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Hello World!");

        Scanner sc = new Scanner(new File("src/calculator/input.txt"));

        while (sc.hasNextLine()) {
            CalculatorContext calculator = new CalculatorContext();
            calculator.solve(sc.nextLine());
        }
        System.out.println("Calculator has run all problems in input file. Ending program run.");
    }
}
