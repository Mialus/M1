package edu.ufc.deptinfo.bt.basededonnes;

import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.database.Cursor;

import java.util.List;

/**
 * Created by Bruno on 30/09/15.
 */
public class NotesDatabase extends SQLiteOpenHelper {
    SQLiteDatabase db;
    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table notes "
            + "(_id integer primary key autoincrement, "
            + "commentaire text not null) ;";

    public NotesDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getCursor() {
        this.db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM notes",null);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        this.db = database;
        database.execSQL(DATABASE_CREATE) ;
        db.execSQL("INSERT INTO notes (commentaire) VALUES ('Mon premier commentaire')");
        db.execSQL("INSERT INTO notes (commentaire) VALUES ('Mondeuxième commentaire')");
        db.execSQL("INSERT INTO notes (commentaire) VALUES ('mon troisième commentaire')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        /* Pas pour le moment */
    }

    public void insereCommentaire (String commentaire) {
        ContentValues values = new ContentValues();
        values.put("commentaire", commentaire);
        db.insert("notes",  null,  values);
    }

    public void chargerLesCommentaires(List<String> lcs) {
        Cursor cursor = this.getCursor() ;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String commentaire = cursor.getString(1) ;
            lcs.add(commentaire);
            cursor.moveToNext();
        }
        cursor.close();
    }
}
