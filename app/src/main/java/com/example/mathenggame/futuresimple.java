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

public class futuresimple extends AppCompatActivity {
    private TextView change_am_1, change_am_2, change_am_3, change_he_1, change_he_2, change_he_3, change_they_1, change_they_2, change_they_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_futuresimple);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        change_am_1 = findViewById(R.id.t_i_futureSimple);
        change_am_2 = findViewById(R.id.p_i_futureSimple);
        change_am_3 = findViewById(R.id.pr_i_futureSimple);
        change_he_1 = findViewById(R.id.t_he_futureSimple);
        change_he_2 = findViewById(R.id.p_he_futureSimple);
        change_he_3 = findViewById(R.id.pr_he_futureSimple);
        change_they_1 = findViewById(R.id.t_they_futureSimple);
        change_they_2 = findViewById(R.id.p_they_futureSimple);
        change_they_3 = findViewById(R.id.pr_they_futureSimple);
        change_color();
    }
    public void change_color() {
        ForegroundColorSpan red_collor = new ForegroundColorSpan(Color.RED);

        Spannable am_1 = new SpannableString((String) change_am_1.getText());
        Spannable am_2 = new SpannableString((String) change_am_2.getText());
        Spannable am_3 = new SpannableString((String) change_am_3.getText());

        Spannable he_1 = new SpannableString((String) change_he_1.getText());
        Spannable he_2 = new SpannableString((String) change_he_2.getText());
        Spannable he_3 = new SpannableString((String) change_he_3.getText());

        Spannable they_1 = new SpannableString((String) change_they_1.getText());
        Spannable they_2 = new SpannableString((String) change_they_2.getText());
        Spannable they_3 = new SpannableString((String) change_they_3.getText());

        am_1.setSpan(red_collor, 2, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        am_2.setSpan(red_collor, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        am_3.setSpan(red_collor, 2, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        he_1.setSpan(red_collor, 4, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        he_2.setSpan(red_collor, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        he_3.setSpan(red_collor, 4, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        they_1.setSpan(red_collor, 5, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        they_2.setSpan(red_collor, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        they_3.setSpan(red_collor, 5, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        change_am_1.setText(am_1);
        change_am_2.setText(am_2);
        change_am_3.setText(am_3);

        change_he_1.setText(he_1);
        change_he_2.setText(he_2);
        change_he_3.setText(he_3);

        change_they_1.setText(they_1);
        change_they_2.setText(they_2);
        change_they_3.setText(they_3);
    }
}