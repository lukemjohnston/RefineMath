package com.example.mathflash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class wrong extends AppCompatActivity {
    public TextView formulaTV;
    public String gameMode, gameLength;
    public int rCount, cCount, maxRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong);

        Intent mIntent = getIntent();
        rCount = mIntent.getIntExtra("rCount", 0);
        cCount = mIntent.getIntExtra("cCount", 0);
        gameMode = mIntent.getStringExtra("gameMode");
        gameLength = mIntent.getStringExtra("gameLength");

        rCount++;

        if (gameLength.equals("10 Rounds"))
            maxRound = 10;
        if (gameLength.equals("20 Rounds"))
            maxRound = 20;
        if (gameLength.equals("30 Rounds"))
            maxRound = 30;

        formulaTV = (TextView)findViewById(R.id.wfullFormula);
        formulaTV.setText(getIntent().getStringExtra("fullFormula"));

        final Handler h = new Handler();
        int finalRCount = rCount;
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (finalRCount == (maxRound+1))
                    intent = new Intent(getApplicationContext(), end_screen.class);
                else
                    intent = new Intent(getApplicationContext(), game.class);
                intent.putExtra("rCount", finalRCount);
                intent.putExtra("cCount", cCount);
                intent.putExtra("gameMode", gameMode);
                intent.putExtra("gameLength", gameLength);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out );
            }

        }, 1500);
    }

    @Override
    public void onBackPressed() {

    }

}