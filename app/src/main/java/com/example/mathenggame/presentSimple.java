package com.example.mathenggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//https://www.jezykiobce.pl/blog/jezyk-angielski/podstawowe-czasy-w-jezyku-angielskim
public class presentSimple extends AppCompatActivity {
    private Button present_simple;
    private TextView change_s,change_do_1,change_do_2,change_does,change_dont_1,change_dont_2,change_doesent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_simple);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        change_do_1 = findViewById(R.id.do_1);
        change_do_2 = findViewById(R.id.do_2);
        change_does = findViewById(R.id.does_1);
        change_s = findViewById(R.id.s_1);
        change_dont_1 = findViewById(R.id.dont_1);
        change_dont_2 = findViewById(R.id.dont_2);
        change_doesent = findViewById(R.id.doesnt_1);
        change_text_color();


    }
    public void change_text_color(){
        //color
        ForegroundColorSpan red_collor = new ForegroundColorSpan(Color.RED);
        //span
        SpannableString do_i = new SpannableString((String)change_do_1.getText());
        SpannableString do_he = new SpannableString((String)change_do_2.getText());
        SpannableString dooes_they = new SpannableString((String)change_does.getText());
        SpannableString s_ = new SpannableString((String)change_s.getText());
        SpannableString dont_i = new SpannableString((String)change_dont_1.getText());
        SpannableString dont_they = new SpannableString((String)change_dont_2.getText());
        SpannableString dosent_he = new SpannableString((String)change_doesent.getText());

        do_i.setSpan(red_collor,0,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        do_he.setSpan(red_collor,0,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        dooes_they.setSpan(red_collor,0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s_.setSpan(red_collor,7,8,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        dont_i.setSpan(red_collor,2,7,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        dont_they.setSpan(red_collor,4,11,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        dosent_he.setSpan(red_collor,4,11,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        change_do_1.setText(do_i);
        change_do_2.setText(do_he);
        change_does.setText(dooes_they);
        change_s.setText(s_);
        change_dont_1.setText(dont_i);
        change_dont_2.setText(dont_they);
        change_doesent.setText(dosent_he);
    }
}