package com.jxavier.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int cpt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        cpt = 0;
        TextView nbclicks = (TextView)findViewById(R.id.click);
        nbclicks.setText("Nombre de clics : "+cpt);
    }

    public void incrementer(View view){
        cpt++;
        TextView nbclicks = (TextView)findViewById(R.id.click);
        nbclicks.setText("Nombre de clics : "+cpt);
    }

    public void stats(View view){
        Intent myintent=new Intent(this,StatsActivity.class).putExtra("compteur",cpt);
        startActivity(myintent);
    }
}
