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

public class Gyroscope extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "Gyroscope";
    private SensorManager sensorManager;
    private Sensor Gyro;
    TextView x,y,z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        x = (TextView) findViewById(R.id.x);
        y = (TextView) findViewById(R.id.z);
        z = (TextView) findViewById(R.id.y);

        Log.d(TAG, "onCreate: initialize sensor service");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (Gyro != null) {
            sensorManager.registerListener(Gyroscope.this, Gyro, sensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: register gyroscope sensor");
        } else {
         z.setText("Gyroscope not supported");
    }
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        x.setText("x= "+sensorEvent.values[0]);
        y.setText("y= "+sensorEvent.values[1]);
        z.setText("z= "+sensorEvent.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}