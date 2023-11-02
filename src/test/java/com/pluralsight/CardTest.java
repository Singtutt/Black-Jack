package com.pluralsight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void getSuit() {
        Card card = new Card("Hearts", "Ace");
        assertEquals("Hearts", card.getSuit());
    }

    @Test
    void getRank() {
        Card card = new Card("Hearts", "2");
        assertEquals("2", card.getRank());

    }
    // Need to test actuated Face card values assigned (expected: 10/11)
    @Test
    public void testFaceCardScores() {
        Card card = new Card("Hearts", "Jack");
        assertEquals(10, card.getScore());
        Card card2 = new Card("Hearts", "Queen");
        assertEquals(10, card2.getScore());
        Card card3 = new Card("Hearts", "King");
        assertEquals(10, card3.getScore());
        Card card4 = new Card("Hearts", "Ace");
        assertEquals(11, card4.getScore());
    }
}