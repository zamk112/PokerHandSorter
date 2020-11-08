package com.Rules.RankingRulesTest;

import com.Rules.Combination;
import com.Card.Ranking;
import com.Rules.RankingRules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testRankingRulesHighCard {
    private int[][] highCard;
    private int[][] highCard2;
    private int[][] highCard3;

    private Ranking rank;

    @BeforeEach
    public void setUp() {
        highCard = new int[][]{
                {3, 0, 0, 0, 1},
                {5, 0, 1, 0, 0},
                {7, 1, 1, 0, 0},
                {12, 1, 0, 0, 0}
        };

        highCard2 = new int[][]{
                {4, 0, 1, 0, 0},
                {5, 0, 1, 0, 0},
                {7, 0, 1, 0, 0},
                {9, 0, 1, 0, 0},
                {10, 0, 1, 0, 0}
        };

        highCard3 = new int[][]{
                {5, 0, 1, 0, 0},
                {7, 0, 1, 1, 0},
                {9, 0, 1, 0, 1}
        };

    }

    @Test
    public void testHighCard() {
        rank = RankingRules.highCard(highCard);
        Assertions.assertEquals(Combination.HighCard, rank.getRank());
        assertEquals(3, rank.getCardNum().size());
        assertEquals(3, rank.getCardNum().get(0));
        assertEquals(5, rank.getCardNum().get(1));
        assertEquals(12, rank.getCardNum().get(2));
    }

    @Test
    public void testHighCard2() {
        rank = RankingRules.highCard(highCard2);
        assertEquals(Combination.HighCard, rank.getRank());
        assertEquals(5, rank.getCardNum().size());
        assertEquals(4, rank.getCardNum().get(0));
        assertEquals(5, rank.getCardNum().get(1));
        assertEquals(7, rank.getCardNum().get(2));
        assertEquals(9, rank.getCardNum().get(3));
        assertEquals(10, rank.getCardNum().get(4));
    }

    @Test
    public void testHighCard3() {
        rank = RankingRules.highCard(highCard3);
        assertEquals(Combination.HighCard, rank.getRank());
        assertEquals(1, rank.getCardNum().size());
        assertEquals(5, rank.getCardNum().get(0));
    }

}
