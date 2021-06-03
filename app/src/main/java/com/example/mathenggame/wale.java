package com.example.mathenggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class wale extends AppCompatActivity {
    private TextView changeA,changeP1,changeP2,changeObw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wale);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        changeA = findViewById(R.id.obw_cube);
        changeObw = findViewById(R.id.obw_c);
        changeP1 = findViewById(R.id.v_1);
        changeP2 = findViewById(R.id.v_3);
        change_color();
    }
    public void change_color(){
        ForegroundColorSpan red_collor = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan red_collor_2 = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan red_collor_3 = new ForegroundColorSpan(Color.RED);

        Spannable obw = new SpannableString(""+changeA.getText());
        Spannable obw_w = new SpannableString((String)changeObw.getText());
        Spannable p2_w = new SpannableString((String)changeP2.getText());
        Spannable p1_w = new SpannableString((String)changeP1.getText());

        obw.setSpan(red_collor,0,5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        obw.setSpan(red_collor_2,30,33, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        obw_w.setSpan(red_collor_3,0,8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        p1_w.setSpan(red_collor,0,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        p2_w.setSpan(red_collor,0,16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        changeA.setText(obw);
        changeObw.setText(obw_w);
        changeP1.setText(p1_w);
        changeP2.setText(p2_w);
    }
}