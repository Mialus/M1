package fr.univfcomte.comp4.memoire;

import fr.univfcomte.comp4.pile.*;
import fr.univfcomte.comp4.quadruplet.Objet;
import fr.univfcomte.comp4.quadruplet.ObjetConstante;
import fr.univfcomte.comp4.quadruplet.ObjetMethode;
import fr.univfcomte.comp4.quadruplet.ObjetOmega;
import fr.univfcomte.comp4.quadruplet.ObjetTab;
import fr.univfcomte.comp4.quadruplet.ObjetVariable;
import fr.univfcomte.comp4.quadruplet.ObjetVconstante;
import fr.univfcomte.comp4.quadruplet.Quad;
import fr.univfcomte.comp4.quadruplet.SortOmega;
import fr.univfcomte.comp4.quadruplet.Sorte;
import fr.univfcomte.comp4.quadruplet.Valeur;
import fr.univfcomte.comp4.quadruplet.ValeurOmega;
import fr.univfcomte.comp4.quadruplet.ValeurTab;
import fr.univfcomte.comp4.tas.*;

public class Memoire {

	private Pile pile;
	private Tas tas;
	private int nbInstructions;
	
	public Memoire(int nbInstrs)
	{
		try {
			pile = new Pile();
			tas = new Tas();
			this.nbInstructions = nbInstrs;
		} catch (Exception e) {
			System.err.println("Memoire constructor : " +e.getMessage());
		}
	}
	
	public Memoire(int nbInstrs, int taille) throws Exception
	{
		pile = new Pile();
		tas = new Tas(taille);
		this.nbInstructions = nbInstrs;
	}
	
	public int getNbInstructions()
	{
		return this.nbInstructions;
	}
	
	public void empiler(Quad q)
	{
		this.pile.push(q);
	}
	
	public Quad depiler()
	{
		return (Quad)this.pile.pop();
	}
	
	public void echanger()
	{
		this.pile.swap();
	}
	
	public Element getElement(String id)
	{
		Element tmp = this.pile.getHautPile();
    	String idHP = "null";
    	while(tmp != null && !idHP.equals(id))
    	{
    		idHP = ((Quad)tmp.getValeur()).getId();
    		if(!idHP.equals(id))
    		{
    			tmp = tmp.getSuivant();
    		}
    	}
    	
    	return tmp;
	}
	
	public void declVar(String id, Valeur v, Sorte t)
    {
    	this.pile.push(new Quad(id,v, new ObjetVariable(),t));	
    }
	    
    public void identVal(String id, Sorte t, int s)
    {
    	Element tmp = this.pile.getHautPile();
    	while(tmp != null && s > 0)
    	{
    		tmp = tmp.getSuivant();
    		s--;
    	}
    	
    	if(tmp == null)
    	{
    		return;
    	}
    	
    	if(s == 0)
    	{
    		Quad q =(Quad) tmp.getValeur();
    		q.setId(id);
    		q.setType(t);
    		q.setObj(new ObjetVariable());
    	}
    }

    public void declCst(String id, Valeur v, Sorte t)
    {
    	if(v instanceof ValeurOmega)
    	{
    		
    		this.pile.push(new Quad(id,v,new ObjetVconstante(),t));
    	}else
    	{
    		this.pile.push(new Quad(id,v,new ObjetConstante(),t));
    	}		
    }
    
    public void declTab(String id, Valeur v, Sorte t) throws Exception
    {
	    		ValeurTab val = tas.creerTas(v, t, id);
	    		this.pile.push(new Quad(id,val,new ObjetTab(),t));	
    }
    
    public void declMeth(String id, Valeur v, Sorte t)
    {
    	this.pile.push(new Quad(id,v,new ObjetMethode(),t));
    }
    
    public void retirerDecl(String id) throws Exception
    {
    	if(this.pile.getHautPile() == null)
    	{
    		return;
    	}
    	
    	if(((Quad)this.pile.getHautPile().getValeur()).getId().equals(id))
    	{
    		Quad q =(Quad) this.pile.pop();
    		if(q.getObj() instanceof ObjetTab)
    		{
    			this.retirerTas((ValeurTab)q.getVal());
    		}
    	}else
    	{
    		Quad q = (Quad) this.pile.pop();
    		this.retirerDecl(id);
    		this.pile.push(q);
    		
    	}
    }
    
    public void retirerTas(ValeurTab tab) throws Exception
    {
			tas.retirerTas(tab);
    }
    
    public void affecterVariableClasse(Valeur v)
    {
    	
    	if(this.pile.getHautPile() == null)
    	{
    		return;
    	}
    	Element tmp =this.pile.getHautPile();
    	while(tmp.getSuivant() != null)
    	{
    		tmp = tmp.getSuivant();
    	}
    	
    	((Quad)tmp.getValeur()).setVal(v);
    }
    
    public Valeur variableClasse()
    {
    	if(this.pile.getHautPile() == null)
    	{
    		
    		return new ValeurOmega();
    	}

    	Element tmp = this.pile.getHautPile();
    	while(tmp.getSuivant() != null)
    	{
    		tmp = tmp.getSuivant();
    	}
    	
    	return ((Quad)tmp.getValeur()).getVal();
    }
    
    public void affecterVal(String id, Valeur v) throws Exception
    {
    	Element tmp = this.getElement(id);
    	
    	if(tmp == null)
    	{
    		return;
    	}
    	
		if(((Quad)tmp.getValeur()).getObj() instanceof ObjetVconstante)
		{
			((Quad)tmp.getValeur()).setVal(v);
			((Quad)tmp.getValeur()).setObj(new ObjetConstante());
		}else
		{
			if(((Quad)tmp.getValeur()).getObj() instanceof ObjetConstante)
    		{
    		
			}else
			{
    			if(((Quad)tmp.getValeur()).getObj() instanceof ObjetTab)
        		{
    				tas.ajouterRef((ValeurTab)v);
    				tas.retirerTas((ValeurTab)((Quad)tmp.getValeur()).getVal());
    				((Quad)tmp.getValeur()).setVal(v);
        		}else
        		{
        			((Quad)tmp.getValeur()).setVal(v);
        		}
			}
		}
    	
    }
    
    public void affecterValT(String id, Valeur v, Valeur indice) throws Exception
    {
		ValeurTab tab =(ValeurTab) this.val(id);
		tas.affecterTas(v, (Integer) indice.getVal(), tab);
    }
    
    public void affecterType(String id, Sorte t)
    {
    	Element tmp = this.getElement(id);
    	if(tmp == null)
    	{
    		return;
    	}
    	
    	((Quad)tmp.getValeur()).setType(t);
    }
    
    public Valeur val(String id)
    {
    	Element tmp = this.getElement(id);
    	String idHP = "null";
    	if(tmp != null)
    	{
    		idHP = ((Quad)tmp.getValeur()).getId();
    	}
    	
    	Valeur res = new ValeurOmega();
    	if(idHP.equals(id))
    	{
    		res = ((Quad)tmp.getValeur()).getVal();
    	}
    	return res;
    }
    
    
    public Valeur valT(String id, int indice) throws Exception
    {

    	Valeur vTab = this.val(id);
    	Valeur res = new ValeurOmega();
    	if(vTab instanceof ValeurTab)
    	{
			res= tas.valeurTas((ValeurTab)vTab, indice);
    	}
    	return res;
    }
    
    public Objet objet(String id)
    {
    	Element tmp = this.getElement(id);
    	String idHP = "null";
    	if(tmp != null)
    	{
    		idHP = ((Quad)tmp.getValeur()).getId();
    	}
    	
    	Objet res = new ObjetOmega();
    	if(idHP.equals(id))
    	{
    		res = ((Quad)tmp.getValeur()).getObj();
    	}
    	return res;
    }
    
    public Sorte sorte(String id)
    {
    	Element tmp = this.getElement(id);
    	String idHP = "null";
    	if(tmp != null)
    	{
    		idHP = ((Quad)tmp.getValeur()).getId();
    	}
    	
    	Sorte res = new SortOmega();
    	if(idHP.equals(id))
    	{
    		res = ((Quad)tmp.getValeur()).getType();
    	}
    	return res;
    }
    
    public void expParam(Element lexp, Element lparam)
    {
    	Quad tmp;
    	boolean flag = true;
    	while(flag)
    	{
    		if(lparam==null || lexp==null)
    		{
    			break;
    		}
    		tmp = (Quad)lparam.getValeur();
    		if(!(tmp!= null && lexp.getValeur() !=null))
    		{
    			flag = false;
    		}
    		if(flag)
    		{
    			this.declVar(tmp.getId(),(Valeur)lexp.getValeur(), tmp.getType());
    		}
    		if(lexp.getSuivant()!= null && lparam.getSuivant() !=null)
    		{
    			lexp = lexp.getSuivant();
    			lparam = lparam.getSuivant();
    			
    		}else
    		{
    			flag = false;
    		}
    		
    	}
    	
    }
    
    public void afficherTas() throws Exception
    {
    	Element tmp = this.pile.getHautPile();
    	System.out.println("Tas :");
    	while(tmp != null)
    	{
    		Objet o = ((Quad)tmp.getValeur()).getObj();
    		if(o instanceof ObjetTab)
    		{
    			tas.afficherTableau(((Quad)tmp.getValeur()).getId(),(ValeurTab) ((Quad)tmp.getValeur()).getVal());
    		}
    		tmp = tmp.getSuivant();
    	}
    }

	public String getTableauxTasToString() throws Exception
	{
		String s = "";
		Element tmp = this.pile.getHautPile();
		while(tmp != null)
		{
			Objet o = ((Quad)tmp.getValeur()).getObj();
			if(o instanceof ObjetTab)
			{
				s += tas.getTableauToString(((Quad)tmp.getValeur())) + "\n";
			}
			tmp = tmp.getSuivant();
		}
		return s;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Memoire && o!=null)
		{
			Memoire mem = (Memoire)o;
			return this.pile.equals(mem.pile) && this.tas.equals(mem.tas) && this.nbInstructions == mem.nbInstructions;
		}else
		{
			return false;
		}
	}
	
    @Override
    public String toString() {
        try {
			return "Pile : \n"+this.pile+"\nTas :\n"+this.getTableauxTasToString();
		} catch (Exception e) {
			return "Erreur toString() Memoire : "+e.getMessage();
		}
    }
}
