package com.example.mathenggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {
    private Button teach_button,time_game_button,multi_game_button,Best_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        teach_button = (Button) findViewById(R.id.learn_button);
        time_game_button = (Button) findViewById(R.id.time_game_button);
        multi_game_button = (Button) findViewById(R.id.playwf_button);
        Best_score = (Button) findViewById(R.id.Best_resoult);
        teach_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teach_game_open();
                MainActivity.play_sound();
            }
        });
        time_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time_game_open();
                MainActivity.play_sound();
            }
        });
        multi_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multi_game_open();
                MainActivity.play_sound();
            }
        });
        Best_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                best_score_open();
                MainActivity.play_sound();
            }
        });
    }
    public void teach_game_open(){
        Intent start_game_teach = new Intent(this,Teach_g.class);
        startActivity(start_game_teach);
        MainActivity.play_sound();
    }
    public void time_game_open(){
        Intent start_game_time = new Intent(this,Game_Time.class);
        startActivity(start_game_time);
        MainActivity.play_sound();
    }
    public void multi_game_open(){
        Intent Multi_game = new Intent(this,Multi_game.class);
        startActivity(Multi_game);
        MainActivity.play_sound();
    }
    public void best_score_open(){
        Intent best = new Intent(this,Best_resoult.class);
        startActivity(best);
        MainActivity.play_sound();
    }
}

