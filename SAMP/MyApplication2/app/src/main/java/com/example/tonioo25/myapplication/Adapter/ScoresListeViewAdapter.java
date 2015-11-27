package com.example.tonioo25.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tonioo25.myapplication.Item.ItemSujet;
import com.example.tonioo25.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Pierre on 26/11/2015.
 */
public class ScoresListeViewAdapter extends BaseAdapter {

    private ArrayList<ItemSujet> listeScore;
    private Activity Act;

    public ScoresListeViewAdapter(ArrayList<ItemSujet> listeA, Activity act) {
        listeScore = listeA;
        Act = act;
    }

    @Override
    public int getCount() {
        return listeScore.size();
    }

    @Override
    public Object getItem(int position) {
        return listeScore.get(position);
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
            convertView = inf.inflate(R.layout.one_element_categorie,null);
            vueHolder = new ViewHolder();

            vueHolder.text1 = (TextView) convertView.findViewById(R.id.zoneTexte3);
            convertView.setTag(vueHolder);

        }
        else{
            vueHolder = (ViewHolder)convertView.getTag();
        }
        vueHolder.text1.setText(listeScore.get(position).getSujet());
        return convertView;
    }

    private class ViewHolder{
        TextView text1;


    }
}
