package com.pluralsight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void testPlayerNameAssignment() {
        Hand hand = new Hand("Gambling Gabe");
        assertEquals("Gambling Gabe", hand.getNameOfPlayer());
    }
    @Test
    void testInitialPlayerHand() {
        Hand hand = new Hand("Gambling Gabby");
        assertEquals("Gambling Gabby", hand.getNameOfPlayer());
        assertTrue(hand.getCards().isEmpty()); // New Player starts with nothing
    }

    @Test
    void testHandTotalScore() {
        Hand hand = new Hand("Gambling Gabby");
        Card first = new Card("Hearts", "Ace");
        Card second = new Card("Clubs", "King");
        hand.handSplit(first);
        hand.handSplit(second);
        assertEquals(21, hand.handTotalScore());
    }

    @Test
    void testHandSplit() {
        Hand hand = new Hand("Gambling Gabby");
        Card first = new Card("Hearts", "Ace");
        Card second = new Card("Clubs", "King");
        hand.handSplit(first);
        hand.handSplit(second);
        assertEquals(2, hand.getCards().size());
    }

    @Test
    void testAceScoreFactor() {
        Hand hand = new Hand("Gambling Gabby");
        Card first = new Card("Hearts", "Ace");
        Card second = new Card("Clubs", "King");
        Card third = new Card("Spades", "Ace");
        Card fourth = new Card("Diamonds", "2");
        hand.handSplit(first);
        hand.handSplit(second);
        hand.handSplit(third);
        hand.handSplit(fourth);
        assertEquals(14, hand.handTotalScore());
    }
}