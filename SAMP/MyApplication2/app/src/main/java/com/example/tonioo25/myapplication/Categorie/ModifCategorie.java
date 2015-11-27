package com.example.tonioo25.myapplication.Categorie;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tonioo25.myapplication.Adapter.SujetListeViewAdapter;
import com.example.tonioo25.myapplication.Item.ItemSujet;
import com.example.tonioo25.myapplication.QuestionActivity;
import com.example.tonioo25.myapplication.QuizzDatabase;
import com.example.tonioo25.myapplication.R;

import java.util.ArrayList;

import static android.widget.Toast.makeText;

/**
 * Created by tonioo25 on 21/10/2015.
 */
public class ModifCategorie extends AppCompatActivity{

    private ListView listeDeCategorie;
    ArrayList<ItemSujet> listeCategorie = new ArrayList<>();
    SujetListeViewAdapter listeSujet;
    Activity act;
    //Déclaration de la base
    QuizzDatabase db = new QuizzDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();
        act=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modif_categorie);



        listeDeCategorie= (ListView) findViewById(R.id.listeViewCategorie);
        db.chargerLesCategories(listeCategorie);
        listeSujet = new SujetListeViewAdapter(listeCategorie,this);
        listeDeCategorie.setAdapter(listeSujet);

        ((Button) findViewById(R.id.ajoutQuestion)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText edt_ajouter = (EditText) findViewById(R.id.texte254);
                if(!edt_ajouter.getText().toString().isEmpty()) {
                    db.insereSujet(edt_ajouter.getText().toString());
                    listeCategorie.clear();
                    db.chargerLesCategories(listeCategorie);
                    listeSujet.notifyDataSetChanged();
                }else{
                    AlertDialog.Builder erreur = new AlertDialog.Builder(act);
                    erreur.setTitle("Erreur")
                            .setMessage("Vous n'avez pas mis de Catégorie !")
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

                        listeDeCategorie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent i = new Intent(ModifCategorie.this, QuestionActivity.class);
                                i.putExtra("sujetChoisi", listeCategorie.get(position).getId());
                                startActivityForResult(i, 2000);

                            }
                        });
        listeDeCategorie.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                db.supprimeCategorie(listeCategorie.get(position).getSujet());
                listeCategorie.clear();
                db.chargerLesCategories(listeCategorie);
                listeSujet.notifyDataSetChanged();
                return false;
            }
        });
                    }

    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        if (requestCode==2000) {
            if (resultCode == 1) {
                setResult(1);
                finish();
            }
        }
    }
}