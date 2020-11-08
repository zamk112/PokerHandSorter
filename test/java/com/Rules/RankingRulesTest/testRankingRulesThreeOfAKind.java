package com.Rules.RankingRulesTest;

import com.Rules.Combination;
import com.Card.Ranking;
import com.Rules.RankingRules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class testRankingRulesThreeOfAKind {
    private int[][] threeOfAKind;
    private int[][] threeOfAKind2;
    private int[][] threeOfAKind3;
    private int[][] threeOfAKind4;
    private int[][] threeOfAKind5;

    private Ranking rank;

    @BeforeEach
    public void setUp() {
        threeOfAKind = new int[][] {
                {3, 1, 1, 1, 0},
                {4, 1, 0, 0, 0},
                {8, 0, 1, 0, 0}
        };

        threeOfAKind2 = new int[][] {
                {3, 0, 1, 0, 0},
                {5, 0, 1, 1, 1},
                {9, 0, 0, 1, 0}
        };

        threeOfAKind3 = new int[][] {
                {2, 1, 0, 1, 1},
                {9, 0, 0, 1, 0},
                {11, 0, 0, 1, 0},
        };


        threeOfAKind4 = new int[][] {
                {6, 1, 1, 0, 1},
                {8, 0, 0, 1, 0},
                {12, 0, 0, 1, 0},
        };

        threeOfAKind5 = new int[][] {
                {6, 1, 0, 0, 1},
                {8, 0, 1, 1, 0},
                {12, 0, 0, 1, 0},
        };

    }

    @Test
    public void testThreeOfAKind() {
        rank = RankingRules.threeOfAKind(threeOfAKind);
        Assertions.assertEquals(Combination.ThreeOfAKind, rank.getRank());
        assertEquals(1, rank.getCardNum().size());
        assertEquals(3, rank.getCardNum().get(0));
    }

    @Test
    public void testThreeOfAKind2() {
        rank = RankingRules.threeOfAKind(threeOfAKind2);
        assertEquals(Combination.ThreeOfAKind, rank.getRank());
        assertEquals(1, rank.getCardNum().size());
        assertEquals(5, rank.getCardNum().get(0));
    }

    @Test
    public void testThreeOfAKind3() {
        rank = RankingRules.threeOfAKind(threeOfAKind3);
        assertEquals(Combination.ThreeOfAKind, rank.getRank());
        assertEquals(1, rank.getCardNum().size());
        assertEquals(2, rank.getCardNum().get(0));
    }
    @Test
    public void testThreeOfAKind4() {
        rank = RankingRules.threeOfAKind(threeOfAKind4);
        assertEquals(Combination.ThreeOfAKind, rank.getRank());
        assertEquals(1, rank.getCardNum().size());
        assertEquals(6, rank.getCardNum().get(0));
    }

    @Test
    public void testThreeOfAKind5() {
        rank = RankingRules.threeOfAKind(threeOfAKind5);
        assertNull(rank);
    }
}
