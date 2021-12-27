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

        wTextview = (TextView)findViewById(R.id.wfullFormula);
        wTextview.setText(getIntent().getStringExtra("fullFormula"));

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