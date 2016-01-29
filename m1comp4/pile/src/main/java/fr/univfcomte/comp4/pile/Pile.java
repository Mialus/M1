/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univfcomte.comp4.pile;

public class Pile{
    Element hautPile;
    
    public Pile() {
        this.hautPile=null;
    }
    
    //Gestion de la pile
    public void push(Object q){
        Element e = new Element();
        e.valeur=q;
        e.suivant=hautPile;
        hautPile=e;
    }
    
    public Object pop(){
		if(hautPile!=null){
            Element tmp = hautPile;
            hautPile=tmp.suivant;
           return tmp.valeur;  
        }else{
            return null;
        }
    }

    public void swap()
    {
    	if(this != null)
    	{
	    	if(this.hautPile == null)
	    	{
	    		return;
	    	}
	    	Object q1 = this.pop();
	    	if(this.hautPile == null)
	    	{
	    		this.push(q1);
	    		return;
	    	}
	    	Object q2 = this.pop();
	    	this.push(q1);
	    	this.push(q2);
    	}
    }
    
    public Element getHautPile()
    {
        return this.hautPile;
    }
    
    public void setHautPile(Element hp)
    {
    	this.hautPile = hp;
    }
    
    public String toString()
    {
    	String s="";
    	Element tmp = this.hautPile;
    	while(tmp != null)
    	{
    		s+=tmp.getValeur()+"\n";
    		tmp = tmp.getSuivant();
    	}
    	return s;
    }
    
    public boolean equals(Object o)
    {
    	if(o instanceof Pile && o!= null)
    	{
    		Pile p = (Pile)o;
    		if(this.hautPile == null)
    		{
    			if(p.hautPile == null)
    			{
    				return true;
    			}else
    			{
    				return false;
    			}
    		}
    		return this.hautPile.equals(p.hautPile);
    	}else
    	{
    		return false;
    	}
    }
}
