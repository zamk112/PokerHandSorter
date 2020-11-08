package com.Rules.RankingRulesTest;

import com.Card.Ranking;
import com.Rules.RankingRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class testRankingRulesStraightFlush {
    private int[][] striaghtFlush;
    private int[][] striaghtFlush2;
    private int[][] straight;
    private int[][] striaghtFlush3;

    private Ranking rank;

    @BeforeEach
    public void setUp() {
        striaghtFlush = new int[][]{
                {3, 0, 0, 1, 0},
                {4, 0, 0, 1, 0},
                {5, 0, 0, 1, 0},
                {6, 0, 0, 1, 0},
                {7, 0, 0, 1, 0}
        };

        striaghtFlush2 = new int[][]{
                {3, 0, 1, 0, 0},
                {4, 0, 1, 0, 0},
                {5, 0, 1, 0, 0},
                {6, 0, 1, 0, 0},
                {7, 0, 1, 0, 0}
        };

        straight = new int[][]{
                {3, 1, 0, 0, 0},
                {4, 0, 1, 0, 0},
                {5, 0, 0, 1, 0},
                {6, 0, 0, 0, 1},
                {7, 1, 0, 0, 0}
        };

        striaghtFlush3 = new int[][]{
                {3, 0, 0, 1, 0},
                {4, 1, 0, 1, 0},
                {6, 0, 1, 1, 0}
        };
    }

    @Test
    public void testFlush() {
        rank = RankingRules.straightFlush(striaghtFlush);
        assertEquals(5, rank.getCardNum().size());
        assertEquals(3, rank.getCardNum().get(0));
        assertEquals(4, rank.getCardNum().get(1));
        assertEquals(5, rank.getCardNum().get(2));
        assertEquals(6, rank.getCardNum().get(3));
        assertEquals(7, rank.getCardNum().get(4));
    }

    @Test
    public void testFlush2() {
        rank = RankingRules.straightFlush(striaghtFlush2);
        assertEquals(5, rank.getCardNum().size());
        assertEquals(3, rank.getCardNum().get(0));
        assertEquals(4, rank.getCardNum().get(1));
        assertEquals(5, rank.getCardNum().get(2));
        assertEquals(6, rank.getCardNum().get(3));
        assertEquals(7, rank.getCardNum().get(4));
    }

    @Test
    public void testStraight() {
        rank = RankingRules.straightFlush(straight);
        assertNull(rank);
    }

    @Test
    public void testFlush3() {
        rank = RankingRules.straightFlush(striaghtFlush3);
        assertNull(rank);
    }
}
