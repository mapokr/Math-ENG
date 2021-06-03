package com.example.mathenggame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Multi_game extends AppCompatActivity {
    private Button b_1, b_2, b_3, r_1, r_2, r_3;
    private static Button Start_multi;
    private TextView b_p, b_q, r_p, r_q;
    public zadania_matematyka sld;
    private Cursor c;
    private String tmpb= " ";
    private String tmpr= " ";

    private static int countb,countr= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        sld = new zadania_matematyka(this);
        setContentView(R.layout.activity_multi_game);
        b_1 = (Button) findViewById(R.id.blue_ans_1);
        b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_reply(1);
                MainActivity.play_sound();
            }
        });
        b_2 = (Button) findViewById(R.id.blue_ans_2);
        b_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_reply(2);
                MainActivity.play_sound();
            }
        });
        b_3 = (Button) findViewById(R.id.blue_ans_3);
        b_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_reply(3);
                MainActivity.play_sound();
            }
        });
        r_1 = (Button) findViewById(R.id.red_ans_1);
        r_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_reply(4);
                MainActivity.play_sound();
            }
        });
        r_2 = (Button) findViewById(R.id.red_ans_2);
        r_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_reply(5);
                MainActivity.play_sound();
            }
        });
        r_3 = (Button) findViewById(R.id.red_ans_3);
        r_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_reply(6);
                MainActivity.play_sound();
            }
        });
        b_p = (TextView) findViewById(R.id.blue_point);
        b_q = (TextView) findViewById(R.id.blue_quest);

        r_p = (TextView) findViewById(R.id.red_point);
        r_q = (TextView) findViewById(R.id.red_quest);

        Start_multi = (Button) findViewById(R.id.multi_game_button);
        Start_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.play_sound();
                set_quest_multi(1);
                set_quest_multi(2);
                v.setVisibility(v.GONE);
                r_p.setVisibility(View.VISIBLE);
                b_p.setVisibility(View.VISIBLE);
            }
        });


    }

    public void set_quest_multi(int x) {
        AlertDialog.Builder Ad;
        if(countb==5){
            Start_multi.setVisibility(View.VISIBLE);
            Ad = new AlertDialog.Builder(this).setTitle("KONIEC GRY").
                    setMessage("Wygrał gracz nr 1\n").
                    setMessage("gracz nr 1:"+countb+" pkt\t"+"gracz nr 2:"+countr+" pkt");
            Ad.setPositiveButton("Zagraj Ponownie", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tmpb = " ";
                    tmpr = " ";
                    countb = 0;
                    countr = 0;
                }
            });
            AlertDialog as = Ad.create();
            as.show();
        }

        if(countr==5){
            Start_multi.setVisibility(View.VISIBLE);
            Ad = new AlertDialog.Builder(this).setTitle("KONIEC GRY").setMessage("Wygrał gracz nr 2\n").setMessage("gracz nr 1:"+countb+" pkt\t"+"gracz nr 2:"+countr+" pkt");
            Ad.setPositiveButton("Zagraj Ponownie", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tmpb = " ";
                    tmpr = " ";
                    countb = 0;
                    countr = 0;
                }
            });
            AlertDialog as = Ad.create();
            as.show();
        }
        c = this.sld.GetRandRowDD();
        if (c.getCount() == 0) {
            System.out.println("on_click_f");
        } else {
            while (c.moveToNext()) {
                if(x==1) {
                    b_1.setText(c.getString(1).toString());
                    b_2.setText(c.getString(3).toString());
                    b_3.setText(c.getString(2).toString());
                    b_q.setText(c.getString(0).toString());
                    b_p.setText("PKT: " + countb);
                    tmpb = c.getString(4).toString();
                }
                if(x==2) {
                    r_1.setText(c.getString(1).toString());
                    r_2.setText(c.getString(3).toString());
                    r_3.setText(c.getString(2).toString());
                    r_q.setText(c.getString(0).toString());
                    r_p.setText("PKT: " + countr);
                    tmpr = c.getString(4).toString();
                }

            }
        }
    }

    public void send_reply(int x){
        if(!tmpb.equals(" ") || !tmpr.equals(" ")) {
            switch (x) {
                case 1:
                    if (b_1.getText().equals(tmpb)) {
                        countb += 1;
                        set_quest_multi(1);
                    } else {
                        if(countb>0) {
                            countb--;
                        }
                        set_quest_multi(1);
                    }
                    break;

                case 2:
                    if (b_2.getText().equals(tmpb)) {
                        //  System.out.println("2");
                        countb += 1;
                        set_quest_multi(1);


                    } else {

                        if(countb>0)
                        {
                        countb--;}
                        set_quest_multi(1);
                    }
                    break;
                case 3:
                    if (b_3.getText().equals(tmpb)) {
                        //  System.out.println("3");
                        countb += 1;
                        set_quest_multi(1);


                    } else {

                        if(countb>0)
                        {countb--;}
                        set_quest_multi(1);
                    }
                    break;
                case 4:
                    if (r_1.getText().equals(tmpr)) {
                        //  System.out.println("3");
                        countr += 1;
                        set_quest_multi(2);


                    } else {

                        if(countr>0)
                        { countr--;}
                        set_quest_multi(2);
                    }
                    break;
                case 5:
                    if (r_2.getText().equals(tmpr)) {
                        //  System.out.println("3");
                        countr += 1;
                        set_quest_multi(2);


                    } else {

                        if(countr>0)
                        {countr--;}
                        set_quest_multi(2);
                    }
                    break;
                case 6:
                    if (r_3.getText().equals(tmpr)) {
                        //  System.out.println("3");
                        countr += 1;
                        set_quest_multi(2);


                    } else {

                        if(countr>0)
                        { countr--;}
                        set_quest_multi(2);

                    }
                    break;
                default:
                    set_quest_multi(1);
                    set_quest_multi(2);

            }
        }
        else{
            Toast.makeText(this,"Musisz wystartować grę", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onBackPressed() {
        countb=0;
        countr=0;
        super.onBackPressed();
    }
}