package com.example.open_day_project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class proxim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxim);
        SensorManager sensorManager= (SensorManager)getSystemService(SENSOR_SERVICE);
        final Sensor promximSensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        SensorEventListener sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.values[0]<promximSensor.getMaximumRange()){
                    getWindow().getDecorView().setBackgroundColor(Color.RED);//hand on the sensor
                    //  TextView.setText("PASS");
                }
                else{
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {


            }
        };
        sensorManager.registerListener(sensorEventListener,promximSensor,2 * 1000 * 1000);    }
}