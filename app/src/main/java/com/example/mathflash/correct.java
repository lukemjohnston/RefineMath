package com.example.mathflash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class correct extends AppCompatActivity {
    TextView cTextview;
    TextView roundCount;
    TextView correctCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        Intent mIntent = getIntent();
        int rCount = mIntent.getIntExtra("rCount", 0);
        int cCount = mIntent.getIntExtra("cCount", 0);

        rCount++;
        cCount++;

        cTextview = (TextView)findViewById(R.id.fullFormula);
        cTextview.setText(getIntent().getStringExtra("fullFormula"));

        //RoundCount = (TextView)findViewById(R.id.fullFormula);


        final Handler h = new Handler();
        int finalRCount = rCount;
        int finalCCount = cCount;
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), game.class);
                intent.putExtra("rCount", finalRCount);
                intent.putExtra("cCount", finalCCount);
                startActivity(intent);

            }

        }, 1500);
    }
}