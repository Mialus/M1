package fr.univfcomte.comp4.memoire_MiniJaja;

import fr.univfcomte.comp4.pile.*;
import fr.univfcomte.comp4.tas.*;
import fr.univfcomte.comp4.table_hachage.*;
import fr.univfcomte.comp4.quadruplet.*;


public class MemoireMiniJaja {
	
	public static final String PORTEE_CLASSE = "class";
	
	private Pile pile;
	private Tas tas;
	private TableSymbole tableSymboles;
	private String portee;
	private String nomClasse;
	
	public MemoireMiniJaja()
	{
		this(new TableSymbole());
		this.tableSymboles.put(new Symbole("C","class"), new Info("var","entier","class"));
		this.tableSymboles.put(new Symbole("x","class"), new Info("var","entier","class"));
		this.tableSymboles.put(new Symbole("x","main"), new Info("var","entier","class"));
		this.tableSymboles.put(new Symbole("y","main"), new Info("var","entier","main"));
		this.tableSymboles.put(new Symbole("f","class"), new Info("meth","entier","class"));
		this.tableSymboles.put(new Symbole("p","f"), new Info("var","entier","f"));
		this.tableSymboles.put(new Symbole("c","f"), new Info("var","entier","f"));
		System.out.println(this.tableSymboles);
		
	}
	
	public MemoireMiniJaja(TableSymbole ts)
	{
		try
		{
			this.tableSymboles = new TableSymbole();
			this.tas = new Tas();
			this.pile = new Pile(tas);
			this.portee = PORTEE_CLASSE;
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	public MemoireMiniJaja(TableSymbole ts, int tailleT)
	{
		try
		{
			this.tableSymboles = ts;
			tas = new Tas(tailleT);
			pile = new Pile(tas);
			this.portee = PORTEE_CLASSE;
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
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
	
	public Pile getPile() {
		return this.pile;
	}

	public Tas getTas() {
		return this.tas;
	}

	public void declVar(String id, Valeur v, Sorte t)
    {
		try {
			Info info = this.tableSymboles.get(new Symbole(id, this.portee));
			Quad valeur = new Quad(id,v, new ObjetVariable(), t);
			this.pile.push(valeur);
	    	info.setValeur(valeur);
		} catch (TableHachageException e) {
			System.err.println(e.getMessage());
		}
		
    }
    
    public void declCst(String id, Valeur v, Sorte t)
    {
    	try
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
			this.pile.push(valeur);
	    	info.setValeur(valeur);
    	} catch (TableHachageException e) {
			System.err.println(e.getMessage());
		}
    }
    
    public void declTab(String id, Valeur v, Sorte t)
    {
    	try
    	{
    		Info info = this.tableSymboles.get(new Symbole(id, this.portee));
			Quad valeur = null;
			try
	    	{
		    	ValeurTab val = tas.creerTas(v, t, id);
		    	valeur = new Quad(id,val,new ObjetTab(),t);
	    	}catch(Exception e)
	    	{
	    		System.err.println(e.getMessage());
	    	}
			this.pile.push(valeur);
	    	info.setValeur(valeur);
	    } catch (TableHachageException e) {
			System.err.println(e.getMessage());
		}
    }
    
    public void declMeth(String id, Valeur v, Sorte t)
    {
    	try
    	{
	    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
			Quad valeur = new Quad(id,v,new ObjetMethode(),t);
			this.pile.push(valeur);
	    	info.setValeur(valeur);
    	} catch (TableHachageException e) {
			System.err.println(e.getMessage());
		}
    }
    
    public void retirerDecl(String id)
    {
    	try
    	{
	    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
	    	Quad valeur = info.getValeur();
	    	if(valeur.getObj() instanceof ObjetTab)
			{
				try
				{
					tas.retirerTas((ValeurTab)valeur.getVal());
				}catch(Exception e)
				{
					System.err.println(e.getMessage());
				}
				
			}
	    	this.pile.retirerDecl(id);
	    	this.tableSymboles.remove(new Symbole(id, this.portee));
    	} catch (TableHachageException e) {
			System.err.println(e.getMessage());
		}
    }
    
    public void affecterVariableClasse(Valeur v)
    {
    	try
    	{
	    	Info info = this.tableSymboles.get(new Symbole(this.nomClasse, this.portee));
			Quad valeur = info.getValeur();
			valeur.setVal(v);
    	} catch (TableHachageException e) {
			System.err.println(e.getMessage());
		}
    }
    
    public Valeur variableClasse()
    {	
    	Valeur v = null;
    	try
    	{
	    	Info info = this.tableSymboles.get(new Symbole(this.nomClasse, this.portee));
			Quad valeur = info.getValeur();
			System.out.println("!!!!!!!!! "+valeur);
			v = valeur.getVal();
    	} catch (TableHachageException e) {
			System.err.println(e.getMessage());
		}
    	return v;
    }
    
    public void affecterVal(String id, Valeur v)
    {
    	try
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
	    				try
	    				{
	    					tas.retirerTas((ValeurTab)valeur.getVal());
	    				}catch(Exception e)
	    				{
	    					System.err.println(e.getMessage());
	    				}
	    				valeur.setVal(v);
	        		}else
	        		{
	        			valeur.setVal(v);
	        		}
				}
			}
    	} catch (TableHachageException e) {
			System.err.println(e.getMessage());
		}
    }
    
    public void affecterValT(ValeurTab tab, Valeur v, Valeur indice)
    {
    	try
    	{
    		tas.affecterTas(v, (Integer) indice.getVal(), tab);
    	}catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    }
    
    public void affecterType(String id, Sorte t)
    {
    	try
    	{
	    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
			Quad valeur = info.getValeur();
			valeur.setType(t);
	    } catch (TableHachageException e) {
			System.err.println(e.getMessage());
		}
    }
    
    public Valeur val(String id)
    {
    	Valeur v = null;
    	try
    	{
	    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
			Quad valeur = info.getValeur();
			v = valeur.getVal();
    	} catch (TableHachageException e) {
			System.err.println(e.getMessage());
		}
    	return v;
    }
    
    public Valeur valT(String id, int indice)
    {
    	Valeur v = null;
    	try
    	{
	    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
			Quad valeur = info.getValeur();
			v = null;
			try {
				v = this.tas.valeurTas((ValeurTab)valeur.getVal(), indice);
			} catch (TasException e) {
				System.err.println(e.getMessage());
			}
    	} catch (TableHachageException e) {
			System.err.println(e.getMessage());
		}
    	
    	return v;
    }
    
    public Objet objet(String id)
    {
    	Objet o = null;
    	try
    	{
	    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
			Quad valeur = info.getValeur();
			o = valeur.getObj();
    	} catch (TableHachageException e) {
			System.err.println(e.getMessage());
		}
    	
    	return o;
    }
    
    public Sorte sorte(String id)
    {
    	Sorte s = null;
    	try
    	{
	    	Info info = this.tableSymboles.get(new Symbole(id, this.portee));
			Quad valeur = info.getValeur();
			s = valeur.getType();
    	} catch (TableHachageException e) {
			System.err.println(e.getMessage());
		}
    	return s;
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