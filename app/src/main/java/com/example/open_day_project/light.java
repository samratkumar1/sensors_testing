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

public class light extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "light";
    Sensor light;
    SensorManager sensorManager;
    TextView lght;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        lght= (TextView) findViewById(R.id.temp);


        Log.d(TAG, "onCreate: intializing sensor services");
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        light=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(light.this,light,sensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: register light sensor");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        lght.setText("light= "+sensorEvent.values[0]);


    }
}