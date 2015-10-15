package com.example.pierre.quizz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre on 12/10/2015.
 */
public class ajoutQuestion extends AppCompatActivity {

    ListView vueQuestion;
    List<String> mesQuestion = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    SQL notesDB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        notesDB = new SQL(this);
        notesDB.chargerLesQuestions(mesQuestion);

        vueQuestion= (ListView) findViewById(android.R.id.list);
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, mesQuestion);
        vueQuestion.setAdapter(adapter);

    }
    public void onClickAppuyez(View v) {
        EditText edt_ajouter = (EditText) findViewById(R.id.commentaireSaisi);
        mesQuestion.add(edt_ajouter.getText().toString());
        notesDB.insereQuestion(edt_ajouter.getText().toString(),"réponse");
        adapter.notifyDataSetChanged();
    }
}
