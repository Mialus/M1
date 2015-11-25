package com.example.tonioo25.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.tonioo25.myapplication.Adapter.AdapterListView;
import com.example.tonioo25.myapplication.Adapter.QuestionListeViewAdapter;
import com.example.tonioo25.myapplication.Item.ItemQR;

import java.util.ArrayList;

/**
 * Created by tonioo25 on 14/10/2015.
 */


public class AjoutQuestion extends AppCompatActivity{

    //Création des élémentsS
    private Button boutonValider;
    private RadioButton boutonVrai;
    private RadioButton boutonFaux;
    private EditText texte;
    Bundle extra;

    //Déclaration de la base
    QuizzDatabase db = new QuizzDatabase(this);

    //Element xml pour afficher la liste
    private ListView listeQuestion;
    ArrayList <ItemQR> listeDesQuestions = new ArrayList<>();

    //private itemQR qr = new itemQR();
    //HashMap<String,String> toutesLesQuestions = new HashMap<>();

    //Liste qui contient toutes les questions
    //ArrayList<String> toutesLesQuestions = new ArrayList<>();
    ArrayList<ItemQR> toutesLesQuestions = new ArrayList<>();

    AdapterListView adapVue = new AdapterListView(toutesLesQuestions, this);


    //Details de chaques éléments de la liste
    ArrayAdapter<String> AdapterDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajoutquestion_main);

        Intent i = getIntent();
        int idSujet = i.getIntExtra("sujetChoisi", 1);

        //Déclaration de l'Adapteur
        //AdapterDB = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,toutesLesQuestions);

        //On retourne la valeur des élements dans de nouveaux elements crées
        boutonValider = (Button) findViewById(R.id.ajoutQuestion);
        texte = (EditText) findViewById(R.id.texte);

        db.chargerLesQuestions(listeDesQuestions);
        //Lorsque que l'on clique sur valider, on ajoute la question à la base de données
        findViewById(R.id.ajouter).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String questionAAjouter = texte.getText().toString();
                String reponseAAjouter = "vrai";
                if (boutonVrai.isChecked()) {
                    reponseAAjouter = "vrai";
                } else {
                    reponseAAjouter = "faux";
                }

                //On ajoute dans la base de données la question et sa reponse avec
                db.insereQuestion(questionAAjouter, reponseAAjouter);
                toutesLesQuestions.add(new ItemQR(questionAAjouter, reponseAAjouter, null));
            }

        });


        listeQuestion = (ListView) findViewById(R.id.lv_reponses_saisie);
        ArrayList<String> listeRep = new ArrayList<>();
        listeRep.add("");
        listeRep.add("");
        listeRep.add("");
        listeRep.add("");

        QuestionListeViewAdapter viewQuestion = new QuestionListeViewAdapter(listeRep, this);
        listeQuestion.setAdapter(viewQuestion);


        db.chargerLesQuestions(toutesLesQuestions, idSujet);


    }

}
