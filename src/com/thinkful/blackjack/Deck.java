package com.thinkful.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {
//    private Card[] cards;
    private List<Card> cards;
//    public static final int DECK_SIZE = 52;

    public Deck(){
//       this.setCards(new Card[DECK_SIZE]);
        this.setCards(new ArrayList<Card>());

        int i = 0;
       for(Suit suit: Suit.values()){
           for(Face face: Face.values()){
//             cards[i] = new  Card(face , suit);
               this.getCards().add(new Card(face, suit));
             i++;
           }
       }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + Arrays.toString(new List[]{cards}) +
                '}';
    }
}
