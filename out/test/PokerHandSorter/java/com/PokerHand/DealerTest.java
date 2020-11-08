package com.PokerHand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    @Test
    public void isValidCard() {
        assertEquals(6, Dealer.isValidCard("8D"));
        assertEquals(-1, Dealer.isValidCard("D8"));
        assertEquals(9, Dealer.isValidCard("JD"));
        assertEquals(12, Dealer.isValidCard("AK"));         // This is still a valid test because of first character is a valid character
        assertEquals(-1, Dealer.isValidCard("ZZ"));
        assertEquals(-1, Dealer.isValidCard("jS"));
        assertEquals(-1, Dealer.isValidCard("ah"));
        assertEquals(11, Dealer.isValidCard("Kc"));
    }

    @Test
    public void isValidSuit() {
        assertEquals(1, Dealer.isValidSuit("6H"));
        assertEquals(-1, Dealer.isValidSuit("8c"));
        assertEquals(-1, Dealer.isValidSuit("AK"));
        assertEquals(2, Dealer.isValidSuit("jS"));
        assertEquals(0, Dealer.isValidSuit("DD"));
        assertEquals(3, Dealer.isValidSuit("cC"));

    }

}