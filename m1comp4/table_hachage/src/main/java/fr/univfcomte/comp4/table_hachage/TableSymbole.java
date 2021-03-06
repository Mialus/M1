package fr.univfcomte.comp4.table_hachage;

import java.util.Arrays;

public class TableSymbole extends TableHachage {

	private Instance hautPile;
	
	public TableSymbole()
	{
		super();
		this.hautPile = new Instance();
	}
	
	public Info get(Symbole key) throws TableHachageException
	{
		Info res = null;
		try {
			res =(Info) super.get(key);
		}catch(TableHachageException e)
		{
			res = (Info) super.get(new Symbole(key.getIdent(), "class"));
		}
		
		return res;
	}
	
	public void remove(Symbole key) throws TableHachageException
	{
		try {
			super.remove(key);
		}catch(TableHachageException e)
		{
			super.remove(new Symbole(key.getIdent(), "class"));
		}
	}
	
	public void setHautPile(Instance hp)
	{
		this.hautPile = hp;
	}
	
	public Instance getHautPile()
	{
		return this.hautPile;
	}
	
	public boolean equals(Object o)
	{
		if(o instanceof TableSymbole && o!= null)
		{
			TableSymbole ts = (TableSymbole)o;
			return this.nbrObjet == ts.nbrObjet && Arrays.equals(this.table, ts.table)
					&& this.hautPile.equals(ts.hautPile);
		}else
		{
			return false;
		}
	}
	
	public void updateHautPile()
	{
		
		while(this.hautPile.getPrecedent() != null)
		{
			this.hautPile = this.hautPile.getPrecedent();
		}
	}
}
