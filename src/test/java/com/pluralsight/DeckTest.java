package com.pluralsight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void testCreateDeck() {
        Deck deck = new Deck();
        assertNotNull(deck); // (Existing deck?)
        assertEquals(52, deck.getCards().size()); // Deck = 52 Cards
    }

    @Test
    void testShuffleDeck() {
        Deck deck = new Deck();
        Deck shuffling = new Deck();
        shuffling.shuffle();
        assertNotEquals(deck.getCards(), shuffling.getCards()); // Compare pre- / post-shuffling (Not the same?)
    }

    @Test
    void testSplitDeck() {
        Deck deck = new Deck();
        for (int i = 0; i < 2; i++) { // Split 2 Cards initially
            Card playerCards = deck.split();
            assertNotNull(playerCards); // (Player got their split?)
        }
        assertEquals(50, deck.getCards().size()); // Expected card remainder
    }
}