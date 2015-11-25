package com.example.tonioo25.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.tonioo25.myapplication.Activity.MenuActivity;

/**
 * Created by tonioo25 on 21/10/2015.
 */
public class ScoresActivity extends AppCompatActivity {

    int cpt = 0;
    int i =0;
    int reponseVue = 0;
    String reponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores_main);

        Intent i = getIntent();
        reponse = i.getStringExtra("reponseCourante");
        Log.i("test 5", "" + reponse);

        findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Log.i("test 1", "" + reponseVue);
                Intent i = new Intent(ScoresActivity.this, MenuActivity.class);
                startActivity(i);
                //finish();
            }

        });
    }

}
