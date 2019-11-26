package com.jxavier.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    int cpt = 0;
    Handler handler;
    Date currentTime;
    Date firstTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();


    }

    @Override
    protected void onStart() {
        super.onStart();
        cpt = 0;
        TextView nbclicks = (TextView)findViewById(R.id.click);
        nbclicks.setText("Nombre de clics : "+cpt);


    }

    public void incrementer(View view){
        if(cpt==0){
            final Chronometer simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer); // initiate a chronometer
            simpleChronometer.setText("");
            simpleChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                int counter = 10;
                @Override
                public void onChronometerTick(Chronometer chronometer) {
                    if(counter == 0)
                    {
                        counter = 10;
                    }
                    chronometer.setText("Time left:"+ counter + " s");
                    counter--;

                }
            });
            simpleChronometer.setVisibility(View.VISIBLE);
            simpleChronometer.start();
            final Intent myintent=new Intent(this,StatsActivity.class);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    myintent.putExtra("compteur",cpt);
                    simpleChronometer.setText("");
                    simpleChronometer.stop();
                    startActivity(myintent);
                }
            }, 10000);
        }
        cpt++;
        TextView nbclicks = (TextView) findViewById(R.id.click);
        nbclicks.setText("Nombre de clics : " + cpt);
    }

    public void stats(View view){
        Intent myintent=new Intent(this,StatsActivity.class).putExtra("compteur",cpt);
        startActivity(myintent);
    }
}
