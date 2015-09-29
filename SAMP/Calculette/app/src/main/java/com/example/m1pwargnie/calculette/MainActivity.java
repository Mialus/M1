package com.example.m1pwargnie.calculette;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.m1pwargnie.calculette.CalcApp;

public class MainActivity extends AppCompatActivity {

    CalcApp cal = new com.example.m1pwargnie.calculette.CalcApp(this);
    String chaine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById (R.id.button14)).setOnClickListener(new View.OnClickListener() { // Bouton 0
            public void onClick(View v) {

                chaine = MainActivity.this.cal.chiffre("0");
                ((TextView) findViewById(R.id.textView)).setText(chaine);
            }
        }) ;

        ((Button)findViewById (R.id.button9)).setOnClickListener(new View.OnClickListener() { // Bouton 1
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 1);
            }
        }) ;

        ((Button)findViewById (R.id.button10)).setOnClickListener(new View.OnClickListener() { // Bouton 2
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 2);
            }
        }) ;

        ((Button)findViewById (R.id.button11)).setOnClickListener(new View.OnClickListener() { // Bouton 3
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 3);
            }
        }) ;

        ((Button)findViewById (R.id.button5)).setOnClickListener(new View.OnClickListener() { // Bouton 4
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 4);
            }
        }) ;

        ((Button)findViewById (R.id.button6)).setOnClickListener(new View.OnClickListener() { // Bouton 5
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 5);
            }
        }) ;

        ((Button)findViewById (R.id.button7)).setOnClickListener(new View.OnClickListener() { // Bouton 6
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 6);
            }
        }) ;

        ((Button)findViewById (R.id.button)).setOnClickListener(new View.OnClickListener() { // Bouton 7
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 7);
            }
        }) ;

        ((Button)findViewById (R.id.button2)).setOnClickListener(new View.OnClickListener() { // Bouton 8
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 8);
            }
        }) ;

        ((Button)findViewById (R.id.button3)).setOnClickListener(new View.OnClickListener() { // Bouton 9
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 9);
            }
        }) ;

        ((Button)findViewById (R.id.button4)).setOnClickListener(new View.OnClickListener() { // Bouton +
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 0);
            }
        }) ;

        ((Button)findViewById (R.id.button8)).setOnClickListener(new View.OnClickListener() { // Bouton -
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 0);
            }
        }) ;

        ((Button)findViewById (R.id.button12)).setOnClickListener(new View.OnClickListener() { // Bouton *
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 0);
            }
        }) ;

        ((Button)findViewById (R.id.button16)).setOnClickListener(new View.OnClickListener() { // Bouton /
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 0);
            }
        }) ;

        ((Button)findViewById (R.id.button13)).setOnClickListener(new View.OnClickListener() { // Bouton .
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 0);
            }
        }) ;

        ((Button)findViewById (R.id.button15)).setOnClickListener(new View.OnClickListener() { // Bouton =
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView)).setText("" + 0);
            }
        }) ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /**
     * Created by m1pwargnie on 16/09/15.
     */
}
