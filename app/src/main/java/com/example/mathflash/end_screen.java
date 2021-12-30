package com.example.mathflash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class end_screen extends AppCompatActivity {
    TextView score;
    TextView percent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        Intent mIntent = getIntent();
        int cCount = mIntent.getIntExtra("cCount", 0);
        float finPer = ((float)cCount/30)*100;

        score = (TextView)findViewById(R.id.score);
        score.setText(cCount+"/30");
        percent = (TextView)findViewById(R.id.percent);
        percent.setText((int)finPer+"%");

    }

    public void returnMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    int rCount = 1;
    int cCount = 0;
    public void startGame(View v) {
        Intent intent = new Intent(v.getContext(), game.class);
        intent.putExtra("rCount", rCount);
        intent.putExtra("cCount", cCount);
        startActivity(intent);
    }
}