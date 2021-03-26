package com.example.mathenggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class Teach_game extends AppCompatActivity {

    private Button flip1;
    private static Button next;
    private zadania_matematyka sld;
    private static String tmp,tmp2;
    private int count=0;
    private Cursor c;
    private static int  TIME = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach_game);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        sld = new zadania_matematyka(this);
        flip1 = (Button) findViewById(R.id.flip_1);
        next = (Button) findViewById(R.id.next_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_quest();
                MainActivity.play_sound();
                count=0;
                next.setText("NEXT");

            }
        });
        flip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tran_button();
                MainActivity.play_sound();

            }
        });

    }
    public void tran_button() {
        Handler handler = new Handler();
        if (count == 0) {
            flip1.animate().scaleX(0);
            flip1.animate().start();
            new Handler().postDelayed(new Runnable() {
                                          @Override
                                          public void run() {
                                              flip1.animate().scaleX(1);
                                              flip1.animate().start();
                                              flip1.setText(tmp);
                                              count++;
                                          }
                                      }, TIME
            );

        } else {

            flip1.animate().scaleX(0);
            flip1.animate().start();
                new Handler().postDelayed(new Runnable() {

                                              @Override
                                              public void run() {
                                                  flip1.animate().scaleX(1);
                                                  flip1.animate().start();
                                                  flip1.setText(tmp2);
                                                  count--;
                                              }
                                          }, TIME
                );




        }
    }


    public void set_quest(){
        c =sld.GetRandOne();
        if(c.getCount()==0){
            System.out.println("on_click_f");
        }
        else{
            while(c.moveToNext()){
                flip1.setText(c.getString(1).toString());
                tmp=c.getString(0).toString();
                tmp2 =c.getString(1).toString();


            }

        }
}}