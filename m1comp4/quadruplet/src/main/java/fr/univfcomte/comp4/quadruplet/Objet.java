/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univfcomte.comp4.quadruplet;

/**
 *
 * @author Pierre
 */
public abstract class Objet{
    protected String obj;

    public String getObj() {
        return obj;
    }
    
    public boolean equals(Object o)
    {
    	if(o instanceof Objet && o!= null)
    	{
    		return (this.obj).equals(((Objet) o).obj);
    	}else
    	{
    		return false;
    	}
    	
    }
    
    public String toString()
    {
    	return this.obj;
    }
}
