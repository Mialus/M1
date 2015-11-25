package com.example.tonioo25.myapplication.Item;

import java.util.ArrayList;

/**
 * Created by tonioo25 on 15/10/2015.
 */
//Création de l'oject item pour afficher la question et la reponse dans la page de modif des questions
public class ItemQR {

    String question;
    String bonneReponse;

    ArrayList<String> lesReponsesPossibles = new ArrayList<>();

    public ItemQR(String question, String reponse, ArrayList<String> lep) {
        this.question = question;
        this.bonneReponse = reponse;
        this.lesReponsesPossibles = lep;
    }

    public ArrayList<String> getLesReponsesPossibles() {
        return lesReponsesPossibles;
    }

    public void setLesReponsesPossibles(ArrayList<String> lesReponsesPossibles) {
        this.lesReponsesPossibles = lesReponsesPossibles;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return bonneReponse;
    }

    public void setReponse(String reponse) {
        this.bonneReponse = reponse;
    }
}
