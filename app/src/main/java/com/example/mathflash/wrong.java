package com.example.mathflash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class wrong extends AppCompatActivity {

    TextView wTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong);

        Intent mIntent = getIntent();
        int rCount = mIntent.getIntExtra("rCount", 0);
        int cCount = mIntent.getIntExtra("cCount", 0);

        rCount++;

        wTextview = (TextView)findViewById(R.id.wfullFormula);
        wTextview.setText(getIntent().getStringExtra("fullFormula"));

        final Handler h = new Handler();
        int finalRCount = rCount;
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), game.class);
                intent.putExtra("rCount", finalRCount);
                intent.putExtra("cCount", cCount);
                startActivity(intent);

            }

        }, 1500);
    }
}