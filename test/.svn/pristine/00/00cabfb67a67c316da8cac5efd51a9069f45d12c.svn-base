package fr.univfcomte.comp4.memoire_MiniJaja;

import fr.univfcomte.comp4.pile.*;
import fr.univfcomte.comp4.tas.*;
import fr.univfcomte.comp4.table_hachage.*;
import fr.univfcomte.comp4.quadruplet.*;

public class MemoireMiniJaja {
	private Pile pile;
	private Tas tas;
	private TableHachage tableSymboles;
	private String portee;
	
	public MemoireMiniJaja()
	{
		this(new TableHachage());
	}
	
	public MemoireMiniJaja(TableHachage ts)
	{
		try
		{
			this.tableSymboles = new TableHachage();
			this.tas = new Tas();
			this.pile = new Pile(tas);
			this.portee = "classe";
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	public MemoireMiniJaja(TableHachage ts, int tailleT)
	{
		try
		{
			this.tableSymboles = ts;
			tas = new Tas(tailleT);
			pile = new Pile(tas);
			this.portee = "classe";
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public void setPortee(String p)
	{
		this.portee = p;
	}
	
	public Pile getPile() {
		return this.pile;
	}

	public Tas getTas() {
		return this.tas;
	}

	public void empiler(Quad q)
	{
		pile.push(q);
	}
	
	public Quad depiler()
	{
		Quad q =(Quad)pile.pop();
		try {
			this.tableSymboles.get(new Symbole(q.getId(), this.portee));
		} catch (TableHachageException e) {
			System.err.println(e.getMessage());
		}
		return q;
	}
	
	public void echanger()
	{
		pile.swap();
	}
	
	public void declVar(String id, Valeur v, Sorte t)
    {
    	pile.declVar(id, v, t);
    }
    
    public void identVal(String id, Sorte t, int s)
    {
    	pile.identVal(id, t, s);
    }

    public void declCst(String id, Valeur v, Sorte t)
    {
    	pile.declCst(id, v, t);
    }
    
    public void declTab(String id, Valeur v, Sorte t)
    {
    	pile.declTab(id, v, t);
    }
    
    public void declMeth(String id, Valeur v, Sorte t)
    {
    	pile.declMeth(id, v, t);
    }
    
    public void retirerDecl(String id)
    {
    	pile.retirerDecl(id);
    }
    
    public void affecterVariableClasse(Valeur v)
    {
    	pile.affecterVariableClasse(v);
    }
    
    public Valeur variableClasse()
    {
    	Valeur v = pile.variableClasse();
    	
    	return v;
    }
    
    public void affecterVal(String id, Valeur v)
    {
    	pile.affecterVal(id, v);
    }
    
    public void affecterValT(ValeurTab tab, Valeur v, Valeur indice)
    {
    	pile.affecterValT(tab, v, indice);
    }
    public void affecterType(String id, Sorte t)
    {
    	pile.affecterType(id, t);
    }
    
    public Valeur val(String id)
    {
    	Valeur v = pile.val(id);
    	
    	return v;
    }
    
    public Valeur valT(String id, int indice)
    {
    	Valeur v = pile.valT(id, indice);
    	
    	return v;
    }
    
    public Objet objet(String id)
    {
    	Objet o = pile.objet(id);
    	
    	return o;
    }
    
    public Sorte sorte(String id)
    {
    	Sorte s = pile.sorte(id);
    	
    	return s;
    }
    
    public void expParam(Element lexp, Element lparam)
    {
    	pile.expParam(lexp, lparam);
    }
    
    public void afficherTas()
    {
    	this.pile.afficherTas();
    }

	public String getTableauxTasToString()
	{
		return this.pile.getTableauxTasToString();
	}
    
    public void afficherPile()
    {
    	System.out.println("pile :\n"+pile);
    }
    
    public String toString()
    {
    	return "Pile : \n"+pile.toString()+"\nTas :\n"+tas.toString() + "\nTableaux : \n" + getTableauxTasToString();
    }
}
