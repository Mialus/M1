package fr.univfcomte.comp4.compilateur;

import java.util.ArrayList;

public class Paire {
    private String instructions;
    private int adresse;
    
    public Paire()
    {
    	this(0);
    	
    }
    public Paire(int ad)
    {
    	this.adresse = ad;
    	this.instructions = "";
    }
    
    public Paire(String str, int ad)
    {
    	this.adresse = ad;
    	this.instructions = "";
    	this.add(str);
    }
    
    public void setAdresse(int ad)
    {
    	this.adresse = ad;
    }
    
    public void incAdresse(int nb)
    {
    	this.adresse += nb;
    }
    
    
    public int getAdresse()
    {
    	return this.adresse;
    }
    
    public String getInstructions()
    {
    	return this.instructions;
    }
    
    
    public void add(String str)
    {
    	this.instructions+=str;
    }
    
    public void add(ArrayList<String> instrs)
    {
    	if(!instrs.isEmpty())
    	{
            for(String str : instrs)
            {
    		this.add(str);
            }
    	}
    }
    
    
}
