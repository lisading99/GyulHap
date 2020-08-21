package com.example.gyulhap;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {
    private UpdateGameActivity updateGameActivityListener;
    public static interface UpdateGameActivity {
        public void restartCountDownTimer();
        public void dialogResult();
        public void pauseCountDownTimer();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        updateGameActivityListener = (UpdateGameActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.updateGameActivityListener = null;
    }

    public AlertDialogFragment() {
        super();
    }

    public static AlertDialogFragment newInstance(String title, String message) {
        AlertDialogFragment frag = new AlertDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("message", message);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        String message = getArguments().getString("message");
        // pause countDownTimer in game activity
        updateGameActivityListener.pauseCountDownTimer();
        return new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                GameActivity.isOnBackPressed = true;
                                updateGameActivityListener.dialogResult();
                            }
                        }
                )
                .setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                GameActivity.isOnBackPressed = false;
                                updateGameActivityListener.restartCountDownTimer();
                                return;
                            }
                        })
                .create();
    }
}