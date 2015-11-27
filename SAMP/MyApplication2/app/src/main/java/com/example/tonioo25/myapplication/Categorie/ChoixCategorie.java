package com.example.tonioo25.myapplication.Categorie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tonioo25.myapplication.Activity.MenuActivity;
import com.example.tonioo25.myapplication.Adapter.SujetListeViewAdapter;
import com.example.tonioo25.myapplication.Activity.MainActivity;
import com.example.tonioo25.myapplication.Item.ItemSujet;
import com.example.tonioo25.myapplication.QuizzDatabase;
import com.example.tonioo25.myapplication.R;
import com.example.tonioo25.myapplication.ScoresActivity;

import java.util.ArrayList;

/**
 * Created by tonioo25 on 21/10/2015.
 */
public class ChoixCategorie extends AppCompatActivity{
    Bundle extra;
    private ListView listeDeCategorie;
    ArrayList<ItemSujet> listeCategorie = new ArrayList<>();
    Context cont;

    //Déclaration de la base
    QuizzDatabase db = new QuizzDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorie_main);
        cont=this;
        extra= getIntent().getExtras();
        listeDeCategorie= (ListView) findViewById(R.id.listeViewCategorie);
        db.chargerLesCategories(listeCategorie);
        SujetListeViewAdapter listeSujet = new SujetListeViewAdapter(listeCategorie,this);
        listeDeCategorie.setAdapter(listeSujet);

        listeDeCategorie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                if (extra.getString("choix").equals("Jouer")) {
                    i = new Intent(ChoixCategorie.this, MainActivity.class);
                } else {
                    i = new Intent(ChoixCategorie.this, ScoresActivity.class);
                }
                i.putExtra("sujetChoisi", listeCategorie.get(position).getId());
                startActivityForResult(i, 1500);

            }
        });

        //Permet de revenir au menu du quizz
        findViewById(R.id.retour).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ChoixCategorie.this, MenuActivity.class);
                finish();
            }
        });

        //Permet de raffraichir l'acticité si la base n'est pas charger
        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent refresh = new Intent(cont, ChoixCategorie.class);
                refresh.putExtra("choix",extra.getString("choix"));
                startActivity(refresh);
                finish();
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        if (requestCode==1500) {
            if (resultCode == 1) {
                setResult(1);
                finish();
            }
        }
    }
}
