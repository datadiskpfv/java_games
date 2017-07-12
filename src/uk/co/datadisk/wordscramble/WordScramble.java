package uk.co.datadisk.wordscramble;

import uk.co.datadisk.mywindow.MyWindow;
import static uk.co.datadisk.mystringmethods.MyStringMethods.scramble;

/**
 * Created by vallep on 12/07/2017.
 *
 */
public class WordScramble extends MyWindow {
    public WordScramble() {
        //String word = "ANIMALS";
        String words[] = {"ANIMALS", "ELEPHANT", "GIRAFFE", "PENGUIN", "GORIALLA"};

        for (String word : words) {
            String scrambled = scramble(word);
            print(scrambled);
        }
    }

    public static void main(String[] args) {
        new WordScramble();
    }
}
