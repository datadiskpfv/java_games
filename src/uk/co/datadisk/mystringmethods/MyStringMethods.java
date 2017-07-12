package uk.co.datadisk.mystringmethods;

import java.util.Random;

/**
 * Created by vallep on 12/07/2017.
 *
 */
public class MyStringMethods {

    public static String scramble(String word) {
        String scrambled = "";

        Random rand = new Random();
        int length = 0;

        while (word.length() > 0) {
            // pick a random letter from the original word
            length = word.length();
            int index = rand.nextInt(length);
            //System.out.println("index = " + index);
            String letter = word.substring(index, index + 1);
            //System.out.println("letter = " + letter);

            // remove that letter from the original word
            String firstString = word.substring(0, index);
            String secondString = word.substring(index + 1);
            word = firstString + secondString;
            //System.out.println("word = " + word);

            // add that letter to a new word
            scrambled += letter;
            //System.out.println("scrambled = " + scrambled);
        }

        // repeat util all letters have been removed from the original word

        return scrambled;
    }
}
