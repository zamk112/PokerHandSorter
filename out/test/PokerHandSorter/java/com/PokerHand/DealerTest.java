package com.PokerHand;

import com.Card.Hand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {
    private Hand highCard;
    private Hand pair;
    private Hand twoPairs;
    private Hand threeOfAkind;
    private Hand straight;
    private Hand flush;
    private Hand fullHouse;
    private Hand fourOfAKind;
    private Hand straightFlush;
    private Hand royalFlush;

    int rank;

    @BeforeEach
    public void setUp() {
        highCard = new Hand();
        highCard.put("8D");
        highCard.put("5C");
        highCard.put("KD");
        highCard.put("6H");
        highCard.put("9S");

        pair = new Hand();
        pair.put("5D");
        pair.put("KS");
        pair.put("8H");
        pair.put("5H");
        pair.put("6D");

        twoPairs = new Hand();
        twoPairs.put("6D");
        twoPairs.put("9H");
        twoPairs.put("KC");
        twoPairs.put("9S");
        twoPairs.put("6H");


        threeOfAkind = new Hand();
        threeOfAkind.put("7S");
        threeOfAkind.put("9C");
        threeOfAkind.put("5D");
        threeOfAkind.put("7H");
        threeOfAkind.put("7C");


        straight = new Hand();
        straight.put("5D");
        straight.put("8C");
        straight.put("7S");
        straight.put("6H");
        straight.put("9D");

        flush = new Hand();
        flush.put("JS");
        flush.put("AS");
        flush.put("5S");
        flush.put("KS");
        flush.put("3S");

        fullHouse = new Hand();
        fullHouse.put("4D");
        fullHouse.put("7S");
        fullHouse.put("4S");
        fullHouse.put("7D");
        fullHouse.put("4H");

        fourOfAKind = new Hand();
        fourOfAKind.put("10D");
        fourOfAKind.put("10H");
        fourOfAKind.put("QD");
        fourOfAKind.put("10S");
        fourOfAKind.put("10C");

        straightFlush = new Hand();
        straightFlush.put("9S");
        straightFlush.put("6S");
        straightFlush.put("5S");
        straightFlush.put("8S");
        straightFlush.put("7S");

        royalFlush = new Hand();
        royalFlush.put("AC");
        royalFlush.put("QC");
        royalFlush.put("JC");
        royalFlush.put("10C");
        royalFlush.put("KC");

    }

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

    @Test
    void setRanking() {
//        rank = Dealer.setRanking(highCard.getHand());
//        assertEquals(0, rank);
//
//        rank = Dealer.setRanking(pair.getHand());
//        assertEquals(1, rank);
//
//        rank = Dealer.setRanking(twoPairs.getHand());
//        assertEquals(2, rank);
//
//        rank = Dealer.setRanking(threeOfAkind.getHand());
//        assertEquals(3, rank);
//
//        rank = Dealer.setRanking(straight.getHand());
//        assertEquals(4, rank);
//
//        rank = Dealer.setRanking(flush.getHand());
//        assertEquals(5, rank);
//
//        rank = Dealer.setRanking(fullHouse.getHand());
//        assertEquals(6, rank);
//
//        rank = Dealer.setRanking(fourOfAKind.getHand());
//        assertEquals(7, rank);
//
//        rank = Dealer.setRanking(straightFlush.getHand());
//        assertEquals(8, rank);
//
//        rank = Dealer.setRanking(royalFlush.getHand());
//        assertEquals(9, rank);
    }
}