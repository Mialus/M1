package fr.univfcomte.comp4.table_hachage;

import fr.univfcomte.comp4.quadruplet.Quad;


public class Instance {

	private Quad valeur;
	private Instance valeurSuivante;
	private Instance suivant;
	private Instance precedent;
	
	public Instance()
	{
		this(null, null, null, null);
	}
	
	public Instance(Quad v, Instance vSuivant, Instance suivant, Instance precedent)
	{
		valeur = v;
		this.suivant = suivant;
		this.precedent = precedent;
		valeurSuivante = vSuivant;
	}
	
	public void setValeur(Quad q)
	{
		this.valeur = q;
	}
	
	public void setValeurSuivante(Instance vSuivant)
	{
		this.valeurSuivante = vSuivant;
	}
	
	public void setSuivant(Instance suivant)
	{
		this.suivant = suivant;
	}
	
	public void setPrecedent(Instance precedent)
	{
		this.precedent = precedent;
	}
	
	public Quad getValeur()
	{
		return this.valeur;
	}
	
	public Instance getValeurSuivante()
	{
		return this.valeurSuivante;
	}
	
	public Instance getSuivant()
	{
		return this.suivant;
	}
	
	public Instance getPrecedent()
	{
		return this.precedent;
	}
	
	public boolean equals(Object o)
	{
		if(o instanceof Instance && o!= null)
		{
			Instance i = (Instance)o;
			boolean v1, v2, v3, v4;
			
			if(this.valeur == null)
			{
				if(i.valeur != null)
				{
					return false;
				}
			}else
			{
				if(!this.valeur.equals(i.valeur))
				{
					return false;
				}
			}
			
			if(this.valeurSuivante == null)
			{
				if(i.valeurSuivante != null)
				{
					return false;
				}
			}else
			{
				if(!this.valeurSuivante.equals(i.valeurSuivante))
				{
					return false;
				}
			}
			
			if(this.suivant == null)
			{
				if(i.suivant != null)
				{
					return false;
				}
			}else
			{
				if(!this.suivant.equals(i.suivant))
				{
					return false;
				}
			}
			
			if(this.precedent == null)
			{
				if(i.precedent != null)
				{
					return false;
				}
			}
	
			return true;
		}else
		{
			return false;
		}
	}
	
	public String toString()
	{
		return "{"+valeur+"}";
	}
}
