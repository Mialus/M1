package com.example.tonioo25.myapplication.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.tonioo25.myapplication.Categorie.ChoixCategorie;
import com.example.tonioo25.myapplication.Categorie.ModifCategorie;
import com.example.tonioo25.myapplication.Parser;
import com.example.tonioo25.myapplication.QuestionActivity;
import com.example.tonioo25.myapplication.QuizzDatabase;
import com.example.tonioo25.myapplication.R;
import com.example.tonioo25.myapplication.ScoresActivity;

/**
 * Created by tonioo25 on 14/10/2015.
 */
public class MenuActivity extends AppCompatActivity {
    QuizzDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);

        //Permet de jouer au quizz, change d'activité, nous envoie vers MainActivity
        findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ChoixCategorie.class);
                i.putExtra("choix", "Jouer");
                startActivity(i);
            }
        });

        findViewById(R.id.scores).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ChoixCategorie.class);
                i.putExtra("choix", "Score");
                startActivity(i);
            }
        });

        findViewById(R.id.quitter).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.exit(0);
            }
        });

        //Permet de mofidier le quizz (les catégories et les questions associés à ces catégories)
        findViewById(R.id.categorie).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ModifCategorie.class);
                startActivity(i);
            }
        });
        db=new QuizzDatabase(this);
    }


}
