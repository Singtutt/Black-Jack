package com.pluralsight;
import java.util.ArrayList;
import java.util.Scanner;

public class GameLogic {
    private Deck deck;
    private ArrayList<Hand> hands;
    private Scanner scan;

    public GameLogic(Scanner scan) {
        this.scan = scan;
        deck = new Deck();
        hands = new ArrayList<>();
    }

    public void startUp(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("What is Player #" + (i + 1) + " Name? ");
            String playerName = scan.next();
            hands.add(new Hand(playerName));
        }

        deck.shuffle();
        initialSplit();
        gamePlay();
    }

    public void initialSplit() {
        for (int i = 0; i < 2; i++) {
            for (Hand hand : hands) {
                hand.handSplit(deck.split());
            }
        }
    }

    public void gamePlay() {
        boolean roundsFinished = false;

        while(!roundsFinished) {
            for (Hand hand : hands) {
                System.out.println(hand.getNameOfPlayer() + "'s Turn: ");

                while (true) {
                    System.out.println("Your cards... " + getPlayersHand(hand.getCards()) +
                            "\nScore Total... " + hand.handTotalScore() +
                            "\nHit or Stay (H or S): ");
                    String option = scan.next();

                    if (option.equalsIgnoreCase("H")) {
                        hand.handSplit(deck.split());
                        int total = hand.handTotalScore();
                        if (total > 21) {
                            System.out.println("Yikes! You went over 21!" +
                                    "\nYour Final Score: " + total);
                            break;
                        }
                    } else if (option.equalsIgnoreCase("S")) {
                        break;
                    }
                }
            }

            roundsFinished = true;
            for (Hand hand : hands) {
                if (hand.handTotalScore() <= 21) {
                    roundsFinished = false;
                    break;
                }
            }
        }

        luckyWinner();
    }
    private String getPlayersHand(ArrayList<Card> cards) {
        StringBuilder playerHand = new StringBuilder();
        for (Card card : cards) {
            playerHand.append(card.getRank()).append(card.getSuit()).append(" | ");
        }
        return playerHand.toString();
    }

    private void luckyWinner() {
        Hand winner = hands.get(0);
        int highScore = winner.handTotalScore();

        for (Hand hand : hands) {
            int total = hand.handTotalScore();

            if (total > highScore && total <= 21) {
                winner = hand;
                highScore = total;
            }
        }

        System.out.println("The Winner is... " + winner.getNameOfPlayer() +
                "\nWinning Score is... " + highScore);
    }
}
