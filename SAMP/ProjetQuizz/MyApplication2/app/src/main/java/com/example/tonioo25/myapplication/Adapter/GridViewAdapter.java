package com.example.tonioo25.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.tonioo25.myapplication.R;

import java.util.ArrayList;

/**
 * Created by tonioo25 on 09/11/2015.
 */
public class GridViewAdapter extends BaseAdapter{
    private ArrayList<String> listeAdapter;
    private Activity Act;

    public GridViewAdapter(ArrayList<String> listeA, Activity act) {
        listeAdapter = listeA;
        Act = act;
    }

    @Override
    public int getCount() {
        return listeAdapter.size();
    }

    @Override
    public Object getItem(int position) {
        return listeAdapter.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vueHolder = null;

        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) Act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.one_element_gridview,null);
            vueHolder = new ViewHolder();

            //vueHolder.bouton1 = (Button) convertView.findViewById(R.id.repAQuestion);

            convertView.setTag(vueHolder);

        }
        else{
            vueHolder = (ViewHolder)convertView.getTag();
        }
        vueHolder.bouton1.setText(listeAdapter.get(position));
        return convertView;
    }

    private class ViewHolder{
        Button bouton1;

    }
}
