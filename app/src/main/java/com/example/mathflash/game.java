package com.example.mathflash;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        int var = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
        int min = 1, max = 2, ans = 0;

        if (var < 3) {
            min = 1;
            max = 50;
        }
        if (var == 3) {
            min = 1;
            max = 12;
        }

        //creates a random math formula
        int number1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
        int number2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
        String n1 = String.valueOf(number1);
        String n2 = String.valueOf(number2);
        String v = "$";

        if (var == 1) {      //addition
            ans = number1 + number2;
            v = "+";
        }
        if (var == 2) {      //subtraction
            ans = number1 - number2;
            v = "-";
        }
        if (var == 3) {      //multiplication
            ans = number1 * number2;
            v = "x";
        }
        String formula = n1 + " " + v + " " + n2 + " =  ?";
        TextView textView0 = (TextView) findViewById(R.id.mathFormula);
        textView0.setText(formula);


        Button correct_button = (Button) findViewById(R.id.option1);
        Button wrong_button1 = (Button) findViewById(R.id.option2);
        Button wrong_button2 = (Button) findViewById(R.id.option3);
        Button wrong_button3 = (Button) findViewById(R.id.option4);
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
                int a4 = ans - 4;
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
                Intent intent = new Intent(getApplicationContext(), correct.class);
                startActivity(intent);
            }
        });

        wrong_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wrong.class);
                startActivity(intent);
            }
        });

        wrong_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wrong.class);
                startActivity(intent);
            }
        });

        wrong_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wrong.class);
                startActivity(intent);
            }
        });


    }


    public void returnMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}