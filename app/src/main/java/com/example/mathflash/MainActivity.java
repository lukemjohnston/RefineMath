package com.example.mathflash;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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