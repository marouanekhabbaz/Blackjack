package com.thinkful.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private  List<Card> cards;
    private HandStatus status;

    public List<Card> getCards() {
        return cards;
    }
    public void setStatus(HandStatus status) {
        this.status = status;

    }

    public HandStatus getStatus() {
        return status;
    }

    public Hand() {
        this.cards = new ArrayList<Card>();
        setStatus(HandStatus.OPEN);
    }

    public void addCard(Card card){
        this.getCards().add(card);
        if(this.getValue()> 21){
            setStatus(HandStatus.BUST);
        }
    }

    public int getValue() {
        int total = 0;
        for(Card card: this.getCards()){
            total = total + card.getValue();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }
}
