package com.pokergame;

// Ethan Olesinski eo2454
// add your own banner here
import java.util.ArrayList;

public class Player {


    public ArrayList<Card> hand; // the player's cards
    private double bankroll;
    public double bet;

    // you may choose to use more instance variables

    public Player(){

        bankroll = 100;
        bet = 0;
        hand = new ArrayList<Card>();
        // create a player here
    }

    public void addCard(Card c){

        hand.add(c);

        // add the card c to the player's hand
    }

    public void removeCard(Card c){

        for(int i = 0; i<hand.size(); i++) {
            if((hand.get(i).compareTo(c)) == 0) {
                hand.remove(i);
            }
        }

        // remove the card c from the player's hand
    }

    public void bets(double amt){

        bet = amt;
        // player makes a bet
    }

    public void winnings(double odds){

        bankroll += odds;
        //	adjust bankroll if player wins
    }

    public double getBankroll(){

        return bankroll;
        // return current balance of bankroll
    }

    // you may wish to use more methods here
}




