package com.example.tt1;

public class Poker {
    private int rank;
    private int suit;

    Poker(int r,int s){
        this.suit=s;
        this.rank=r;
    }

    public void setRank(int a) {
        rank=a;
    }
    public void setSuit(int b) {
        suit=b;
    }
    public int getRank() {
        return rank;
    }
    public int getSuit() {
        return suit;
    }


}
