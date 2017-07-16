package uk.co.datadisk.crazyeights;

import uk.co.datadisk.cards.Card;
import uk.co.datadisk.cards.Deck;
import uk.co.datadisk.cards.Hand;
import uk.co.datadisk.mywindow.MyWindow;

import java.lang.reflect.Array;
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

    private int countHearts = 0;
    private int countDiamonds = 0;
    private int countSpades = 0;
    private int countClubs = 0;

    public CrazyEights() {

        boolean done = false;

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

        int turn = rand.nextInt(2);
        if(turn == 1) {
            print("Computer will go first");
            playComputerCard();
        } else {
            print("Player will go first");
        }

        while(!done) {
            playMyCard();
            if(myHand.size() == 0) {
                done = true;
            } else {
                playComputerCard();
                if(computerHand.size() == 0) {
                    done = true;
                }
            }
        }
        print();
        if(myHand.size() == 0) {
            print("Well done you won, the computer has " + computerHand.size() + " has cards left");
        } else {
            print("Sorry you lost, you had " + myHand.size() + " cards left, discard was " + discard);
        }
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
        print("You drew " + drewCard);
        myHand.add(drewCard);

        if(isValidPlay(drewCard.toString())) {
            print("You played " + drewCard);
            discardMyCard(drewCard);
        }
    }

    private void discardMyCard(Card myCard) {
        myHand.remove(myCard);
        discardPile.add(discard);
        discard = myCard;
        if (myCard.getRank() == '8') {
            activeSuit = promptForSuit();
        }
    }

    private void discardComputerCard(Card computerCard) {
        computerHand.remove(computerCard);
        discardPile.add(discard);
        discard = computerCard;

        if(discard.getRank() == '8') {
            int highestCount = countHearts;
            activeSuit = 'H';

            if(countDiamonds > highestCount) {
                highestCount = countDiamonds;
                activeSuit = 'D';
            }
            if(countClubs > highestCount) {
                highestCount = countClubs;
                activeSuit = 'C';
            }
            if(countSpades > highestCount) {
                highestCount = countSpades;
                activeSuit = 'S';
            }
        }
    }

    private void playComputerCard() {
        System.out.println("Computer hand: " + computerHand.toString());

        ArrayList<Card> playableCards = new ArrayList<>();
        ArrayList<Card> eights = new ArrayList<>();

        countHearts = 0;
        countDiamonds = 0;
        countSpades = 0;
        countClubs = 0;

        for (int i = 0; i < computerHand.size(); i++) {
            Card card = computerHand.cardAt(i);
            if (card.getRank() == '8') {
                eights.add(computerHand.cardAt(i));
            } else {
                switch(card.getSuit()) {
                    case 'S':
                        countSpades++;
                        break;
                    case 'D':
                        countDiamonds++;
                        break;
                    case 'H':
                        countHearts++;
                        break;
                    case 'C':
                        countClubs++;
                        break;
                }
            }
        }

        for (int i = 0; i < computerHand.size(); i++) {
            Card card = computerHand.cardAt(i);

            if (discard.getRank() == '8') {
                if (card.getSuit() == activeSuit) {
                    playableCards.add(card);
                }
            } else if (card.getSuit() == discard.getSuit() || card.getRank() == discard.getRank()) {
                playableCards.add(card);
            }
        }

        int numberOfPlayableCards = playableCards.size();
        if (numberOfPlayableCards > 0) {
            int pick = rand.nextInt(numberOfPlayableCards);
            Card playedCard = playableCards.get(pick);
            discardComputerCard(playedCard);
        } else if (eights.size() > 0){
            Card playedCard = eights.get(0);
            discardComputerCard(playedCard);
        } else {
            Card drewCard = deal();
            computerHand.add(drewCard);
            print();
            print("Computer drew a card");

            if(drewCard.getSuit() == discard.getSuit() || drewCard.getRank() == discard.getRank()) {
                discardComputerCard(drewCard);
            }
        }
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
                discardMyCard(selectedCard);
                validPlay = true;
            }
        }
    }

    private boolean isValidPlay(String rankSuit) {
        boolean validPlay = true;
        Card card = new Card(rankSuit);

        System.out.println("Card: " + card.toString());
        System.out.println("Discard: " + discard.toString());

        System.out.println(("Card suit: " + card.getSuit() + " Card Rank: " + card.getRank()));
        System.out.println(("Discard suit: " + discard.getSuit() + " Discard Rank: " + discard.getRank()));

        if(!card.isValid()) {
            print(rankSuit + " is not valid");
            validPlay = false;
        } else if (!myHand.contains(card)) {
            print(rankSuit + " is not in hand");
            validPlay = false;
        } else if (card.getRank() != '8') {
            if (discard.getRank() == '8') {
                if (card.getSuit() != activeSuit ) {
                    print(rankSuit + " cannot be played on " + discard + " because the suit was set to " + activeSuit);
                    validPlay = false;
                }
            } else if ( card.getSuit() != discard.getSuit() && card.getRank() != discard.getRank() ) {
                print(rankSuit + " cannot be played on " + discard + ".");
                validPlay = false;
            }
        }
        return validPlay;
    }

    private char promptForSuit() {
        char suit = ' ';
        boolean validSuit = false;
        while(!validSuit) {
            suit = promptForChar("Change the suit to H, D, C or S?");
            suit = Character.toUpperCase(suit);
            if (Card.isValidSuit(suit)) {
                validSuit = true;
            }
        }
        return suit;
    }

    public static void main(String[] args) {
        new CrazyEights();
    }
}