package com.example.mathflash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class correct extends AppCompatActivity {
    TextView cTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        cTextview = (TextView)findViewById(R.id.fullFormula);
        cTextview.setText(getIntent().getStringExtra("fullFormula"));

        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), game.class);
                startActivity(intent);

            }

        }, 1500);
    }
}