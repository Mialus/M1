/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univfcomte.comp4.pile;
/**
 *
 * @author Pierre
 */
public class Element{
    protected Object valeur;
    protected Element suivant;  
    
    public Element()
    {
    	this.valeur=null;
    	this.suivant=null;
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
    
    public boolean equals(Object o)
    {
    	if(o instanceof Element && o!= null)
    	{
    		Element e = (Element)o;
    		if(this.valeur == null && this.suivant == null)
    		{
    			if(e.valeur != null || e.suivant != null)
    			{
    				return false;
    			}
    		}
    		
    		if(this.valeur == null)
    		{
    			if(e.valeur != null)
    			{
    				return false;
    			}
    		}
    		
    		if(this.suivant == null)
    		{
    			if(e.suivant != null)
    			{
    				return false;
    			}else
    			{
    				return true;
    			}
    		}
    		return (this.valeur.equals(e.valeur) && this.suivant.equals(e.suivant));
    	}else
    	{
    		return false;
    	}
    }
}
