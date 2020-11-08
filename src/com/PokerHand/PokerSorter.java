package com.PokerHand;

import com.Card.Hand;
import com.Rules.RankingChecks;

import java.util.Scanner;

public class PokerSorter {

    public static void run(int startPos, int endPos, String[] handStr, Hand player) {
        for (int i = startPos; i <= endPos; i++) {
            player.put(handStr[i]);
        }

        player.setRank(Dealer.setRanking(player.getHand()));
    }

    public static void printResults(int p1Score, int p2Score) {
        System.out.println("Player 1: " + p1Score);
        System.out.println("Player 2: " + p2Score);
    }

    public static void main(String[] args) {
        String inString;
        String dealerStr[];
        Hand p1, p2;
        int p1Score = 0, p2Score = 0;

        if (args.length == 0) {
            Scanner sc = new Scanner(System.in);
            if (!sc.hasNextLine()) {
                System.out.println("Usage: $ cat");

            }
            else {
                while(sc.hasNextLine()) {
                    inString = sc.nextLine();
                    dealerStr = inString.split("\\s+");
                    if (dealerStr.length == 10) {
                        int winner = 0;
                        p1 = new Hand();
                        p2 = new Hand();

                        run(0, 4, dealerStr, p1);
                        run(5, 9, dealerStr, p2);

                        winner = RankingChecks.checking(p1.getRank(), p2.getRank(), p1.getRank().size()-1, p2.getRank().size()-1, inString);
                        if (winner == 0)
                            p1Score++;
                        else if (winner == 1)
                            p2Score++;

                    }
                }

                printResults(p1Score, p2Score);
            }
        }
    }
}
