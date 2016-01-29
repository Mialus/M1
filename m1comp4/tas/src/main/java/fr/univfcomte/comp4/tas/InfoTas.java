package fr.univfcomte.comp4.tas;

public class InfoTas {
	private int indice;
	private int taille;
	private int ref;
	
	public InfoTas(int indice, int t)
	{
		this.indice= indice;
		this.taille = t;
		this.ref = 1;
	}
	
	public int getIndice()
	{
		return this.indice;
	}
	
	public int getTaille()
	{
		return this.taille;
	}
	
	public int getRef()
	{
		return this.ref;
	}
	
	public void setIndice(int id)
	{
		this.indice = id;
	}
	
	public void decrRef()
	{
		this.ref--;
	}
	
	public void incrRef()
	{
		this.ref++;
	}
	
	public boolean equals(Object o)
	{
		if(o instanceof InfoTas && o!= null)
		{
			InfoTas infoT = (InfoTas)o;
			return (this.indice == infoT.indice && this.ref == infoT.ref && this.taille == infoT.taille);
		}else
		{
			return false;
		}
	}
	
	public String toString()
	{
		return "(ind : "+this.indice+", taille : "+this.taille+", ref : "+this.ref+")";
	}
}
