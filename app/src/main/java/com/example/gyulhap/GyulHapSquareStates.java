package com.example.gyulhap;

import android.widget.TextView;

public class GyulHapSquareStates {
    private int squareNum;
    TextView squareNumText;
    private boolean squareSelected;
    public GyulHapSquareStates(int squareNum, TextView squareNumText, boolean squareSelected) {
        this.squareNum = squareNum;
        this.squareNumText = squareNumText;
        this.squareSelected = squareSelected;
    }

    public void setSquareNum(int squareNum) {
        this.squareNum = squareNum;
    }

    public void setSquareNumText(TextView squareNumText) {
        this.squareNumText = squareNumText;
    }

    public void setSquareSelected(boolean squareSelected) {
        this.squareSelected = squareSelected;
    }

    public int getSquareNum() {
        return squareNum;
    }

    public TextView getSquareNumText() {
        return squareNumText;
    }

    public boolean getSquareSelected() {
        return squareSelected;
    }
}
