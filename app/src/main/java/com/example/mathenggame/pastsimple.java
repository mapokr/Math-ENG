package com.example.mathenggame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class pastsimple extends AppCompatActivity {
    private TextView change_ed_1,change_did_1,change_didnt_1,change_ed_2,change_did_2,change_didnt_2,change_ed_3,change_did_3,change_didnt_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastsimple);
        change_ed_1 = findViewById(R.id.t_i_pastsimple);
        change_did_1= findViewById(R.id.p_i_pastsimple);
        change_didnt_1 = findViewById(R.id.pr_i_pastsimple);
        change_ed_2 = findViewById(R.id.t_he_pastsimple);
        change_did_2 = findViewById(R.id.p_he_pastsimple);
        change_didnt_2 = findViewById(R.id.pr_he_pastsimple);
        change_ed_3 = findViewById(R.id.t_they_pastsimple);
        change_did_3 = findViewById(R.id.p_they_pastsimple);
        change_didnt_3 = findViewById(R.id.pr_they_pastsimple);
        change_color();
    }
    public void change_color(){

        ForegroundColorSpan red_collor = new ForegroundColorSpan(Color.RED);


        Spannable ed_1 = new SpannableString((String)change_ed_1.getText());
        Spannable am_2 = new SpannableString((String)change_did_1.getText());
        Spannable am_3 = new SpannableString((String)change_didnt_1.getText());

        Spannable he_1 = new SpannableString((String)change_ed_2.getText());
        Spannable he_2 = new SpannableString((String)change_did_2.getText());
        Spannable he_3 = new SpannableString((String)change_didnt_2.getText());

        Spannable they_1 = new SpannableString((String)change_ed_3.getText());
        Spannable they_2 = new SpannableString((String)change_did_3.getText());
        Spannable they_3 = new SpannableString((String)change_didnt_3.getText());

        ed_1.setSpan(red_collor,6,8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        am_2.setSpan(red_collor,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        am_3.setSpan(red_collor,2,8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        he_1.setSpan(red_collor,6,8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        he_2.setSpan(red_collor,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        he_3.setSpan(red_collor,3,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        they_1.setSpan(red_collor,3,6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        they_2.setSpan(red_collor,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        they_3.setSpan(red_collor,3,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);



        change_ed_1.setText(ed_1);
        change_did_1.setText(am_2);
        change_didnt_1.setText(am_3);

        change_ed_2.setText(he_1);
        change_did_2.setText(he_2);
        change_didnt_2.setText(he_3);

        change_ed_3.setText(they_1);
        change_did_3.setText(they_2);
        change_didnt_3.setText(they_3);
}
}