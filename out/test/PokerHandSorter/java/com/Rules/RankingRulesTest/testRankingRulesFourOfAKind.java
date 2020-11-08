package com.Rules.RankingRulesTest;

import com.Rules.Combination;
import com.Card.Ranking;
import com.Rules.RankingRules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class testRankingRulesFourOfAKind {
    public int[][] testFourOfAKind;
    public int[][] testFourOfAKind2;
    public int[][] testFourOfAKind3;

    Ranking rank;

    @BeforeEach
    public void setUp() {
        testFourOfAKind = new int[][]{
                {8, 1, 1, 1, 1},
                {10, 1, 0, 0, 0}
        };

        testFourOfAKind2 = new int[][]{
                {6, 0, 1, 0, 0},
                {9, 1, 1, 1, 1}
        };

        testFourOfAKind3 = new int[][]{
                {6, 0, 1, 0, 0},
                {9, 1, 1, 1, 0},
                {11, 0, 0, 0, 1}
        };
    }

    @Test
    public void testFourOfAKind() {
        rank = RankingRules.fourOfAKind(testFourOfAKind);
        Assertions.assertEquals(Combination.FourOfAKind, rank.getRank());
        assertEquals(1, rank.getCardNum().size());
        assertEquals(8, rank.getCardNum().get(0));
    }

    @Test
    public void testFourOfAKind2() {
        rank = RankingRules.fourOfAKind(testFourOfAKind2);
        assertEquals(Combination.FourOfAKind, rank.getRank());
        assertEquals(1, rank.getCardNum().size());
        assertEquals(9, rank.getCardNum().get(0));
    }

    @Test
    public void testFourOfAKind3() {
        rank = RankingRules.fourOfAKind(testFourOfAKind3);
        assertNull(rank);
    }
}
