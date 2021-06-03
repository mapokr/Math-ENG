package com.example.mathenggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fig_przes extends AppCompatActivity {
    Button cube, cuboid,wal,kul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fig_przes);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        cube = findViewById(R.id.cube);
        cuboid = findViewById(R.id.cuboid);
        wal = findViewById(R.id.wal);
        kul = findViewById(R.id.kul);
        cube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_cube();
            }
        });
        cuboid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_cuboid();
            }
        });
        wal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_wal();
            }
        });
        kul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_kul();
            }
        });
    }

    private void open_kul() {
        Intent it = new Intent(this,kol.class);
        startActivity(it);
    }

    private void open_wal() {
        Intent it = new Intent(this,wale.class);
        startActivity(it);
    }

    public void open_cube(){
        Intent it = new Intent(this,cube.class);
        startActivity(it);
    }
    public void open_cuboid(){
        Intent it = new Intent(this,pcube.class);
        startActivity(it);
    }
}