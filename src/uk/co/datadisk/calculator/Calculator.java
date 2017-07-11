package uk.co.datadisk.calculator;

import uk.co.datadisk.mywindow.MyWindow;

/**
 * Created by vallep on 11/07/2017.
 *
 */
public class Calculator extends MyWindow {
    public Calculator() {
        String s = "y";

        while (s.startsWith("y") || s.startsWith("Y")) {
            double a = promptForDouble("Enter a number: ");
            String operation = promptForString("Enter a operation");
            double b = promptForDouble("Enter another number: ");

            double c;
            switch(operation) {
                case "+":
                    c = a + b;
                    print(a + " + " + b + " = " + c);
                    break;
                case "*":
                    c = a * b;
                    print(a + " * " + b + " = " + c);
                    break;
                case "-":
                    c = a - b;
                    print(a + " - " + b + " = " + c);
                    break;
                case "/":
                    try {
                        c = a / b;
                        print(a + " / " + b + " = " + c);
                    } catch (ArithmeticException e ) {
                        print("Division by zero is not allowed.");
                    }
                    break;
            }

            s = promptForString("Do you want to add more numbers? ");

         }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
