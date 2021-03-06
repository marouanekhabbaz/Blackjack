package com.thinkful.blackjack;

public class Card {
    private Suit suit;
    private Face cardFace;
    private int value;
    private boolean turnedUp;

    public  Card(){
        this(Suit.SPADES, Face.ACE , 1, false );
    }

    public Card(Face cardFace, Suit suit) {
      this(suit, cardFace, 1, false);
    }

    public Card( Suit suit, Face cardFace, int value, boolean turnedUp) {
        this.suit = suit;
        this.cardFace = cardFace;
        this.value = cardFace.getValue();
        this.turnedUp = turnedUp;
    }

    @Override
    public String toString(){
         return String.format("%s%s%s",
                this.getCardFace(), this.getSuit(), this.isTurnedUp()?"\u2191":"\u2193");
    }

    public Suit getSuit() {
        return suit;
    }

    public Face getCardFace() {
        return cardFace;
    }

    public int getValue() {
        return value;
    }

    public boolean isTurnedUp() {
        return turnedUp;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setCardFace(Face cardFace) {
        this.cardFace = cardFace;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setTurnedUp(boolean turnedUp) {
        this.turnedUp = turnedUp;
    }

    @Override
    public boolean equals(Object obj) {
        // self check
        if (this == obj)
            return true;
        // null check
        if (obj == null)
            return false;
        // type check and cast
        if (getClass() != obj.getClass())
            return false;

        //cast as Card
        Card card = (Card) obj;

        // field comparison
        return this.getCardFace() == card.getCardFace() && this.getSuit() == card.getSuit();
    }
}
