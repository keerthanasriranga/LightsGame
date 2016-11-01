package com.wordpress.keerthanasriranga.lightsgame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3,button4,b_new;

    int c = 0;

    TextView highScore;

    String buttonColor1, buttonColor2, buttonColor3,buttonColor4;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        b_new = (Button) findViewById(R.id.b_new);




        r = new Random();
        int temp;

        temp = r.nextInt(3) + 1;
        if(temp==1){
            buttonColor1="red";
        } else if (temp==2){
            buttonColor1 = "green";
        }else if(temp==3){
            buttonColor1 = "blue";
        }

        temp = r.nextInt(3) + 1;
        if(temp==1){
            buttonColor2="red";
        } else if (temp==2){
            buttonColor2 = "green";
        }else if(temp==3){
            buttonColor2 = "blue";
        }

        temp = r.nextInt(3) + 1;
        if(temp==1){
            buttonColor3="red";
        } else if (temp==2){
            buttonColor3 = "green";
        }else if(temp==3){
            buttonColor3 = "blue";
        }

        temp = r.nextInt(3) + 1;
        if(temp==1){
            buttonColor4="red";
        } else if (temp==2){
            buttonColor4 = "green";
        }else if(temp==3){
            buttonColor4 = "blue";
        }

       applyColor(button1, buttonColor1);
        applyColor(button2, buttonColor2);
        applyColor(button3, buttonColor3);
        applyColor(button4, buttonColor4);

        //clicks

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                buttonColor1 = changeColor(buttonColor1);
                applyColor(button1, buttonColor1);

                buttonColor2 = changeColor(buttonColor2);
                applyColor(button2, buttonColor2);

                c++;

                checkForWin();

            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                buttonColor1 = changeColor(buttonColor1);
                applyColor(button1, buttonColor1);

                buttonColor2 = changeColor(buttonColor2);
                applyColor(button2, buttonColor2);

                buttonColor3 = changeColor(buttonColor3);
                applyColor(button3, buttonColor3);

                c++;

                checkForWin();


            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                buttonColor2 = changeColor(buttonColor2);
                applyColor(button2, buttonColor2);

                buttonColor3 = changeColor(buttonColor3);
                applyColor(button3, buttonColor3);

                c++;



                checkForWin();

            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                buttonColor3 = changeColor(buttonColor3);
                applyColor(button3, buttonColor3);

                buttonColor4 = changeColor(buttonColor4);
                applyColor(button4, buttonColor4);

                c++;

                checkForWin();

            }
        });

        b_new.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
        );

    }

    public void checkForWin(){
        if(buttonColor1.equals("green")
                && buttonColor2.equals("green")
                && buttonColor3.equals("green")
                && buttonColor4.equals("green")){
            Toast.makeText(MainActivity.this, "Winner!", Toast.LENGTH_SHORT).show();

            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);

           /* SharedPreferences prefs = this.getSharedPreferences("myPrefskey", Context.MODE_PRIVATE);
            int c = prefs.getInt("key", 0);
            highScore.setText(c);*/


        }
    }

    public String changeColor(String color){
        if(color.equals("red")){
            color = "green";
        }else if(color.equals("green")){
            color="blue";
        }else if(color.equals("blue")){
            color="red";
        }

        return color;
    }

    public void applyColor(Button button, String color) {
        if (color.equals("red")) {
            button.setBackgroundColor(Color.RED);
        }
        else if (color.equals("green")) {
            button.setBackgroundColor(Color.GREEN);
        }
        else if (color.equals("blue")) {
            button.setBackgroundColor(Color.BLUE);
        }

        /*SharedPreferences prefs = this.getSharedPreferences("myPrefskey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("key", c);
        editor.commit();*/


    }
}
