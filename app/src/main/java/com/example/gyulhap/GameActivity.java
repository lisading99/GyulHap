package com.example.gyulhap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameActivity extends AppCompatActivity implements
        AlertDialogFragment.UpdateGameActivity{
    GyulHapSquares[][] gyulHapBoardSquares;
    ArrayList<ArrayList<Integer>> gyulHapBoardAnswers;
    Button hapBtn, clearBtn;
    boolean isValidSelection = false;
    static boolean isOnBackPressed = false;
    long timeLeft = 120000;
    CountDownTimer countDownTimer;
    ImageView square1, square2, square3, square4, square5, square6, square7, square8, square9;
    static TextView timer, one, two, three, four, five, six, seven, eight, nine;

    GyulHapSquareStates gyulHapSquare1State, gyulHapSquare2State, gyulHapSquare3State,
            gyulHapSquare4State, gyulHapSquare5State, gyulHapSquare6State,
            gyulHapSquare7State, gyulHapSquare8State, gyulHapSquare9State;
    ArrayList<GyulHapSquareStates> gyulHapSquareStates = new ArrayList<>();
    Uri uri;
    ArrayList<Integer> selectedSquaresList = new ArrayList<>();
    ArrayList<ArrayList<Integer>> selectedSquaresCorrect = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        square1 = findViewById(R.id.square1);
        square2 = findViewById(R.id.square2);
        square3 = findViewById(R.id.square3);
        square4 = findViewById(R.id.square4);
        square5 = findViewById(R.id.square5);
        square6 = findViewById(R.id.square6);
        square7 = findViewById(R.id.square7);
        square8 = findViewById(R.id.square8);
        square9 = findViewById(R.id.square9);
        hapBtn = findViewById(R.id.hapBtn);
        clearBtn = findViewById(R.id.clearBtn);
        timer = findViewById(R.id.timer);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);

        // make the gyul hap objects
        Intent intent = getIntent();
        String level = intent.getStringExtra("level");
        GyulHapBoard gyulHapBoard = new GyulHapBoard(level);
        gyulHapBoardSquares = gyulHapBoard.getGyulHapBoard();
        gyulHapBoardAnswers = gyulHapBoard.getGyulHapBoardAnswers();

        // loop through all gyul hap squares and display
        GyulHapSquares square = null;
        int index = 1;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                square = gyulHapBoardSquares[row][col];
                uri = Uri.parse(square.getImg());

                switch (index) {
                    case 1:
                        square1.setImageURI(uri);
                        break;
                    case 2:
                        square2.setImageURI(uri);
                        break;
                    case 3:
                        square3.setImageURI(uri);

                        break;
                    case 4:
                        square4.setImageURI(uri);
                        break;
                    case 5:
                        square5.setImageURI(uri);
                        break;
                    case 6:
                        square6.setImageURI(uri);
                        break;
                    case 7:
                        square7.setImageURI(uri);
                        break;
                    case 8:
                        square8.setImageURI(uri);
                        break;
                    case 9:
                        square9.setImageURI(uri);
                        break;
                }
                index++;

            }
        }

        // listen for onclicks from user and save square as selection
        gyulHapSquare1State = new GyulHapSquareStates(1, one, false);
        gyulHapSquare2State = new GyulHapSquareStates(2, two, false);
        gyulHapSquare3State = new GyulHapSquareStates(3, three, false);
        gyulHapSquare4State = new GyulHapSquareStates(4, four, false);
        gyulHapSquare5State = new GyulHapSquareStates(5, five, false);
        gyulHapSquare6State = new GyulHapSquareStates(6, six, false);
        gyulHapSquare7State = new GyulHapSquareStates(7, seven, false);
        gyulHapSquare8State = new GyulHapSquareStates(8, eight, false);
        gyulHapSquare9State = new GyulHapSquareStates(9, nine, false);
        gyulHapSquareStates.add(gyulHapSquare1State);
        gyulHapSquareStates.add(gyulHapSquare2State);
        gyulHapSquareStates.add(gyulHapSquare3State);
        gyulHapSquareStates.add(gyulHapSquare4State);
        gyulHapSquareStates.add(gyulHapSquare5State);
        gyulHapSquareStates.add(gyulHapSquare6State);
        gyulHapSquareStates.add(gyulHapSquare7State);
        gyulHapSquareStates.add(gyulHapSquare8State);
        gyulHapSquareStates.add(gyulHapSquare9State);

        square1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSquareClickedActions(gyulHapSquare1State);
            }
        });

        square2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSquareClickedActions(gyulHapSquare2State);
            }
        });
        square3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSquareClickedActions(gyulHapSquare3State);
            }
        });
        square4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSquareClickedActions(gyulHapSquare4State);
            }
        });
        square5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSquareClickedActions(gyulHapSquare5State);
            }
        });
        square6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSquareClickedActions(gyulHapSquare6State);
            }
        });
        square7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSquareClickedActions(gyulHapSquare7State);
            }
        });
        square8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSquareClickedActions(gyulHapSquare8State);
            }
        });
        square9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSquareClickedActions(gyulHapSquare9State);
            }
        });

        hapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hapBtn.isEnabled()) {
                    // check selected squares with answers
                    Collections.sort(selectedSquaresList);

                    for (int n = 0; n < selectedSquaresCorrect.size(); n++) {
                        if (selectedSquaresCorrect.get(n).equals(selectedSquaresList)) {
                            // answer already exists - user already submitted answer before
                            Toast.makeText(GameActivity.this,
                                    "Combination/answer already" +
                                            " submitted before", Toast.LENGTH_SHORT).show();
                            clearAll();
                            return;
                        }
                    }
                    for (int i = 0; i < gyulHapBoardAnswers.size(); i++) {
                        Collections.sort(gyulHapBoardAnswers.get(i));
                        if (gyulHapBoardAnswers.get(i).equals(selectedSquaresList)) {
                            Toast.makeText(GameActivity.this, "Correct!",
                                    Toast.LENGTH_SHORT).show();
                            selectedSquaresCorrect.add(new ArrayList<Integer>(Arrays.asList(
                                    selectedSquaresList.get(0), selectedSquaresList.get(1),
                                    selectedSquaresList.get(2)
                            )));
                            isValidSelection = true;
                            clearAll();
                            return;
                        }
                    }

                    if (! isValidSelection) {
                        Toast.makeText(GameActivity.this,
                                "Incorrect!", Toast.LENGTH_SHORT).show();
                        clearAll();
                    }
                }
            }
        });
        isOnBackPressed = false;

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAll();
            }
        });
    }

    private void handleSquareClickedActions(GyulHapSquareStates gyulHapSquareState) {
        boolean squareSelected = gyulHapSquareState.getSquareSelected();
        gyulHapSquareState.setSquareSelected(!squareSelected);

        if (squareSelected) {
            if (selectedSquaresList.size() != 3) {
                selectedSquaresList.add(gyulHapSquareState.getSquareNum());
                gyulHapSquareState.getSquareNumText().setTextColor(getResources().getColor(R.color.shadow));
            }
            if (selectedSquaresList.size() == 3) {
                // enable hap button
                hapBtn.setEnabled(true);
            }
        } else {
            gyulHapSquareState.getSquareNumText().setTextColor(getResources().getColor(R.color.white));
            selectedSquaresList.remove(Integer.valueOf(gyulHapSquareState.getSquareNum()));
            if (selectedSquaresList.size() < 3) {
                hapBtn.setEnabled(false);
            }
        }
    }

    private void clearAll() {
        for (int m = 0; m < gyulHapSquareStates.size(); m++) {
            gyulHapSquareStates.get(m).getSquareNumText().setTextColor(
                    getResources().getColor(R.color.white));
        }
        // reset squares selection list
        selectedSquaresList = new ArrayList<>();
        // reset hapBtn back to disabled
        hapBtn.setEnabled(false);
        isValidSelection = false;
    }

    @Override
    public void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    public void onResume() {
        super.onResume();
        startCountDownTimer();
    }

    @Override
    public void onBackPressed() {
        if (timeLeft == 0) {
            finish();
        }
        // return to the home activity - ask user if they want to quit game
        AlertDialogFragment alertDialogFragment = AlertDialogFragment.newInstance(
                "Quit game", "Would you like to quit the current game?"
        );
        alertDialogFragment.show(getSupportFragmentManager(), "dialog");
    }

    private void startCountDownTimer() {
        // start timer for 120 second seconds
      countDownTimer =  new CountDownTimer(timeLeft, 1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText("seconds remaining: " + millisUntilFinished / 1000);
                timeLeft = millisUntilFinished;
            }
            public void onFinish() {
                // start results activity
                if (! isOnBackPressed) {
                    Intent intent = new Intent(GameActivity.this, ResultActivity.class );
                    intent.putExtra("selectedSquaresCorrect", selectedSquaresCorrect);
                    intent.putExtra("gyulHapBoardAnswers", gyulHapBoardAnswers);

                    // store scores
                    SharedPreferences settings = getApplicationContext().getSharedPreferences("SCORE", 0);
                    String bestScore = settings.getString("BESTSCORE", "");
                    SharedPreferences.Editor editor = settings.edit();
                    if (bestScore.contentEquals("")) {
                        editor.putString("BESTSCORE", Integer.toString(selectedSquaresCorrect.size()) +
                                "/" + gyulHapBoardAnswers.size());
                        editor.apply();
                    } else {
                        int score = Integer.parseInt(bestScore.substring(0, bestScore.indexOf("/")));
                        int total = Integer.parseInt(bestScore.substring(bestScore.indexOf("/") + 1));
                        if ((score / total) <= (selectedSquaresCorrect.size() /
                                gyulHapBoardAnswers.size()) && total < gyulHapBoardAnswers.size()) {
                            editor.clear();
                            editor.putString("BESTSCORE", Integer.toString(
                                    selectedSquaresCorrect.size()) +
                                    "/" + gyulHapBoardAnswers.size());
                            editor.apply();
                        }
                    }
                    Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(
                            GameActivity.this).toBundle();
                    startActivity(intent, bundle);
                }
            }
        }.start();
    }

    @Override
    public void restartCountDownTimer() {
        startCountDownTimer();
    }

    @Override
    public void dialogResult() {
        finish();
    }

    @Override
    public void pauseCountDownTimer() {
        countDownTimer.cancel();
    }
}
