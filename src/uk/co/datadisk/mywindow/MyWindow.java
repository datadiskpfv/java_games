package uk.co.datadisk.mywindow;

import com.godtsoft.diyjava.DIYWindow;

/**
 * Created by vallep on 11/07/2017.
 *
 */
public class MyWindow extends DIYWindow {

    protected int promptForInt(String prompt) {
        int i;
        print(prompt);
        String s = input();
        try {
            i = Integer.parseInt(s);
        } catch(NumberFormatException e) {
            print(s + " is not a valid number. Try again.");
            i = promptForInt(prompt);
        }
        return i;
    }

    protected double promptForDouble(String prompt) {
        double d;
        print(prompt);
        String s = input();
        try {
            d = Double.parseDouble(s);
        } catch(NumberFormatException e) {
            print(s + " is not a valid number. Try again.");
            d = promptForDouble(prompt);
        }
        return d;
    }

    protected String promptForString(String prompt) {
        print(prompt);
        String s = input();
        return s;
    }

}
