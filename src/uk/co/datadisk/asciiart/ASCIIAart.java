package uk.co.datadisk.asciiart;

import com.godtsoft.diyjava.DIYWindow;

/**
 * Created by vallep on 09/07/2017.
 */
public class ASCIIAart extends DIYWindow {
    public ASCIIAart() {
        print(" @@@@@@@@");
        print(" |      |");
        print(" | (0)(0)");
        print("C       _)");
        print(" |   ___|");
        print(" |     /");
        print("/      \\");
        print("");
    }

    public static void main(String[] args) {
        new ASCIIAart();
    }
}
