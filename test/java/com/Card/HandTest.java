package com.Card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
    private Hand h1;
    private ArrayList<Suit> s2;
    private ArrayList<Suit> sA;

    @BeforeEach
    public void setUp() {
        h1 = new Hand();
        // Valid Input
        h1.put("2D");
        h1.put("2C");
        h1.put("AC");
        // Invalid Input
        h1.put("SC");
        h1.put("jh");
        h1.put("9Z");
        h1.put("LC");
        h1.put("GG");
    }

    @Test
    public void getContainsCard() {
        assertTrue(h1.getHand().containsKey(new Card('2', 0)));
        assertFalse(h1.getHand().containsKey(new Card('S', -1)));
        assertFalse(h1.getHand().containsKey(new Card('Z', 20)));
        assertTrue(h1.getHand().containsKey(new Card('A', 12)));
        assertFalse(h1.getHand().containsKey(new Card('9', 8)));

        // Comparion is based on Card.order, even though card character is incorrect
        assertTrue(h1.getHand().containsKey(new Card('S', 0)));
        assertTrue(h1.getHand().containsKey(new Card('T', 12)));

        // Valid Character but incorrect number
        assertFalse(h1.getHand().containsKey(new Card('2', 99)));
        assertFalse(h1.getHand().containsKey(new Card('A', 2000)));
    }

    @Test
    public void checkSuit() {
       s2 = h1.getHand().get(new Card('2', 0));
       sA = h1.getHand().get(new Card('A', 12));

        assertTrue(s2.contains(new Suit('D', 0)));
        assertTrue(s2.contains(new Suit('C', 3)));
        assertFalse(s2.contains(new Suit('H', 1)));
        assertFalse(s2.contains(new Suit('Z', 23)));

        assertTrue(sA.contains(new Suit('C', 3)));
        assertFalse(sA.contains(new Suit('S', 2)));
        assertFalse(sA.contains(new Suit('S', 2)));


        // Comparion is based on Suit.Index, even though card character is incorrect
        assertTrue(s2.contains(new Suit('Z', 0)));
        assertTrue(sA.contains(new Suit('E', 3)));

        // Valid Character but invalid number
        assertFalse(s2.contains(new Suit('D', 50)));
        assertFalse(sA.contains(new Suit('C', 300)));
    }

}