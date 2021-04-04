package com.pokergame;

// Ethan Olesinski eo2454
// add your own banner here
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private Player p;
    private Deck cards;
    public double payout;
    // you'll probably need some more here

    public int suit;
    public int rank;
    public String face;

    public Game(String[] array){

        ArrayList<Card> testHand = new ArrayList<>();

        for(int i=0; i<array.length; i++) {

            // Parse the string into rank and suit values
            String subCard = array[i];
            String subRank = subCard.substring(1);
            String subSuit = subCard.substring(0, 1);

            int parseRank = Integer.parseInt(subRank);
            //int parseSuit = Integer.parseInt(subSuit);

            //System.out.println(subSuit); //hs

            if(subSuit.equals("c")) {

                suit = 1;
                face = "♣";
                rank = parseRank;
            }

            else if(subSuit.equals("d")) {

                suit = 2;
                face = "♦";
                rank = parseRank;
            }

            else if(subSuit.equals("h")) {

                suit = 3;
                face = "♥";
                rank = parseRank;
            }

            else {

                suit = 4;
                face = "♠";
                rank = parseRank;

            }

            //System.out.println(suit);
            Card testCard = new Card(suit, rank);
            testHand.add(testCard);

            System.out.print(face + rank + " ");


        }

        // Check to see if there is anything in the hand
        System.out.println(checkHand(testHand));
        System.out.println("You won: " + payout);


    }



    public Game(){

        p = new Player();
        cards = new Deck();

        // This no-argument constructor is to actually play a normal game

    }

    public void play(){

        System.out.println("Welcome to Poker!");

        // Ask the player how much they would like to bet
        p.bets(askBet());

        // Shuffle the deck
        cards.shuffle();

        // Create a hand for the player
        for(int i = 0; i<5; i++){

            p.addCard(cards.deal());

        }

        // Display the player's hand
        System.out.println("Here is your hand:");
        System.out.println(p.hand);

        // Ask the player if they would like to remove a card from thier hand
        System.out.println("Would you like to remove a card? Type yes or no: ");
        Scanner input = new Scanner(System.in);
        String answer = input.next();

        while(answer.equals("yes")) {

            // Ask the player which card they would like to remove
            System.out.print("Which one? Type the number: ");
            int cardNum = input.nextInt();

            // Remove the card and then add a new card to the hand
            p.removeCard(p.hand.get(cardNum-1));
            p.addCard(cards.deal());

            // Display the player's new hand
            System.out.println("Your new hand is:");
            System.out.println(p.hand);

            // Ask the player if they would like to rejet any more cards
            System.out.println("Would you like to reject any others?");
            answer = input.next();

        }


        System.out.println(checkHand(p.hand));
        System.out.println("You won: " + payout);



        // this method should play the game
    }

    public String checkHand(ArrayList<Card> hand){

        // Sort the hand before checking conditions
        sort(hand);

        // Check to see if there is a Royal Flush
        if(royalFlush(hand) == true) {

            payout = payout + 250 * p.bet;
            return "You've got a Royal Flush";
        }

        // Check to see if there is a Straight Flush
        else if(straightFlush(hand) == true) {

            payout = payout + 50 * p.bet;
            return "You've got a Straight Flush";
        }

        // Check to see if there is Four of a Kind
        else if(fourOfaKind(hand) == true) {

            payout = payout + 25 * p.bet;
            return "You've got Four of a Kind";
        }

        // Check to see if there is a Full House
        else if(fullHouse(hand) == true) {

            payout = payout + 6 * p.bet;
            return "You've got a Full House";
        }

        // Check to see if there is a Flush
        else if(flush(hand) == true) {

            payout = payout + 5 * p.bet;
            return "You've got a Flush";
        }

        // Check to see if there is a Straight
        else if(straight(hand) == true) {

            payout = payout + 4 * p.bet;
            return "You've got a Straight";
        }

        // Check to see if there is Three of a Kind
        else if(threeOfaKind(hand) == true) {

            payout = payout + 3 * p.bet;
            return "You've got Three of a Kind";
        }

        // Check to see if there are Two Pairs
        else if(twoPairs(hand) == true) {

            payout = payout + 2 * p.bet;
            return "You've got Two Pairs";
        }

        // Check to see if there is a Pair
        else if(pair(hand) == true) {

            payout = payout + 1 * p.bet;
            return "You've got a Pair";
        }

        // Return that they have nothing in thier hand
        else {

            //payout = payout + 0 * p.bet;
            return "Sorry, you have nothing in your hand";
        }



    }


    // Creat a method to sort the cards in the hand

    public void sort(ArrayList<Card> hand) {

        // Sort the cards in the hand
        Collections.sort(hand);
    }

    // Get a bet from the player
    public Double askBet() {

        Scanner betAmount = new Scanner(System.in);
        System.out.print("How much would you like to bet?: ");
        double value = betAmount.nextDouble();
        return value;

    }

    // Create a method to ask if a player wants to change a card in thier hand
    /*public boolean ask() {

        Scanner ask = new Scanner(System.in);
        System.out.print("Do you want to remove any cards from your hand? Type yes or no: ");
        String answer = ask.next();
        answer.toLowerCase();
        if(answer.equals("yes")) {

            return true;
        }

        else {

            return false;
        }

    }


    // Create a method to change a card in the hand
    public Card changeCard() {

        Scanner whichCard = new Scanner(System.in);
        System.out.print("Which card do you want to remove? Suit/Rank: ");
        int suitChange = whichCard.nextInt();
        int rankChange = whichCard.nextInt();
        Card removeCard = new Card(suitChange, rankChange);
        return removeCard;

    } */

    public String toString() {

        return ("Your current hand is: " + p.hand);
    }


    // Methods to check cards

    // Check to see if there is a pair
    public boolean pair(ArrayList<Card> hand) {

        for(int i=0; i<hand.size()-1; i++) {

            // Check to see if two cards next to each other are the same
            if(p.hand.get(i).getRank() == p.hand.get(i+1).getRank()) {

                return true;
            }

        }
        return false;
    }

    // Check to see if there are two pairs
    public boolean twoPairs(ArrayList<Card> hand) {

        int pairs = 0;

        for(int i=0; i<hand.size()-1; i++) {

            // Check to see if two cards next to each other are the same
            if(p.hand.get(i).getRank() == p.hand.get(i+1).getRank()) {

                pairs = pairs+1;
            }
        }

        // Check to see if there are two pairs
        if(pairs == 2) {

            return true;
        }

        return false;
    }

    // Check to see if there is a Royal Flush

    public boolean royalFlush(ArrayList<Card> hand) {

        for(int i=0; i<hand.size()-1; i++) {

            // Make sure that each card in the hand is the same suit
            if(p.hand.get(i).getSuit() != p.hand.get(i+1).getSuit()) {

                return false;
            }

            // Check to see if the first and second cards in the hand are an ace and 10
            else if(p.hand.get(0).getRank() == 1 && p.hand.get(1).getRank() == 10) {

                // Check to see if the third and fourth cards are a Jack and Queen
                if(p.hand.get(2).getRank() == 11 && p.hand.get(3).getRank() == 12) {

                    // Check to see if the fifth card is a King
                    if(p.hand.get(4).getRank() == 13) {

                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Check to see if there is a straight flush

    public boolean straightFlush(ArrayList<Card> hand) {

        for(int i=0; i<hand.size()-1; i++) {

            // Make sure that each card in the hand is the same suit
            if(p.hand.get(i).getSuit() != p.hand.get(i+1).getSuit()) {

                return false;

            }

            // Check to see if the first card is four values lower than the last card
            else if(p.hand.get(4).getRank() - p.hand.get(0).getRank() == 4) {

                // Check to see if there are any pairs in the hand
                if(pair(hand) != true) {

                    return true;

                }
            }

        }

        return false;

    }

    // Check to see if there is a full house

    public boolean fullHouse(ArrayList<Card> hand) {

        // if(pair(hand) == true && threeOfaKind(hand) == true)

        // Check to see if the first and second two cards are equal
        // Check to see if the fourth and fifth two cards are equal
        if(p.hand.get(0).getRank() == p.hand.get(1).getRank() &&
                p.hand.get(3).getRank() == p.hand.get(4).getRank()) {

            // Check to see if the third card equals one of the first pairs or second pairs
            if(p.hand.get(2).getRank() == p.hand.get(0).getRank() ||
                    p.hand.get(2).getRank() == p.hand.get(3).getRank()) {

                return true;

            }
        }

        return false;
    }

    // Check to see if there is a four of a kind

    public boolean fourOfaKind(ArrayList<Card> hand) {

        for(int i=0; i<1; i++) {

            // Check to see if two cards in the hand match
            if(p.hand.get(i).getRank() == p.hand.get(i+1).getRank()) {

                // Check to see if three cards in the hand match
                if(p.hand.get(i).getRank() == p.hand.get(i+2).getRank()) {

                    // Check to see if four cards in the hand match
                    if(p.hand.get(i).getRank() == p.hand.get(i+3).getRank()) {

                        return true;

                    }
                }
            }
        }

        return false;

    }

    // Check to see if there is a Flush

    public boolean flush(ArrayList<Card> hand) {

        for(int i =0; i<hand.size()-1; i++) {

            // Check to see if each card in the hand is the same suit
            if(p.hand.get(i).getSuit() != p.hand.get(i+1).getSuit()) {

                return false;
            }
        }

        return true;

    }

    // Check to see if there is a straight

    public boolean straight(ArrayList<Card> hand) {

        // Check to see if the first card is four values lower than the last card
        if(p.hand.get(4).getRank() - p.hand.get(0).getRank() == 4) {

            // Make sure there are no pairs in the hand
            if(pair(hand) != true) {

                return true;
            }
        }

        return false;

    }

    // Check to see if there is a three of a kind

    public boolean threeOfaKind(ArrayList<Card> hand) {

        for(int i=0; i<2; i++) {

            // Check to see if two cards match
            if(p.hand.get(i).getRank() == p.hand.get(i+1).getRank()) {

                // Check to see if three cards match
                if(p.hand.get(i).getRank() == p.hand.get(i+2).getRank()) {

                    return true;
                }
            }
        }
        return false;

    }



    // you will likely want many more methods here
    // per discussion in class
}


