package uk.co.datadisk.secretcodekey;

import uk.co.datadisk.mywindow.MyWindow;

import java.io.*;

import static uk.co.datadisk.mystringmethods.MyStringMethods.scramble;

/**
 * Created by vallep on 12/07/2017.
 *
 */
public class SecretCodeKey extends MyWindow {
    public SecretCodeKey() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz !£$%^&*()";

        String scrambled = scramble(alphabet);
        print(alphabet);
        print(scrambled);

        //String filename = "c:\\web\\key.txt";
        String filename = "key.txt";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(new File(filename)));
            out.write(alphabet);
            out.newLine();
            out.write(scrambled);
            out.close();
        } catch (IOException e) {
            print("could not open file " + filename);
        }

    }

    public static void main(String[] args) {
        new SecretCodeKey();
    }
}
