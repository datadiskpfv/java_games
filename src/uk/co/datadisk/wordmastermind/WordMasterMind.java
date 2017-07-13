package uk.co.datadisk.wordmastermind;

import uk.co.datadisk.mywindow.MyWindow;

/**
 * Created by vallep on 13/07/2017.
 */
public class WordMasterMind extends MyWindow {
    public WordMasterMind() {
        boolean repeat = true;

        while(repeat) {
            print("Hello");
            repeat = promptForYesNo("Do you want to repeat this (Y|y|N|n)?");
        }
    }

    public static void main(String[] args) {
        new WordMasterMind();
    }
}
