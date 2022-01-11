package com.example.mathflash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class correct extends AppCompatActivity {
    public TextView formulaTV;
    public String gameMode, gameLength;
    public int rCount, cCount, maxRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        Intent mIntent = getIntent();
        rCount = mIntent.getIntExtra("rCount", 0);
        cCount = mIntent.getIntExtra("cCount", 0);
        gameMode = mIntent.getStringExtra("gameMode");
        gameLength = mIntent.getStringExtra("gameLength");

        rCount++;
        cCount++;

        if (gameLength.equals("10 Rounds"))
            maxRound = 10;
        if (gameLength.equals("20 Rounds"))
            maxRound = 20;
        if (gameLength.equals("30 Rounds"))
            maxRound = 30;

        formulaTV = (TextView)findViewById(R.id.fullFormula);
        formulaTV.setText(getIntent().getStringExtra("fullFormula"));


        final Handler h = new Handler();
        int finalRCount = rCount;
        int finalCCount = cCount;
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), game.class);
                if (finalRCount == (maxRound+1)) {
                    if (gameMode.equals("Test Mode"))
                        intent = new Intent(getApplicationContext(), end_screen.class);
                    else if (gameMode.equals("Practice Mode"))
                        intent = new Intent(getApplicationContext(), practice_end_screen.class);
                }
                intent.putExtra("rCount", finalRCount);
                intent.putExtra("cCount", finalCCount);
                intent.putExtra("gameMode", gameMode);
                intent.putExtra("gameLength", gameLength);
                startActivity(intent);

            }

        }, 1500);
    }
}