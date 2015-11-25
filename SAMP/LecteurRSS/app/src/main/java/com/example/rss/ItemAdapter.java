package com.example.rss;

import java.util.Date;

import android.content.Context;
import android.database.Cursor;
import android.text.Html;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
 * L'Adapter qui permet de construire la ListView des items d'une channel enregistre dans l'application
 */
public class ItemAdapter extends BaseAdapter{
	private Cursor mCursor;
	private LayoutInflater mInflater;
	private Context mContext;
	
	public ItemAdapter(Context mContext, Cursor mCursor){
		this.mCursor = mCursor;
		mInflater = LayoutInflater.from(mContext);
		this.mContext = mContext;
	}
	
	public int getCount() {
		return mCursor.getCount();
	}

	public Object getItem(int position) {
		return mCursor.moveToPosition(position);
	}

	public long getItemId(int position) {
		mCursor.moveToPosition(position);
		return mCursor.getLong(0);
	}


	public View getView(int position, View convertView, ViewGroup parent) {
	  LinearLayout layoutItem;
	
	  if (convertView == null) {
	    layoutItem = (LinearLayout) mInflater.inflate(R.layout.row_item, parent, false);
	  } else {
	  	layoutItem = (LinearLayout) convertView;
	  }
	
	  mCursor.moveToPosition(position);
	  ((TextView) layoutItem.findViewById(R.id.textViewTitle)).setText(mCursor.getString(2));
	  if(mCursor.getString(3) != null && !mCursor.getString(3).equals("")){
		  ((TextView) layoutItem.findViewById(R.id.textViewDescription)).setText(Html.fromHtml(mCursor.getString(3)));
		  ((TextView) layoutItem.findViewById(R.id.textViewDescription)).setMovementMethod(LinkMovementMethod.getInstance());
		  ((TextView) layoutItem.findViewById(R.id.textViewDescription)).setVisibility(View.VISIBLE);
	  }
	  else{
		  ((TextView) layoutItem.findViewById(R.id.textViewDescription)).setVisibility(View.GONE);
	  }
	  Date date = new Date();
	  date.setTime(mCursor.getLong(4));
	  String sDate;
	  sDate = (String) DateFormat.format("EEEE dd MMMM yyyy hh:mm:ss", date.getTime());

	  ((TextView) layoutItem.findViewById(R.id.textViewDate)).setText(sDate);

	  ((TextView) layoutItem.findViewById(R.id.textViewLink)).setText(Html.fromHtml("<a href="+mCursor.getString(5)+">"+mContext.getString(R.string.click_here)+"</a>"));
	  ((TextView) layoutItem.findViewById(R.id.textViewLink)).setMovementMethod(LinkMovementMethod.getInstance());

	  layoutItem.setTag(mCursor.getString(0));
	
	  return layoutItem;
	}


}
