package com.Card;

import com.PokerHand.Dealer;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class represents the hand of the player.
 * Card and Suit makes up one card. Using a TreeMap; when the card is added; it is added in sorted order.
 * Dealer checks if the Card and suit are valid. Highest Rank will be set after Dealer does the Ranking.
 */
public class Hand {
    private Map<Card, ArrayList<Suit>> hand;
    private ArrayList<Ranking> ranking;

    public Hand() {
        this.hand = new TreeMap<Card, ArrayList<Suit>>();
        this.ranking = null;
    }

    public void put (String cardStr) {
        int cardNum = Dealer.isValidCard(cardStr);
        int suitNum = Dealer.isValidSuit(cardStr);

        if (cardNum != -1 && suitNum != -1) {
            Card card = new Card(Dealer.cardRange[cardNum], cardNum);
            Suit suit = new Suit(Dealer.suitRange[suitNum], suitNum);
            // See if card already exists
            if (this.hand.containsKey(card)) {
                ArrayList<Suit> suitList = this.hand.get(card);
                if (!suitList.contains(suit))
                    suitList.add(suit);
            }
            else {
                ArrayList<Suit> suitList = new ArrayList<Suit>();
                suitList.add(suit);
                this.hand.put(card, suitList);
            }
        }
    }

    public Map<Card, ArrayList<Suit>> getHand() {
        return this.hand;
    }



    public void setRank(ArrayList<Ranking> ranking) {
        this.ranking = ranking;
    }

    public ArrayList<Ranking> getRank() {
        return this.ranking;
    }
}
