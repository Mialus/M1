package com.example.tonioo25.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.example.tonioo25.myapplication.Adapter.ScoresListeViewAdapter;
import com.example.tonioo25.myapplication.Item.ItemSujet;

import java.util.ArrayList;

/**
 * Created by tonioo25 on 21/10/2015.
 */
public class ScoresActivity extends AppCompatActivity {

    //Déclaration des variables
    private ListView listeDeScore;
    ArrayList<ItemSujet> listeScore = new ArrayList<>();
    Bundle recup;

    //Création de la base de données
    QuizzDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores_main);

        recup = getIntent().getExtras();
        int id = recup.getInt("sujetChoisi");
        //Gestion de la base de données et du cuseur pour la parcourir
        db = new QuizzDatabase(this);
        ((TextView) findViewById(R.id.titreScore)).setText("Voici votre score pour le quizz "+db.getSujet(id));

        listeDeScore = (ListView) findViewById(R.id.liste_score);
        db.chargerLesScores(listeScore,id);

        ScoresListeViewAdapter viewScores = new ScoresListeViewAdapter(listeScore, this);
        listeDeScore.setAdapter(viewScores);

        findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(1);
                finish();
            }

        });
    }

}
