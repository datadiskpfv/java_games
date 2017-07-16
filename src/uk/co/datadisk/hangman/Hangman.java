package uk.co.datadisk.hangman;

import uk.co.datadisk.mywindow.MyWindow;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by vallep on 16/07/2017.
 *
 */
public class Hangman extends MyWindow {

    private String phrase;
    private String clue;
    private String wrongLetters;
    private static final String FILENAME = "phrases.txt";

    public Hangman() {

        //phrase = "HELLO WORLD";
        ArrayList<String> phrases = new ArrayList<>();
        Random rand = new Random();

        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(FILENAME)));
            String s = in.readLine();
            while( s != null) {
                phrases.add(s);
                s = in.readLine();
            }
            in.close();

            int numberOfPhrases = phrases.size();

            boolean again = true;

            while(again) {
                int pick = rand.nextInt(numberOfPhrases);
                phrase = phrases.get(pick);
                phrase = phrase.toUpperCase();

                blankOutClue();

                wrongLetters = "";

                while (clue.contains("-") && wrongLetters.length() < 10) {
                    String guess = promptForString("Guess a letter");
                    guess.toUpperCase();

                    if (guess.length() != 1) {
                        print("Your guess must contain only 1 letter. Guess again");
                    } else if (clue.contains(guess) || wrongLetters.contains(guess)) {
                        print("You have already guessed " + guess + ". Guess again");
                    } else {
                        boolean found = false;

                        int index = phrase.indexOf(guess);

                        while (index > -1) {
                            found = true;
                            clue = replaceStringAt(clue, index, guess);
                            index = phrase.indexOf(guess, index + 1);
                        }
                        if (!found) {
                            wrongLetters += guess;
                        }
                        printPuzzle();
                    }
                }
                if (!clue.contains("-")) {
                    print("Congratulations! You guessed it before you were hanged!");
                } else {
                    print("Sorry, you lose. The phrase was " + phrase);
                }
                again = promptForYesNo("Do you want to play again?");
            }

        } catch (FileNotFoundException e) {
            print("Could not find file" + FILENAME);
        } catch (IOException e) {
            print("Could not read from file" + FILENAME);
        }
    }

    private void printPuzzle() {

        print("------");
        switch(wrongLetters.length()) {
            case 0:
                print("|");
                print("|" + wrongLetters);
                print("|");
                break;
            case 1:
                print("|    O");
                print("|         " + wrongLetters);
                print("|");
                break;
            case 2:
                print("|    O");
                print("|    |    " + wrongLetters);
                print("|");
                break;
            case 3:
                print("|    O");
                print("|   -|    " + wrongLetters);
                print("|");
                break;
            case 4:
                print("|    O");
                print("|  --|    " + wrongLetters);
                print("|");
                break;
            case 5:
                print("-----");
                print("|    O");
                print("|  --|-     " + wrongLetters);
                print("|");
                break;
            case 6:
                print("|    O");
                print("|  --|--     " + wrongLetters);
                print("|");
                break;
            case 7:
                print("|    O");
                print("|  --|--     " + wrongLetters);
                print("|   /");
                break;
            case 8:
                print("|    O");
                print("|  --|--     " + wrongLetters);
                print("|  _/");
                break;
            case 9:
                print("|    O");
                print("|  --|--     " + wrongLetters);
                print("|  _/ \\");
                break;
            case 10:
                print("|    O");
                print("|  --|--     " + wrongLetters);
                print("|  _/ \\_");
                break;
        }

        print("|          ");
        print("|            " + clue);
        print("========================================================================");
        print();

        //print("-----");
        //print("|    O");
        //print("|  --|--");
        //print("|  _/ \\_");
        //print("|");
    }

    private void blankOutClue() {
        clue = "";

        for (int i = 0; i < phrase.length(); i++) {
            char letter = phrase.charAt(i);
            if( letter == ' ' ) {
                clue += ' ';
            } else {
                clue += "-";
            }
        }
    }

    public static void main(String[] args) {
        new Hangman();
    }
}
