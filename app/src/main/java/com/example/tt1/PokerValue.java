package com.example.tt1;

public class PokerValue {
    private int CompValue;
    private int MaxRank;
    private int MaxSuit;
    private int Number;
    private Poker []LastPoker;
//    private Poker []PokerWantToOut;

    PokerValue(int CV,int R,int S){
        this.CompValue=CV;
        this.MaxRank=R;
        this.MaxSuit=S;
        this.Number=0;




        this.LastPoker=new Poker[5];
        for(int i=0;i<5;i++)
        {

            this.LastPoker[i]=new Poker(-1,-1);

        }
//        for(int i=0;i<5;i++)
//        {
//            this.PokerWantToOut[i].setRank(-1);
//            this.PokerWantToOut[i].setSuit(-1);
//        }
//        加一些牌组

    }

    public int getCompValue()
    {
        return this.CompValue;
    }
    public int getMaxRank()
    {
        return this.MaxRank;
    }
    public int getMaxSuit()
    {
        return this.MaxSuit;
    }
    public int getNumber()
    {
        return this.Number;
    }
    public Poker getPoker(int k){return this.LastPoker[k];}

    public void setPokerValue(int CV,int R,int S){
        this.CompValue=CV;
        this.MaxRank=R;
        this.MaxSuit=S;
    }




    public void setLastPoker(int r,int s)
    {
        this.LastPoker[this.Number].setSuit(s);
        this.LastPoker[this.Number].setRank(r);

        this.Number++;
    }

    public int getLastPokerRank(int k)
    {
        return this.LastPoker[k].getRank();
    }
    public int getLastPokerSuit(int k)
    {
        return this.LastPoker[k].getSuit();
    }







//    1表示P1>P2,-1表示P1<P2,0表示不合法
    public int Compare(PokerValue P1,PokerValue P2){

        if(P2.getCompValue()==-1)return 1;

        if(P1.getCompValue()==P2.getCompValue())
        {

            if(P1.getMaxRank()!=P2.getMaxRank())
            {
                 if(P1.getMaxRank()>P2.getMaxRank()){
                     return 1;
                 }
                 else return -1;

            }
            else{
                if(P1.getMaxSuit()>P2.getMaxSuit()){
                    return 1;
                }
                else return -1;
            }

        }
        else{
            if(P1.getCompValue()<5||P2.getCompValue()<5)return 0;
            else{
                if(P1.getCompValue()>P2.getCompValue()){
                    return 1;
                }
                else return -1;
            }
        }


    }




}
