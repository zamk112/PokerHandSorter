package com.PokerHand;

import com.Card.Card;
import com.Card.Suit;
import com.Rules.Combination;
import com.Card.Ranking;
import com.Rules.RankingRules;

import java.util.ArrayList;
import java.util.Map;

public class Dealer {
    public final static char cardRange[] = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
    public final static char suitRange[] = {'D', 'H', 'S', 'C'};

    public static int isValidCard (String card) {
        if (card.length() > 1) {
            for (int i = 0; i < cardRange.length; i++)
                if (card.charAt(0) == cardRange[i])
                    return i;
        }

        return -1;
    }

    public static int isValidSuit(String card) {
        for (int i = 0; i < suitRange.length; i++)
            if (card.charAt(1) == suitRange[i])
                return i;

        return -1;
    }

    public static ArrayList<Ranking> setRanking(Map<Card, ArrayList<Suit>> hand) {
        ArrayList<Ranking> SavedRanking = new ArrayList<Ranking>();
        int ranking[][] = new int[hand.size()][5];
        int i = 0, count = 0, rank = -1;

        for (Map.Entry<Card, ArrayList<Suit>> entry: hand.entrySet()) {
            ranking[i][0] = entry.getKey().getOrder();
            ArrayList<Suit> suitList = entry.getValue();
            for (Suit s: suitList) {
                switch (s.getIndex()) {
                    case 0:
                        ranking[i][1] = 1;
                        count++;
                        break;
                    case 1:
                        ranking[i][2] = 1;
                        count++;
                        break;
                    case 2:
                        ranking[i][3] = 1;
                        count++;
                        break;
                    case 3:
                        ranking[i][4] = 1;
                        count++;
                        break;
                }

            }
            i++;
        }

        // Run through the gauntlet of Ranking Checks!!
        if (count == 5) {
            Ranking rankScore = RankingRules.highCard(ranking);
            if (rankScore != null && rankScore.getRank() == Combination.HighCard)
                SavedRanking.add(rankScore);

            rankScore = RankingRules.pair(ranking);
            if (rankScore != null && rankScore.getRank() == Combination.Pair)
                SavedRanking.add(rankScore);

            rankScore = RankingRules.twoPairs(ranking);
            if (rankScore != null && rankScore.getRank() == Combination.TwoPairs)
                SavedRanking.add(rankScore);

            rankScore = RankingRules.threeOfAKind(ranking);
            if (rankScore != null && rankScore.getRank() == Combination.ThreeOfAKind)
                SavedRanking.add(rankScore);

            rankScore = RankingRules.straight(ranking);
            if (rankScore != null && rankScore.getRank() == Combination.Straight)
                SavedRanking.add(rankScore);

            rankScore = RankingRules.flush(ranking);
            if (rankScore != null && rankScore.getRank() == Combination.Flush)
                SavedRanking.add(rankScore);

            rankScore = RankingRules.fullHouse(ranking);
            if (rankScore != null && rankScore.getRank() == Combination.FullHouse)
                SavedRanking.add(rankScore);

            rankScore = RankingRules.fourOfAKind(ranking);
            if (rankScore != null && rankScore.getRank() == Combination.FourOfAKind)
                SavedRanking.add(rankScore);

            rankScore = RankingRules.straightFlush(ranking);
            if (rankScore != null && rankScore.getRank() == Combination.StraightFlush)
                SavedRanking.add(rankScore);

            rankScore = RankingRules.royalFlush(ranking);
            if (rankScore != null && rankScore.getRank() == Combination.RoyalFlush)
                SavedRanking.add(rankScore);
        }

        return SavedRanking;
    }

}
