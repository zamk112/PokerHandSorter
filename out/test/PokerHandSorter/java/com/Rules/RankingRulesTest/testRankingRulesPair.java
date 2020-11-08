package com.Rules.RankingRulesTest;

import com.Rules.Combination;
import com.Card.Ranking;
import com.Rules.RankingRules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testRankingRulesPair {
    private int[][] pair;
    private int[][] pair2;
    private int[][] pair3;
    private int[][] pair4;

    private Ranking rank;

    @BeforeEach
    public void setUp() {
        pair = new int[][] {
                {3, 1, 1, 0, 0},
                {4, 1, 0, 0, 0},
                {6, 0, 1, 0, 0},
                {11, 0, 0, 1, 0}
        };

        pair2 = new int[][] {
                {2, 0, 0, 0, 1},
                {5, 1, 0, 0, 0},
                {9, 1, 1, 0, 0},
                {10, 0, 0, 1, 0}
        };

        pair3 = new int[][] {
                {5, 1, 1, 0, 0},
                {10, 1, 1, 0, 0},
                {12, 0, 0, 1, 0}
        };

        pair4 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
    }

    @Test
    public void testPair() {
        rank = RankingRules.pair(pair);
        Assertions.assertEquals(Combination.Pair, rank.getRank());
        assertEquals(1, rank.getCardNum().size());
        assertEquals(3, rank.getCardNum().get(0));
    }

    @Test
    public void testPair2() {
        rank = RankingRules.pair(pair2);
        assertEquals(Combination.Pair, rank.getRank());
        assertEquals(1, rank.getCardNum().size());
        assertEquals(9, rank.getCardNum().get(0));
    }

    @Test
    public void testPair3() {
        rank = RankingRules.pair(pair3);
        assertNull(rank.getRank());

    }

}
