package com.example.gyulhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class BestScoreActivity extends AppCompatActivity {
    TextView bestScoreText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_score);
        bestScoreText = findViewById(R.id.bestScore);

        SharedPreferences settings = getApplicationContext().getSharedPreferences("SCORE", 0);
        String bestScore = settings.getString("BESTSCORE", "");

        bestScoreText.setText(bestScore);
    }
}
