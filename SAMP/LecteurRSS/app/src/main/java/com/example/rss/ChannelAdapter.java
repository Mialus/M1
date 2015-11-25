package com.example.rss;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
 * L'Adapter qui permet de construire la ListView des channels enregistre dans l'application
 */
public class ChannelAdapter extends BaseAdapter{
	private Cursor mCursor;
	private LayoutInflater mInflater;
	private int pId, pTitre;
	
	public ChannelAdapter(Cursor mCursor, Context mContext){
		this.mCursor = mCursor;
		mInflater = LayoutInflater.from(mContext);
		if(mCursor.moveToFirst()){
			pId = mCursor.getColumnIndex("id");
			pTitre = mCursor.getColumnIndex("titre");
		}
	}
	
	public int getCount() {
		return mCursor.getCount();
	}

	public Object getItem(int position) {
		return mCursor.moveToPosition(position);
	}

	public long getItemId(int position) {
		return position;
	}


	public View getView(int position, View convertView, ViewGroup parent) {
	  LinearLayout layoutItem;
	
	  if (convertView == null) {
	    layoutItem = (LinearLayout) mInflater.inflate(R.layout.row_channel, parent, false);
	  } else {
	  	layoutItem = (LinearLayout) convertView;
	  }
	
	  mCursor.moveToPosition(position);
	  ((TextView) layoutItem.findViewById(R.id.textViewTitle)).setText(mCursor.getString(pTitre));
	  ((TextView) layoutItem.findViewById(R.id.textViewNombre)).setText(String.valueOf(DB.getItemsNumber(mCursor.getString(pId))));
	  layoutItem.setTag(mCursor.getString(pId));
	
	  return layoutItem;
	}
}
