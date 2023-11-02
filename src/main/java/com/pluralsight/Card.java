package com.pluralsight;

public class Card {
    private String suit;
    private String rank;
    private int score;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;

        switch (rank) {
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
                this.score = Integer.parseInt(rank);
                break;
            case "Jack":
            case "Queen":
            case "King":
                this.score = 10;
                break;
            case "Ace":
                this.score = 11;
                break;
            default:
                this.score = 0;
        }
    }

    public String getSuit(){
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getScore() {
        return score;
    }
}


