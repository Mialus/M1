package com.example.tonioo25.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by tonioo25 on 21/10/2015.
 */
public class ScoreFinDePartie extends AppCompatActivity {
    Bundle extra;
    QuizzDatabase db;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_fin_de_partie);

        extra= getIntent().getExtras();
        ((TextView) findViewById(R.id.textView)).setText("Votre score est de "+extra.getString("score")+"/"+extra.getString("total"));
        db = new QuizzDatabase(this);
        id = (int) db.insereScore(extra.getString("score") + " sur " + extra.getString("total"), extra.getInt("sujet"));
        System.out.println(id);
        findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(1);
                finish();
            }

        });
    }
}
