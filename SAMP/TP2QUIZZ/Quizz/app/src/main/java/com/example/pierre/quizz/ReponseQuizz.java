package com.example.pierre.quizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.util.*;

public class ReponseQuizz extends AppCompatActivity {

Bundle extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int it = 0;
        String chaine;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reponse_quizz);

        extra= getIntent().getExtras();



        ((Button)findViewById (R.id.buttonRep)).setOnClickListener(new View.OnClickListener() { //Button Montrez la réponse
            public void onClick(View v) {
                Intent clic = new Intent(ReponseQuizz.this, Quizz.class);
                clic.putExtra("vuRep",true);
                setResult(RESULT_OK,clic);
                finish();
            if (extra.getBoolean("rep")){
                ((TextView) findViewById(R.id.textView3)).setText("Vrai");
            }else{
                ((TextView) findViewById(R.id.textView3)).setText("Faux");
            }
            }
        }) ;
    }


}