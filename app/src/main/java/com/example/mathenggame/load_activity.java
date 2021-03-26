package com.example.mathenggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;


public class load_activity extends AppCompatActivity {
    private static int  SPLASH = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_load_activity);
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          Intent load_screen = new Intent(load_activity.this,MainActivity.class);
                                          startActivity(load_screen);
                                       
                                      }
                                  }, SPLASH
        );
    }
}