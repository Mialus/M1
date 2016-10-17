package fr.univfcomte.comp4.table_hachage;

public class TableSymbole extends TableHachage {

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
}
