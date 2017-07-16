package uk.co.datadisk.cards;

/**
 * Created by vallep on 16/07/2017.
 *
 */
public class Card {

    private static final String RANKS = "A23456789TJQK";
    private static final String SUITS = "HDCS";

    private char rank = ' ';
    private char suit = ' ';

    public char getRank() {
        return rank;
    }

    public char getSuit() {
        return suit;
    }

    public static boolean isValidSuit(char c) {
        boolean valid = false;
        if (SUITS.indexOf(c) > -1 ) {
            valid = true;
        }
            return valid;
    }

    public boolean isValid() {
        boolean valid = false;
        if (suit == ' ') {
            valid = true;
        }
        return valid;
    }

    public boolean equals(Card card) {
        boolean equals = false;
        if((card.getSuit() == suit) && (card.getRank() == rank)) {
            equals = true;
        }
        return equals;
    }

    public boolean isGreaterThan(Card card) {
        boolean greaterThan = false;

        char cardRank = card.getRank();
        char cardSuit = card.getSuit();

        if(SUITS.indexOf(suit) > SUITS.indexOf(cardSuit)) {
            greaterThan = true;
        } else if(suit == cardSuit) {
            if (RANKS.indexOf(rank) > RANKS.indexOf(cardRank)) {
                greaterThan = true;
            }
        }
        return greaterThan;
    }

    public Card(String rs) {

        if (rs.length() == 2) {
            char r = rs.charAt(0);
            char s = rs.charAt(1);

            System.out.println("R: " + r + "  S: " + s);

            int ri = RANKS.indexOf(r);
            int si = SUITS.indexOf(s);


            System.out.println("ri: " + ri + "  si: " + si);
            if(ri > -1 && si > -1) {
                rank = r;
                suit = s;
            }
        }
        rank = rs.charAt(0);
        suit = rs.charAt(1);
    }

    public Card(int id) {
        id = id % 52;
        if( id < 0 ) {
            id = id * -1;
        }
        rank = RANKS.charAt(id % 13);
        suit = SUITS.charAt(id / 13);
    }

    public String toString() {
        return "" + rank + suit;
    }
}