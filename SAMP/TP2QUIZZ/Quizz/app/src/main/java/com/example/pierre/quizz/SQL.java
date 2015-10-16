package com.example.pierre.quizz;

/**
 * Created by Pierre on 12/10/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class SQL extends SQLiteOpenHelper {
    SQLiteDatabase db;
    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table questionQuizz "
            + "(_id integer primary key autoincrement, "
            + "question text not null,"
            + "reponse text not null)  ";

    public SQL(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getCursor() {
        this.db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM questionQuizz",null);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        this.db = database;
        database.execSQL(DATABASE_CREATE) ;
        db.execSQL("INSERT INTO questionQuizz (question,reponse) VALUES ('Le diable de Tasmanie vit dans la jungle du Brésil.','Faux')");
        db.execSQL("INSERT INTO questionQuizz (question,reponse) VALUES ('La sauterelle saute l équivalent de 200 fois sa taille.','Vrai')");
        db.execSQL("INSERT INTO questionQuizz (question,reponse) VALUES ('Les pandas hibernent.','Faux')");
        db.execSQL("INSERT INTO questionQuizz (question,reponse) VALUES ('On trouve des dromadaires en liberté en Australie.','Vrai')");
        db.execSQL("INSERT INTO questionQuizz (question,reponse) VALUES ('Le papillon monarque vole plus de 4000 km.','Vrai')");
        db.execSQL("INSERT INTO questionQuizz (question,reponse) VALUES ('Les gorilles mâles dorment dans les arbres.','Faux')");
    }

    public String getReponse(int it){
        Cursor cu;
        String rep="SELECT reponse FROM questionQuizz WHERE _id =" + it;
        cu=db.rawQuery(rep,null);
        cu.moveToFirst();
        rep=cu.getString(0);
        return rep;
    }
    public int getTaille(){
        Cursor cu;
        int nb;
        String rep="SELECT COUNT(question) FROM questionQuizz";
        cu=db.rawQuery(rep,null);
        cu.moveToFirst();
        nb=cu.getInt(0);
        return nb;

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insereQuestion (String question,String reponse) {
        ContentValues values = new ContentValues();
        values.put("question", question);
        values.put("reponse", reponse);
        db.insert("questionQuizz",  null,  values);
    }

    public void supprimeQuestion (int ques){
        db.execSQL("DELETE FROM questionQuizz WHERE _id ="+ques);
    }

    public void chargerLesQuestions(List<String> lcs) {
        Cursor cursor = this.getCursor() ;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String question = cursor.getString(1) ;
            lcs.add(question);
            cursor.moveToNext();
        }
        cursor.close();
    }
}
