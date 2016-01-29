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
import com.example.tonioo25.myapplication.Item.ItemQR;

import java.util.ArrayList;

/**
 * Created by tonioo25 on 14/10/2015.
 */


public class QuestionActivity extends AppCompatActivity{

    //Recharge l'affichage de la base de données dans la listeView
    public void reloadDB(){
        adapVue.notifyDataSetChanged();
    }

    //Création des éléments
    int idSujet;
    private EditText texte;

    //Déclaration de la base
    QuizzDatabase db = new QuizzDatabase(this);

    //Element xml pour afficher la liste
    private ListView listeQuestion;
    ArrayList <ItemQR> listeDesQuestions = new ArrayList<>();

    //Liste qui contient toutes les questions
    ArrayList<ItemQR> toutesLesQuestions = new ArrayList<>();

    AdapterListView adapVue = new AdapterListView(toutesLesQuestions, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_main);

        Intent i = getIntent();
        idSujet = i.getIntExtra("sujetChoisi",1);

        //On retourne la valeur des élements dans de nouveaux elements crées
        texte = (EditText)findViewById(R.id.texte);

        db.chargerLesQuestions(listeDesQuestions);

        listeQuestion = (ListView) findViewById(R.id.listeViewQuestion);
        db.chargerLesQuestions(toutesLesQuestions, idSujet);

        //Permet de parcourir la liste précisément (une par une) de mes questions et de les afficher
        listeQuestion.setAdapter(adapVue);

        listeQuestion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                db.suppDatabase(toutesLesQuestions.get(position).getQuestion());
                toutesLesQuestions.remove(position);
                reloadDB();
            }
        });

        findViewById(R.id.ajoutQuestion).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(QuestionActivity.this, AjoutQuestion.class);
                i.putExtra("sujetChoisi", idSujet);
                startActivityForResult(i,2000);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        if (requestCode==2000) {
            toutesLesQuestions.clear();
            db.chargerLesQuestions(toutesLesQuestions, idSujet);
            reloadDB();
            if (resultCode == 1) {
                setResult(1);
                finish();
            }
        }
    }
}