package uk.co.datadisk.cards;

/**
 * Created by vallep on 16/07/2017.
 *
 */
public class Card {

    private char rank = ' ';
    private char suit = ' ';

    public Card(String rs) {
        rank = rs.charAt(0);
        suit = rs.charAt(1);
    }

    public String toString() {
        return "" + rank + suit;
    }
}