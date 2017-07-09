package uk.co.datadisk.namegame;

import com.godtsoft.diyjava.DIYWindow;

/**
 * Created by vallep on 09/07/2017.
 *
 */
public class NameGame extends DIYWindow {
    public NameGame() {
        print("Enter your name: ");
        String name = input();
        print("");

        print(name + " be nimble");
        print(name + " be quick");
        print(name + " jump over a candlestick.");
        print("");
        print("Way to go," + name + "!");

        if(name.equals("Jack")) {
            print(name + ", your jumping skills are famous");
        } else {
            print(name + ", I've never heard of you");
        }

        if(name.startsWith("P")) {
            print(name + ", are you a Java programmer?");
        }

        if(name.startsWith("King")) {
            print("Your highness");
        }

        if(!name.contains(" ")) {
            print("Don't you have a first and last name?");
        }

        if (name.startsWith("Dr.") && !name.equals("Dr. Frankenstein")) {
            print("Doctor, this may be a medical emergency!");
        } else {
            print("Doctor Frankenstein, no help is needed here");
        }
    }

    public static void main(String[] args) {
        new NameGame();
    }

}