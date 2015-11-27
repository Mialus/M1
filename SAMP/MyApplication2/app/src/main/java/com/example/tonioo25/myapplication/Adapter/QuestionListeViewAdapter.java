package com.example.tonioo25.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import com.example.tonioo25.myapplication.R;


import java.util.ArrayList;

/**
 * Created by tonioo25 on 16/11/2015.
 */
public class QuestionListeViewAdapter extends BaseAdapter {

    ArrayList <String> listeQuestion = new ArrayList<>();
    private Activity Act;
    private ArrayList<String> listeCheck = new ArrayList<>();

    public QuestionListeViewAdapter(ArrayList<String> listeA, Activity act,ArrayList<String> listeC) {
        listeQuestion = listeA;
        Act = act;
        listeCheck = listeC;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listeQuestion.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return listeQuestion.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //ViewHolder holder = null;
        final ViewHolder holder;
        if (convertView == null) {

            holder = new ViewHolder();
            LayoutInflater inf = (LayoutInflater) Act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.one_element_edittext, null);
            holder.editText1 = (EditText) convertView.findViewById(R.id.lv_reponses_editText1);
            holder.reponse = (CheckBox) convertView.findViewById (R.id.checkButton);
            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }
        listeCheck.add("false");
        holder.ref = position;

        holder.editText1.setText(listeQuestion.get(position));

        holder.reponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                listeCheck.set(holder.ref, java.lang.Boolean.toString(cb.isChecked()));
            }
        });

        holder.editText1.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                listeQuestion.set(holder.ref, arg0.toString());
            }
        });

        return convertView;
    }

    private class ViewHolder {
        EditText editText1;
        CheckBox reponse;
        int ref;
    }

    public String getCheck(int position)
    {
        String ret = listeCheck.get(position);
        return ret;
    }
}
