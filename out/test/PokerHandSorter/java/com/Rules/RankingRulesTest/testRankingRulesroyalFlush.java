package com.Rules.RankingRulesTest;
import com.Card.Ranking;
import com.Rules.RankingRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class testRankingRulesroyalFlush {
    private int[][] testRoyalFlush;
    private int[][] striaghtFlush;
    private int[][] straight;

    Ranking rank;

    @BeforeEach
    public void setUp() {
        testRoyalFlush = new int[][] {
                {8, 1, 0, 0, 0},
                {9, 1, 0, 0, 0},
                {10, 1, 0, 0, 0},
                {11, 1, 0, 0, 0},
                {12, 1, 0, 0, 0},
        };

        striaghtFlush = new int[][]{
                {3, 0, 0, 1, 0},
                {4, 0, 0, 1, 0},
                {5, 0, 0, 1, 0},
                {6, 0, 0, 1, 0},
                {7, 0, 0, 1, 0}
        };

        straight = new int[][]{
                {3, 1, 0, 0, 0},
                {4, 0, 1, 0, 0},
                {5, 0, 0, 1, 0},
                {6, 0, 0, 0, 1},
                {7, 1, 0, 0, 0}
        };
    }

    @Test
    public void testRoyalFlush() {
        rank = RankingRules.royalFlush(testRoyalFlush);
        assertEquals(5, rank.getCardNum().size());
        assertEquals(8, rank.getCardNum().get(0));
        assertEquals(9, rank.getCardNum().get(1));
        assertEquals(10, rank.getCardNum().get(2));
        assertEquals(11, rank.getCardNum().get(3));
        assertEquals(12, rank.getCardNum().get(4));
    }

    @Test
    public void testStriaghtFlush() {
        rank = RankingRules.royalFlush(striaghtFlush);
        assertNull(rank);
    }

    @Test
    public void testStraight() {
        rank = RankingRules.royalFlush(straight);
        assertNull(rank);
    }
}
