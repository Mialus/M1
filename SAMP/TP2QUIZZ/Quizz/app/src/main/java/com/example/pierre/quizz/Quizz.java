package com.example.pierre.quizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.util.*;

public class Quizz extends AppCompatActivity {
    int it = 0;
    boolean clicRep = true;
    ListView vueQues;
    String chaine;
    ArrayAdapter<String> adapter;
    SQL notesDB ;
    Bundle extra;
    List<String> ques = new ArrayList<String>();

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        extra = getIntent().getExtras();

        //création de la base
        notesDB = new SQL(this);
        notesDB.chargerLesQuestions(ques);// téléchargement des question

        if (it<ques.size()) {

            ((TextView) findViewById(R.id.textView)).setText(ques.get(it));
            ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() { //Button True
                public void onClick(View v) {
                    if (clicRep) { // test si l'utilisateur à vu la réponse
                        if (it == ques.size() - 1) {
                            it = 0;
                        }
                        if (notesDB.getReponse(it + 1).equals("Vrai")) { // si la réponse est correct, on passe à la suivante
                            chaine = ques.get(it + 1);
                            ((TextView) findViewById(R.id.textView)).setText(chaine);
                            it++;
                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong ! Try Again :)", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Vous avez vu la réponse !", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() { //Button False
                public void onClick(View v) {
                    if (clicRep) {
                        if (it == ques.size() - 1) {
                            it = 0;
                        }
                        if (notesDB.getReponse(it + 1).equals("Faux")) {
                            chaine = ques.get(it + 1);
                            ((TextView) findViewById(R.id.textView)).setText(chaine);
                            it++;
                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong ! Try Again :)", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Vous avez vu la réponse !", Toast.LENGTH_SHORT).show();
                    }
                }

            });

            ((Button) findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() { //Button Next
                public void onClick(View v) {
                    clicRep = true;
                    System.out.println("Ceci est le it : " + it);
                    if (it == ques.size() - 1) {
                        it = 0;
                    } else {
                        it++;
                    }
                    chaine = ques.get(it);
                    ((TextView) findViewById(R.id.textView)).setText(chaine);
                }
            });

            ((Button) findViewById(R.id.button4)).setOnClickListener(new View.OnClickListener() { //Button voir réponse
                public void onClick(View v) {
                    Intent reponse = new Intent(Quizz.this, ReponseQuizz.class);
                    reponse.putExtra("rep", notesDB.getReponse(it + 1));
                    startActivityForResult(reponse, 0);
                }
            });
        }else{
            Intent score = new Intent(Quizz.this, AfficheScore.class);
            score.putExtras("score", );
            startActivity(score);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quizz, menu);
        return true;
    }

    public void button (View view) {
        Toast.makeText(Quizz.this, "Wrong ! try again !", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == 0){
            clicRep = false;
        }

    }
}
