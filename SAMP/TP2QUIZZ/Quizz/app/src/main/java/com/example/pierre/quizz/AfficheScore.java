package com.example.pierre.quizz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;
/**
 * Created by Pierre on 21/10/2015.
 */
public class AfficheScore extends AppCompatActivity{
Bundle extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        extra= getIntent().getExtras();

        ((TextView) findViewById(R.id.textView)).setText("Votre score est de "+extra.getString("score")+"/"+extra.getString("total"));

        ((Button)findViewById (R.id.buttonRetour)).setOnClickListener(new View.OnClickListener() { //Button retour au amin
            public void onClick(View v) {
                setResult(1);
                finish();
            }
        });
    }
}
