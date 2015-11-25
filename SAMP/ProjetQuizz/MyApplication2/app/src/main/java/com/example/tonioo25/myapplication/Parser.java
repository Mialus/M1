package com.example.tonioo25.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import android.widget.Toast;


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
                    if(parser.getName().equalsIgnoreCase("Quizz")){
                        idCategorie=db.insereSujet(parser.getAttributeValue(0));
                    }
                    else if(tag.equalsIgnoreCase("Reponse")){
                        String bonneRep = parser.getAttributeValue(0);
                        db.updateQuestion(idQuestion,listeDesReponses.get(Integer.parseInt(bonneRep)-1));
                        listeDesReponses.clear();
                    }
                    System.out.println(parser.getName());

                }
                else if(type == XmlPullParser.TEXT) {
                    if(tag.equalsIgnoreCase("Question")){
                        idQuestion =db.insertQuestion(parser.getText(),idCategorie);

                    }
                    else if(tag.equalsIgnoreCase("Proposition")){
                        String chaine = parser.getText();


                        //Pour supprimer tabulation et saut de ligne
                        chaine =chaine.replaceAll("\t","");
                        chaine= chaine.replaceAll("\n","");

                        //On verifie ensuite que le texte n'est pas vide
                        if(!chaine.isEmpty()){
                            listeDesReponses.add(chaine);
                            db.insertReponse(chaine,idQuestion);
                        }
                        System.out.println("test4"+chaine);
                    }



                    System.out.println(parser.getText());
                }
                else if(type == XmlPullParser.END_TAG) {
                    if(parser.getName().equalsIgnoreCase("Question")){
                        idQuestion=0;
                    }
                    if(parser.getName().equalsIgnoreCase("Quizz")){
                        idCategorie=0;
                    }
                    System.out.println(parser.getName());
                }
                type = parser.next();
            }



        }catch (Exception e){e.printStackTrace();}
        return null;
    }

}