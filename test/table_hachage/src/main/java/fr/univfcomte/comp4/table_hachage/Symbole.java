package fr.univfcomte.comp4.table_hachage;

public class Symbole {
	
	/* identificateur de l'objet (var, cst, tab) */ 
	String ident;
	
	/* portée de l'objet
	 * "classe" si c'est une méthode ou une variable de classe
	 */
	String portee;
	
	public Symbole (String ident, String portee) {
		this.ident = ident;
		this.portee = portee;
	}
	
	public String getIdent () {
		return ident;
	}
	
	public String getPortee () {
		return portee;
	}
	
	public String toString () {
		return ident+portee;
	}
	
	/* compare deux symboles */
	public boolean equals (Object other) {
		if (other instanceof Symbole) {
			Symbole otherSymbole = (Symbole)other;
			if (this.getIdent().equals(otherSymbole.getIdent())
				&& this.getPortee().equals(otherSymbole.getPortee())) {
				return true;
			}
			else  {
				return false;
			}
		}
		else {
			return false;
		}
	}

}