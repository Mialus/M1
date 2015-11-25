package com.example.tonioo25.myapplication.Categorie;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;

import com.example.tonioo25.myapplication.Activity.MainActivity;
import com.example.tonioo25.myapplication.Adapter.SujetListeViewAdapter;
import com.example.tonioo25.myapplication.Item.ItemSujet;
import com.example.tonioo25.myapplication.QuestionActivity;
import com.example.tonioo25.myapplication.QuizzDatabase;
import com.example.tonioo25.myapplication.R;

import java.util.ArrayList;

/**
 * Created by tonioo25 on 21/10/2015.
 */
public class ModifCategorie extends AppCompatActivity{

    private ListView listeDeCategorie;
    ArrayList<ItemSujet> listeCategorie = new ArrayList<>();

    //Déclaration de la base
    QuizzDatabase db = new QuizzDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.modif_categorie);



        listeDeCategorie= (ListView) findViewById(R.id.listeViewCategorie);
        db.chargerLesCategories(listeCategorie);
        SujetListeViewAdapter listeSujet = new SujetListeViewAdapter(listeCategorie,this);
        listeDeCategorie.setAdapter(listeSujet);

        listeDeCategorie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ModifCategorie.this, QuestionActivity.class);
                i.putExtra("sujetChoisi", listeCategorie.get(position).getId());
                startActivity(i);

            }
        });
    }
}