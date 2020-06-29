package com.example.gyulhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class ResultActivity extends AppCompatActivity {
    ArrayList<ArrayList<Integer>> selectedSquaresCorrect = new ArrayList<>();
    ArrayList<ArrayList<Integer>> gyulHapBoardAnswers = new ArrayList<>();
    TextView userResultsText, missingAnswersText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inside your activity (if you did not enable transitions in your theme)
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        // set an exit transition
        getWindow().setEnterTransition(new Slide());
        setContentView(R.layout.activity_result);
        userResultsText = findViewById(R.id.userAnswers);
        missingAnswersText = findViewById(R.id.missingAnswers);
        selectedSquaresCorrect = (ArrayList<ArrayList<Integer>>)
                getIntent().getSerializableExtra("selectedSquaresCorrect");
        gyulHapBoardAnswers = (ArrayList<ArrayList<Integer>>)
                getIntent().getSerializableExtra("gyulHapBoardAnswers");


        // display correct answers user got right

        int selectedSquaresCorrectSize = selectedSquaresCorrect.size();
        String[] answersFromUser = new String[selectedSquaresCorrectSize];
        for (int i = 0; i < selectedSquaresCorrect.size(); i++) {
            int first = selectedSquaresCorrect.get(i).get(0);
            int second = selectedSquaresCorrect.get(i).get(1);
            int third = selectedSquaresCorrect.get(i).get(2);

            answersFromUser[i] = first + ", " +
                    second + ", " + third;

        }

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, R.layout.results_list, answersFromUser);
        ListView listView = (ListView) findViewById(R.id.userAnswersList);
        try {
            listView.setAdapter(itemsAdapter);
        } catch (Exception e) {

        }

        // display answers they missed
        // determine combinations user did not get

        int missingAnswersSize = gyulHapBoardAnswers.size() - selectedSquaresCorrectSize;
        String[] missingAnswers = new String[missingAnswersSize];
        boolean matches = false;
        for (int m = 0; m < gyulHapBoardAnswers.size(); m++) {
            Collections.sort(gyulHapBoardAnswers.get(m));
            for (int n = 0; n < selectedSquaresCorrectSize; n++) {
                if (gyulHapBoardAnswers.get(m).equals(selectedSquaresCorrect.get(n))) {
                    matches = true;
                }
            }
            if (! matches) {
                int first = gyulHapBoardAnswers.get(m).get(0);
                int second = gyulHapBoardAnswers.get(m).get(1);
                int third = gyulHapBoardAnswers.get(m).get(2);

                missingAnswers[m] = first + ", " + second +
                            ", " + third;

            }
        }

        ArrayAdapter<String> missingAnswersAdapter =
                new ArrayAdapter<String>(this, R.layout.results_list, missingAnswers);
        ListView missingAnswersListView = (ListView) findViewById(R.id.missingAnswersList);
        try {
            missingAnswersListView.setAdapter(missingAnswersAdapter);
        } catch (Exception e) {

        }
        // congrats if all correct
        if (missingAnswersSize == 0) {
            userResultsText.setText("Congrats! You have discovered all the haps :)");
            userResultsText.setTextSize(30);
            missingAnswersText.setText("");
            listView.setAdapter(null);
            missingAnswersListView.setAdapter(null);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
    }
}
