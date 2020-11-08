package com.Rules.RankingRulesTest;

import com.Card.Ranking;
import com.Rules.RankingRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class testRankingRulesStraight {
    private int[][] straight;
    private int[][] straight2;
    private int[][] straight3;
    private int[][] straight4;
    private int[][] straight5;
    private int[][] straight6;

    private Ranking rank;

    @BeforeEach
    public void setUp() {
        straight = new int[][]{
                {3, 1, 0, 0, 0},
                {4, 0, 1, 0, 0},
                {5, 0, 0, 1, 0},
                {6, 0, 0, 0, 1},
                {7, 1, 0, 0, 0}
        };

        straight2 = new int[][]{
                {3, 0, 1, 0, 0},
                {4, 0, 0, 1, 0},
                {5, 0, 0, 0, 1},
                {6, 1, 0, 0, 0},
                {7, 0, 1, 0, 0}
        };

        straight3 = new int[][]{
                {3, 0, 0, 1, 0},
                {4, 0, 0, 0, 1},
                {5, 1, 0, 0, 0},
                {6, 0, 1, 0, 0},
                {7, 0, 0, 1, 0}
        };

        straight4 = new int[][]{
                {3, 0, 0, 1, 0},
                {4, 0, 0, 1, 0},
                {5, 0, 0, 1, 0},
                {6, 0, 0, 1, 0},
                {7, 0, 0, 1, 0}
        };

        straight5 = new int[][]{
                {0, 0, 0, 1, 0},
                {4, 0, 0, 1, 0},
                {6, 0, 0, 1, 0},
                {7, 0, 0, 1, 0},
                {9, 0, 0, 1, 0}
        };

        straight6 = new int[][]{
                {3, 0, 0, 1, 0},
                {4, 1, 0, 1, 0},
                {6, 0, 1, 1, 0}
        };
    }

    @Test
    public void testStraight() {
        rank = RankingRules.straight(straight);
        assertEquals(5, rank.getCardNum().size());
        assertEquals(3, rank.getCardNum().get(0));
        assertEquals(4, rank.getCardNum().get(1));
        assertEquals(5, rank.getCardNum().get(2));
        assertEquals(6, rank.getCardNum().get(3));
        assertEquals(7, rank.getCardNum().get(4));
    }

    @Test
    public void testStraight2() {
        rank = RankingRules.straight(straight2);
        assertEquals(5, rank.getCardNum().size());
        assertEquals(3, rank.getCardNum().get(0));
        assertEquals(4, rank.getCardNum().get(1));
        assertEquals(5, rank.getCardNum().get(2));
        assertEquals(6, rank.getCardNum().get(3));
        assertEquals(7, rank.getCardNum().get(4));
    }

    @Test
    public void testStraight3() {
        rank = RankingRules.straight(straight3);
        assertEquals(5, rank.getCardNum().size());
        assertEquals(3, rank.getCardNum().get(0));
        assertEquals(4, rank.getCardNum().get(1));
        assertEquals(5, rank.getCardNum().get(2));
        assertEquals(6, rank.getCardNum().get(3));
        assertEquals(7, rank.getCardNum().get(4));
    }

    @Test
    public void testStraight4() {
        rank = RankingRules.straight(straight4);
        assertEquals(5, rank.getCardNum().size());
        assertEquals(3, rank.getCardNum().get(0));
        assertEquals(4, rank.getCardNum().get(1));
        assertEquals(5, rank.getCardNum().get(2));
        assertEquals(6, rank.getCardNum().get(3));
        assertEquals(7, rank.getCardNum().get(4));
    }

    @Test
    public void testStraight5() {
        rank = RankingRules.straight(straight5);
        assertNull(rank);
    }

    @Test
    public void testStraight6() {
        rank = RankingRules.straight(straight6);
        assertNull(rank);
    }
}
