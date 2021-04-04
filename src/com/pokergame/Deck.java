package com.pokergame;

// Ethan Olesinski eo2454
// add your own banner here

import java.util.Random;

public class Deck {

    private Card[] cards;
    private int top; // the index of the top of the deck

    // add more instance variables if needed
    //String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
    //String[] rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};



    public Deck(){

        cards = new Card[52];

        int k = 0;
        top = -1;

        for(int i=1; i<5; i++){

            for(int j=1; j<14; j++) {

                cards[k] = new Card(i,j);
                k++;

            }

        }



        // make a 52 card deck here
    }

    Random rand = new Random();

    public void shuffle(){

        top = -1;

        for(int n = 0; n<52; n++) {

            int m = rand.nextInt(52);
            Card temporary = cards[m];
            cards[m] = cards[n];
            cards[n] = temporary;

        }

        /*
        // Print out the shuffled deck

        for(int w = 0; w<52; w++) {

            System.out.println(cards[w]);

        } */


        // shuffle the deck here
    }

    public Card deal(){

        top++;

        return cards[top];


        // deal the top card in the deck
    }

    // add more methods here if needed

}


