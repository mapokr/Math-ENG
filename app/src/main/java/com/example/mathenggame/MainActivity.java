package com.example.mathenggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public zadania_matematyka database;
    private Button setting_button,start_button,quit_button;
    private boolean count=true;
    private Opcje state;
    static MediaPlayer hit_board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(count==false){
            load_setting();
        }
        hit_board = MediaPlayer.create(this,R.raw.board_hit);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        database = new zadania_matematyka(this);
        if(count){
        database.insert_value();
            update_setting();
            SharedPreferences preferences = getSharedPreferences("end", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("end",count);
            editor.apply();
        }

        setting_button = (Button) findViewById(R.id.setting_button);
        start_button = (Button) findViewById(R.id.start_button);
        quit_button = (Button) findViewById(R.id.quit_button);

        setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_setting();
                play_sound();
            }
        });
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_start();
                play_sound();
            }
        });
        quit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                play_sound();
                System.exit(0);

            }
        });
    }
    public void open_start(){
        Intent start = new Intent(this,Start.class);
        startActivity(start);
    }


    public void open_setting(){
        Intent opcje = new Intent(this, Opcje.class);
        startActivity(opcje);
    }
    public void load_setting(){
        SharedPreferences preferences = getSharedPreferences("end", Context.MODE_PRIVATE);
        count = preferences.getBoolean("end", true );

    }
    public void update_setting(){
        count=false;
    }

    public static void play_sound(){
        hit_board.start();
    }
}
