package uk.co.datadisk.guessmynumber;

import uk.co.datadisk.mywindow.MyWindow;

import java.util.Random;

/**
 * Created by vallep on 11/07/2017.
 *
 */
public class GuessMyNumber extends MyWindow {
    public GuessMyNumber() {
        Random rand = new Random();
        int myNumber = rand.nextInt(101);
        int count = 0;
        int myGuess = promptForInt("Guess my number between 0 and 100");

        while (myNumber != myGuess) {
            if (myNumber > myGuess) {
                myGuess = promptForInt("You guessed too low, try again.");
            } else if (myNumber < myGuess){
                myGuess = promptForInt("You guessed too high. Try again.");
            }
            count += 1;
        }
        print("You guessed it after " + count + " tries!");

    }

    public static void main(String[] args) {
        new GuessMyNumber();
    }
}
