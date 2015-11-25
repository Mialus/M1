package com.example.rss;

import java.text.DateFormat;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/*
 * L'activite de la channel, la oo les items sont affiches
 */
public class ItemActivity extends Activity{
	private String channelId;
	ImageView imageView;
	
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_item);
	    
	    channelId = getIntent().getStringExtra("channelId");
	    
	    imageView = (ImageView) findViewById(R.id.imageViewChannel);
	    imageView.setVisibility(View.GONE);
	    
	 }
	 
	 @Override
	 public void onResume(){
		 super.onResume();
		 
		 Cursor info = DB.getChannel(channelId);
		 info.moveToFirst();
		 
		 byte[] blobImage = info.getBlob(5);
		 if(blobImage != null){
			 imageView.setImageBitmap(BitmapFactory.decodeByteArray( blobImage,0,blobImage.length));
			 imageView.setVisibility(View.VISIBLE);
		 }
		    
		 info.moveToFirst();
		 Date date = new Date();
		 date.setTime(info.getLong(3));
		 String sDate = DateFormat.getDateInstance().format(date);
		 
		 ((TextView) findViewById(R.id.textViewTitle)).setText(info.getString(1));
		 ((TextView) findViewById(R.id.textViewLink)).setText(info.getString(4));
		 ((TextView) findViewById(R.id.textViewDescription)).setText(info.getString(2));
		 ((TextView) findViewById(R.id.textViewDate)).setText(sDate);
		 
		 ListView listView = (ListView) findViewById(R.id.listViewItem);
		 ItemAdapter adapter = new ItemAdapter(this, DB.getItems(channelId));
		 listView.setAdapter(adapter);
	 }
	 
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.menu_item, menu);
	        return true;
	    }
	    
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	            case R.id.item_delete_rss:
	            	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	                builder.setTitle(R.string.delete_rss)
	                	   .setMessage(R.string.delete_rss_sure)
	                       .setCancelable(false)
	                       .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
	                           public void onClick(DialogInterface dialog, int id) {
	                        	    DB.deleteChannel(channelId);   
	                        	    finish();
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
	            case R.id.item_update_rss:
	            	new AddChannel(this).execute(channelId);
	                return true;
	            default:
	                return super.onOptionsItemSelected(item);
	        }
	    }
}
