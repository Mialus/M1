package fr.univfcomte.comp4.table_hachage;

import fr.univfcomte.comp4.quadruplet.Quad;
/* classe permettant de relater les informations nécessaires d'un identificateur
 * pour le contrôle de type
 */
public class Info {
	
	/* nom du noeud de l'AST */
	private String genre;
	
	/* type de l'identificateur */
	private String type;
	
	/* portée de l'identificateur */
	private String portee;
	
	/* types des entêtes pour les méthodes */
	private String typeEntetes;
	
	/* type de retour pour les méthodes */
	private String typeRetour;
	
	/* Valeur de l'élément */
	private Quad valeur;

	public Info(String genre, String type, String portee) {
		this.genre = genre;
		this.type = type;
		this.portee = portee;
	}
	
	public Info(String genre, String type, String portee, String typeEntetes, String typeRetour) {
		this(genre,type,portee);
		this.typeEntetes = typeEntetes;
		this.typeRetour = typeRetour;
	}
	
	public String getGenre() {
		return genre;
	}

	public String getPortee() {
		return portee;
	}

	public String getType() {
		return type;
	}

	public String getTypeEntetes() {
		return typeEntetes;
	}

	public String getTypeRetour() {
		return typeRetour;
	}
	
	public void setValeur(Quad q)
	{
		this.valeur = q;
	}
	
	public Quad getValeur()
	{
		return this.valeur;
	}
	
	
	public String toString () {
		if (typeEntetes == null && typeRetour == null) {
			return genre+"-"+type+"-"+portee;
		}
		else {
			return genre+"-"+type+"-"+portee+"-"+typeEntetes+"-"+typeRetour;
		}
	}

}
