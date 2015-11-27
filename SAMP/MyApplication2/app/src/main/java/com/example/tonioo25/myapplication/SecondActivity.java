package com.example.tonioo25.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by m1acasagr3 on 29/09/15.
 */
//Activité qui permet à l'utilisateur de voir ou non la réponse à la question si il le souhaite
public class SecondActivity extends AppCompatActivity {
    int cpt = 0;
    int i =0;
    int reponseVue = 0;
    String reponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_main2);


        Intent i = getIntent();
        reponse = i.getStringExtra("reponseCourante");

        findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((TextView) findViewById(R.id.repText)).setText(String.valueOf(reponse));
                reponseVue = 1;
            }
        });

        findViewById(R.id.modifQuizz).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("reponseVue",reponseVue);
                setResult(RESULT_OK, data);
                finish();
            }

        });
    }

    public void laRepEstVue() {
        //super.finish();
    }

}
