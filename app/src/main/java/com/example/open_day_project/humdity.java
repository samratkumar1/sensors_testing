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

public class humdity extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "humidity";
    Sensor humidity;
    SensorManager sensorManager;
    TextView hum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humdity);


        hum= (TextView) findViewById(R.id.hum);


        Log.d(TAG, "onCreate: intializing sensor services");
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        humidity=sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if (humidity!= null) {
            sensorManager.registerListener(humdity.this,humidity,sensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: register light sensor");
        } else {
            hum.setText("Humidity sensor not supported");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        hum.setText("Humidity= " + sensorEvent.values[0]);
    }
}