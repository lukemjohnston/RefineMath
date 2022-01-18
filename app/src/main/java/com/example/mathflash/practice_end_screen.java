package com.example.mathflash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class practice_end_screen extends AppCompatActivity {
    private TextView score, percent;
    public String gameMode, gameLength;
    public int rCount, cCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_end_screen);
    }

    public void returnMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out );
    }

    public void startGame(View v) {
        rCount = 1;
        cCount = 0;

        Intent intent = new Intent(v.getContext(), game.class);
        intent.putExtra("rCount", rCount);
        intent.putExtra("cCount", cCount);
        intent.putExtra("gameMode", gameMode);
        intent.putExtra("gameLength", gameLength);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out );
    }
}