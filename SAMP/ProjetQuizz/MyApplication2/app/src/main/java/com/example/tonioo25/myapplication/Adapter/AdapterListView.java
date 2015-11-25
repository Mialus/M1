package com.example.tonioo25.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tonioo25.myapplication.Item.ItemQR;
import com.example.tonioo25.myapplication.R;

import java.util.ArrayList;

/**
 * Created by tonioo25 on 15/10/2015.
 */
public class AdapterListView extends BaseAdapter{

    private ArrayList<ItemQR> listeAdapter;
    private Activity Act;

    public AdapterListView(ArrayList<ItemQR> listeA, Activity act) {
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
            convertView = inf.inflate(R.layout.one_element_main,null);
            vueHolder = new ViewHolder();

            vueHolder.text1 = (TextView) convertView.findViewById(R.id.zoneTexte1);
            vueHolder.text2 = (TextView) convertView.findViewById(R.id.zoneTexte2);

            convertView.setTag(vueHolder);

        }
        else{
            vueHolder = (ViewHolder)convertView.getTag();
        }
        vueHolder.text1.setText(listeAdapter.get(position).getQuestion());
        vueHolder.text2.setText(listeAdapter.get(position).getReponse());
        return convertView;
    }

    private class ViewHolder{
        TextView text1;
        TextView text2;


    }
}


