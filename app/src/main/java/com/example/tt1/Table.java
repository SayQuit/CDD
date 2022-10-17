package com.example.tt1;

public class Table {


    private Player []Computer;
    private Player player;
    private PokerValue lastPokerValue;
    private int Lastturns;




    //上次出的牌型,可为NULL
    //上次出牌的人,如果是自己则上次出的牌型为NULL，可以出任何合法的牌
    //当前出牌人

    Table(){
        this.Lastturns=-1;
        this.lastPokerValue=new PokerValue(-1,-1,-1);
        this.Computer=new Player[4];
        this.player=new Player();

        for(int i=0;i<4;i++)
        {
            this.Computer[i]=new Player();
        }



    }



    public int Deal_Cards(){
        int First=-1;
        for(int i=0;i<13;i++)
        {
            for(int j=0;j<4;j++)
            {
                int k=ChoosePlayer();

                Computer[k].getCards(i+3,j);
                if(k==3)this.player.getCards(i+3,j);

                if(i==0&&j==0)First=k;

            }
//            {
//                int k=ChoosePlayer();
//
////                Computer[k].getCards(i+3,j);
//                Computer[j].getCards(i+3,j);
//                if(j==3)this.player.getCards(i+3,j-k);
//
//                if(i==0&&j==0)First=k;
//
//            }
        }


        return First;



    }

    public int ChoosePlayer(){
        int k=(int)(Math.random()*4);


        while(Computer[k].isFull())
        {

            k=(int)(Math.random()*4);
        }
        return k;



    }
    public int getPlayerCardId(int index){
        return player.getPokerId(index);
    }
    public int getPlayerCardIdByRS(int r,int s){
        return player.getPokerIdByRS(r,s);
    }

    public int Poker_Out(int n){


        if(n>5)return -1;

        if(this.player.checkLegal()==-1){
            return -1;
        }


        PokerValue PV=this.player.getValue();

        if(this.Lastturns==3)this.lastPokerValue.setPokerValue(-1,-1,-1);

        if(PV.Compare(PV,this.lastPokerValue)==-1||PV.Compare(PV,this.lastPokerValue)==0)
            return -1;
        this.lastPokerValue=PV;

        this.Lastturns=3;
        return this.player.SubNum(n);


        //
//        //将pokervalue传出来，判断选中的是否符合规则——这里用到API   不合法返回 -1
//        //合法进行比较
//        if(!this.lastPokerValue.isPokerLegal())return -1;
//        这里的lastPokerValue换成这一次出牌的PokerValue，并且如果合法，则已经弄好了value、rank、suit
        //获取完进行 比较函数    不合法返回-1         Compare（）-1和0表示不行，lastPokerValue必须放后面
        //合法:将pokervalue写入lastPokerValue  并且进行return subnum
        //对出牌以后进行整理并且返回剩余牌数
    }

//    模拟出牌函数，当前index，上次出牌的pokervalue，

    public PokerValue autoTable(int turns){

            if(this.Lastturns==turns)this.lastPokerValue.setPokerValue(-1,-1,-1);
            PokerValue PV=this.Computer[turns].autoPokerOut(lastPokerValue);
            if(PV!=null)
            {

                lastPokerValue=PV;
                Lastturns=turns;

            }
            return PV;


    }

    public int getCardNum(int index)
    {
        return this.Computer[index].getCards_num();
    }
    public void pass(){

    }


    public void setplayerSelected(int index){
        this.player.setSelected(index);
    }
    public void setplayernotSelected(int index){
        this.player.setnotSelected(index);
    }
    public boolean getplayerisSelected(int index){
        return this.player.getisSelected(index);
    }









}
