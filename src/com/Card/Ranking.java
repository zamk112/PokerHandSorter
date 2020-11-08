package com.Card;

import com.Rules.Combination;

import java.util.List;

public class Ranking {
    private Combination rank;
    private List<Integer> cardNum;

    public Ranking(Combination rank, List<Integer> cardNum) {
        this.cardNum = cardNum;
        this.rank = rank;
    }


    public Combination getRank() {
        return this.rank;
    }

    public List<Integer> getCardNum() {
        return this.cardNum;
    }

}
