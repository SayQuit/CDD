package com.example.tt1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import com.example.tt1.databinding.ActivityMainBinding;

public class Main extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;



    private Playground p;
    ImageButton []poker=new ImageButton[13];
    ImageButton []selectpoker=new ImageButton[13];
    ImageButton []Outpoker=new ImageButton[13];
    Button []npcPoker=new Button[3];
    ImageButton []npcOutPoker=new ImageButton[15];
    private int CardNum;
    private ImageButton []TIPs=new ImageButton[2];

    private int isWin;
    private int first;


//    ViewGroup.LayoutParams []pokerMargin=new ViewGroup.LayoutParams[13];





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.init();

    }

    public void init(){


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        p=new Playground(this);
        first=p.returnFirst();
//        if(first<3){
//            int u=first;
//            while(u<3){
//                this.autoSingle(u);
//                u++;
//            }
//        }

        CardNum=13;
        isWin=0;



        poker[0] = findViewById(R.id.p1);
        poker[1] = findViewById(R.id.p2);
        poker[2] = findViewById(R.id.p3);
        poker[3] = findViewById(R.id.p4);
        poker[4] = findViewById(R.id.p5);
        poker[5] = findViewById(R.id.p6);
        poker[6] = findViewById(R.id.p7);
        poker[7] = findViewById(R.id.p8);
        poker[8] = findViewById(R.id.p9);
        poker[9] = findViewById(R.id.p10);
        poker[10] = findViewById(R.id.p11);
        poker[11] = findViewById(R.id.p12);
        poker[12] = findViewById(R.id.p13);

        selectpoker[0] = findViewById(R.id.m1);
        selectpoker[1] = findViewById(R.id.m2);
        selectpoker[2] = findViewById(R.id.m3);
        selectpoker[3] = findViewById(R.id.m4);
        selectpoker[4] = findViewById(R.id.m5);
        selectpoker[5] = findViewById(R.id.m6);
        selectpoker[6] = findViewById(R.id.m7);
        selectpoker[7] = findViewById(R.id.m8);
        selectpoker[8] = findViewById(R.id.m9);
        selectpoker[9] = findViewById(R.id.m10);
        selectpoker[10] = findViewById(R.id.m11);
        selectpoker[11] = findViewById(R.id.m12);
        selectpoker[12] = findViewById(R.id.m13);

        Outpoker[0] = findViewById(R.id.o1);
        Outpoker[1] = findViewById(R.id.o2);
        Outpoker[2] = findViewById(R.id.o3);
        Outpoker[3] = findViewById(R.id.o4);
        Outpoker[4] = findViewById(R.id.o5);
        Outpoker[5] = findViewById(R.id.o6);
        Outpoker[6] = findViewById(R.id.o7);
        Outpoker[7] = findViewById(R.id.o8);
        Outpoker[8] = findViewById(R.id.o9);
        Outpoker[9] = findViewById(R.id.o10);
        Outpoker[10] = findViewById(R.id.o11);
        Outpoker[11] = findViewById(R.id.o12);
        Outpoker[12] = findViewById(R.id.o13);

        npcOutPoker[0]=findViewById(R.id.co1);
        npcOutPoker[1]=findViewById(R.id.co2);
        npcOutPoker[2]=findViewById(R.id.co3);
        npcOutPoker[3]=findViewById(R.id.co4);
        npcOutPoker[4]=findViewById(R.id.co5);
        npcOutPoker[5]=findViewById(R.id.co6);
        npcOutPoker[6]=findViewById(R.id.co7);
        npcOutPoker[7]=findViewById(R.id.co8);
        npcOutPoker[8]=findViewById(R.id.co9);
        npcOutPoker[9]=findViewById(R.id.co10);
        npcOutPoker[10]=findViewById(R.id.co11);
        npcOutPoker[11]=findViewById(R.id.co12);
        npcOutPoker[12]=findViewById(R.id.co13);
        npcOutPoker[13]=findViewById(R.id.co14);
        npcOutPoker[14]=findViewById(R.id.co15);


        npcPoker[0]=findViewById(R.id.ci1);
        npcPoker[1]=findViewById(R.id.ci2);
        npcPoker[2]=findViewById(R.id.ci3);


        this.TIPs[0]=findViewById(R.id.lost);
        this.TIPs[1]=findViewById(R.id.win);
        this.TIPs[0].setVisibility(View.INVISIBLE);
        this.TIPs[1].setVisibility(View.INVISIBLE);



        for(int i=0;i<13;i++)
        {
            poker[i].setImageResource(p.getCardId(i));
            selectpoker[i].setImageResource(p.getCardId(i));
            selectpoker[i].setVisibility(View.INVISIBLE);
            Outpoker[i].setVisibility(View.INVISIBLE);

//            pokerMargin[i]=(ViewGroup.LayoutParams) poker[i].getLayoutParams();


        }
        for(int i=0;i<15;i++)
        {
            this.npcOutPoker[i].setVisibility(View.INVISIBLE);

        }

        if(first<3){
            int u=first;
            while(u<3){
                this.autoSingle(u);
                u++;
            }
        }
    }
    public void ClickPoker(View v){
        int index=-1;

        switch (v.getId()){

            case R.id.p1:index=0;break;
            case R.id.p2:index=1;break;
            case R.id.p3:index=2;break;
            case R.id.p4:index=3;break;
            case R.id.p5:index=4;break;
            case R.id.p6:index=5;break;
            case R.id.p7:index=6;break;
            case R.id.p8:index=7;break;
            case R.id.p9:index=8;break;
            case R.id.p10:index=9;break;
            case R.id.p11:index=10;break;
            case R.id.p12:index=11;break;
            case R.id.p13:index=12;break;
            case R.id.m1:index=0;break;
            case R.id.m2:index=1;break;
            case R.id.m3:index=2;break;
            case R.id.m4:index=3;break;
            case R.id.m5:index=4;break;
            case R.id.m6:index=5;break;
            case R.id.m7:index=6;break;
            case R.id.m8:index=7;break;
            case R.id.m9:index=8;break;
            case R.id.m10:index=9;break;
            case R.id.m11:index=10;break;
            case R.id.m12:index=11;break;
            case R.id.m13:index=12;break;
            default:return;

        }

        setPokerSelect(index);



    }
    public void setPokerSelect(int index){


        if(index>=0||index<CardNum){
//            if(isSelected[index]==false)pokerMargin[index].height+=50;
//            else pokerMargin[index].height-=50;
//            isSelected[index]=!isSelected[index];
            if(!this.p.getTableisSelected(index))
            {
                poker[index].setVisibility(View.INVISIBLE);
                selectpoker[index].setVisibility(View.VISIBLE);
                this.p.setTableSelected(index);
            }
            else{
                selectpoker[index].setVisibility(View.INVISIBLE);
                poker[index].setVisibility(View.VISIBLE);
                this.p.setTablenotSelected(index);
            }


        }

    }
    public void poker_out(View v){
        if(this.isWin==1)
        {
            this.init();
            return;
        }

        int outPokerNum=0;



        for(int i=0;i<CardNum;i++){
            this.Outpoker[i].setVisibility(View.INVISIBLE);
            if(this.p.getTableisSelected(i)==true){
                this.Outpoker[outPokerNum].setVisibility(View.VISIBLE);
                this.Outpoker[outPokerNum].setImageResource(p.getCardId(i));
                outPokerNum++;
            }
        }
        int tempCardNum=this.p.Poker_out(outPokerNum);

        if(tempCardNum==-1){
            for(int i=0;i<13;i++){
                this.Outpoker[i].setVisibility(View.INVISIBLE);
            }
        }
        else
        {
            this.CardNum=tempCardNum;
            if(this.first==3){
                this.first=-1;
            }
            this.refresh();
            if(CardNum==0){

                this.TIPs[1].setVisibility(View.VISIBLE);
                isWin=1;
            }
            else this.autoAll();

        }
//             char []x=new char[4];
//             x[0]='1';
//             x[1]='1';
//             x[2]='1';
//             x[3]='1';
//             Button btn=new Button(this);
//             btn.findViewById(R.id.out);
//             btn.setText(x,0,4);


    }
//     public void waitSomeTime(){
////         try {
////
////             Thread.sleep(this.getTime());
////
////
////         }catch (InterruptedException ex)
////         {
////             System.out.println("出现异常");
////         }
//
//     }

    public int getTime(){
        int k=(int)(Math.random()*3000);
        return 1000+k;
    }





    public void autoSingle(int i){
        PokerValue PV=this.p.auto(i);




        for(int j=i*5;j<i*5+5;j++)
        {
            this.npcOutPoker[j].setVisibility(View.INVISIBLE);
        }

        if(PV!=null){
            for(int j=0;j<PV.getNumber();j++)
            {
                this.npcOutPoker[j+i*5].setVisibility(View.VISIBLE);
                this.npcOutPoker[j+i*5].setImageResource(this.p.getCardIdByRS(PV.getPoker(j).getRank(),PV.getPoker(j).getSuit()));

            }


            if(this.p.getCardNum(i)==0)
            {
                this.TIPs[0].setVisibility(View.VISIBLE);
                isWin=1;
            }




        }
    }







    public void autoAll(){



        for(int i=0;i<3;i++){
//            this.waitSomeTime();
            this.autoSingle(i);
            char []x=new char[2];
            int k=this.p.getCardNum(i);



            int len=0;
            if(k>=10)
            {
                len=2;
                x[0]='1';
                k-=10;
                x[1]=(char)(k+'0');
            }
            else {
                len=1;
                x[0]=(char)(k+'0');
            }
            this.npcPoker[i].setText(x,0,len);
        }

//        this.waitSomeTime();
//        this.autoSingle(0);
//        this.waitSomeTime();
//        this.autoSingle(1);
//        this.waitSomeTime();
//        this.autoSingle(2);
//         this.waitSomeTime(0);
//         this.waitSomeTime(1);
//         this.waitSomeTime(2);
        // 这里变一下npc背面数字
//         char []x=new char[2];
//         x[0]='1';
//         x[1]='2';
//         this.npcPoker[0].setText(x,0,2);
    }

    public void refresh(){

        for(int i=0;i<13;i++){
            selectpoker[i].setVisibility(View.INVISIBLE);
            poker[i].setVisibility(View.INVISIBLE);
        }
        for(int i=0;i<CardNum;i++)
        {
            poker[i].setImageResource(p.getCardId(i));
            selectpoker[i].setImageResource(p.getCardId(i));
            poker[i].setVisibility(View.VISIBLE);
        }



        //后面npc出牌以后也要这里进行刷新，改变上面几个按钮


    }
    public void poker_in(View v){
        if(this.isWin==1)
        {
            this.init();
            return;
        }

        for(int i=0;i<CardNum;i++){
            if(this.p.getTableisSelected(i)==true){
                selectpoker[i].setVisibility(View.INVISIBLE);
                poker[i].setVisibility(View.VISIBLE);
                this.p.setTablenotSelected(i);
            }
        }
    }

    public void poker_pass(View v){

        if(this.isWin==1)
        {
            this.init();
            return;
        }
        if(this.first==3){
            return;
        }
        this.p.pass();
        for(int i=0;i<13;i++){
            this.Outpoker[i].setVisibility(View.INVISIBLE);
        }
        autoAll();
    }





}