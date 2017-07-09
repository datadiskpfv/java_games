package uk.co.datadisk.sillystory;

import com.godtsoft.diyjava.DIYWindow;

/**
 * Created by vallep on 09/07/2017.
 */
public class SillyStory extends DIYWindow {
    public SillyStory() {
        print("Enter your name: ");
        String name = input();
        print("");

        print("Enter your favourite animal: ");
        String animal = input();
        print("");

        print("Enter a part of your animal: ");
        String animalPart = input();
        print("");


        print(name + " had a little " + animal + ",");
        print("Whose " + animalPart + " was white as snow.");
        print("And everywhere that " + name + " went.");
        print("The " + animal + " was sure to go.");

    }

    public static void main(String[] args) {
        new SillyStory();
    }
}
