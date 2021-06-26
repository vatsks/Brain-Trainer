package com.example.brain_trainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView textViewtimer,textViewquestions,textViewansers;Random rand;
    Button button,button2,button3,button4;int locationofcorrectanswer;
    ArrayList<Integer> answer=new ArrayList<>();

    CountDownTimer countDownTimer=new CountDownTimer(30000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            textViewtimer.setText(Integer.toString((int) (millisUntilFinished/1000))+"s");
        }

        @Override
        public void onFinish() {
            textViewtimer.setText("00s");
        }
    };
        public void click(View view){
            int k=Integer.parseInt(button.getText().toString());
            if(k==locationofcorrectanswer){
                textViewquestions.setText("correct");
            }

        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewtimer=findViewById(R.id.textViewtimer);
        button = findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        textViewquestions=findViewById(R.id.textViewquestions);
        countDownTimer.start();
        rand = new Random();
        int a= rand.nextInt(20);
        int b= rand.nextInt(61);
        textViewquestions.setText(Integer.toString(a)+"+"+Integer.toString(b));
        locationofcorrectanswer = rand.nextInt(4);
        for(int i=0;i<4;i++){
            if (i==locationofcorrectanswer){
                answer.add(a+b);
            }
            else {
                int wringanswer=rand.nextInt(80);
                while(wringanswer==a+b){
                answer.add(rand.nextInt(20)+rand.nextInt(60));}

            answer.add(wringanswer);
        }

    }
        button.setText((Integer.toString(answer.get(0))));
        button2.setText((Integer.toString(answer.get(1))));
        button3.setText((Integer.toString(answer.get(2))));
        button4.setText((Integer.toString(answer.get(3))));


    }
}