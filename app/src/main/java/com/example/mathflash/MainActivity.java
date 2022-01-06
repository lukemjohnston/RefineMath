package com.example.mathflash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=findViewById(R.id.playButton);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyMainFragment myMainFragment = new MyMainFragment();
                myMainFragment.show(getFragmentManager(), "MyFragment");

            }
        });
    }


    int rCount = 30;
    int cCount = 0;
    public void startGame(View v) {
        Intent intent = new Intent(v.getContext(), game.class);
        intent.putExtra("rCount", rCount);
        intent.putExtra("cCount", cCount);
        startActivity(intent);
    }

    public void openSettings(View v) {
        Intent intent = new Intent(v.getContext(), SettingsActivity.class);
        intent.putExtra("rCount", rCount);
        intent.putExtra("cCount", cCount);
        startActivity(intent);
    }
}