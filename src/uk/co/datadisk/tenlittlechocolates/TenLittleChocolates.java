package uk.co.datadisk.tenlittlechocolates;

import uk.co.datadisk.mywindow.MyWindow;

/**
 * Created by vallep on 12/07/2017.
 *
 */
public class TenLittleChocolates extends MyWindow{
    public TenLittleChocolates() {
        for (int i = 1; i < 4; i++) {
            print(i + " little");
        }
        print("chocolates.");

        for (int i = 4; i < 7; i++) {
            print(i + " little");
        }
        print("chocolates.");

        for (int i = 7; i < 10; i++) {
            print(i + " little");
        }
        print("chocolates.");
        print("10 little chocolates bars.");
        print();
        for (int i = 10; i > 7 ; i--) {
            print(i + " little");
        }
        print("chocolates.");
        for (int i = 7; i > 4 ; i--) {
            print(i + " little");
        }
        print("chocolates.");
        for (int i = 4; i > 1 ; i--) {
            print(i + " little");
        }
        print("chocolates.");
        print("1 little chocolates bar.");

    }

    public static void main(String[] args) {
        new TenLittleChocolates();
    }
}
