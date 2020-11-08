package com.Rules;

import com.Card.Ranking;

import java.util.ArrayList;

public class RankingChecks {

    public static int checking(ArrayList<Ranking> p1Rank, ArrayList<Ranking> p2Rank, int p1Size, int p2Size, String inString) {

        try {
            if (p1Rank.get(p1Size).getRank().ordinal() > p2Rank.get(p2Size).getRank().ordinal())
                return 0;
            else if (p1Rank.get(p1Size).getRank().ordinal() < p2Rank.get(p2Size).getRank().ordinal())
                return 1;
            else if (p1Rank.get(p1Size).getRank().ordinal() == p2Rank.get(p2Size).getRank().ordinal()) {
                // Get the highest card and in their current rank and compare
                ArrayList<Integer> p1Hand = (ArrayList<Integer>) p1Rank.get(p1Size).getCardNum();
                ArrayList<Integer> p2Hand = (ArrayList<Integer>) p2Rank.get(p2Size).getCardNum();
                int winner = checkHighestCard(p1Hand, p2Hand, p1Hand.size(), p2Hand.size());

                if (winner == -1)
                    return checking(p1Rank, p2Rank, p1Size-1, p2Size-1, inString);
                else
                    return winner;
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Error on " + inString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return -1;
    }

    private static int checkHighestCard(ArrayList<Integer> p1Hand, ArrayList<Integer> p2Hand, int p1HandSize, int p2HandSize) {

        if (p1HandSize < 1 || p2HandSize < 1)
            return -1;

        if (p1Hand.get(p1HandSize-1) == p2Hand.get(p2HandSize-1))
            return checkHighestCard(p1Hand, p2Hand, p1HandSize-1, p2HandSize-1);
        else if (p1Hand.get(p1HandSize-1) > p2Hand.get(p2HandSize-1))
            return 0;
        else if (p1Hand.get(p1HandSize-1) < p2Hand.get(p2HandSize-1))
            return 1;

        return -1;
    }
}
