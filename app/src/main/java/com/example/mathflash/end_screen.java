package com.example.mathflash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class end_screen extends AppCompatActivity {
    private TextView score, percent;
    public String gameMode, gameLength;
    public int rCount, cCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        Intent mIntent = getIntent();
        cCount = mIntent.getIntExtra("cCount", 0);
        rCount = mIntent.getIntExtra("rCount", 0);
        gameMode = mIntent.getStringExtra("gameMode");
        gameLength = mIntent.getStringExtra("gameLength");

        rCount--;

        float finPer = ((float)cCount/rCount)*100;

        score = (TextView)findViewById(R.id.score);
        score.setText(cCount+"/"+rCount);
        percent = (TextView)findViewById(R.id.percent);
        percent.setText((int)finPer+"%");

    }

    public void returnMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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
    }
}