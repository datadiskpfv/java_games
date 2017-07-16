package uk.co.datadisk.wordmastermind;

import uk.co.datadisk.mywindow.MyWindow;
import java.io.*;
import java.util.Random;

/**
 * Created by vallep on 13/07/2017.
 *
 */
public class WordMasterMind extends MyWindow {

    private String word;
    private String clue;

    private static final int NUMBEROFWORDS = 342;
    private static final String FILENAME = "wordMasterMind.txt";

    public WordMasterMind() {

        String words[] = new String[NUMBEROFWORDS];
        Random rand = new Random();

        int count = 1;
        boolean repeat = true;

        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(FILENAME)));
            for (int i = 0; i < NUMBEROFWORDS; i++) {
                words[i] = in.readLine();
            }
            in.close();

            int pick = rand.nextInt(NUMBEROFWORDS);
            word = words[pick];
            word = word.toUpperCase();
        } catch (FileNotFoundException e) {
            print("Error unable to open file " + FILENAME);
        } catch (IOException e) {
            print("Error reading file " + FILENAME);
        }

        //String guess = "lint";
        //clue = "----";
        while(repeat) {
            print("I'm thinking of a 4 letter word.");
            print("  I will give you clues:");
            print("  An \"O\" means you guessed the correct letter in the correct place.");
            print("  An \"X\" means you guessed the correct letter in the wrong place.");
            print();
            String guess = promptForString("Enter a guess? ");
            guess = guess.toUpperCase();
            String originalWord = word;
            boolean solved = false;

            while(!solved) {
                if(guess.length() > 3) {
                    word = originalWord;
                    clue = "----";

                    findRightPlaceLetters(guess);
                    findWrongPlaceLetters(guess);

                    System.out.println("Guess: " + guess);
                    System.out.println("originalWord: " + originalWord);
                    if (guess.equals(originalWord)) {
                        solved = true;
                    } else {
                        print(clue);
                        guess = promptForString("Enter a guess?");
                        guess = guess.toUpperCase();
                        count++;
                    }
                }
                else {
                    print("You have had " + count + " tries");
                    guess = promptForString("Enter a guess ? ");
                    guess = guess.toUpperCase();
                }
            }

            int pick = rand.nextInt(NUMBEROFWORDS);
            word = words[pick];
            word = word.toUpperCase();
            print("OOOO");
            print("Well Done you guess the word in " + count + " tries");
            repeat = promptForYesNo("Do you want to play again");
        }
        System.exit(0);
    }

    private void findRightPlaceLetters(String guess) {
        for (int i = 0; i < word.length(); i++) {
            String guessLetter = guess.substring(i, i + 1);
            String wordLetter = word.substring(i, i + 1);
            if(guessLetter.equals(wordLetter)) {
                clue = replaceStringAt(clue, i, "O");
                word = replaceStringAt(word, i, "-");
            }
        }
    }

    private void findWrongPlaceLetters(String guess) {
        for (int i = 0; i < word.length(); i++) {
            String letter = guess.substring(i, i + 1);
            int letterLoc = word.indexOf(letter);
            if ( letterLoc > -1) {
                word = replaceStringAt(word, letterLoc, "-");
                String clueLetter = clue.substring(i, i + 1);
                if(clueLetter.equals("-")) {
                    clue = replaceStringAt(clue, i, "X");
                }
            }
        }
    }

    public static void main(String[] args) {
        new WordMasterMind();
    }
}
