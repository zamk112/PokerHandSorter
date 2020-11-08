package com.Card;

public class Suit {
    private char suit;
    private int index;

    public Suit(char suit, int index) {
        this.suit = suit;
        this.index = index;
    }

    public char getSuit() {
        return this.suit;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public boolean equals(Object o) {
        Suit s1 = (Suit)o;

        if (this.index != s1.getIndex())
            return false;

        return true;
    }
}
