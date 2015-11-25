/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univfcomte.comp4.pile;

import fr.univfcomte.comp4.quadruplet.*;
/**
 *
 * @author Pierre
 */
public class Element implements Cloneable{
    protected Object valeur;
    protected Element suivant;  
    
    public Element()
    {
    	this.valeur=null;
    	this.suivant=null;
    }
    
    public Object clone() {
		Element e = null;
		try {
			e = (Element) super.clone();
		} catch(CloneNotSupportedException cnse) {
			cnse.printStackTrace(System.err);
		}
		if(this.valeur instanceof Quad)
		{
			e.valeur = ((Quad)this.valeur).clone();
		}else
		{
			e.valeur = null;
		}
		if(this.suivant != null)
		{
			e.suivant = (Element) this.suivant.clone();
		}else
		{
			e.suivant = null;
		}
		
		return e;
	}
    
    public Object getValeur()
    {
    	return this.valeur;
    }
    
    public Element getSuivant()
    {
    	return this.suivant;
    }
    
    public void setValeur(Object val)
    {
    	this.valeur = val;
    }
    
    public void setSuivant(Element e)
    {
    	this.suivant=e;
    }
    
    public String toString()
    {
    	
    	String s="";
    	if(this.valeur != null)
    	{
    		s+=this.valeur.toString();
    	}
    	if(this.suivant != null)
    	{
    		s+=" -> "+this.suivant.toString();
    	}
    	return s;
    }
}