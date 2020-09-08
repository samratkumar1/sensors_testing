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

public class Accelerometer extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "Accelerometer";
    private SensorManager sensorManager;
    Sensor accelerometer;
    TextView xvalue,yvalue,zvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        xvalue= (TextView) findViewById(R.id.x);
        yvalue= (TextView) findViewById(R.id.z);
        zvalue= (TextView) findViewById(R.id.y);

        Log.d(TAG, "onCreate: intializing sensor services");
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(Accelerometer.this,accelerometer,sensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: register accelerometer sensor");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        xvalue.setText("x= "+sensorEvent.values[0]);
        yvalue.setText("y= "+sensorEvent.values[1]);
        zvalue.setText("z= "+sensorEvent.values[2]);
    }
}