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

public class magn extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "Mag";
    Sensor sensorl;
 SensorManager sensorManager;
 TextView xval,yval,zval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magn);
        xval= (TextView) findViewById(R.id.xval);
        yval= (TextView) findViewById(R.id.yval);
        zval= (TextView) findViewById(R.id.zval);

        Log.d(TAG, "onCreate: intializing sensor services");
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorl=sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sensorManager.registerListener(magn.this,sensorl,sensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: register magneto sensor");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        xval.setText("x= "+sensorEvent.values[0]);
        yval.setText("y= "+sensorEvent.values[1]);
        zval.setText("z= "+sensorEvent.values[2]);

    }
}
