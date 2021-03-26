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

public class triangle extends AppCompatActivity {
    private TextView changeA,changeP1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangle);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        changeA = findViewById(R.id.obw_tria);
        changeP1 = findViewById(R.id.pw_tria);

        change_color();
    }
    public void change_color(){
        ForegroundColorSpan red_collor = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan red_collor_2 = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan red_collor_3 = new ForegroundColorSpan(Color.RED);

        Spannable obw = new SpannableString(""+changeA.getText());



        Spannable p1_w = new SpannableString((String)changeP1.getText());

        obw.setSpan(red_collor,16,29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        obw.setSpan(red_collor_2,44,57, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        obw.setSpan(red_collor_3,70,88, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        p1_w.setSpan(red_collor,0,15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        changeA.setText(obw);

        changeP1.setText(p1_w);
    }
}