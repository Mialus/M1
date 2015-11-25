/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univfcomte.comp4.memoire;

/**
 *
 * @author Pierre
 */

public class Pile{
    Element hautPile;

    public Pile() {
        this.hautPile=null;
    }
    
    public void push(Quad q){
        Element e = new Element();
        e.valeur=q;
        e.suivant=hautPile;
        hautPile=e;
    }
    
    public Quad pop(){
        if(hautPile!=null){
            Element tmp = hautPile;
            hautPile=tmp.suivant;
           return tmp.valeur;  
        }else{
            return null;
        }
    }

    @Override
    public String toString() {
        Element tmp = hautPile;
        String valPile = "";
        while(tmp.valeur!=null){
        
        valPile= valPile + tmp.valeur.toString() + "\n";
        tmp = tmp.suivant;
        };
        return valPile;
    }
    
}
