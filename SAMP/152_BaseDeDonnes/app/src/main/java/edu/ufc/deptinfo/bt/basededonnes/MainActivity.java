package edu.ufc.deptinfo.bt.basededonnes;

import android.app.ListActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    ListView vueNotes;
    List<String> mesNotes = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    NotesDatabase notesDB ;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesDB = new NotesDatabase(this);
        notesDB.chargerLesCommentaires(mesNotes);

        vueNotes = (ListView) findViewById(android.R.id.list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mesNotes);
        vueNotes.setAdapter(adapter);
    }

    public void onClickAppuyez(View v) {
        EditText edt_ajouter = (EditText) findViewById(R.id.commentaireSaisi);
        mesNotes.add(edt_ajouter.getText().toString());
        notesDB.insereCommentaire(edt_ajouter.getText().toString());
        adapter.notifyDataSetChanged();
    }
}