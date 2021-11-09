package com.thinkful.blackjack;

public class Game {
    private Hand player;
    private  Hand dealer ;
    private Deck deck;

    public void setPlayer(Hand player) {
        this.player = player;
    }

    public void setDealer(Hand dealer) {
        this.dealer = dealer;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Hand getPlayer() {
        return player;
    }

    public Hand getDealer() {
        return dealer;
    }

    public Deck getDeck() {
        return deck;
    }

    public Game(){
        setPlayer(new Hand());
        setDealer(new Hand());
        setDeck(new Deck());
        deck.shuffle();
        player.addCard(deck.deal());
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
        dealer.addCard(deck.deal());
    }
    @Override
    public String toString(){
        return String.format("Player: %s, Dealer: %s", getPlayer(), getDealer());
    }

    public void playerMove(Action action) {
        if(action == Action.HIT) {
            getPlayer().addCard(getDeck().deal());
        } else {
            if(action == Action.STAND) {
                getPlayer().setStatus(HandStatus.STAND);
            }
        }
    }

    public void dealerMove() {
        while(getDealer().getValue() < 16 && getDealer().getStatus() == HandStatus.OPEN) {
            getDealer().addCard(getDeck().deal());
        }
        if(getDealer().getStatus() == HandStatus.OPEN) {
            getDealer().setStatus(HandStatus.STAND);
        }
    }

    public boolean isPlayerTurn() {
        return getPlayer().getStatus() == HandStatus.OPEN;
    }


    public String outcome() {

        //if you both bust
        if(getPlayer().getStatus() == HandStatus.BUST && getDealer().getStatus() == HandStatus.BUST) {
            return "Everyone BUSTED! No winners!";
        }

        // if you bust but not dealer
        if (getPlayer().getStatus() == HandStatus.BUST && getDealer().getStatus() == HandStatus.STAND) {
            return "You BUST! Dealer wins!";
        }

        //if dealer bust but not you
        if(getPlayer().getStatus() == HandStatus.STAND && getDealer().getStatus() == HandStatus.BUST) {
            return "Dealer BUST! You Win!";

        }

        //neither bust
        if(getPlayer().getValue() > getDealer().getValue()) {
            return "You win!";
        }

        return "You lose. Dealer wins.";
    }
}
