package com.example.mathflash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game extends AppCompatActivity {
    public int rCount, cCount, maxRound;
    public String gameMode, gameLength, fullFormula;
    public Button correct_button, wrong_button1, wrong_button2, wrong_button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createFormula();
    }


    public void createFormula() {
        Intent mIntent = getIntent();
        rCount = mIntent.getIntExtra("rCount", 0);
        cCount = mIntent.getIntExtra("cCount", 0);
        gameMode = mIntent.getStringExtra("gameMode");
        gameLength = mIntent.getStringExtra("gameLength");


        PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences sp =  PreferenceManager.getDefaultSharedPreferences(this);

        boolean addTrue = sp.getBoolean("add", true);
        boolean subTrue = sp.getBoolean("sub", true);
        boolean multTrue = sp.getBoolean("mult", true);
        boolean divTrue = sp.getBoolean("div", true);


        if (gameLength.equals("10 Rounds"))
            maxRound = 10;
        if (gameLength.equals("20 Rounds"))
            maxRound = 20;
        if (gameLength.equals("30 Rounds"))
            maxRound = 30;

        String round = String.valueOf(rCount);
        TextView roundCount = (TextView) findViewById(R.id.roundCount);
        roundCount.setText(round + "/" + maxRound);

        int var = 0;
        boolean creating = true;

        while(creating){
            var = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);

            if ((var == 1) && (addTrue == true)) {      //addition
                creating = false;
            }
            else if ((var == 2) && (subTrue == true)) {      //subtraction
                creating = false;
            }
            else if ((var == 3) && (multTrue == true)) {      //multiplication
                creating = false;
            }
            else if ((var == 4) && (divTrue == true)) {      //division
                creating = false;
            }
        }

        int min = 1, max = 2, ans = 0;

        if (var < 3) {
            min = 1;
            max = 50;
        }
        if (var >= 3) {
            min = 1;
            max = 12;
        }

        //creates a random math formula
        int number1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
        int number2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
        String v = "$";

        boolean negAllow = sp.getBoolean("negatives", false);

        if (var == 1) {      //addition
            ans = number1 + number2;
            v = "+";
        }
        if (var == 2) {      //subtraction
            if ((negAllow == false) && (number2 > number1)) {
                int temp = number1;
                number1 = number2;
                number2 = temp;
            }
            ans = number1 - number2;
            v = "-";
        }
        if (var == 3) {      //multiplication
            ans = number1 * number2;
            v = "x";
        }
        if (var == 4) {      //division
            ans = number1 * number2;
            int temp = number1;
            number1 = ans;
            ans = temp;
            v = "÷";
        }
        String n1 = String.valueOf(number1);
        String n2 = String.valueOf(number2);
        String formula = n1 + " " + v + " " + n2;
        TextView textView0 = (TextView) findViewById(R.id.mathFormula);
        textView0.setText(formula);


        String a = String.valueOf(ans);
        fullFormula = n1 + " " + v + " " + n2 + " =  "+a;

        configureButtons(ans, rCount, cCount, fullFormula);
    }


    private void configureButtons(int ans, int rCount, int cCount, String fullFormula) {
        correct_button = (Button) findViewById(R.id.option1);
        wrong_button1 = (Button) findViewById(R.id.option2);
        wrong_button2 = (Button) findViewById(R.id.option3);
        wrong_button3 = (Button) findViewById(R.id.option4);
        //puts the answer in one of the buttons
        int correctButton = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
        if (correctButton == 1) {
            TextView textView1 = (TextView) findViewById(R.id.option1);
            textView1.setText("" + ans);
            correct_button = (Button) findViewById(R.id.option1);
            wrong_button1 = (Button) findViewById(R.id.option2);
            wrong_button2 = (Button) findViewById(R.id.option3);
            wrong_button3 = (Button) findViewById(R.id.option4);
        }
        if (correctButton == 2) {
            TextView textView2 = (TextView) findViewById(R.id.option2);
            textView2.setText("" + ans);
            correct_button = (Button) findViewById(R.id.option2);
            wrong_button1 = (Button) findViewById(R.id.option1);
            wrong_button2 = (Button) findViewById(R.id.option3);
            wrong_button3 = (Button) findViewById(R.id.option4);
        }
        if (correctButton == 3) {
            TextView textView3 = (TextView) findViewById(R.id.option3);
            textView3.setText("" + ans);
            correct_button = (Button) findViewById(R.id.option3);
            wrong_button1 = (Button) findViewById(R.id.option1);
            wrong_button2 = (Button) findViewById(R.id.option2);
            wrong_button3 = (Button) findViewById(R.id.option4);
        }
        if (correctButton == 4) {
            TextView textView3 = (TextView) findViewById(R.id.option4);
            textView3.setText("" + ans);
            correct_button = (Button) findViewById(R.id.option4);
            wrong_button1 = (Button) findViewById(R.id.option1);
            wrong_button2 = (Button) findViewById(R.id.option2);
            wrong_button3 = (Button) findViewById(R.id.option3);
        }


        //puts close answers in the other buttons
        int scramble = (int)Math.floor(Math.random()*(3-1+1)+1);
        if (scramble > 0) {
            if (correctButton != 1){
                TextView textView1 = (TextView) findViewById(R.id.option1);
                int a1 = ans+2;
                textView1.setText("" + a1);
            }
            if (correctButton != 2) {
                TextView textView2 = (TextView) findViewById(R.id.option2);
                int a2 = ans + 3;
                textView2.setText("" + a2);
            }
            if (correctButton != 3) {
                TextView textView3 = (TextView) findViewById(R.id.option3);
                int a3 = ans + 5;
                textView3.setText("" + a3);
            }
            if (correctButton != 4) {
                TextView textView4 = (TextView) findViewById(R.id.option4);
                int a4 = ans - 2;
                textView4.setText("" + a4);
            }
        }
        if (scramble == 2) {
            if (correctButton != 1){
                TextView textView1 = (TextView) findViewById(R.id.option1);
                int a1 = ans+1;
                textView1.setText("" + a1);
            }
            if (correctButton != 2) {
                TextView textView2 = (TextView) findViewById(R.id.option2);
                int a2 = ans - 4;
                textView2.setText("" + a2);
            }
            if (correctButton != 3) {
                TextView textView3 = (TextView) findViewById(R.id.option3);
                int a3 = ans + 10;
                textView3.setText("" + a3);
            }
            if (correctButton != 4) {
                TextView textView4 = (TextView) findViewById(R.id.option4);
                int a4 = ans - 2;
                textView4.setText("" + a4);
            }
        }
        if (scramble == 3) {
            if (correctButton != 1){
                TextView textView1 = (TextView) findViewById(R.id.option1);
                int a1 = ans-5;
                textView1.setText("" + a1);
            }
            if (correctButton != 2) {
                TextView textView2 = (TextView) findViewById(R.id.option2);
                int a2 = ans + 2;
                textView2.setText("" + a2);
            }
            if (correctButton != 3) {
                TextView textView3 = (TextView) findViewById(R.id.option3);
                int a3 = ans - 8;
                textView3.setText("" + a3);
            }
            if (correctButton != 4) {
                TextView textView4 = (TextView) findViewById(R.id.option4);
                int a4 = ans - 10;
                textView4.setText("" + a4);
            }
        }

        correct_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), correct.class);
                intent.putExtra("fullFormula", fullFormula);
                intent.putExtra("rCount", rCount);
                intent.putExtra("cCount", cCount);
                intent.putExtra("gameMode", gameMode);
                intent.putExtra("gameLength", gameLength);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out );
            }
        });


        wrong_button1.setOnClickListener(new View.OnClickListener() {
            int buttonNum = 1;

            @Override
            public void onClick(View v) {
                wrongButton(v, buttonNum);
            }
        });

        wrong_button2.setOnClickListener(new View.OnClickListener() {
            int buttonNum = 2;

            @Override
            public void onClick(View v) {
                wrongButton(v, buttonNum);
            }
        });

        wrong_button3.setOnClickListener(new View.OnClickListener() {
            int buttonNum = 3;

            @Override
            public void onClick(View v) {
               wrongButton(v, buttonNum);
            }
        });

    }

    public void wrongButton(View v, int button) {
        if (gameMode.equals("Test Mode")) {
            Intent intent = new Intent(v.getContext(), wrong.class);
            intent.putExtra("fullFormula", fullFormula);
            intent.putExtra("rCount", rCount);
            intent.putExtra("cCount", cCount);
            intent.putExtra("gameMode", gameMode);
            intent.putExtra("gameLength", gameLength);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out );
        }
        else if (gameMode.equals("Practice Mode")) {
            if (button == 1)
                wrong_button1.setBackgroundColor(Color.LTGRAY);
            if (button == 2)
                wrong_button2.setBackgroundColor(Color.LTGRAY);
            if (button == 3)
                wrong_button3.setBackgroundColor(Color.LTGRAY);
        }
    }

    @Override
    public void onBackPressed() {
        View v = null;
        returnMain(v);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void returnMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out );
    }
}