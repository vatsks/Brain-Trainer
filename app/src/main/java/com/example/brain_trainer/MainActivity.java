package com.example.brain_trainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView textViewtimer,textViewquestions,textViewansers,textView4;
    Random rand;
    Button button,button2,button3,button4,buttonplayagain;
    int locationofcorrectanswer,score=0,noofques=0;
    ArrayList<Integer> answer=new ArrayList<>();

    CountDownTimer countDownTimer=new CountDownTimer(10000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            textViewtimer.setText(Integer.toString((int) (millisUntilFinished/1000))+"s");
        }

        @Override
        public void onFinish() {
            textView4.setText("Your Score is "+Integer.toString(score)+"/"+Integer.toString(noofques));buttonplayagain.setVisibility(View.VISIBLE);

        }
    };
        public void setquestion(){

            rand = new Random();
            int a= rand.nextInt(20);
            int b= rand.nextInt(61);
            textViewquestions.setText(Integer.toString(a)+"+"+Integer.toString(b));
            answer.clear();
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

        public void click(View view){
           if (Integer.toString(locationofcorrectanswer).equals(view.getTag().toString())){
               textView4.setText("Correct");score++;

           }else {
               textView4.setText("not correct");
           }
           noofques++;
           textViewansers.setText(Integer.toString(score)+"/"+Integer.toString(noofques));
           setquestion();


        }
        public  void playagain(View view){
            countDownTimer.start();
            setquestion();


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
        buttonplayagain=findViewById(R.id.buttonplayagain);
        textViewquestions=findViewById(R.id.textViewquestions);
        textViewansers=findViewById(R.id.textViewanswers);
        textView4=findViewById(R.id.textView4);
        countDownTimer.start();
        setquestion();



    }
}