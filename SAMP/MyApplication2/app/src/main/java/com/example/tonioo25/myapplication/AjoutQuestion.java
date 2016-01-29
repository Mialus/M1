package com.example.tonioo25.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.tonioo25.myapplication.Adapter.AdapterListView;
import com.example.tonioo25.myapplication.Adapter.QuestionListeViewAdapter;
import com.example.tonioo25.myapplication.Item.ItemQR;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

/**
 * Created by tonioo25 on 14/10/2015.
 */


public class AjoutQuestion extends AppCompatActivity {

    //Création des élémentsS
    private EditText texte;
    int id,it;
    QuestionListeViewAdapter viewQuestion;
    int sujet;
    ArrayList<String> listeRep;
    ArrayList<String> listeCheck;
    Bundle extra;
    Activity act;

    //Déclaration de la base
    QuizzDatabase db = new QuizzDatabase(this);

    //Element xml pour afficher la liste
    private ListView listeQuestion;
    ArrayList<ItemQR> listeDesQuestions = new ArrayList<>();

    //Liste qui contient toutes les questions

    ArrayList<ItemQR> toutesLesQuestions = new ArrayList<>();

    AdapterListView adapVue = new AdapterListView(toutesLesQuestions, this);


    //Details de chaques éléments de la liste
    ArrayAdapter<String> AdapterDB;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajoutquestion_main);

        extra = getIntent().getExtras();
        sujet = extra.getInt("sujetChoisi");

        //On retourne la valeur des élements dans de nouveaux elements crées
        texte = (EditText) findViewById(R.id.texte);

        db.chargerLesQuestions(listeDesQuestions);

        listeQuestion = (ListView) findViewById(R.id.lv_reponses_saisie);
        listeRep = new ArrayList<>();
        listeCheck = new ArrayList<>();
        act = this;
        listeRep.add("");
        viewQuestion = new QuestionListeViewAdapter(listeRep, act,listeCheck);
        listeQuestion.setAdapter(viewQuestion);

        findViewById(R.id.plus).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listeRep.add("");
                QuestionListeViewAdapter viewQuestion = new QuestionListeViewAdapter(listeRep, act, listeCheck);
                listeQuestion.setAdapter(viewQuestion);
            }
        });

        findViewById(R.id.moins).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listeRep.remove("");
                QuestionListeViewAdapter viewQuestion = new QuestionListeViewAdapter(listeRep, act,listeCheck);
                listeQuestion.setAdapter(viewQuestion);
            }
        });

        findViewById(R.id.ajouter).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!texte.getText().toString().isEmpty()) {
                    it=0;
                    id = db.insertQuestion(texte.getText().toString(), sujet);
                    for (int i = 0; i < listeRep.size(); i++) {
                        if(!listeRep.get(i).toString().equals("")) {
                            it++;
                            db.insertReponse(listeRep.get(i).toString(), id);
                            if (listeCheck.get(i).equals("true")) {
                                it++;
                                db.updateQuestion(id, listeRep.get(i).toString());
                            }
                            if (it == i) {
                                AlertDialog.Builder erreur = new AlertDialog.Builder(act);
                                erreur.setTitle("Erreur")
                                        .setMessage("Vous n'avez pas mis de bonne réponse !")
                                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .create()
                                        .show();
                            } else {
                                setResult(0);
                                finish();
                            }
                        }
                    }
                }else{
                    AlertDialog.Builder erreur = new AlertDialog.Builder(act);
                    erreur.setTitle("Erreur")
                        .setMessage("Vous n'avez pas mis de question !")
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create()
                        .show();
                }
            }
        });

        findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(1);
                finish();
            }
        });
                        db.chargerLesQuestions(toutesLesQuestions, sujet);


                        // ATTENTION: This was auto-generated to implement the App Indexing API.
                        // See https://g.co/AppIndexing/AndroidStudio for more information.
                        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
                    }

                    @Override
                    public void onStop() {
                        super.onStop();

                        // ATTENTION: This was auto-generated to implement the App Indexing API.
                        // See https://g.co/AppIndexing/AndroidStudio for more information.
                        Action viewAction = Action.newAction(
                                Action.TYPE_VIEW, // TODO: choose an action type.
                                "AjoutQuestion Page", // TODO: Define a title for the content shown.
                                // TODO: If you have web page content that matches this app activity's content,
                                // make sure this auto-generated web page URL is correct.
                                // Otherwise, set the URL to null.
                                Uri.parse("http://host/path"),
                                // TODO: Make sure this auto-generated app deep link URI is correct.
                                Uri.parse("android-app://com.example.tonioo25.myapplication/http/host/path")
                        );
                        AppIndex.AppIndexApi.end(client, viewAction);
                        client.disconnect();
                    }
                }
