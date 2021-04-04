package com.pokergame;

// Ethan Olesinski eo2454
// add your own banner here

public class Card implements Comparable<Card>{

    private int suit; // use integers 1-4 to encode the suit
    private int rank; // use integers 1-13 to encode the rank
    private String face;

    public Card(int suit, int rank){

        this.suit = suit;
        this.rank = rank;

        //make a card with suit s and value v
    }

    public int compareTo(Card c){

        Card other = (Card) c;
        if (rank < other.rank) {

            return -1;
        }

        if (rank > other.rank) {

            return 1;
        }

        return 0;

        // Then we implement the sorting

        //Card other = (Card) c;

        //BankAccount[] accounts = new BankAccount[3];
        //acounts[0] = new BankAccount(10000);
        //acounts[1] = new BankAccount(0);
        //acounts[2] = new BankAccount(2000)
        //Arrays.sort(accounts);

        // use this method to compare cards so they
        // may be easily sorted

    }

    public int getRank() {

        return rank;
    }

    public int getSuit() {

        return suit;
    }

    public String toString(){

        if(suit == 1) {

            face = "♣";
        }
        else if(suit == 2) {

            face = "♦";
        }
        else if(suit == 3) {

            face = "♥";
        }
        else {

            face = "♠";
        }

        return face + rank;

        // use this method to easily print a Card object
    }
    // add some more methods here if needed

}
