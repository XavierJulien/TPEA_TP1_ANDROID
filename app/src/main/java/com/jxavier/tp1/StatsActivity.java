package com.jxavier.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        int cpt= getIntent().getIntExtra("compteur",-1);
        TextView text = (TextView)findViewById(R.id.nbclick);
        text.setText("Nombre de click : "+cpt);
    }

}
