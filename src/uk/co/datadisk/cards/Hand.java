package uk.co.datadisk.cards;

import java.util.ArrayList;

/**
 * Created by vallep on 16/07/2017.
 */
public class Hand {
    ArrayList<Card> cards = new ArrayList<>();

    public void add(Card card) {
        int index  = 0;
        boolean done = false;

        while(!done && index < cards.size()) {
            Card cardInHand = cards.get(index);
            if ( card.isGreaterThan(cardInHand)) {
                index++;
            } else {
                done = true;
            }
        }
        cards.add(index, card);
    }

    public void remove(Card card) {
        int index = 0;
        boolean found = false;

        while(!found && index < cards.size()) {
            Card comparedCard = cards.get(index);
            if(comparedCard.equals(card)) {
                cards.remove(index);
                found = true;
            } else {
                index++;
            }
        }
    }

    public boolean contains(Card card) {
        int index = 0 ;
        boolean contains = false;

        while(!contains && index < cards.size()) {
            Card comparedCard = cards.get(index);
            if(comparedCard.equals(card)) {
                contains = true;
            } else {
                index++;
            }
        }

        return contains;
    }

    public Card cardAt(int index) {
        return cards.get(index);
    }

    public int size() {
        return cards.size();
    }

    public String toString() {
        String string = "";

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (i != 0 ) {
                Card priorCard = cards.get(i - 1);
                char priorSuit = priorCard.getSuit();
                char currentSuit = card.getSuit();
                if( priorSuit != currentSuit) {
                    string += "  ";
                }
            }
            string += card.toString() + " ";
        }
        return string;
    }

    public ArrayList<Card> getHand() {
        return cards;
    }
}
