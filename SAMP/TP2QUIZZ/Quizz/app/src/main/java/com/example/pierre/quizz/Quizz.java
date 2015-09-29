package com.example.pierre.quizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.util.*;

public class Quizz extends AppCompatActivity {
    int it = 0;
    String chaine;
    /*final Boolean[] tab{
        getResources().getBoolean(R.bool.R1)
    };*/
    List<String> ques = new ArrayList<String>();
    List<Boolean> rep = new ArrayList<Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        ques.add(getResources().getString(R.string.Q1));
        ques.add(getResources().getString(R.string.Q2));
        ques.add(getResources().getString(R.string.Q3));
        ques.add(getResources().getString(R.string.Q4));
        ques.add(getResources().getString(R.string.Q5));
        ques.add(getResources().getString(R.string.Q6));

        rep.add(getResources().getBoolean(R.bool.R1));
        rep.add(getResources().getBoolean(R.bool.R2));
        rep.add(getResources().getBoolean(R.bool.R3));
        rep.add(getResources().getBoolean(R.bool.R4));
        rep.add(getResources().getBoolean(R.bool.R5));
        rep.add(getResources().getBoolean(R.bool.R6));


        findViewById (R.id.button).setOnClickListener(new View.OnClickListener() { //Button True
            public void onClick(View v) {
                if (rep.get(it) == true) {
                    chaine = ques.get(it + 1);
                    System.out.println("test");
                    ((TextView) findViewById(R.id.textView)).setText(chaine);
                    it++;
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong ! Try Again :)", Toast.LENGTH_SHORT);
                }
            }
        }) ;
        findViewById (R.id.button2).setOnClickListener(new View.OnClickListener() { //Button False
            public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Wrong ! Try Again :)", Toast.LENGTH_SHORT);
            }
        }) ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quizz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void button (View view){
        Toast.makeText(Quizz.this, "Wrong ! try again !", Toast.LENGTH_SHORT).show();
    }
}
