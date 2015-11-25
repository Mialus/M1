package com.example.tonioo25.myapplication.Item;

/**
 * Created by tonioo25 on 10/11/2015.
 */
public class ItemSujet {
    String sujet;
    int id;

    public ItemSujet(String sujet, int id) {
        this.sujet = sujet;
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
