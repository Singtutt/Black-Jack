package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private String nameOfPlayer;
    private ArrayList<Card> cards;

    public Hand(String nameOfPlayer) {
        this.nameOfPlayer = nameOfPlayer;
        this.cards = new ArrayList<>();
    }

    public String getNameOfPlayer() {
        return nameOfPlayer;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void handSplit(Card card) {
        cards.add(card);
    }

    public int handTotalScore() {
        int total = 0;
        int aceCount = 0;
        for (Card card : cards) {
            total += card.getScore();
            if (card.getRank().equals("Ace")) {
                aceCount++;
            }
        }
        while (aceCount > 0 && total > 21) { // Handles Ace score factors (Score = 1/11)
            total -= 10;
            aceCount--;
        }
        return total;
    }
}
