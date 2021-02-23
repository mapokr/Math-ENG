package com.example.mathenggame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Game_Time extends AppCompatActivity {
    private Button ans_1,ans_2,ans_3;
    private static Button start_game;
    private static TextView time;
    private static int  count=0;
    private zadania_matematyka sld;
    private static TextView question,count_view;
    private Cursor c;
    private static String tmp=" ";
    private static CountDownTimer cdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__time);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        sld = new zadania_matematyka(this);
        ans_1 =(Button) findViewById(R.id.anwser_1);
        ans_2 =(Button) findViewById(R.id.anwser_2);
        ans_3 =(Button) findViewById(R.id.anwser_3);
        start_game =(Button) findViewById(R.id.start_game_button);
        question = (TextView) findViewById(R.id.question_view);
        count_view = (TextView) findViewById(R.id.correct_count);
        time = (TextView) findViewById(R.id.timer);
        start_game.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MainActivity.play_sound();
                set_quest();
                set_timer();
                v.setVisibility(v.GONE);
            }
        });
        ans_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click_button(1);
                MainActivity.play_sound();
            }
        });
        ans_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click_button(2);
                MainActivity.play_sound();
            }

        });
        ans_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click_button(3);
                MainActivity.play_sound();
            }

        });

    }

    public void click_button(int x){
        if(!tmp.equals(" ")) {
            switch (x) {
                case 1:
                    if (ans_1.getText().equals(tmp)) {

                        count += 1;
                        set_quest();



                    } else {

                        if(count>0){
                            count--;
                        }
                        set_quest();
                    }
                    break;
                case 2:
                    if (ans_2.getText().equals(tmp)) {
                        //  System.out.println("2");
                        count += 1;
                        set_quest();


                    } else {

                        if(count>0){
                            count--;
                        }
                        set_quest();
                    }
                    break;
                case 3:
                    if (ans_3.getText().equals(tmp)) {
                        //  System.out.println("3");
                        count += 1;
                        set_quest();


                    } else {

                        if(count>0){
                            count--;
                        }
                        set_quest();

                    }
                    break;
                default:
                    set_quest();


            }
        }
        else{
            Toast.makeText(this,"Musisz wystartować grę", Toast.LENGTH_SHORT).show();
        }
    }
    public void set_quest(){

        c =sld.GetRandRowDD();
        if(c.getCount()==0){
            System.out.println("on_click_f");
        }
        else{
            while(c.moveToNext()){

                ans_1.setText(c.getString(1).toString());
                ans_2.setText(c.getString(3).toString());
                ans_3.setText(c.getString(2).toString());
                question.setText(c.getString(0).toString());
                count_view.setText("PKT: "+count);
                tmp =c.getString(4).toString();


            }

        }

    }
    public void set_timer(){
        cdt = new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("Czas:"+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
            int x =Opcje.get_state();

               sld.Insert_Result(count);
               try {
                   save_new_res();
               }finally {

               }

            }
        };
        cdt.start();
    }
    public void save_new_res(){
        AlertDialog.Builder Ad;

        Ad = new AlertDialog.Builder(this).setTitle("KONIEC GRY").setMessage("ilość punktów: "+count);
        
        Ad.setPositiveButton("Zagraj Ponownie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tmp = " ";
                count = 0;
            }
        });
        AlertDialog as = Ad.create();
        try {
            as.show();
        } finally {

        }

        start_game.setVisibility(View.VISIBLE);
    }


}
