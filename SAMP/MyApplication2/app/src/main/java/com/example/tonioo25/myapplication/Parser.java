package com.example.tonioo25.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import java.net.URL;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Xml;


/**
 * Created by tonioo25 on 09/11/2015.
 */
public class Parser extends AsyncTask<String, Integer, Long> {

    Context context;
    QuizzDatabase db;

    public Parser(Context context, QuizzDatabase db) {
        this.context = context;
        this.db = db;
    }

    // On parcours tout le fichier le fichier xml et on verifie si c'est un tag ou non, puis on recupère la valeur et on l'affiche
    @Override
    protected Long doInBackground(String... params) {
        try {
            int test=0;
            URL url = new URL(params[0]);
            XmlPullParserFactory xml = XmlPullParserFactory.newInstance();
            xml.setNamespaceAware(true);
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(url.openStream(),"utf-8");

            int type = parser.getEventType();
            String tag = "null";
            int idQuestion=0;
            int idCategorie=0;

            //Liste de toutes les reponses
            ArrayList<String> listeDesReponses = new ArrayList<>();

            while(type != XmlPullParser.END_DOCUMENT){
                if(type == XmlPullParser.START_TAG){

                    tag = parser.getName();
                    if(parser.getName().equalsIgnoreCase("Quizz")){ //
                        idCategorie=db.insereSujet(parser.getAttributeValue(0));
                    }
                    else if(tag.equalsIgnoreCase("Reponse")){
                        if(test==0) {
                            String bonneRep = parser.getAttributeValue(0);
                            db.updateQuestion(idQuestion, listeDesReponses.get(Integer.parseInt(bonneRep) - 1));
                            listeDesReponses.clear();
                        }
                    }

                }
                else if(type == XmlPullParser.TEXT) {
                    if(tag.equalsIgnoreCase("Question")){
                        //if(db.notExisteQ(parser.getText(),idCategorie)) {
                            idQuestion = db.insertQuestion(parser.getText(), idCategorie);
                        //}else{
                           // test=1;
                        //}

                    }
                    else if(tag.equalsIgnoreCase("Proposition")){
                        if(test==0) {
                            String chaine = parser.getText();


                            //Pour supprimer tabulation et saut de ligne
                            chaine = chaine.replaceAll("\t", "");
                            chaine = chaine.replaceAll("\n", "");

                            //On verifie ensuite que le texte n'est pas vide
                            if (!chaine.isEmpty()) {
                                listeDesReponses.add(chaine);
                                db.insertReponse(chaine, idQuestion);
                            }
                        }
                    }


                }
                else if(type == XmlPullParser.END_TAG) {
                    if(parser.getName().equalsIgnoreCase("Question")){
                        idQuestion=0;
                        test=0;
                    }
                    if(parser.getName().equalsIgnoreCase("Quizz")){
                        idCategorie=0;
                    }
                }
                type = parser.next();
            }



        }catch (Exception e){e.printStackTrace();}
        return null;
    }

}