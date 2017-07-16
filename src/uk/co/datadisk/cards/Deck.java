package uk.co.datadisk.cards;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by vallep on 16/07/2017.
 *
 */
public class Deck {
    ArrayList<Card> cards = new ArrayList<>();
    Random rand = new Random();

    public Deck() {
        for (int i = 0; i < 52; i++) {
            Card card = new Card(i);
            cards.add(card);
        }
        shuffle();
    }

    public String toString() {
        String deck = "";
        for(Card card : cards) {
            deck += card.toString() + " ";
        }
        return deck;
    }

    public void shuffle() {
        ArrayList<Card> shuffled = new ArrayList<>();
        int numberOfTimes = cards.size();
        for(int i = 0; i < numberOfTimes; i++) {
            int deckSize = cards.size();
            int pick = rand.nextInt(deckSize);
            Card card = cards.remove(pick);
            shuffled.add(card);
        }
        cards = shuffled;
    }

    public Card deal() {
        Card card = cards.remove(0);
        return card;
    }

    public void reuse(ArrayList<Card> newCards) {
        cards = newCards;
    }

    public int size() {
        return cards.size();
    }
}