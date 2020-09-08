package com.example.open_day_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3=(Button) findViewById(R.id.button3);
        Button button4=(Button) findViewById(R.id.button9);
        Button button5=(Button) findViewById(R.id.button8);
        Button button6=(Button) findViewById(R.id.button6);
        Button button7=(Button) findViewById(R.id.button4);
        Button button8=(Button) findViewById(R.id.button10);




        Button button9=(Button) findViewById(R.id.button7);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity5();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity6();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity7();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity8();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity9();
            }
        });

    }
    public void openActivity1(){
        Intent intent=new Intent(this,proxim.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent=new Intent(this,Accelerometer.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent=new Intent(this,Gyroscope.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent=new Intent(this,magn.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent=new Intent(this,light.class);
        startActivity(intent);
    }
    public void openActivity6(){
        Intent intent=new Intent(this,temp.class);
        startActivity(intent);
    }
    public void openActivity7(){
        Intent intent=new Intent(this,humdity.class);
        startActivity(intent);
    }
    public void openActivity8(){
        Intent intent=new Intent(this,pressure.class);
        startActivity(intent);
    }
    public void openActivity9(){
        Intent intent=new Intent(this,RGB.class);
        startActivity(intent);
    }
    }
