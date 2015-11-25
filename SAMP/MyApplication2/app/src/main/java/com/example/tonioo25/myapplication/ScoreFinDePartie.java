package com.example.tonioo25.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.tonioo25.myapplication.Activity.MenuActivity;

/**
 * Created by tonioo25 on 21/10/2015.
 */
public class ScoreFinDePartie extends AppCompatActivity {
Bundle extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_fin_de_partie);

        extra= getIntent().getExtras();
        ((TextView) findViewById(R.id.textView)).setText("Votre score est de "+extra.getString("score")+"/"+extra.getString("total"));

        findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ScoreFinDePartie.this, MenuActivity.class);
                startActivity(i);
                finish();
            }

        });
    }
}
