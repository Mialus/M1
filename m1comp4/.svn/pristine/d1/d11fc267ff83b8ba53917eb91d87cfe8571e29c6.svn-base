/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univfcomte.comp4.pile;

import fr.univfcomte.comp4.tas.*;
import fr.univfcomte.comp4.quadruplet.*;
/**
 *
 * @author Pierre
 */

public class Pile implements Cloneable{
    Element hautPile;
    Tas tas;
    
    public Pile() throws Exception{
        this(new Tas());
    }
    
    public Pile(Tas t) {
        this.hautPile=null;
		tas = t;
    }
    
    public Object clone() {
		Pile p = null;
		try {
			p = (Pile) super.clone();
		} catch(CloneNotSupportedException cnse) {
			cnse.printStackTrace(System.err);
		}
		if(this != null)
    	{
			if(this.hautPile != null)
			{
				p.hautPile =(Element) this.hautPile.clone();
			}
    	}
		
		return p;
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
    
    public void declVar(String id, Valeur v, Sorte t)
    {
    	this.push(new Quad(id,v, new ObjetVariable(),t));	
    }
    
    public void identVal(String id, Sorte t, int s)
    {
    	if(this != null)
    	{
	    	if(this.hautPile == null)
	    	{
	    		return;
	    	}
	    	if(s == 0)
	    	{
	    		Quad q =(Quad) this.hautPile.valeur;
	    		q.setId(id);
	    		q.setType(t);
	    		q.setObj(new ObjetVariable());
	    	}else
	    	{
	    		Quad q =(Quad) this.pop();
	    		this.identVal(id, t, s-1);
	    		this.push(q);
	    		
	    	}
    	}
    }

    public void declCst(String id, Valeur v, Sorte t)
    {
    	if(v instanceof ValeurOmega)
    	{
    		
    		this.push(new Quad(id,v,new ObjetVconstante(),t));
    	}else
    	{
    		this.push(new Quad(id,v,new ObjetConstante(),t));
    	}		
    }
    
    public void declTab(String id, Valeur v, Sorte t)
    {
    	
    	
    	try
    	{
	    	ValeurTab val = tas.creerTas(v, t, id);
	    	this.push(new Quad(id,val,new ObjetTab(),t));
    	}catch(Exception e)
    	{
    		System.err.println(e.getMessage());
    	}
    }
    
    public void declMeth(String id, Valeur v, Sorte t)
    {
    	this.push(new Quad(id,v,new ObjetMethode(),t));
    }
    
    public void retirerDecl(String id)
    {
    	if(this.hautPile == null)
    	{
    		return;
    	}
    	if(((Quad)this.hautPile.valeur).getId().equals(id))
    	{
    		Quad q =(Quad) this.pop();
    		if(q.getObj() instanceof ObjetTab)
    		{
    			try
    			{
    				tas.retirerTas((ValeurTab)q.getVal());
    			}catch(Exception e)
    			{
    				System.err.println(e.getMessage());
    			}
    			
    		}
    	}else
    	{
    		Quad q = (Quad) this.pop();
    		this.retirerDecl(id);
    		this.push(q);
    		
    	}
    }
    
    public void affecterVariableClasse(Valeur v)
    {
    	
    	if(this.hautPile == null)
    	{
    		return;
    	}
    	Element tmp = this.hautPile;
    	while(tmp.suivant != null)
    	{
    		tmp = tmp.suivant;
    	}
    	
    	((Quad)tmp.valeur).setVal(v);
    }
    
    public Valeur variableClasse()
    {
    	if(this.hautPile == null)
    	{
    		
    		return new ValeurOmega();
    	}

    	Element tmp = this.hautPile;
    	while(tmp.suivant != null)
    	{
    		tmp = tmp.suivant;
    	}
    	
    	return ((Quad)tmp.valeur).getVal();
    }
    
    public void affecterVal(String id, Valeur v)
    {
    	if(this.hautPile == null)
    	{
    		return;
    	}
    	
    	if(!((Quad)this.hautPile.valeur).getId().equals(id))
    	{
    		Quad q = (Quad)this.pop();
    		this.affecterVal(id, v);
    		this.push(q);
    	}else
    	{
    		if(((Quad)this.hautPile.valeur).getObj() instanceof ObjetVconstante)
    		{
    			((Quad)this.hautPile.valeur).setVal(v);
    			((Quad)this.hautPile.valeur).setObj(new ObjetConstante());
    		}else
    		{
    			if(((Quad)this.hautPile.valeur).getObj() instanceof ObjetConstante)
        		{
        		
    			}else
    			{
	    			if(((Quad)this.hautPile.valeur).getObj() instanceof ObjetTab)
	        		{
	    				tas.ajouterRef((ValeurTab)v);
	    				try
	    				{
	    					tas.retirerTas((ValeurTab)((Quad)this.hautPile.valeur).getVal());
	    				}catch(Exception e)
	    				{
	    					System.err.println(e.getMessage());
	    				}
	    				((Quad)this.hautPile.valeur).setVal(v);
	        		}else
	        		{
	        			((Quad)this.hautPile.valeur).setVal(v);
	        		}
    			}
    		}
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
    	if (this.hautPile == null)
    	{
    		return;
    	}
    	if(((Quad)this.hautPile.valeur).getId().equals(id))
    	{
    		((Quad)this.hautPile.valeur).setType(t);
    	}else
    	{
    		Quad q = (Quad)this.pop();
    		this.affecterType(id, t);
    		this.push(q);
    	}
    }
    
    public Valeur val(String id)
    {
    	Pile p = (Pile)this.clone();
    	if(p.hautPile == null)
    	{
    		return new ValeurOmega();
    	}
    	if(((Quad)p.hautPile.valeur).getId().equals(id))
    	{
    		return ((Quad)p.hautPile.valeur).getVal();
    	}else
    	{
    		p.pop();
    		return this.valBis(id,p);
    	}
    }
    
    private Valeur valBis(String id, Pile p)
    {
    	if(p.hautPile == null)
    	{
    		return new ValeurOmega();
    	}
    	if(((Quad)p.hautPile.valeur).getId().equals(id))
    	{
    		return ((Quad)p.hautPile.valeur).getVal();
    	}else
    	{
    		p.pop();
    		return this.valBis(id,p);
    	}
    }
    
    public Valeur valT(String id, int indice)
    {
    	Pile p = (Pile)this.clone();
    	if(p.hautPile == null)
    	{
    		return new ValeurOmega();
    	}

    	if(((Quad)p.hautPile.valeur).getId().equals(id))
    	{
    		Valeur v = ((Quad)p.hautPile.valeur).getVal();
    		Valeur res = new ValeurOmega();
    		try
    		{
    			res= tas.valeurTas((ValeurTab)v, indice);
    		}catch(Exception e)
    		{
    			System.out.println(e.getMessage());
    		}
    		return res;
    	}else
    	{
    		p.pop();
    		return this.valTBis(id,indice, p);
    	}
    }
    
    private Valeur valTBis(String id, int indice, Pile p)
    {
    	if(p.hautPile == null)
    	{
    		return new ValeurOmega();
    	}
    	if(((Quad)p.hautPile.valeur).getId().equals(id))
    	{
    		Valeur v = ((Quad)p.hautPile.valeur).getVal();
    		Valeur res = new ValeurOmega();
    		try
    		{
    			
    			res= tas.valeurTas((ValeurTab)v, indice);
    		}catch(Exception e)
    		{
    			System.out.println(e.getMessage());
    		}

    		return res;
    	}else
    	{
    		p.pop();
    		return this.valTBis(id,indice,p);
    	}
    }
    public Objet objet(String id)
    {
    	Pile p = (Pile) this.clone();
    	if(p.hautPile == null)
    	{
    		return new ObjetOmega();
    	}
    	if(((Quad)p.hautPile.valeur).getId().equals(id))
    	{
    		return ((Quad)p.hautPile.valeur).getObj();
    	}else
    	{
    		p.pop();
    		return this.objet(id);
    	}
    }
    
    public Sorte sorte(String id)
    {
    	Pile p = (Pile) this.clone();
    	if(p.hautPile == null)
    	{
    		return new SortOmega();
    	}
    	if(((Quad)p.hautPile.valeur).getId().equals(id))
    	{
    		return ((Quad)p.hautPile.valeur).getType();
    	}else
    	{
    		p.pop();
    		return this.sorte(id);
    	}
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
    		tmp = (Quad)lparam.valeur;
    		if(!(tmp!= null && lexp.valeur !=null))
    		{
    			flag = false;
    		}
    		if(flag)
    		{
    			this.declVar(tmp.getId(),(Valeur)lexp.valeur, tmp.getType());
    		}
    		if(lexp.suivant != null && lparam.suivant !=null)
    		{
    			lexp = lexp.suivant;
    			lparam = lparam.suivant;
    			
    		}else
    		{
    			flag = false;
    		}
    		
    	}
    	
    }
    
    public void afficherTas()
    {
    	Pile tmp =(Pile) this.clone();
    	System.out.println("Tas :");
    	while(tmp.hautPile != null)
    	{
    		Objet o = ((Quad)tmp.hautPile.valeur).getObj();
    		if(o instanceof ObjetTab)
    		{
    			tas.afficherTableau(((Quad)tmp.hautPile.valeur).getId());
    		}
    		tmp.hautPile = tmp.hautPile.suivant;
    	}
    }

	public String getTableauxTasToString()
	{
		String s = "";
		Pile tmp =(Pile) this.clone();
		while(tmp.hautPile != null)
		{
			Objet o = ((Quad)tmp.hautPile.valeur).getObj();
			if(o instanceof ObjetTab)
			{
				s += tas.getTableauToString(((Quad)tmp.hautPile.valeur)) + "\n";
			}
			tmp.hautPile = tmp.hautPile.suivant;
		}
		return s;
	}
	
    @Override
    public String toString() {
        Element tmp = hautPile;
        String valPile = "";
        while(tmp!=null){
        
	        valPile= valPile + tmp.valeur.toString() + "\n";
	        tmp = tmp.suivant;
        };
        
        return valPile;
    }
    
}
