package com.Rules.RankingRulesTest;

import com.Card.Ranking;
import com.Rules.RankingRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testRankingRulesFullHouse {
    private int[][] fullHouse;
    private int[][] fullHouse2;
    private int[][] fullHouse3;

    Ranking rank;

    @BeforeEach
    public void setUp() {
        fullHouse = new int[][] {
                {2, 1, 1, 1, 0},
                {5, 1, 0, 1, 0}
        };

        fullHouse2 = new int[][] {
                {8, 1, 0, 1, 0},
                {10, 1, 0, 1, 1}
        };

        fullHouse3 = new int[][] {
                {4, 1, 0, 1, 0},
                {7, 1, 0, 1, 0},
                {9, 0, 1, 0, 0}
        };
    }

    @Test
    public void testFullHouse() {
        rank = RankingRules.fullHouse(fullHouse);
        assertEquals(2, rank.getCardNum().size());
        assertEquals(2, rank.getCardNum().get(0));
        assertEquals(5, rank.getCardNum().get(1));
    }

    @Test
    public void testFullHouse2() {
        rank = RankingRules.fullHouse(fullHouse2);
        assertEquals(2, rank.getCardNum().size());
        assertEquals(8, rank.getCardNum().get(0));
        assertEquals(10, rank.getCardNum().get(1));
    }

    @Test
    public void testFullHouse3() {
        rank = RankingRules.fullHouse(fullHouse3);
        assertNull(rank);
    }

}
