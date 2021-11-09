package com.thinkful.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    public void shuffle(){
        Random ran = new Random();
        for(int i=0; i < this.cards.size(); i++){
            Card c = this.cards.remove(i);
            int newIndex = ran.nextInt(this.cards.size());
            this.cards.add(newIndex, c);
        }
    }

    public Card deal() {
        if(this.getCards().isEmpty()) {
            // we need to do something about this
            return null;
        }
        //return the first card
        return this.getCards().remove(0);
    }

}
