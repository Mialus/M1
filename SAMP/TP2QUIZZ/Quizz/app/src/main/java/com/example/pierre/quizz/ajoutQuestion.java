package com.example.pierre.quizz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre
 */

public class ajoutQuestion extends AppCompatActivity {
    RadioButton btVrai;
    String chaine;
    ListView vueQuestion;
    List<String> mesQuestion = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    SQL notesDB ;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        btVrai = (RadioButton) findViewById(R.id.radioButton);
        notesDB = new SQL(this);
        notesDB.chargerLesQuestions(mesQuestion);

        vueQuestion= (ListView) findViewById(android.R.id.list);
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, mesQuestion);
        vueQuestion.setAdapter(adapter);

        vueQuestion.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                chaine=mesQuestion.get(position);
                mesQuestion.remove(position);
                notesDB.supprimeQuestion(chaine);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
    //called when you push the button
    public void onClickAppuyez(View v) {

        if(btVrai.isChecked()){
            EditText edt_ajouter = (EditText) findViewById(R.id.commentaireSaisi);
            mesQuestion.add(edt_ajouter.getText().toString());
            notesDB.insereQuestion(edt_ajouter.getText().toString(), "Vrai");
            adapter.notifyDataSetChanged();
        }else{
            EditText edt_ajouter = (EditText) findViewById(R.id.commentaireSaisi);
            mesQuestion.add(edt_ajouter.getText().toString());
            notesDB.insereQuestion(edt_ajouter.getText().toString(), "Faux");
            adapter.notifyDataSetChanged();
        }
    }
}
