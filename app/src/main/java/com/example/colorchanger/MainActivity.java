package com.example.colorchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private TextView colorName;
    private String colors[];
    private int currentRandomNum;
    private int prevRandomNum;
    private String color;
    private int intColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorName = (TextView)findViewById(R.id.tv);
        btn = (Button)findViewById(R.id.btn);
        prevRandomNum = -1;

        colors = new String[]{"#E74C3C", "#F1C40F", "#2ECC71", "#2980B9"};

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setActivityBackgroundColor();
                changeText();


            }
        });


    }

    /**
     * changes the background color randomly
     */
    public void setActivityBackgroundColor() {
        Random random = new Random();

       do{
            currentRandomNum = random.nextInt(colors.length);

        }while(prevRandomNum == currentRandomNum);

        prevRandomNum = currentRandomNum;

        color = colors[currentRandomNum];
        intColor = Color.parseColor(color);

        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(intColor);


    }

    /**
     * changes text based on color of background
     */
    public void changeText(){

        if(currentRandomNum == 0){

            colorName.setText("Red");
        }
        else if(currentRandomNum == 1){

            colorName.setText("Yellow");

        }

        else if(currentRandomNum == 2){

            colorName.setText("Green");

        }

        else if(currentRandomNum == 3){

            colorName.setText("Blue");

        }

    }
}
