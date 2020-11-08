package com.Rules.RankingRulesTest;

import com.Rules.Combination;
import com.Card.Ranking;
import com.Rules.RankingRules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class testRankingRulesTwoPairs {
    private int[][] twoPairs;
    private int[][] twoPairs2;
    private int[][] twoPairs3;
    private int[][] twoPairs4;

    private Ranking rank;

    @BeforeEach
    public void setUp() {
        twoPairs = new int[][] {
                {4, 1, 1, 0, 0},
                {7, 0, 1, 1, 0},
                {11, 0, 0, 0, 1}
        };

        twoPairs2 = new int[][] {
                {5, 1, 1, 0, 0},
                {9, 0, 0, 1, 0},
                {11, 0, 0, 1, 1}
        };

        twoPairs3 = new int[][] {
                {3, 0, 1, 0, 0},
                {6, 1, 0, 1, 0},
                {10, 0, 0, 1, 1}
        };

        twoPairs4 = new int[][] {
                {3, 0, 1, 0, 0},
                {6, 1, 0, 1, 0},
                {10, 0, 0, 1, 0},
                {12, 0, 0, 0, 1},
        };
    }

    @Test
    public void testTwoPairs() {
        rank = RankingRules.twoPairs(twoPairs);
        Assertions.assertEquals(Combination.TwoPairs, rank.getRank());
        assertEquals(2, rank.getCardNum().size());
        assertEquals(4, rank.getCardNum().get(0));
        assertEquals(7, rank.getCardNum().get(1));
    }

    @Test
    public void testTwoPairs2() {
        rank = RankingRules.twoPairs(twoPairs2);
        assertEquals(Combination.TwoPairs, rank.getRank());
        assertEquals(2, rank.getCardNum().size());
        assertEquals(5, rank.getCardNum().get(0));
        assertEquals(11, rank.getCardNum().get(1));
    }


    @Test
    public void testTwoPairs3() {
        rank = RankingRules.twoPairs(twoPairs3);
        assertEquals(Combination.TwoPairs, rank.getRank());
        assertEquals(2, rank.getCardNum().size());
        assertEquals(6, rank.getCardNum().get(0));
        assertEquals(10, rank.getCardNum().get(1));
    }

    @Test
    public void testTwoPairs4() {
        rank = RankingRules.twoPairs(twoPairs4);
        assertNull(rank.getRank());
        assertNull(rank.getCardNum());
    }
}
