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
 * Created by Pierre on 12/10/2015.
 */
public class ajoutQuestion extends AppCompatActivity {
    RadioButton btVrai;
    ListView vueQuestion;
    List<String> mesQuestion = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    SQL notesDB ;

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
                mesQuestion.remove(position);
                notesDB.supprimeQuestion(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

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
        /*EditText edt_ajouter = (EditText) findViewById(R.id.commentaireSaisi);
        mesQuestion.add(edt_ajouter.getText().toString());
        notesDB.insereQuestion(edt_ajouter.getText().toString(), "Faux");
        adapter.notifyDataSetChanged();*/
    }
}
