package com.example.tt1;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        Intent intent=new Intent();
//        intent.setClass(this,Main.class);
//        startActivity(intent);



    }

    public void clickSingle(View v){
        Intent intent=new Intent();
        intent.setClass(this,Main.class);
        startActivity(intent);
    }
}