package fr.univfcomte.comp4.memoire_MiniJaja;

import fr.univfcomte.comp4.pile.*;
import fr.univfcomte.comp4.tas.*;
import fr.univfcomte.comp4.table_hachage.*;
import fr.univfcomte.comp4.quadruplet.*;


public class MemoireMiniJaja {
	
	public final String PORTEE_CLASSE = "class";
	
	private Tas tas;
	private TableSymbole tableSymboles;
	private String portee;
	private String nomClasse;
	
	public MemoireMiniJaja()
	{
		this(new TableSymbole());
		this.tableSymboles.put(new Symbole("C","class"), new Info("var","entier","class"));
		this.tableSymboles.put(new Symbole("x","class"), new Info("var","entier","class"));
		this.tableSymboles.put(new Symbole("y1","class"), new Info("cst","entier","class"));
		this.tableSymboles.put(new Symbole("y2","class"), new Info("cst","entier","class"));
		this.tableSymboles.put(new Symbole("tab","class"), new Info("tab","entier","class"));
		this.tableSymboles.put(new Symbole("tab2","class"), new Info("tab","entier","class"));
		this.tableSymboles.put(new Symbole("meth","class"), new Info("meth","entier","class","vide"));
		this.tableSymboles.put(new Symbole("x","main"), new Info("var","entier","class"));
		this.tableSymboles.put(new Symbole("y","main"), new Info("var","entier","main"));
		this.tableSymboles.put(new Symbole("f","class"), new Info("meth","entier","class"));
		this.tableSymboles.put(new Symbole("p","f"), new Info("var","entier","f"));
		this.tableSymboles.put(new Symbole("c","f"), new Info("var","entier","f"));
	}
	
	public MemoireMiniJaja(TableSymbole ts)
	{
		try
		{
			this.tableSymboles = ts;
			this.tas = new Tas();
			this.portee = PORTEE_CLASSE;
		}catch(Exception e)
		{
			System.err.println("MemoireMiniJaja constructor : "+e.getMessage());
		}
	}
	
	public MemoireMiniJaja(TableSymbole ts, int tailleT) throws Exception
	{
		this.tableSymboles = ts;
		tas = new Tas(tailleT);
		this.portee = PORTEE_CLASSE;
	}

	public void setPortee(String p)
	{
		this.portee = p;
	}
	
	public String getPortee()
	{
		return this.portee;
	}
	
	public void setNomClass(String nom)
	{
		this.nomClasse = nom;
	}
	
	public TableSymbole getTableSymbole()
	{
		return this.tableSymboles;
	}

	public Tas getTas() {
		return this.tas;
	}
	
	public void declVar(String id, Valeur v, Sorte t) throws Exception
    {
		Info info = this.tableSymboles.get(new Symbole(id, this.portee));
		Quad val = new Quad(id,v, new ObjetVariable(), t);
    	info.setValeur(val, this.tableSymboles.getHautPile());
    	this.tableSymboles.updateHautPile();
		
    }
    
    public void declCst(String id, Valeur v, Sorte t) throws Exception
    {
    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
		Quad valeur;
		if(v instanceof ValeurOmega)
    	{
    		
    		valeur = new Quad(id,v,new ObjetVconstante(),t);
    	}else
    	{
    		valeur = new Quad(id,v,new ObjetConstante(),t);
    	}
    	info.setValeur(valeur, this.tableSymboles.getHautPile());
    	this.tableSymboles.updateHautPile();
    }
    
    public void declTab(String id, Valeur v, Sorte t) throws Exception
    {
		Info info = this.tableSymboles.get(new Symbole(id, this.portee));
		Quad valeur = null;

	    ValeurTab val = tas.creerTas(v, t, id);
	    valeur = new Quad(id,val,new ObjetTab(),t);

    	info.setValeur(valeur, this.tableSymboles.getHautPile());
    	this.tableSymboles.updateHautPile();
    }
    
    public void declMeth(String id, Valeur v, Sorte t) throws Exception
    {
    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
		Quad valeur = new Quad(id,v,new ObjetMethode(),t);
    	info.setValeur(valeur, this.tableSymboles.getHautPile());
    	this.tableSymboles.updateHautPile();
    }
    
    public void retirerDecl(String id) throws Exception
    {
    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
    	Quad q =(Quad) info.getValeur();
    	Instance hp = info.retirerValeur();
    	if(hp != null)
    	{
    		this.tableSymboles.setHautPile(hp);
    	}
		if(q.getObj() instanceof ObjetTab)
		{
			tas.retirerTas((ValeurTab)q.getVal());
		}
    }
    
    public void affecterVariableClasse(Valeur v) throws Exception
    {
    	Info info = this.tableSymboles.get(new Symbole(this.nomClasse, this.portee));
		Quad valeur = info.getValeur();
		valeur.setVal(v);
    }
    
    public Valeur variableClasse() throws Exception
    {	
    	Valeur v = null;
    	Info info = this.tableSymboles.get(new Symbole(this.nomClasse, this.portee));
		Quad valeur = info.getValeur();
		v = valeur.getVal();
		
    	return v;
    }
    
    public void affecterVal(String id, Valeur v) throws Exception
    {
    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
		Quad valeur = info.getValeur();
		if(valeur.getObj() instanceof ObjetVconstante)
		{
			valeur.setVal(v);
			valeur.setObj(new ObjetConstante());
		}else
		{
			if(valeur.getObj() instanceof ObjetConstante)
    		{
    		
			}else
			{
    			if(valeur.getObj() instanceof ObjetTab)
        		{
    				tas.ajouterRef((ValeurTab)v);
    				tas.retirerTas((ValeurTab)valeur.getVal());
    				valeur.setVal(v);
        		}else
        		{
        			valeur.setVal(v);
        		}
			}
		}
    }
    
    public void affecterValT(ValeurTab tab, Valeur v, Valeur indice) throws Exception
    {
    	tas.affecterTas(v, (Integer) indice.getVal(), tab);
    }
    
    public void affecterType(String id, Sorte t) throws Exception
    {
    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
		Quad valeur = info.getValeur();
		valeur.setType(t);
    }
    
    public Valeur val(String id) throws Exception
    {
    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
		Quad valeur = info.getValeur();
		Valeur v = valeur.getVal();

    	return v;
    }
    
    public Valeur valT(String id, int indice) throws Exception
    {
    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
		Quad valeur = info.getValeur();
		Valeur v = this.tas.valeurTas((ValeurTab)valeur.getVal(), indice);
    	
    	return v;
    }
    
    public Objet objet(String id) throws Exception
    {

    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
		Quad valeur = info.getValeur();
		Objet o = valeur.getObj();
		
    	return o;
    }
    
    public Sorte sorte(String id) throws Exception
    {
    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
		Quad valeur = info.getValeur();
		Sorte s = valeur.getType();
		
    	return s;
    }
    
    public void expParam(Element lexp, Element lparam) throws Exception
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
    		if(lexp.getSuivant() != null && lparam.getSuivant() !=null)
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
    	Instance tmp = this.tableSymboles.getHautPile();
    	System.out.println("Tas :");
    	while(tmp != null)
    	{
    		Quad q = (Quad)tmp.getValeur();
    		if(q != null)
    		{
	    		Objet o = q.getObj();
	    		if(o instanceof ObjetTab)
	    		{
	    			tas.afficherTableau(((Quad)tmp.getValeur()).getId(),(ValeurTab) ((Quad)tmp.getValeur()).getVal());
	    		}
    		}
    		tmp = tmp.getSuivant();
    	}
    }

	public String getTableauxTasToString() throws Exception
	{
		String s = "";
		
		Instance tmp = this.tableSymboles.getHautPile();
    	while(tmp != null)
    	{
    		Quad q = (Quad)tmp.getValeur();
    		if(q != null)
    		{
	    		Objet o = q.getObj();
	    		if(o instanceof ObjetTab)
	    		{
	    			s += tas.getTableauToString(q) + "\n";
	    		}
    		}
    		tmp = tmp.getSuivant();
    	}
		return s;
	}
    
    public void afficherPile()
    {
    	Instance tmp = this.tableSymboles.getHautPile();
    	while(tmp != null)
    	{
    		if(tmp.getValeur() != null)
    		{
    			System.out.println(tmp.getValeur());
    		}
    		tmp = tmp.getSuivant();
    	}
    }
    
    public String getPileToString()
    {
    	String s = "";
    	Instance tmp = this.tableSymboles.getHautPile();
    	while(tmp != null)
    	{
    		if(tmp.getValeur() != null)
    		{
    			s+=tmp.getValeur()+"\n";
    		}
    		tmp = tmp.getSuivant();
    	}
    	
    	return s;
    }
    
    public boolean equals(Object o)
    {
    	if(o instanceof MemoireMiniJaja && o!=null)
    	{
    		MemoireMiniJaja mem = (MemoireMiniJaja)o;
    		
    		if(this.nomClasse == null)
    		{
    			if(mem.nomClasse != null)
    			{
    				return false;
    			}
    		}else
    		{
    			if(!this.nomClasse.equals(mem.nomClasse))
    			{
    				return false;
    			}
    		}
    		
    		return this.tas.equals(mem.tas) && this.tableSymboles.equals(mem.tableSymboles) 
    				&& this.portee.equals(mem.portee) && this.nomClasse.equals(mem.nomClasse);
    	}else
    	{
    		return false;
    	}
    }
    
    public String toString()
    {
    	try {
			return "Pile : \n"+this.getPileToString()+ "\nTableaux : \n" + getTableauxTasToString();
		} catch (Exception e) {
			return "Erreur toString() MemoireMinijaja : "+e.getMessage();
		}
    }
}
