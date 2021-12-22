package com.example.mathflash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class game extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int var = (int)Math.floor(Math.random()*(3-1+1)+1);
        int min = 1;
        int max = 2;
        int ans = 0;

        if(var < 3) {
            min = 1;
            max = 50;
        }
        if(var == 3) {
            min = 1;
            max = 12;
        }

        int number1 = (int)Math.floor(Math.random()*(max-min+1)+min);
        int number2 = (int)Math.floor(Math.random()*(max-min+1)+min);
        String n1 = String.valueOf(number1);
        String n2 = String.valueOf(number2);
        String v = "$";

        if(var == 1) {      //addition
            ans = number1 + number2;
            v = "+";
        }
        if(var == 2) {      //subtraction
            ans = number1 - number2;
            v = "-";
        }
        if(var == 3) {      //multiplication
            ans = number1 * number2;
            v = "x";
        }
        String formula = n1+" "+v+" "+n2+" =  ?";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView textView = (TextView) findViewById(R.id.mathFormula);
        textView.setText(formula);
    }

    public void optionChosen(View view) {
        Intent intent = new Intent(this, game.class);
        startActivity(intent);
    }

    public void returnMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}