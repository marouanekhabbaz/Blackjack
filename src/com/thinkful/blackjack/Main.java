package com.thinkful.blackjack;

public class Main {


    public static void main (String[] args) {

        Card sevenSpades = new Card();
        Card jackClubs = new Card(Face.JACK, Suit.CLUBS );
        Deck newDecks = new Deck();


        System.out.println(sevenSpades);
        System.out.println(jackClubs);
        System.out.println(newDecks);

    }
}
