package uk.co.datadisk.crazyeights;

import uk.co.datadisk.cards.Card;
import uk.co.datadisk.cards.Deck;
import uk.co.datadisk.cards.Hand;
import uk.co.datadisk.mywindow.MyWindow;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by vallep on 16/07/2017.
 *
 */
public class CrazyEights extends MyWindow {

    private Deck deck = new Deck();
    private Hand myHand = new Hand();
    private Hand computerHand = new Hand();
    private Card discard;
    private ArrayList<Card> discardPile = new ArrayList<>();
    Random rand = new Random();
    private char activeSuit = ' ';


    public CrazyEights() {

        for (int i = 0; i < 7; i++) {
            Card card1 = deal();
            myHand.add(card1);

            Card card2 = deal();
            computerHand.add(card2);
        }

        discard = deal();

        if( discard.getRank() == '8') {
            activeSuit = discard.getSuit();
        } else {
            activeSuit = ' ';
        }

        playMyCard();
        showStatus();
    }

    private Card deal() {
        if (deck.size() == 0 ){
            deck.reuse(discardPile);
            deck.shuffle();
            discardPile.clear();
            print();
            print("The discardPile has been shuffled");
        }

        Card card = deck.deal();
        return card;
    }

    private void showStatus() {
        print();
        print("Computer has " + computerHand.toString() + " cards");
        print("My Hand has " + myHand.toString() + " cards");
        print("Discard: " + discard.toString());
        if(discard.getRank() == '8') {
            print("Suit is " + activeSuit);
        }
    }

    private void drawMyCard() {
        Card drewCard = deal();
        print();
        print("You drew " + drewCard.toString());
        myHand.add(drewCard);

        if(isValidPlay(drewCard.toString())) {
            print("You played " + drewCard);
            discardMycard(drewCard);
        }
    }

    private void discardMycard(Card myCard) {
        myHand.remove(myCard);
        discardPile.add(discard);
        discard = myCard;
    }

    private void playMyCard() {
        showStatus();
        boolean validPlay = false;
        while (!validPlay) {
            String rankSuit = promptForString("What card do you want to play (or D for draw)? ");
            rankSuit = rankSuit.toUpperCase();
            if (rankSuit.equals("D")) {
                drawMyCard();
                validPlay = true;
            } else if (isValidPlay(rankSuit)){
                Card selectedCard = new Card(rankSuit);
                discardMycard(selectedCard);
                validPlay = true;
            }
        }
    }

    private boolean isValidPlay(String rankSuit) {
        boolean validPlay = true;
        Card card = new Card(rankSuit);

        if(!card.isValid()) {
            print(rankSuit + " is not valid");
            validPlay = false;
        } else if (!myHand.contains(card)) {
            print(rankSuit + " is not in hand");
            validPlay = false;
        } else if ( card.getSuit() != discard.getSuit() && card.getSuit() != discard.getSuit()) {
            print(rankSuit + " cannot be played on " + discard + ".");
            validPlay = false;
        }


    }

    public static void main(String[] args) {
        new CrazyEights();
    }
}