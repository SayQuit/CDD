package com.example.tt1;

public class Player {
    private Poker[] mypoker;
    private int Cards_num;
    private boolean []isSelected=new boolean[13];





    Player(){
        this.mypoker=new Poker[13];

        for(int i=0;i<13;i++){
            this.isSelected[i]=false;

        }
        this.Cards_num=0;

    }

    public int getCards_num()
    {return this.Cards_num;}


    public int checkLegal(){

        int[][] p=new int[5][2];
        int num=0;
        for(int i=0;i<this.Cards_num;i++){
            if(isSelected[i]==true){
                p[num][0]=this.mypoker[i].getRank();
                p[num][1]=this.mypoker[i].getSuit();
                num++;
            }

        }

        if(num==1)return 1;
        else if(num==2){
            if(p[0][0]!=p[1][0])return -1;
            else return 1;
        }
        else if(num==2){
            if(p[0][0]==p[1][0]&&p[2][0]==p[1][0])return 1;
            else return -1;
        }
        else if(num==3){
            if(p[0][0]==p[1][0]&&p[2][0]==p[1][0])return 1;
            else return -1;
        }
        else if(num==4){
            if(p[0][0]==p[1][0]&&p[2][0]==p[1][0]&&p[2][0]==p[3][0])return 1;
            else return -1;
        }
        else if(num==5){

//            同色
            if(p[0][1]==p[1][1]&&p[2][1]==p[1][1]&&p[2][1]==p[3][1]&&p[4][1]==p[3][1])
                return 1;

//            顺子
            else if(p[0][0]==p[1][0]-1&&p[2][0]-1==p[1][0]&&p[2][0]==p[3][0]-1&&p[4][0]-1==p[3][0])
                return 1;


            else{

                //通过牌的种类了解是否合法，只有2种rank为合法
                int[] type=new int[2];

                for(int j=0;j<2;j++)
                {
                    type[j]=-1;

                }

                for(int i=0;i<5;i++){
                    if(i==0){
                        type[0]=p[0][0];
                        continue;
                    }

                    if(type[0]!=p[i][0]&&type[1]==-1)type[1]=p[i][0];

                    if(type[0]!=p[i][0]&&type[1]!=p[i][0])return -1;
                }





                return 1;
            }

        }


        else return -1;
    }

    public PokerValue getValue() {

        PokerValue PV = new PokerValue(-1, -1, -1);


//使用之前必须确保进行了checkLegal

        int[][] p = new int[5][2];
        int num = 0;
        for (int i = 0; i < this.Cards_num; i++) {
            if (isSelected[i] == true) {
                p[num][0] = this.mypoker[i].getRank();
                p[num][1] = this.mypoker[i].getSuit();
                num++;
            }

        }

        if (num == 1) {
            PV.setPokerValue(1, p[0][0], p[0][1]);
            PV.setLastPoker(p[0][0], p[0][1]);

        } else if (num == 2) {
            PV.setPokerValue(2, p[0][0], p[0][1]);
            PV.setLastPoker(p[0][0], p[0][1]);
            PV.setLastPoker(p[0][0], p[0][1]);
        } else if (num == 3) {
            PV.setPokerValue(3, p[0][0], p[0][1]);
            PV.setLastPoker(p[0][0], p[0][1]);
            PV.setLastPoker(p[0][0], p[0][1]);
            PV.setLastPoker(p[0][0], p[0][1]);
        } else if (num == 4) {
            PV.setPokerValue(4, p[0][0], p[0][1]);
            PV.setLastPoker(p[0][0], p[0][1]);
            PV.setLastPoker(p[0][0], p[0][1]);
            PV.setLastPoker(p[0][0], p[0][1]);
            PV.setLastPoker(p[0][0], p[0][1]);


        } else if (num == 5) {
            //            同色
            if (p[0][1] == p[1][1] && p[2][1] == p[1][1] && p[2][1] == p[3][1] && p[4][1] == p[3][1]) {
                PV.setPokerValue(6, p[4][0], p[4][1]);
                for (int i = 0; i < 5; i++) {
                    PV.setLastPoker(p[i][0], p[i][1]);
                }
                if (p[0][0] == p[1][0] - 1 && p[2][0] - 1 == p[1][0] && p[2][0] == p[3][0] - 1 && p[4][0] - 1 == p[3][0])
                    PV.setPokerValue(9, p[4][0], p[4][1]);
            }

//            顺子
            else if (p[0][0] == p[1][0] - 1 && p[2][0] - 1 == p[1][0] && p[2][0] == p[3][0] - 1 && p[4][0] - 1 == p[3][0]) {
                PV.setPokerValue(5, p[4][0], p[4][1]);
                for (int i = 0; i < 5; i++) {
                    PV.setLastPoker(p[i][0], p[i][1]);
                }
                if (p[0][1] == p[1][1] && p[2][1] == p[1][1] && p[2][1] == p[3][1] && p[4][1] == p[3][1])
                    PV.setPokerValue(9, p[4][0], p[4][1]);
            } else {
                int[][] type = new int[2][2];

                for (int j = 0; j < 2; j++) {
                    type[j][0] = -1;
                    type[j][1] = 0;
                }

                for (int i = 0; i < 5; i++) {
                    if (i == 0) {
                        type[0][0] = p[0][0];
                        type[0][1]++;
                        continue;
                    }
                    if (type[0][0] != p[i][0] && type[1][0] == -1) {
                        type[1][0] = p[i][0];
                        type[1][1]++;
                        continue;
                    }
                    if (type[0][0] == p[i][0]) type[0][1]++;
                    else if (type[1][0] == p[i][0]) type[1][1]++;
                }

                //通过牌的种类数量确定PokerValue
                if (type[0][1] == 1) {
                    PV.setPokerValue(8, p[4][0], -1);
                } else if (type[0][1] == 2) {
                    PV.setPokerValue(7, p[4][0], -1);
                }
                if (type[0][1] == 4) {
                    PV.setPokerValue(8, p[0][0], -1);
                } else if (type[0][1] == 3) {
                    PV.setPokerValue(7, p[0][0], -1);
                }

                for (int i = 0; i < 5; i++) {
                    PV.setLastPoker(p[i][0], p[i][1]);
                }


            }


        }
        return PV;
    }


    public boolean isBiggerThanFive()
    {
        int Select=0;
        for(int i=0;i<this.Cards_num;i++){
            if(isSelected[i]==true){
                Select++;
            }

        }
        if(Select>5)return false;
        else return true;

    }
    public int SubNum(int n){

        if(n>5)return -1;

        if(this.mypoker[0].getSuit()==0&&mypoker[0].getRank()==3&&isSelected[0]==false){
            return -1;
        }

        int Card_num_last=Cards_num;
        Cards_num-=n;



        Poker[] tempP=new Poker[Cards_num];
        int k=0;
        for(int i=0;i<Card_num_last;i++){
            if(isSelected[i]==false){
                tempP[k]=new Poker(mypoker[i].getRank(),mypoker[i].getSuit());
                k++;
            }

        }
        for(int i=0;i<Cards_num;i++){

            this.mypoker[i].setRank((tempP[i].getRank()));
            this.mypoker[i].setSuit((tempP[i].getSuit()));
            this.isSelected[i]=false;

        }

        return Cards_num;
    }
    public void setSelected(int index){
        this.isSelected[index]=true;
    }
    public void setnotSelected(int index){
        this.isSelected[index]=false;
    }
    public boolean getisSelected(int index){
        return this.isSelected[index];
    }

    public int getCards(int f,int s)
    {
        this.mypoker[Cards_num]=new Poker(f,s);
        Cards_num++;
        return Cards_num;
    }

    public boolean isFull()
    {
        if(this.Cards_num==13)return true;
        else return false;
    }

    public int getPokerId(int index){
        int s=this.mypoker[index].getSuit();
        int r=this.mypoker[index].getRank();

        return getPokerIdByRS(r,s);

    }
    public int getPokerIdByRS(int r,int s){


        switch (r)
        {
            case 3:switch (s) {
                case 0:return R.mipmap.diamond3;
                case 1:return R.mipmap.club3;
                case 2: return  R.mipmap.heart3;
                case 3:return R.mipmap.spade3;
            }
            case 4:switch (s) {
                case 0:return R.mipmap.diamond4;
                case 1:return R.mipmap.club4;
                case 2: return  R.mipmap.heart4;
                case 3:return R.mipmap.spade4;
            }
            case 5:switch (s) {
                case 0:return R.mipmap.diamond5;
                case 1:return R.mipmap.club5;
                case 2: return  R.mipmap.heart5;
                case 3:return R.mipmap.spade5;
            }
            case 6:switch (s) {
                case 0:return R.mipmap.diamond6;
                case 1:return R.mipmap.club6;
                case 2: return  R.mipmap.heart6;
                case 3:return R.mipmap.spade6;
            }
            case 7:switch (s) {
                case 0:return R.mipmap.diamond7;
                case 1:return R.mipmap.club7;
                case 2: return  R.mipmap.heart7;
                case 3:return R.mipmap.spade7;
            }
            case 8:switch (s) {
                case 0:return R.mipmap.diamond8;
                case 1:return R.mipmap.club8;
                case 2: return  R.mipmap.heart8;
                case 3:return R.mipmap.spade8;
            }
            case 9:switch (s) {
                case 0:return R.mipmap.diamond9;
                case 1:return R.mipmap.club9;
                case 2: return  R.mipmap.heart9;
                case 3:return R.mipmap.spade9;
            }
            case 10:switch (s) {
                case 0:return R.mipmap.diamond10;
                case 1:return R.mipmap.club10;
                case 2: return  R.mipmap.heart10;
                case 3:return R.mipmap.spade10;
            }
            case 11:switch (s) {
                case 0:return R.mipmap.diamondj;
                case 1:return R.mipmap.clubj;
                case 2: return  R.mipmap.heartj;
                case 3:return R.mipmap.spadej;
            }
            case 12:switch (s) {
                case 0:return R.mipmap.diamondq;
                case 1:return R.mipmap.clubq;
                case 2: return  R.mipmap.heartq;
                case 3:return R.mipmap.spadeq;
            }
            case 13:switch (s) {
                case 0:return R.mipmap.diamondk;
                case 1:return R.mipmap.clubk;
                case 2: return  R.mipmap.heartk;
                case 3:return R.mipmap.spadek;
            }
            case 14:switch (s) {
                case 0:return R.mipmap.diamond1;
                case 1:return R.mipmap.club1;
                case 2: return  R.mipmap.heart1;
                case 3:return R.mipmap.spade1;
            }
            case 15:switch (s) {
                case 0:return R.mipmap.diamond2;
                case 1:return R.mipmap.club2;
                case 2: return  R.mipmap.heart2;
                case 3:return R.mipmap.spade2;
            }

        }
        return -1;

    }


    public void CoverPoker(int index,int length){
        int i=index;
        while(i+length<Cards_num){
            mypoker[i]=mypoker[i+length];
            i++;
        }
        this.Cards_num-=length;
    }



    public PokerValue MyTurnPokerOut(){
        PokerValue PV=new PokerValue(-1,-1,-1);




        if(mypoker[0].getRank()!=3&&mypoker[0].getSuit()!=0)
        {
            int four=-1;
            int three=-1;
            int []PokerNum=new int[16];
            for(int i=0;i<16;i++){
                PokerNum[i]=0;
            }
            for(int i=0;i<Cards_num;i++){
                PokerNum[mypoker[i].getRank()]++;
                if(PokerNum[mypoker[i].getRank()]==4){
                    four=i-3;
                    break;
                }
                if(PokerNum[mypoker[i].getRank()]==3){
                    if(three!=-1)three=i-2;
                }
            }

            if(four!=-1){
                PV.setPokerValue(4,mypoker[four].getRank(),mypoker[four+3].getSuit());
                PV.setLastPoker(mypoker[four].getRank(),mypoker[four].getSuit());
                PV.setLastPoker(mypoker[four+1].getRank(),mypoker[four+1].getSuit());
                PV.setLastPoker(mypoker[four+2].getRank(),mypoker[four+2].getSuit());
                PV.setLastPoker(mypoker[four+3].getRank(),mypoker[four+3].getSuit());
                this.CoverPoker(four,4);
                return PV;
            }
            else if(three!=-1)
            {
                PV.setPokerValue(3,mypoker[four].getRank(),mypoker[three+2].getSuit());
                PV.setLastPoker(mypoker[three].getRank(),mypoker[three].getSuit());
                PV.setLastPoker(mypoker[three+1].getRank(),mypoker[three+1].getSuit());
                PV.setLastPoker(mypoker[three+2].getRank(),mypoker[three+2].getSuit());
                this.CoverPoker(three,3);
                return PV;
            }
        }


        if(Cards_num>1&&mypoker[0].getRank()!=mypoker[1].getRank())
        {
            PV.setPokerValue(1,mypoker[0].getRank(),mypoker[0].getSuit());
            PV.setLastPoker(mypoker[0].getRank(),mypoker[0].getSuit());
//            得把牌给变了
            this.CoverPoker(0,1);
            return PV;
        }
        else if(Cards_num>2&&mypoker[2].getRank()!=mypoker[1].getRank())
        {
            PV.setPokerValue(2,mypoker[1].getRank(),mypoker[1].getSuit());
            PV.setLastPoker(mypoker[0].getRank(),mypoker[0].getSuit());
            PV.setLastPoker(mypoker[1].getRank(),mypoker[1].getSuit());
            this.CoverPoker(0,2);
            return PV;
        }
        else if(Cards_num>3&&mypoker[2].getRank()!=mypoker[3].getRank())
        {
            PV.setPokerValue(3,mypoker[2].getRank(),mypoker[2].getSuit());
            PV.setLastPoker(mypoker[0].getRank(),mypoker[0].getSuit());
            PV.setLastPoker(mypoker[1].getRank(),mypoker[1].getSuit());
            PV.setLastPoker(mypoker[2].getRank(),mypoker[2].getSuit());
            this.CoverPoker(0,3);
            return PV;
        }
        else if(Cards_num>4)
        {
            PV.setPokerValue(5,mypoker[3].getRank(),mypoker[3].getSuit());
            PV.setLastPoker(mypoker[0].getRank(),mypoker[0].getSuit());
            PV.setLastPoker(mypoker[1].getRank(),mypoker[1].getSuit());
            PV.setLastPoker(mypoker[2].getRank(),mypoker[2].getSuit());
            PV.setLastPoker(mypoker[3].getRank(),mypoker[3].getSuit());
            PV.setLastPoker(mypoker[4].getRank(),mypoker[4].getSuit());
            this.CoverPoker(0,5);
            return PV;
        }
        else{
            PV.setPokerValue(1,mypoker[0].getRank(),mypoker[0].getSuit());
            PV.setLastPoker(mypoker[0].getRank(),mypoker[0].getSuit());
//            得把牌给变了
            this.CoverPoker(0,1);
            return PV;
        }

    }



    public PokerValue autoPokerOut(PokerValue LastPV){
        PokerValue PV=new PokerValue(-1,-1,-1);
        if(LastPV.getCompValue()==-1)
        {
            return MyTurnPokerOut();
        }
        if(LastPV.getCompValue()==1)
        {
            for(int i=0;i<Cards_num;i++){
                if(mypoker[i].getRank()==LastPV.getMaxRank()&&mypoker[i].getSuit()>LastPV.getMaxSuit())
                {
                    PV.setPokerValue(1,mypoker[i].getRank(),mypoker[i].getSuit());
                    PV.setLastPoker(mypoker[i].getRank(),mypoker[i].getSuit());
                    this.CoverPoker(i,1);
                    return PV;
                }
                else if(mypoker[i].getRank()>LastPV.getMaxRank())
                {
                    PV.setPokerValue(1,mypoker[i].getRank(),mypoker[i].getSuit());
                    PV.setLastPoker(mypoker[i].getRank(),mypoker[i].getSuit());
                    this.CoverPoker(i,1);
                    return PV;
                }
                if(i==12)
                {
                    return null;
                }
            }
        }

        else if(LastPV.getCompValue()==2){
            for(int i=0;i<Cards_num-1;i++){
                if(mypoker[i].getRank()==mypoker[i+1].getRank())
                {
                    if(mypoker[i].getRank()>LastPV.getMaxRank())
                    {


                        PV.setPokerValue(2,mypoker[i].getRank(),mypoker[i+1].getSuit());//注意会不会出现bug
                        PV.setLastPoker(mypoker[i].getRank(),mypoker[i].getSuit());
                        PV.setLastPoker(mypoker[i+1].getRank(),mypoker[i+1].getSuit());
                        this.CoverPoker(i,2);
                        return PV;
                    }
                    else if(mypoker[i].getRank()==LastPV.getMaxRank()){
                        if(mypoker[i+1].getSuit()>LastPV.getMaxSuit())//注意会不会出现bug
                        {
                            PV.setPokerValue(2,mypoker[i].getRank(),mypoker[i+1].getSuit());//注意会不会出现bug
                            PV.setLastPoker(mypoker[i].getRank(),mypoker[i].getSuit());
                            PV.setLastPoker(mypoker[i+1].getRank(),mypoker[i+1].getSuit());
                            this.CoverPoker(i,2);
                            return PV;
                        }
                    }
                }

                if(i==11)return null;
            }
        }


        else if(LastPV.getCompValue()==3){
            for(int i=0;i<Cards_num-2;i++){
                if(mypoker[i].getRank()==mypoker[i+1].getRank()&&mypoker[i].getRank()==mypoker[i+2].getRank()){
                    if(mypoker[i].getRank()>LastPV.getMaxRank())
                    {
                        PV.setPokerValue(3,mypoker[i].getRank(),-1);
                        PV.setLastPoker(mypoker[i].getRank(),mypoker[i].getSuit());
                        PV.setLastPoker(mypoker[i+1].getRank(),mypoker[i+1].getSuit());
                        PV.setLastPoker(mypoker[i+2].getRank(),mypoker[i+2].getSuit());

                        this.CoverPoker(i,3);
                        return PV;
                    }
                }

                if(i==10)return null;

            }
        }


        else if(LastPV.getCompValue()==4)
        {
            for(int i=0;i<Cards_num-3;i++){
                if(mypoker[i].getRank()==mypoker[i+1].getRank()&&mypoker[i].getRank()==mypoker[i+2].getRank()&&mypoker[i].getRank()==mypoker[i+3].getRank())
                {
                    if(mypoker[i].getRank()>LastPV.getMaxRank()){
                        PV.setPokerValue(4,mypoker[i].getRank(),-1);
                        PV.setLastPoker(mypoker[i].getRank(),mypoker[i].getSuit());
                        PV.setLastPoker(mypoker[i+1].getRank(),mypoker[i+1].getSuit());
                        PV.setLastPoker(mypoker[i+2].getRank(),mypoker[i+2].getSuit());
                        PV.setLastPoker(mypoker[i+3].getRank(),mypoker[i+3].getSuit());
                        this.CoverPoker(i,4);
                        return PV;
                    }
                }

                if(i==9)return null;

            }
        }





        else if(LastPV.getCompValue()>=5){
            Poker []p=new Poker[this.Cards_num-5];
            boolean []IsOut=new boolean[Cards_num];
            for(int i=0;i<Cards_num;i++){
                IsOut[i]=false;
            }










            if(LastPV.getCompValue()==5){
                int []PokerIndex=new int[16];
                for(int i=0;i<16;i++){
                    PokerIndex[i]=-1;
                }
                for(int i=0;i<Cards_num;i++){
                    if(PokerIndex[mypoker[i].getRank()]==-1)
                    {
                        PokerIndex[mypoker[i].getRank()]=i;
//                      获取某个rank的下标
                    }
                }



                for(int i=LastPV.getMaxRank()-4;i<16;i++){




                    if(PokerIndex[i]!=-1&&PokerIndex[i+1]!=-1&&PokerIndex[i+2]!=-1&&PokerIndex[i+3]!=-1&&PokerIndex[i+4]!=-1){
                        if((i!=LastPV.getMaxRank()-4))
                        {
                            if(mypoker[PokerIndex[i+4]].getSuit()==mypoker[PokerIndex[i]].getSuit()&&mypoker[PokerIndex[i+1]].getSuit()==mypoker[PokerIndex[i]].getSuit()&&mypoker[PokerIndex[i+2]].getSuit()==mypoker[PokerIndex[i]].getSuit()&&mypoker[PokerIndex[i+3]].getSuit()==mypoker[PokerIndex[i]].getSuit())
                                PV.setPokerValue(9,mypoker[PokerIndex[i+4]].getRank(),mypoker[PokerIndex[i+4]].getSuit());
                            else PV.setPokerValue(5,mypoker[PokerIndex[i+4]].getRank(),mypoker[PokerIndex[i+4]].getSuit());
                            PV.setLastPoker(mypoker[PokerIndex[i]].getRank(),mypoker[PokerIndex[i]].getSuit());
                            PV.setLastPoker(mypoker[PokerIndex[i+1]].getRank(),mypoker[PokerIndex[i+1]].getSuit());
                            PV.setLastPoker(mypoker[PokerIndex[i+2]].getRank(),mypoker[PokerIndex[i+2]].getSuit());
                            PV.setLastPoker(mypoker[PokerIndex[i+3]].getRank(),mypoker[PokerIndex[i+3]].getSuit());
                            PV.setLastPoker(mypoker[PokerIndex[i+4]].getRank(),mypoker[PokerIndex[i+4]].getSuit());
                            IsOut[PokerIndex[i+4]]=true;
                            IsOut[PokerIndex[i+3]]=true;
                            IsOut[PokerIndex[i+2]]=true;
                            IsOut[PokerIndex[i+1]]=true;
                            IsOut[PokerIndex[i]]=true;
                            int j=0;
                            for(int u=0;u<Cards_num;u++)
                            {
                                if(IsOut[u]==false){
                                    p[j]=new Poker(mypoker[u].getRank(),mypoker[u].getSuit());
                                    j++;
                                }
                            }
                            for(int u=0;u<Cards_num-5;u++)
                            {
                                mypoker[u].setRank(p[u].getRank());
                                mypoker[u].setSuit(p[u].getSuit());
                            }
                            Cards_num-=5;
                            return PV;
                        }
                        else if(i==LastPV.getMaxRank()-4){
                                while(mypoker[PokerIndex[i+4]].getSuit()<PV.getMaxSuit()){
                                    if(mypoker[PokerIndex[i+4]+1]==mypoker[PokerIndex[i+4]]){
                                        PokerIndex[i+4]+=1;
                                    }
                                    else break;
                                }
                                if(mypoker[PokerIndex[i+4]].getSuit()>PV.getMaxSuit()){
                                    {
                                        if(mypoker[PokerIndex[i+4]].getSuit()==mypoker[PokerIndex[i]].getSuit()&&mypoker[PokerIndex[i+1]].getSuit()==mypoker[PokerIndex[i]].getSuit()&&mypoker[PokerIndex[i+2]].getSuit()==mypoker[PokerIndex[i]].getSuit()&&mypoker[PokerIndex[i+3]].getSuit()==mypoker[PokerIndex[i]].getSuit())
                                            PV.setPokerValue(9,mypoker[PokerIndex[i+4]].getRank(),mypoker[PokerIndex[i+4]].getSuit());
                                        else PV.setPokerValue(5,mypoker[PokerIndex[i+4]].getRank(),mypoker[PokerIndex[i+4]].getSuit());
                                        PV.setLastPoker(mypoker[PokerIndex[i]].getRank(),mypoker[PokerIndex[i]].getSuit());
                                        PV.setLastPoker(mypoker[PokerIndex[i+1]].getRank(),mypoker[PokerIndex[i+1]].getSuit());
                                        PV.setLastPoker(mypoker[PokerIndex[i+2]].getRank(),mypoker[PokerIndex[i+2]].getSuit());
                                        PV.setLastPoker(mypoker[PokerIndex[i+3]].getRank(),mypoker[PokerIndex[i+3]].getSuit());
                                        PV.setLastPoker(mypoker[PokerIndex[i+4]].getRank(),mypoker[PokerIndex[i+4]].getSuit());
                                        IsOut[PokerIndex[i+4]]=true;
                                        IsOut[PokerIndex[i+3]]=true;
                                        IsOut[PokerIndex[i+2]]=true;
                                        IsOut[PokerIndex[i+1]]=true;
                                        IsOut[PokerIndex[i]]=true;
                                        int j=0;
                                        for(int u=0;u<Cards_num;u++)
                                        {
                                            if(IsOut[u]==false){
                                                p[j]=new Poker(mypoker[u].getRank(),mypoker[u].getSuit());
                                                j++;
                                            }
                                        }
                                        for(int u=0;u<Cards_num-5;u++)
                                        {
                                            mypoker[u].setRank(p[u].getRank());
                                            mypoker[u].setSuit(p[u].getSuit());
                                        }
                                        Cards_num-=5;
                                        return PV;
                                    }
                                }
                                else return null;

                        }




                    }
                }
            }












            else if(LastPV.getCompValue()==6){
                int []Suit=new int[4];
                for(int i=0;i<Cards_num;i++){

                }
            }















            else if(LastPV.getCompValue()==7){
                int index=-1;


                for(int i=0;i<Cards_num-2;i++){
                    if(mypoker[i].getRank()>LastPV.getMaxRank()){
                        if(mypoker[i].getRank()==mypoker[i+1].getRank()&&mypoker[i].getRank()==mypoker[i+2].getRank()){
                            IsOut[i]=true;
                            IsOut[i+1]=true;
                            IsOut[i+2]=true;
                            index=i+2;
                            break;
                        }
                    }
                }
                for(int i=0;i<Cards_num-1;i++){

                    if(mypoker[i].getRank()==mypoker[i+1].getRank()&&IsOut[i]==false&&IsOut[i+1]==false){
                        IsOut[i]=true;
                        IsOut[i+1]=true;
                        break;

                    }
                }
                int num=0;
                for(int i=0;i<Cards_num;i++)
                {
                    if(IsOut[i]){
                        num++;
                        PV.setLastPoker(this.mypoker[i].getRank(),this.mypoker[i].getSuit());
                    }
                }
                if(num==5){

                    PV.setPokerValue(7,this.mypoker[index].getRank(),-1);
                    int j=0;
                    for(int i=0;i<Cards_num;i++)
                    {
                        if(IsOut[i]==false){
                            p[j]=new Poker(mypoker[i].getRank(),mypoker[i].getSuit());
                            j++;
                        }
                    }

                    for(int i=0;i<Cards_num-5;i++)
                    {
                        mypoker[i].setRank(p[i].getRank());
                        mypoker[i].setSuit(p[i].getSuit());
                    }
                    Cards_num-=5;

                    return PV;
                }
                else return null;


            }










            else if(LastPV.getCompValue()==8){
                int index=-1;


                for(int i=0;i<11;i++){
                    if(mypoker[i].getRank()>LastPV.getMaxRank()){
                        if(mypoker[i].getRank()==mypoker[i+1].getRank()&&mypoker[i].getRank()==mypoker[i+2].getRank()&&mypoker[i].getRank()==mypoker[i+3].getRank()){
                            IsOut[i]=true;
                            IsOut[i+1]=true;
                            IsOut[i+2]=true;
                            IsOut[i+3]=true;
                            index=i+3;
                            break;
                        }
                    }
                }
                for(int i=0;i<13;i++){

                    if(IsOut[i]==false){
                        IsOut[i]=true;
                    }
                }
                int num=0;
                for(int i=0;i<13;i++)
                {
                    if(IsOut[i]==true){
                        num++;
                        PV.setLastPoker(this.mypoker[i].getRank(),this.mypoker[i].getSuit());
                    }
                }
                if(num==5){
                    PV.setPokerValue(7,this.mypoker[index].getRank(),-1);
                    int j=0;
                    for(int i=0;i<Cards_num;i++)
                    {
                        if(IsOut[i]==false){
                            p[j]=new Poker(mypoker[i].getRank(),mypoker[i].getSuit());
                            j++;
                        }
                    }

                    for(int i=0;i<Cards_num-5;i++)
                    {
                        mypoker[i].setRank(p[i].getRank());
                        mypoker[i].setSuit(p[i].getSuit());
                    }

                    Cards_num-=5;
                    return PV;

                }
                else return null;
            }















            else if(LastPV.getCompValue()==9){
                int []PokerIndex=new int[16];
                for(int i=0;i<16;i++){
                    PokerIndex[i]=-1;
                }
                for(int i=0;i<Cards_num;i++){
                    if(PokerIndex[mypoker[i].getRank()]==-1)
                    {
                        PokerIndex[mypoker[i].getRank()]=i;
//                      获取某个rank的下标
                    }
                }



                for(int i=LastPV.getMaxRank()-4;i<16;i++){

//                    i代表rank大小



                    if(PokerIndex[i]!=-1&&PokerIndex[i+1]!=-1&&PokerIndex[i+2]!=-1&&PokerIndex[i+3]!=-1&&PokerIndex[i+4]!=-1){
                        if((i!=LastPV.getMaxRank()-4))
                        {
                            if(mypoker[PokerIndex[i+4]].getSuit()==mypoker[PokerIndex[i]].getSuit()&&mypoker[PokerIndex[i+1]].getSuit()==mypoker[PokerIndex[i]].getSuit()&&mypoker[PokerIndex[i+2]].getSuit()==mypoker[PokerIndex[i]].getSuit()&&mypoker[PokerIndex[i+3]].getSuit()==mypoker[PokerIndex[i]].getSuit())
                                PV.setPokerValue(9,mypoker[PokerIndex[i+4]].getRank(),mypoker[PokerIndex[i+4]].getSuit());
                            else continue;
                            PV.setLastPoker(mypoker[PokerIndex[i]].getRank(),mypoker[PokerIndex[i]].getSuit());
                            PV.setLastPoker(mypoker[PokerIndex[i+1]].getRank(),mypoker[PokerIndex[i+1]].getSuit());
                            PV.setLastPoker(mypoker[PokerIndex[i+2]].getRank(),mypoker[PokerIndex[i+2]].getSuit());
                            PV.setLastPoker(mypoker[PokerIndex[i+3]].getRank(),mypoker[PokerIndex[i+3]].getSuit());
                            PV.setLastPoker(mypoker[PokerIndex[i+4]].getRank(),mypoker[PokerIndex[i+4]].getSuit());
                            IsOut[PokerIndex[i+4]]=true;
                            IsOut[PokerIndex[i+3]]=true;
                            IsOut[PokerIndex[i+2]]=true;
                            IsOut[PokerIndex[i+1]]=true;
                            IsOut[PokerIndex[i]]=true;
                            int j=0;
                            for(int u=0;u<Cards_num;u++)
                            {
                                if(IsOut[u]==false){
                                    p[j]=new Poker(mypoker[u].getRank(),mypoker[u].getSuit());
                                    j++;
                                }
                            }
                            for(int u=0;u<Cards_num-5;u++)
                            {
                                mypoker[u].setRank(p[u].getRank());
                                mypoker[u].setSuit(p[u].getSuit());
                            }
                            Cards_num-=5;
                            return PV;
                        }
                        else if(i==LastPV.getMaxRank()-4){
                            while(mypoker[PokerIndex[i+4]].getSuit()<PV.getMaxSuit()){
                                if(mypoker[PokerIndex[i+4]+1]==mypoker[PokerIndex[i+4]]){
                                    PokerIndex[i+4]+=1;
                                }
                                else break;
                            }
                            if(mypoker[PokerIndex[i+4]].getSuit()>PV.getMaxSuit()){
                                {
                                    if(mypoker[PokerIndex[i+4]].getSuit()==mypoker[PokerIndex[i]].getSuit()&&mypoker[PokerIndex[i+1]].getSuit()==mypoker[PokerIndex[i]].getSuit()&&mypoker[PokerIndex[i+2]].getSuit()==mypoker[PokerIndex[i]].getSuit()&&mypoker[PokerIndex[i+3]].getSuit()==mypoker[PokerIndex[i]].getSuit())
                                        PV.setPokerValue(9,mypoker[PokerIndex[i+4]].getRank(),mypoker[PokerIndex[i+4]].getSuit());
                                    else continue;
                                    PV.setLastPoker(mypoker[PokerIndex[i]].getRank(),mypoker[PokerIndex[i]].getSuit());
                                    PV.setLastPoker(mypoker[PokerIndex[i+1]].getRank(),mypoker[PokerIndex[i+1]].getSuit());
                                    PV.setLastPoker(mypoker[PokerIndex[i+2]].getRank(),mypoker[PokerIndex[i+2]].getSuit());
                                    PV.setLastPoker(mypoker[PokerIndex[i+3]].getRank(),mypoker[PokerIndex[i+3]].getSuit());
                                    PV.setLastPoker(mypoker[PokerIndex[i+4]].getRank(),mypoker[PokerIndex[i+4]].getSuit());
                                    IsOut[PokerIndex[i+4]]=true;
                                    IsOut[PokerIndex[i+3]]=true;
                                    IsOut[PokerIndex[i+2]]=true;
                                    IsOut[PokerIndex[i+1]]=true;
                                    IsOut[PokerIndex[i]]=true;
                                    int j=0;
                                    for(int u=0;u<Cards_num;u++)
                                    {
                                        if(IsOut[u]==false){
                                            p[j]=new Poker(mypoker[u].getRank(),mypoker[u].getSuit());
                                            j++;
                                        }
                                    }
                                    for(int u=0;u<Cards_num-5;u++)
                                    {
                                        mypoker[u].setRank(p[u].getRank());
                                        mypoker[u].setSuit(p[u].getSuit());
                                    }
                                    Cards_num-=5;
                                    return PV;
                                }
                            }
                            else return null;

                        }




                    }
                }
            }
        }


        return null;


    }







}
