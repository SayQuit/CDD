package com.example.tt1;
import android.content.Context;
import android.view.SurfaceView;

public class Playground extends SurfaceView{
    public Playground(Context context){
        super(context);

//        getHolder().addCallback(callback);


        this.T=new Table();



        this.parentContext=context;


    }
    private Table T;
    private Context parentContext;

    public int returnFirst(){
        return this.T.Deal_Cards();
    }


    public int getCardId(int index){


        return T.getPlayerCardId(index);
    }
    public int getCardIdByRS(int r,int s){


        return T.getPlayerCardIdByRS(r,s);
    }

    public int Poker_out(int n){
        return this.T.Poker_Out(n);
    }

    public void setTableSelected(int index){
        this.T.setplayerSelected(index);
    }
    public void setTablenotSelected(int index){
        this.T.setplayernotSelected(index);
    }
    public boolean getTableisSelected(int index){
        return this.T.getplayerisSelected(index);
    }
    public PokerValue auto(int turns){
        return this.T.autoTable(turns);
    }
    public void pass(){
        this.T.pass();
    }
    public int getCardNum(int index)
    {
        return this.T.getCardNum(index);
    }





//    public Bitmap getScaleBackground(Bitmap bm){
//        WindowManager wm=(WindowManager) getContext().getSystemService(
//                Context.WINDOW_SERVICE);
//        int w = wm.getDefaultDisplay().getWidth();
//        int h = wm.getDefaultDisplay().getHeight();
//
//        int width = bm.getWidth();
//        int height = bm.getHeight();
//        int newWidth = w;
//        int newHeight = h;
//        float scaleWight = ((float)newWidth)/width;
//        float scaleHeight = ((float)newHeight)/height;
//        Matrix matrix = new Matrix();
//        matrix.postScale(scaleWight, scaleHeight);
//        Bitmap res = Bitmap.createBitmap(bm, 0,0,width, height, matrix, true);
//        return res;
//
//    }
//    public void setBackground(){
//
////        Canvas c= getHolder().lockCanvas();
////        Bitmap bm=BitmapFactory.decodeResource(getResources(),R.drawable.background);
////
////        c.drawBitmap(getScaleBackground(bm),0,0,null);
////
////        getHolder().unlockCanvasAndPost(c);
//
//    }


//    public void paintPlayerPoker(){
//
//
//
//
//
//
//
//
//
//
//
//
//    }










//    Callback callback = new Callback() {
//
//        @Override
//        public void surfaceDestroyed(SurfaceHolder arg0) {
//
//
//        }
//
//        @Override
//        public void surfaceCreated(SurfaceHolder arg0) {
//
//        }
//
//        @Override
//        public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
//
//        }
//    };
}
