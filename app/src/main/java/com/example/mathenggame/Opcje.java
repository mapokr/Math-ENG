package com.example.mathenggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Opcje extends AppCompatActivity {

    private static CheckBox e_check, m_check, h_check, eng_check, math_check;
    private boolean e_check_state, m_check_state, h_check_state, eng_check_state, math_check_state;
    private Button save_button;
    FileOutputStream state= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcje);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        e_check = (CheckBox) findViewById(R.id.check_easy);
        m_check = (CheckBox) findViewById(R.id.check_medium);
        h_check = (CheckBox) findViewById(R.id.check_hard);
        eng_check = (CheckBox) findViewById(R.id.check_eng);
        math_check = (CheckBox) findViewById(R.id.check_math);
        save_button = (Button) findViewById(R.id.save_button);

        e_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e_check.setChecked(check_click_level());
            }
        });
        m_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_check.setChecked(check_click_level());
            }
        });
        h_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h_check.setChecked(check_click_level());
            }
        });
        math_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    math_check.setChecked(check_click_category());
            }
        });
        eng_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eng_check.setChecked(check_click_category());
            }
        });
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.play_sound();
                save_setting();
            }
        });

        load_setting();
        update_setting();
    }

    public boolean check_click_level() {
        e_check.setChecked(false);
        m_check.setChecked(false);
        h_check.setChecked(false);
        return true;
    }

    public boolean check_click_category() {
        math_check.setChecked(false);
        eng_check.setChecked(false);
        return true;
    }

    public void save_setting() {
        SharedPreferences preferences = getSharedPreferences("setting", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("e_check", e_check.isChecked());
        editor.putBoolean("m_check", m_check.isChecked());
        editor.putBoolean("h_check", h_check.isChecked());
        editor.putBoolean("eng_check", eng_check.isChecked());
        editor.putBoolean("math_check", math_check.isChecked());
        editor.apply();
        try{
            state = openFileOutput("level.txt",MODE_PRIVATE);
            System.out.println(get_state());
            String asd = Integer.toString(get_state());
            state.write(asd.getBytes());
            state.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "zapisano ustawienia", Toast.LENGTH_SHORT).show();
    }

    public void load_setting() {
        SharedPreferences preferences = getSharedPreferences("setting", Context.MODE_PRIVATE);
        e_check_state = preferences.getBoolean("e_check", true);
        m_check_state = preferences.getBoolean("m_check", false);
        h_check_state = preferences.getBoolean("h_check", false);
        eng_check_state = preferences.getBoolean("eng_check", false);
        math_check_state = preferences.getBoolean("math_check", true);
    }

    public void update_setting() {
        e_check.setChecked(e_check_state);
        m_check.setChecked(m_check_state);
        h_check.setChecked(h_check_state);
        eng_check.setChecked(eng_check_state);
        math_check.setChecked(math_check_state);
    }

    public static int get_state() {
        int tmp = 1;
        try {

        if(math_check.isChecked()){
            if(e_check.isChecked()){
                tmp= 0;

            }
            if(m_check.isChecked()){
                tmp =1;
            }
            if(h_check.isChecked()){
                tmp =2;
            }
        }
            else {
                if(e_check.isChecked()){
                    tmp= 3;

                }
                if(m_check.isChecked()){
                    tmp =4;
                }
                if(h_check.isChecked()){
                    tmp =5;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return tmp;
    }

}