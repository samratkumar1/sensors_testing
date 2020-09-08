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

public class pressure extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "Pressure";
    Sensor Press;
    SensorManager sensorManager;
    TextView pres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        pres= (TextView) findViewById(R.id.pres);


        Log.d(TAG, "onCreate: intializing sensor services");
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Press=sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (Press!= null) {
            sensorManager.registerListener(pressure.this,Press,sensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: register pressure sensor");
        } else {
            pres.setText("pressure sensor not supported");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        pres.setText("Pressure= "+sensorEvent.values[0]);


    }
}