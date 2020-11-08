package com.Rules.RankingRulesTest;

import com.Card.Ranking;
import com.Rules.RankingRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testRankingRulesFlush {
    private int[][] flush;
    private int[][] flush2;
    private int[][] flush3;

    Ranking rank;

    @BeforeEach
    public void setUp() {
        flush = new int[][]{
                {1, 0, 0, 1, 0},
                {3, 0, 0, 1, 0},
                {9, 0, 0, 1, 0},
                {11, 0, 0, 1, 0},
                {12, 0, 0, 1, 0}
        };

        flush2 = new int[][]{
                {3, 0, 1, 0, 0},
                {4, 0, 1, 0, 0},
                {5, 0, 1, 0, 0},
                {6, 0, 1, 0, 0},
                {7, 0, 1, 0, 0}
        };

        flush3 = new int[][]{
                {3, 0, 1, 0, 0},
                {4, 0, 1, 1, 0},
                {5, 0, 1, 1, 0}
        };
    }

    @Test
    public void testFlush() {
        rank = RankingRules.flush(flush);
        assertEquals(5, rank.getCardNum().size());
        assertEquals(1, rank.getCardNum().get(0));
        assertEquals(3, rank.getCardNum().get(1));
        assertEquals(9, rank.getCardNum().get(2));
        assertEquals(11, rank.getCardNum().get(3));
        assertEquals(12, rank.getCardNum().get(4));
    }

    @Test
    public void testFlush2() {
        rank = RankingRules.flush(flush2);
        assertEquals(5, rank.getCardNum().size());
        assertEquals(3, rank.getCardNum().get(0));
        assertEquals(4, rank.getCardNum().get(1));
        assertEquals(5, rank.getCardNum().get(2));
        assertEquals(6, rank.getCardNum().get(3));
        assertEquals(7, rank.getCardNum().get(4));
    }

    @Test
    public void testFlush3() {
        rank = RankingRules.flush(flush3);
        assertNull(rank);
    }
}
