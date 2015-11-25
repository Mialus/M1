package com.example.tonioo25.myapplication.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tonioo25.myapplication.Adapter.GridViewAdapter;
import com.example.tonioo25.myapplication.Item.ItemQR;
import com.example.tonioo25.myapplication.QuizzDatabase;
import com.example.tonioo25.myapplication.R;
import com.example.tonioo25.myapplication.ScoreFinDePartie;
import com.example.tonioo25.myapplication.SecondActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Déclaration des variables
    int cpt = 0;
    int i =0;
    int estVue = 0;
    public static final int ACTIVITE_REP = 1;
    int nombreDeQuestion;
    int questionCourante;
    private String reponseCourante;
    ArrayList<ItemQR> listeDesQuestions;
    int nePeutPlusRep=0;
    Bundle recup;

    //Création de la base de données
    QuizzDatabase db;

    GridView grilleDeReponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grilleDeReponse=(GridView) findViewById(R.id.gridReponse);

        recup = getIntent().getExtras();
        int id = recup.getInt("sujetChoisi");

        //Gestion de la base de données et du cuseur pour la parcourir
        db = new QuizzDatabase(this);
        Cursor c = db.getReadableDatabase().rawQuery("select * from questions",null);
        nombreDeQuestion = c.getCount();
        c.close();

        //Liste des questions de l'object Item que l'on charge dans la base de données
        listeDesQuestions = new ArrayList<>();
        db.chargerLesQuestions(listeDesQuestions,id);

        // On affiche la question 1 du quizz
        questionCourante = 1;
        afficheQuestion(questionCourante);

        final ArrayList<String> StockerRep = listeDesQuestions.get(cpt).getLesReponsesPossibles();
        GridViewAdapter grilleAdapter = new GridViewAdapter(StockerRep,this);
        grilleDeReponse.setAdapter(grilleAdapter);
        findViewById(R.id.next).setOnClickListener(this);

        System.out.println("test 6"+StockerRep.size());
        grilleDeReponse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(listeDesQuestions.get(cpt).getReponse().equalsIgnoreCase(StockerRep.get(position))){
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Permet d'aller du MainActivity vers la SecondAcvtivity qui permet à l'utilisateur de voir la réponse à question
        // Lui envoie la valeur de la réponse courante
        findViewById(R.id.reponse).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("reponseCourante", reponseCourante);
                startActivityForResult(i, ACTIVITE_REP);

            }

        });

    }

    //Fonction qui permet d'afficher la question courante dans l'application pour que l'utilisateur puisse répondre
    private void afficheQuestion(int idQuestion){
            ((TextView) findViewById(R.id.textView)).setText(listeDesQuestions.get(questionCourante).getQuestion());
            reponseCourante = listeDesQuestions.get(questionCourante).getReponse();
    }

    //Fonction qui permet de recuperer la valeur de "estVue" pour savoir si l'utilisateur à vue la reponse
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        if (requestCode == ACTIVITE_REP && resultCode == RESULT_OK) {
            estVue = data.getIntExtra("reponseVue", 1);
            Log.i("test2", "" + estVue);


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    //Gestion de mes boutons
    //Bouton reponse "vrai, reponse "faux", et question "next"
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.vrai:
                if(nePeutPlusRep==0){
                if (reponseCourante.equalsIgnoreCase("vrai") && estVue == 0) {
                    ((TextView) findViewById(R.id.result)).setText(getResources().getText(R.string.correct));
                    nePeutPlusRep=1;

                } else if (!reponseCourante.equalsIgnoreCase("vrai") && estVue == 0){
                    ((TextView) findViewById(R.id.result)).setText(getResources().getText(R.string.incorrect));
                    nePeutPlusRep=1;
                }
                else{
                    ((TextView) findViewById(R.id.result)).setText(getResources().getText(R.string.reponseDejaVue));
                }
                }
                else{
                    ((TextView) findViewById(R.id.result)).setText(getResources().getText(R.string.vousAvezDejaRep));
                }
                break;
            case R.id.faux:
                if(nePeutPlusRep==0) {
                    if (reponseCourante.equalsIgnoreCase("faux") && estVue == 0) {
                        ((TextView) findViewById(R.id.result)).setText(getResources().getText(R.string.correct));
                        nePeutPlusRep = 1;

                    } else if (!reponseCourante.equalsIgnoreCase("faux") && estVue == 0) {
                        ((TextView) findViewById(R.id.result)).setText(getResources().getText(R.string.incorrect));
                        nePeutPlusRep = 1;
                    } else {
                        ((TextView) findViewById(R.id.result)).setText(getResources().getText(R.string.reponseDejaVue));
                    }
                }
                else {
                    ((TextView) findViewById(R.id.result)).setText(getResources().getText(R.string.vousAvezDejaRep));
                    //Toast.makeText(this,"Vous Avez déjà vu la reponse",Toast.LENGTH_LONG).show();
                }
                break;
            */
            case R.id.next:
                // A la fin des question, on va dans l'activité qui montre le score final
                if(questionCourante == nombreDeQuestion-1){
                    Intent i = new Intent(MainActivity.this, ScoreFinDePartie.class);
                    i.putExtra("reponseCourante", reponseCourante);
                    startActivityForResult(i, ACTIVITE_REP);
                }
                else {
                    questionCourante++;
                    nePeutPlusRep=0;

                }
                afficheQuestion(questionCourante);
                System.out.println("question " + questionCourante);
                System.out.println("nb " + nombreDeQuestion);
                estVue=0;
                ((TextView) findViewById(R.id.result)).setText(" ");
                break;
        }
    }
}
