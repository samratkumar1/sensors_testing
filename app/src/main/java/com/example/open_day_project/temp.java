package com.example.open_day_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class temp extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "temp";
    Sensor temperature;
    SensorManager sensorManager;
    TextView temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        temp= (TextView) findViewById(R.id.temp);


        Log.d(TAG, "onCreate: intializing sensor services");
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        temperature=sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (temperature!= null) {
            sensorManager.registerListener(temp.this,temperature,sensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: register light sensor");
        } else {
            temp.setText("Temperature sensor not supported");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        temp.setText("Temperature= "+sensorEvent.values[0]);


    }
}