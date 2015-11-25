package com.example.rss;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
/*
 * Activite principal
 */
public class MainActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    @Override
    public void onResume(){
    	super.onResume();
    	
    	if(!DB.isOpen()){
    		DB.open(this);
    	}    	

        Cursor channels = DB.getChannels();
        
        ListView listView = (ListView) findViewById(R.id.listViewChannel);
        ChannelAdapter adapter = new ChannelAdapter(channels, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					Intent intent = new Intent(MainActivity.this, ItemActivity.class);
					intent.putExtra("channelId", (String) view.getTag());
					startActivity(intent);
			}});
    }
    
    @Override
    public void onDestroy(){
    	super.onDestroy();
    	DB.close();
    	
    }
        
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item_add_rss:
            	final EditText et = new EditText(this);
            	et.setInputType(InputType.TYPE_TEXT_VARIATION_URI);
            	et.setText("http://www.lemonde.fr/rss/une.xml");
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.choix_adresse)
                       .setCancelable(false)
                       .setView(et)
                       .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int id) {
                        	   new AddChannel(MainActivity.this).execute(et.getText().toString());		                             
                           }
                       })
                       .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                           }
                       });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
            case R.id.item_add_lemonde :
            	new AddChannel(MainActivity.this).execute("http://www.lemonde.fr/rss/tag/enseignement-superieur.xml");
            	return true;
            case R.id.item_add_usgs :
            		new AddChannel(MainActivity.this).execute("http://earthquake.usgs.gov/earthquakes/catalogs/eqs1day-M2.5.xml");
            	return true;
            case R.id.item_add_programmez :
        		new AddChannel(MainActivity.this).execute("http://www.programmez.com/rss/rss_actu.php");
        	return true;
            case R.id.item_refresh_all :
        		new AddChannel(MainActivity.this).execute(DB.getChannelsURL());
        	return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    
}
