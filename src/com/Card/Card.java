package com.Card;

public class Card implements Comparable {
    private char card;
    private int order;

    public Card(char card, int order) {
        this.card = card;
        this.order = order;
    }

    public char getCard() {
        return this.card;
    }

    public int getOrder() {
        return this.order;
    }

    /**
     * Eaiser to compare with numbers than string since Dealer does the precondition checks and returns the character
     * and string index from Dealer.cardRange
     * @param o
     * @return -1
     */
    @Override
    public int compareTo(Object o) {
        Card c1 = (Card)o;
        if (this.order < c1.getOrder())
            return -1;
        else if (this.order > c1.getOrder())
            return 1;

        return 0;
    }
}
