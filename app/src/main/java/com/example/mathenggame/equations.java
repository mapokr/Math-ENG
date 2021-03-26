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

public class equations extends AppCompatActivity {
    private TextView changeA,changeP1,changeP2,changeObw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equations);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        changeObw = findViewById(R.id.wy_1);
        changeP1 = findViewById(R.id.wy_2);
        changeP2 = findViewById(R.id.wy_3);
        change_color();

    }
    public void change_color(){
        ForegroundColorSpan red_collor = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan red_collor_2 = new ForegroundColorSpan(Color.RED);

        Spannable obw_w = new SpannableString((String)changeObw.getText());

        Spannable p2_w = new SpannableString((String)changeP2.getText());
        Spannable p1_w = new SpannableString((String)changeP1.getText());

        obw_w.setSpan(red_collor,7,10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        obw_w.setSpan(red_collor_2,20,23, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        p2_w.setSpan(red_collor,7,12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        p1_w.setSpan(red_collor,8,12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        p1_w.setSpan(red_collor_2,18,22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        changeObw.setText(obw_w);
        changeP1.setText(p1_w);
        changeP2.setText(p2_w);
    }

}