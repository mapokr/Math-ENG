package com.example.mathenggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Best_resoult extends AppCompatActivity {
    public zadania_matematyka db;
    public ArrayList<String> res = new ArrayList<String>();
    public TextView mm_easy,mm_medium,mm_hard,ee_easy,ee_medium,ee_hard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_resoult);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        db = new zadania_matematyka(this);
        mm_easy = (TextView) findViewById(R.id.math_re);
        mm_medium = (TextView) findViewById(R.id.math_rm);
        mm_hard = (TextView) findViewById(R.id.math_rh);

        ee_easy = (TextView) findViewById(R.id.eng_re);
        ee_medium = (TextView) findViewById(R.id.eng_rm);
        ee_hard = (TextView) findViewById(R.id.eng_rh);
        Viev_all();
    }
    public void Viev_all() {
        for (int x = 0; x<6 ;x++) {
            Cursor c = db.Get_data(x);
            if (c.getCount() == 0) {
                System.out.println("blad pobrania danych");
            }
            while (c.moveToNext()) {
                res.add(c.getString(0).toString());
                System.out.println(c.getString(0).toString());
            }
        }
        mm_easy.setText("Matematyka łatwa: "+res.get(0).toString());
        mm_medium.setText("Matematyka średna: "+res.get(1).toString());
        mm_hard.setText("Matematyka Trudna: "+res.get(2).toString());
        ee_easy.setText("Agnielski łatwy: "+res.get(3).toString());
       ee_medium.setText("Agnielski średni: "+res.get(4).toString());
        ee_hard.setText("Agnielski Trudny: "+res.get(5).toString());

    }


}