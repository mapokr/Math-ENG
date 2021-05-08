package com.example.mathenggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class planimetria extends AppCompatActivity {
    private Button square,triangle,trapeze,rectangle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planimetria);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        square = findViewById(R.id.squa);
        triangle = findViewById(R.id.trian);
        trapeze = findViewById(R.id.trape);
        rectangle = findViewById(R.id.rect);
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_square();
            }
        });
        triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_triangle();
            }
        });
        trapeze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_rectangle();
            }
        });
        rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_rectangle();
            }
        });

    }

    public void open_square(){
        Intent it = new Intent(this,square.class);
        startActivity(it);
        MainActivity.play_sound();
    }
    public void open_triangle(){
        Intent it = new Intent(this,triangle.class);
        startActivity(it);
        MainActivity.play_sound();
    }
    public void open_trapeze(){
        Intent it = new Intent(this,trapeze.class);
        startActivity(it);
        MainActivity.play_sound();
    }
    public void open_rectangle(){
        Intent it = new Intent(this,rectangle.class);
        startActivity(it);
        MainActivity.play_sound();
    }
}