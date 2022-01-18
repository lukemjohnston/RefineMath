package com.example.mathflash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements MainDialogListener{
    private Button play;
    public String gMode, gLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=findViewById(R.id.playButton);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    public void openDialog() {
        MainDialogFragment fragment = new MainDialogFragment();
        fragment.show(getFragmentManager(), "Game Settings");
    }


    int rCount = 1;
    int cCount = 0;
    public void startGame(View v, String gameMode, String gameLength) {
        Intent intent = new Intent(v.getContext(), game.class);
        intent.putExtra("rCount", rCount);
        intent.putExtra("cCount", cCount);
        intent.putExtra("gameMode", gameMode);
        intent.putExtra("gameLength", gameLength);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out );
    }

    public void openSettings(View v) {
        Intent intent = new Intent(v.getContext(), SettingsActivity.class);
        intent.putExtra("rCount", rCount);
        intent.putExtra("cCount", cCount);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out );
    }

    @Override
    public void submittedInfo(View v, CharSequence gameMode, CharSequence gameLength) { ;
        //Toast.makeText(this, gameMode + "  " + gameLength, Toast.LENGTH_SHORT).show();
        gMode = gameMode.toString();
        gLength = gameLength.toString();
        startGame(v, gMode, gLength);
    }

    @Override
    public void onBackPressed() {
        View v = null;
        returnMain(v);
    }

    public void returnMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out );
    }
}