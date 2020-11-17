package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startBtn;
    private Button startAgainBtn;
    private Button exitBtn;
    private TextView userText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = this.findViewById(R.id.firstButton);
        startAgainBtn = this.findViewById(R.id.secondButton);
        exitBtn = this.findViewById(R.id.thirdButton);
        userText = this.findViewById(R.id.userMessage);

        startBtn.setOnClickListener(this);
        startAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAgainBtn.setVisibility(View.GONE);
                exitBtn.setVisibility(View.GONE);
                startBtn.setVisibility(View.VISIBLE);
                userText.setVisibility(View.VISIBLE);
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        startAgainBtn.setVisibility(View.GONE);
        exitBtn.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        final EditText input = new EditText(this);
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage("WHAT WOULD YOU LIKE TO TALK ABOUT")
                .setView(input)
                .setPositiveButton("CONTINUE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        keepTalking(input.getText().toString());
                    }
                })
                .setNegativeButton("CANCEL", null)
                .show();
        startAgain();
    }

    public void keepTalking(String s) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage("DO YOU LIKE " + s + "?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        likeTopic(s);
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dislikeTopic(s);
                    }
                })
                .show();

    }

    public void likeTopic(String t) {
        Context context = getApplicationContext();
        CharSequence message = "I'm happy that you like " + t + "!!";
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.show();
    }

    public void dislikeTopic(String d) {
        Context context = getApplicationContext();
        CharSequence message = "Are you serious?? You don't like " + d + "!! I can not believe it!!!";
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.show();
    }

    public void startAgain() {
        startBtn.setVisibility(View.GONE);
        userText.setVisibility(View.GONE);
        startAgainBtn.setVisibility(View.VISIBLE);
        exitBtn.setVisibility(View.VISIBLE);
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}