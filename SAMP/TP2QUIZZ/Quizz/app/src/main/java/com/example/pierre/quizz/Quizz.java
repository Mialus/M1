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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        extra= getIntent().getExtras();

        notesDB = new SQL(this);
        notesDB.chargerLesQuestions(ques);

        ((TextView) findViewById(R.id.textView)).setText(ques.get(it));
        /*vueQues = (ListView) findViewById(android.R.id.list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ques);
        vueQues.setAdapter(adapter);
        */
        ((Button)findViewById (R.id.button)).setOnClickListener(new View.OnClickListener() { //Button True
            public void onClick(View v) {
                if (clicRep) {
                    if (it == ques.size() - 1) {
                        it = 0;
                    }
                    if (notesDB.getReponse(it+1) == "Vrai") {
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
        }) ;

        ((Button)findViewById (R.id.button5)).setOnClickListener(new View.OnClickListener() { //Button ajout question
            public void onClick(View v) {

            Intent i = new Intent(Quizz.this, ajoutQuestion.class);
                startActivity(i);
            }
        }) ;

        ((Button)findViewById (R.id.button2)).setOnClickListener(new View.OnClickListener() { //Button False
            public void onClick(View v) {
                if (clicRep) {
                    if (it == ques.size() - 1) {
                        it = 0;
                    }
                    if (notesDB.getReponse(it+1) == "faux") {
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

        }) ;

       ((Button)findViewById (R.id.button3)).setOnClickListener(new View.OnClickListener() { //Button Next
            public void onClick(View v) {
                clicRep=true;
                if(it==ques.size()-1){
                    it=0;
                }
                chaine = ques.get(it + 1);
                ((TextView) findViewById(R.id.textView)).setText(chaine);
                it++;
            }
        }) ;

        ((Button)findViewById (R.id.button4)).setOnClickListener(new View.OnClickListener() { //Button voir réponse
            public void onClick(View v) {
                Intent reponse = new Intent(Quizz.this, ReponseQuizz.class);
                reponse.putExtra("rep",notesDB.getReponse(it+1));
                startActivityForResult(reponse, 0) ;
            }
        }) ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quizz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
