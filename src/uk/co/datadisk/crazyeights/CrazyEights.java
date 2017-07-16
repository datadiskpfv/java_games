package uk.co.datadisk.crazyeights;

import uk.co.datadisk.cards.Card;
import uk.co.datadisk.cards.Deck;
import uk.co.datadisk.mywindow.MyWindow;

import java.util.ArrayList;

/**
 * Created by vallep on 16/07/2017.
 *
 */
public class CrazyEights extends MyWindow {

    public CrazyEights() {
        Deck deck = new Deck();
        ArrayList<Card> discardPile = new ArrayList<>();

        Card card;
        for (int i = 0; i < 10; i++) {
            card = deck.deal();
            print(card.toString());
            discardPile.add(card);
        }
        print("Deck Size: " + deck.size());
        deck.reuse(discardPile);
        print("Deck Size: " + deck.size());
    }

    public static void main(String[] args) {
        new CrazyEights();
    }
}