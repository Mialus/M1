package fr.univfcomte.comp4.table_hachage;

public class ObjetTableHachage {
	
	private Object cle;
	private Object valeur;
	private ObjetTableHachage objetTablePrecedent; 
	private ObjetTableHachage objetTableSuivant;
	
	public ObjetTableHachage(Object cle, Object valeur) {
		this.cle = cle;
		this.valeur = valeur;
		 objetTablePrecedent = null;
		 objetTableSuivant = null;
	}

	public Object getCle() {
		return cle;
	}

	public Object getValeur() {
		return valeur;
	}

	public ObjetTableHachage getObjetTablePrecedent() {
		return objetTablePrecedent;
	}

	public void setObjetTablePrecedent(ObjetTableHachage objetTablePrecedent) {
		this.objetTablePrecedent = objetTablePrecedent;
	}

	public ObjetTableHachage getObjetTableSuivant() {
		return objetTableSuivant;
	}

	public void setObjetTableSuivant(ObjetTableHachage objetTableSuivant) {
		this.objetTableSuivant = objetTableSuivant;
	}
	
	public boolean equals(Object o)
	{
		if(o instanceof ObjetTableHachage && o != null)
		{
			ObjetTableHachage oth = (ObjetTableHachage)o;
			
			if(this.objetTablePrecedent == null)
			{
				if(oth.objetTablePrecedent != null)
				{
					return false;
				}
			}
			
			if(this.objetTableSuivant == null)
			{
				if(oth.objetTableSuivant != null)
				{
					return false;
				}
			}else
			{
				if(!this.objetTableSuivant.equals(oth.objetTableSuivant))
				{
					return false;
				}
			}
			
			return this.cle.equals(oth.cle) && this.valeur.equals(oth.valeur);
		}else
		{
			return false;
		}
	}
	public String toString()
	{
		String s="";
		s+="(key : "+this.cle.toString()+", val : "+this.valeur+")->";
		if(this.getObjetTableSuivant() != null)
		{
			s+=this.getObjetTableSuivant().toString();
		}else
		{
			s+="null";
		}
		return s;
	}
	
}
