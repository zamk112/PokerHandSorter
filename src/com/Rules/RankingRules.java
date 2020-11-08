package com.Rules;

import com.Card.Ranking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankingRules {
    /**
     * This function will check if there is a card with the highest value.
     * And will overwrite the previous highest single value card.
     * @param showHand
     * @return Ranking
     */
    public static Ranking highCard(int[][] showHand) {
        if (showHand != null) {
            int highestCard = 0;
            List<Integer> cardNums = new ArrayList<Integer>();
            for (int i = 0; i < showHand.length; i++) {
                int count = 0;
                for (int j = 1; j < showHand[i].length; j++) {
                    if (showHand[i][j] == 1) {
                        count++;
                    }
                }
                if (count == 1 && showHand[i][0] >= highestCard) {
                    highestCard = showHand[i][0];
                    cardNums.add(highestCard);
                }
            }

            return new Ranking(Combination.HighCard, cardNums);
        }

        return null;
    }

    /**
     * This function will check if there is a pair. Each time it finds the pair; it will
     * overwrite the previous pair.
     * @param showHand
     * @return Ranking
     */
    public static Ranking pair(int[][] showHand) {
        if (showHand != null) {
            List<Integer> cardNums = new ArrayList<Integer>();;
            for (int i = 0; i < showHand.length;i++) {
                int count = 0;
                for (int j = 1; j < showHand[i].length; j++) {
                    if (showHand[i][j] == 1) {
                        count++;
                    }
                }
                if (count == 2) {
                    cardNums.add(showHand[i][0]);
                }
            }

            if (cardNums.size() == 1) {
                return new Ranking(Combination.Pair, cardNums);
            }
        }

        return null;
    }

    /**
     * @param showHand
     * @return Ranking
     */
    public static Ranking twoPairs(int[][] showHand) {
        if (showHand != null) {
            List<Integer> cardNums = new ArrayList<Integer>();
            for (int i = 0; i < showHand.length;i++) {
                int count = 0;
                for (int j = 1; j < showHand[i].length; j++) {
                    if (showHand[i][j] == 1) {
                        count++;
                    }
                }
                if (count == 2 && cardNums.size() < 2)
                    cardNums.add(showHand[i][0]);
            }


            if (cardNums.size() == 2)
                return new Ranking(Combination.TwoPairs, cardNums);

        }
        return null;
    }

    public static Ranking threeOfAKind(int[][] showHand) {
        if (showHand != null) {
            List<Integer> cardNums = new ArrayList<Integer>();
            for (int i = 0; i < showHand.length;i++) {
                int count = 0;
                for (int j = 1; j < showHand[i].length; j++) {
                    if (showHand[i][j] == 1) {
                        count++;
                    }
                }
                if (count == 3)
                    cardNums.add(showHand[i][0]);
            }


            if (cardNums.size() == 1)
                return new Ranking(Combination.ThreeOfAKind, cardNums);

        }
        return null;
    }

    public static Ranking straight(int[][] showHand) {
        if (showHand != null && showHand.length == 5) {
            List<Integer> cardNums = new ArrayList<Integer>();
            for (int i = 0; i < showHand.length; i++) {
                if (i < showHand.length-1 && showHand[i+1][0]-showHand[i][0] == 1) {
                    cardNums.add(showHand[i][0]);
                }
                else if (i == showHand.length-1 && showHand[i][0]-showHand[i-1][0] == 1) {
                    cardNums.add(showHand[i][0]);
                }
            }

            if (cardNums.size() == 5)
                return new Ranking(Combination.Straight, cardNums);
        }

        return null;
    }

    public static Ranking flush(int[][] showHand) {
        if (showHand != null && showHand.length == 5) {
            List<Integer> cardNums = new ArrayList<Integer>();
            int matchSuitIndex = 0;
            for (int i = 0; i < showHand.length; i++) {
                int count = 0;
                for (int j = 1; j < showHand[i].length; j++) {
                    if (matchSuitIndex == 0 && showHand[i][j] == 1) {
                        matchSuitIndex = j;
                        cardNums.add(showHand[i][0]);
                    }
                    else if (showHand[i][j] == 1 && matchSuitIndex == j)
                        cardNums.add(showHand[i][0]);
                }
            }

            if (cardNums.size() == 5)
                return new Ranking(Combination.Flush, cardNums);
        }

        return null;
    }

    public static Ranking fullHouse(int[][] showHand) {
        if (showHand != null && showHand.length == 2) {
            Ranking threeOfAKind = RankingRules.threeOfAKind(showHand);
            Ranking aPair = RankingRules.pair(showHand);

            if ((threeOfAKind != null && threeOfAKind.getRank() == Combination.ThreeOfAKind) && (aPair != null && aPair.getRank() == Combination.Pair)) {
                List<Integer> cardNums = new ArrayList<Integer>();
                cardNums.addAll(threeOfAKind.getCardNum());
                cardNums.addAll(aPair.getCardNum());
                Collections.sort(cardNums);

                return new Ranking(Combination.FullHouse, cardNums);
            }
        }

        return null;
    }


    public static Ranking fourOfAKind(int[][] showHand) {
        if (showHand != null && showHand.length == 2) {
            List<Integer> cardNums = new ArrayList<Integer>();
            for (int i = 0; i < showHand.length;i++) {
                int count = 0;
                for (int j = 1; j < showHand[i].length; j++) {
                    if (showHand[i][j] == 1) {
                        count++;
                    }
                }
                if (count == 4)
                    cardNums.add(showHand[i][0]);
            }


            if (cardNums.size() == 1)
                return new Ranking(Combination.FourOfAKind, cardNums);

        }
        return null;
    }

    public static Ranking straightFlush(int[][] showHand) {
        if (showHand != null && showHand.length == 5) {
            Ranking straight = RankingRules.straight(showHand);
            Ranking flush = RankingRules.flush(showHand);

            if ((straight != null && straight.getRank() == Combination.Straight) && (flush != null && flush.getRank() == Combination.Flush)) {
                List<Integer> cardNums = new ArrayList<Integer>();
                cardNums.addAll(straight.getCardNum());

                return new Ranking(Combination.StraightFlush, cardNums);
            }
        }

        return null;
    }

    public static Ranking royalFlush(int[][] showHand) {
        if (showHand != null && showHand.length == 5) {
            if (showHand[0][0] == 8 && showHand[1][0] == 9 && showHand[2][0] == 10 && showHand[3][0] == 11 && showHand[4][0] == 12) {
                Ranking flush = RankingRules.flush(showHand);

                if (flush != null && flush.getRank() == Combination.Flush) {
                    return new Ranking(Combination.RoyalFlush, flush.getCardNum());
                }
            }
        }
        return null;
    }

}
