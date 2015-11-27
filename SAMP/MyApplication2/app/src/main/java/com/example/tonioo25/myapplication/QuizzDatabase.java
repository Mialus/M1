package com.example.tonioo25.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tonioo25.myapplication.Item.ItemQR;
import com.example.tonioo25.myapplication.Item.ItemSujet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m1acasagr3 on 09/10/15.
 */
public class QuizzDatabase extends SQLiteOpenHelper {
    SQLiteDatabase db;
    Context cont;
    private static final String DATABASE_NAME = "quizz.db";
    private static final int DATABASE_VERSION = 1;

    public static final String QUESTION_KEY = "id";
    public static final String QUESTION_DESC = "Question";
    public static final String REPONSE = "réponse";


    //Base de données qui repertorie les "questions"
       private static final String DATABASE_CREATE = "create table questions "
            + "(_id integer primary key autoincrement, "
            + "question text not null, "
            + "reponse text null, "
            + "sujet integer not null) ;";

    //Base de données qui repertorie les "scores"
    private static final String DATABASE_CREATE4 = "create table scores "
            + "(_id integer primary key autoincrement, "
            + "score text not null, "
            + "sujet integer not null) ;";

    //Base de données qui repertorie les "sujets" ou themes des questions
    private static final String DATABASE_CREATE2 = "create table sujets "
            + "(_id integer primary key autoincrement, "
            + "nom text not null) ;";

    //Base de données qui repertorie les "reponses" des questions
    private static final String DATABASE_CREATE3 = "create table reponses "
            + "(_id integer primary key autoincrement, "
            + "reponse text not null, "
            + "question integer not null) ;";

    public QuizzDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        cont=context;
    }

    public Cursor getCursor() {
        this.db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM questions",null);
    }

    //Création de la base de donnéesS
    @Override
    public void onCreate(SQLiteDatabase database) {
        this.db = database;
        database.execSQL(DATABASE_CREATE) ;
        database.execSQL(DATABASE_CREATE2) ;
        database.execSQL(DATABASE_CREATE3) ;
        database.execSQL(DATABASE_CREATE4) ;

        new Parser(cont,this).execute("https://dept-info.univ-fcomte.fr/joomla/images/CR0700/Quizzs.xml");
        /*db.execSQL("INSERT INTO sujets (nom) VALUES ('Culture Generale')");
        db.execSQL("INSERT INTO sujets (nom) VALUES ('Sport')");
        db.execSQL("INSERT INTO sujets (nom) VALUES ('Histoire')");
        db.execSQL("INSERT INTO sujets (nom) VALUES ('Jeux Videos')");

        //Gestion des questions
            //Culture General
            db.execSQL("INSERT INTO questions (question, reponse, sujet) VALUES ('Le diable de Tasmanie vit dans la jungle du Brésil', 'faux',1)");
            db.execSQL("INSERT INTO questions (question, reponse, sujet) VALUES ('La sauterelle saute l equivalent de 200 fois sa taille', 'vrai',1)");
            db.execSQL("INSERT INTO questions (question, reponse, sujet) VALUES ('Les pandas hibernent.','faux',1)");
            db.execSQL("INSERT INTO questions (question, reponse, sujet) VALUES ('On trouve des dromadaires en liberté en Ausralie.', 'vrai',1)");
            db.execSQL("INSERT INTO questions (question, reponse, sujet) VALUES ('Le papillon monarque vole plus de 4000 km.','vrai',1)");
            db.execSQL("INSERT INTO questions (question, reponse, sujet) VALUES ('Les gorilles mâles dorment dans les arbres', 'faux',1)");

            //Sport
            db.execSQL("INSERT INTO questions (question, reponse, sujet) VALUES ('Zidane a arreté sa carrière internationalle après quelle coupe du monde ?', '2006',2)");
            db.execSQL("INSERT INTO questions (question, reponse, sujet) VALUES ('Qui est le joueur de foot qui a remporté le plus de ballon dor', 'messi',2)");

            //Histoire
            db.execSQL("INSERT INTO questions (question, reponse, sujet) VALUES ('Qui était le roi de France lors de la révolution française ?', 'Louix XVI',3)");
            db.execSQL("INSERT INTO questions (question, reponse, sujet) VALUES ('Qui fut le petit fils de François 1er ?', 'Francois II',3)");
            db.execSQL("INSERT INTO questions (question, reponse, sujet) VALUES ('Date de la prise de la bastille ?','1789',3)");

            //Histoire
            db.execSQL("INSERT INTO questions (question, reponse, sujet) VALUES ('Année de sortie de black ops 3','2015',4)");
            db.execSQL("INSERT INTO questions (question, reponse, sujet) VALUES ('Année de sortie de BO2','2012',4)");

        //// Gestions des themes de reponses
            //culture general
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('faux',1)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('vrai',1)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('je sais pas',1)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('on sen fou',1)");

            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('faux',2)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('vrai',2)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('je sais pas',2)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('on sen fou',2)");

            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('faux',3)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('vrai',3)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('je sais pas',3)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('on sen fou',3)");

            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('faux',4)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('vrai',4)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('je sais pas',4)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('on sen fou',4)");

            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('faux',5)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('vrai',5)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('je sais pas',5)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('on sen fou',5)");

            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('faux',6)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('vrai',6)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('je sais pas',6)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('on sen fou',6)");

            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('Ronaldo',7)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('Pele',7)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('Platini',7)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('Messi',7)");

            //Reponse sport
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('2002',8)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('2006',8)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('2010',8)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('2014',8)");

            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('Ronaldo',9)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('Pele',9)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('Platini',9)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('Messi',9)");

            //Reponse jeux video
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('2012',10)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('2013',10)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('2014',10)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('2015',10)");

            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('2012',11)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('2013',11)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('2014',11)");
            db.execSQL("INSERT INTO reponses (reponse,question) VALUES ('2015',11)");*/



    }


    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        /* Pas pour le moment */
    }

    //Fonction qui permet de rajouter une quesution et sa réponse dans la base de données
    public void insereQuestion (String questionAAjouter, String reponseAAjouter) {
        ContentValues values = new ContentValues();
        values.put("question", questionAAjouter);
        values.put("reponse", reponseAAjouter);
        db.insert("questions", null, values);
    }

    public void chargerLesCategories(ArrayList<ItemSujet> cat) {
        this.db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM sujets",null) ;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String sujets = cursor.getString(1) ;
            cat.add(new ItemSujet(sujets,cursor.getInt(0)));

            if(cursor.getColumnCount()==cursor.getColumnIndex("_id")){
                cursor.moveToFirst();
            }
            cursor.moveToNext();

        }
        cursor.close();
    }

    public void chargerLesScores(ArrayList<ItemSujet> cat,int id) {
        this.db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM scores Where sujet = " + id, null) ;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String sujets = cursor.getString(1) ;
            cat.add(new ItemSujet(sujets,cursor.getInt(0)));

            if(cursor.getColumnCount()==cursor.getColumnIndex("_id")){
                cursor.moveToFirst();
            }
            cursor.moveToNext();

        }
        cursor.close();
    }

    //Fonction qui rajoute un element dans la base de données
    public void chargerLesQuestions(List<ItemQR> lcs) {
        Cursor cursor = this.getCursor() ;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String questions = cursor.getString(1) ;
            String reponse = cursor.getString(2);
            lcs.add(new ItemQR(questions, reponse, null));

            if(cursor.getColumnCount()==cursor.getColumnIndex("_id")){
                cursor.moveToFirst();
            }
            cursor.moveToNext();

        }
        cursor.close();
    }

    //Fonction qui supprime un element dans la base de données
    public void suppDatabase(String question){
        db.delete("questions", "question =?", new String[]{question});
    }

    public ArrayList<String> getReponsebyQuestion(int id){
        this.db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM reponses where question = "+id, null);
        cursor.moveToFirst();
        ArrayList<String> resultat = new ArrayList<>();

        while (!cursor.isAfterLast()) {
            String rep = cursor.getString(1);
            resultat.add(rep);
            cursor.moveToNext();
        }
        cursor.close();
        return resultat;

    }

    public void chargerLesQuestions(ArrayList<ItemQR> listeDesQuestions, int id) {
        this.db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM questions where sujet = "+id, null) ;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String questions = cursor.getString(1) ;
            String reponse = cursor.getString(2);
            ArrayList<String> lesReponses = getReponsebyQuestion(cursor.getInt(0));
            listeDesQuestions.add(new ItemQR(questions, reponse,lesReponses));

            /*if(cursor.getColumnCount()==cursor.getColumnIndex("_id")){
                cursor.moveToFirst();
            }*/
            cursor.moveToNext();

        }
        cursor.close();

    }

    //Fonction qui permet d'ajouter une categorie charger par le fichier xml dans ma base de données
    public int insereSujet(String attributeValue) {
        this.db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nom", attributeValue);
        int id = (int) db.insert("sujets", null,values);

        return id;
    }

    // Focntion qui va ajouter une question lu dans le fichier xml
    public int insertQuestion(String text, int idCategorie) {
        this.db =this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("question", text);
        values.put("sujet", idCategorie);

        int id = (int) db.insert("questions", null,values);

        return id;

    }

    //Fonction qui permet de rajouter un score dans la base de données
    public int insereScore (String scoreAAjouter, int sujet) {
        this.db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("score", scoreAAjouter);
        values.put("sujet", sujet);
        int id = (int) db.insert("scores", null, values);
        return id;
    }

    public int insertReponse(String text, int idQuestion) {
        this.db =this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("reponse", text);
        values.put("question", idQuestion);

        int id = (int) db.insert("reponses", null,values);

        return id;
    }

    public void updateQuestion(int idQuestion, String s) {
        this.db =this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("reponse",s);
        db.update("questions", values, "_id =?", new String[]{"" + idQuestion});

    }

    public String getSujet(int id) {
        this.db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT nom FROM sujets where _id ="+id, null);
        cursor.moveToFirst();
        String rep = cursor.getString(0);
        cursor.close();
        return rep;
    }

    public int getIdSujet(String id) {
        this.db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id FROM sujets where nom = "+id, null);
        cursor.moveToFirst();
        int rep = cursor.getInt(0);
        cursor.close();
        return rep;
    }

    public int getIdQuestion(String ques) {
        this.db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id FROM questions where question LIKE "+ques, null);
        cursor.moveToFirst();
        int rep = Integer.parseInt(cursor.getString(0));
        cursor.close();
        return rep;
    }

    public void supprimeCategorie(String id) {
        db.execSQL("DELETE FROM sujets WHERE nom LIKE '"+id+"'");
    }
}
