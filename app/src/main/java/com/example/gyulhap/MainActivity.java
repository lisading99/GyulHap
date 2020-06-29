package com.example.gyulhap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MaterialButton normal, hard, pastScores;
    TextView gyulHapTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gyulHapTitle = findViewById(R.id.gyulHapTitle);
        normal = findViewById(R.id.normal);
        hard = findViewById(R.id.hard);
        pastScores = findViewById(R.id.pastScores);


        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start game with normal level
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("level", "normal");
                startActivity(intent);
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start game with hard level
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("level", "hard");
                startActivity(intent);
            }
        });

        pastScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BestScoreActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

