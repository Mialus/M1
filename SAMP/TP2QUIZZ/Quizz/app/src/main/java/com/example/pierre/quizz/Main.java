package com.example.pierre.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Pierre
 */

//Main activity
public class Main extends AppCompatActivity {
    Bundle extra;
    SQL notesDB ;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        extra= getIntent().getExtras();

        ((Button)findViewById (R.id.button)).setOnClickListener(new View.OnClickListener() { //Button Quizz
            public void onClick(View v) {

                Intent i = new Intent(Main.this, Quizz.class);
                startActivity(i);
            }
        }) ;

        ((Button)findViewById (R.id.button2)).setOnClickListener(new View.OnClickListener() { //Button ajout question
            public void onClick(View v) {

                Intent i = new Intent(Main.this, ajoutQuestion.class);
                startActivity(i);
            }
        }) ;
    }
    /**
     * Called when you want to go to setting but setting isn't implemented
     */
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

}
