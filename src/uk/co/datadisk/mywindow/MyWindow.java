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
        //String s = input();
        return input();
    }

    protected boolean promptForYesNo(String prompt) {
        boolean yes = true;
        boolean valid = false;

        while(!valid) {
            String answer = promptForString(prompt);
            switch (answer) {
                case "Y":
                case "y":
                    yes = true;
                    valid = true;
                    break;
                case "N":
                case "n":
                    yes = false;
                    valid = true;
                    break;
                default:
                    print(answer + " is an invalid option");
            }
        }
        return yes;
    }

    public String replaceStringAt(String originalString, int index, String replaceString) {
        String newString = originalString;

        int roomAvailable = originalString.length() - index;
        if(replaceString.length() > roomAvailable) {
            replaceString = replaceString.substring(0, roomAvailable);
        }

        if (index < originalString.length()) {
            String firstString = originalString.substring(0, index);
            String secondString = originalString.substring(index + replaceString.length());

            System.out.println("firstString: " + firstString);
            System.out.println("secondString: " + secondString);
            System.out.println("replaceString: " + replaceString);

            newString = firstString + replaceString + secondString;
        }

        return newString;
    }

    protected char promptForChar(String prompt) {
        char c = ' ';

        boolean valid = false;
        while(!valid) {
            print(prompt);
            String s = input();
            if (s.length() == 1) {
                c = s.charAt(0);
                valid = true;
            } else {
                c = promptForChar(prompt);
            }
        }
        return c;
    }
}