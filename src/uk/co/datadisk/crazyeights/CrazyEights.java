package uk.co.datadisk.crazyeights;

import uk.co.datadisk.cards.Card;
import uk.co.datadisk.mywindow.MyWindow;

/**
 * Created by vallep on 16/07/2017.
 *
 */
public class CrazyEights extends MyWindow {

    private static final String RANKS = "A23456789TJQK";
    private static final String SUITS = "HDCS";

    public CrazyEights() {
        Card card = new Card("8H");
        print(card.toString());
    }

    public static void main(String[] args) {
        new CrazyEights();
    }
}