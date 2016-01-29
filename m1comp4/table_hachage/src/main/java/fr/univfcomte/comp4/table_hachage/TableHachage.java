package fr.univfcomte.comp4.table_hachage;

import java.util.Arrays;

public class TableHachage {

	/* taille de la table de hachage (par défaut) */
	public final static int TAILLE = 128;
	
	/* nombre de symboles dans la table */
	protected int nbrObjet;
	
	/* table de hachage */
	protected ObjetTableHachage[] table;
	
	public TableHachage() {
		this(TAILLE);
	}
	
	public TableHachage(int taille) {
		table = new ObjetTableHachage [taille];
		nbrObjet = 0;
	}
	
	/* fonction de hachage */
	private int hash (Object key)
	{

		int hashCode = 0; // code de hachage
		
		int coef = 42; // coefficient de hachage
		
		// Etape 1 - Hachage
		String stringKey = key.toString();
		for(int i = 0 ; i < stringKey.toString().length() ; i++) { // On parcourt tous les caractères
			hashCode += (int)stringKey.toString().charAt(i) * (int)(Math.pow(coef, i));
		}

		// Etape 2 : compression
		return Math.abs(hashCode) % table.length;

	}
	
	/* insère un symbole dans la table */
	public void put(Object key, Object valeur) {
		int index = hash(key); // Calcul de l'indice
		ObjetTableHachage obj = new ObjetTableHachage(key,valeur);
		
		obj.setObjetTablePrecedent(null);
		
		if(table[index] != null) { // si la liste de symboles n'est pas vide
			ObjetTableHachage o = table[index];
			o.setObjetTablePrecedent(obj);
			obj.setObjetTableSuivant(o);
			table[index] = obj;
		}
		else {	
			obj.setObjetTableSuivant(null);
			table[index] = obj;
		}
		nbrObjet++;
	}
	
	/* retourne les infos correspond à la clé donnée */
	public Object get(Object key) throws TableHachageException {
		
		if(nbrObjet == 0) {
			throw new TableHachageException("Table vide.");
		}
			
		int index = hash(key); // Calcul de l'indice
		if(table[index] == null) { // Si la liste n'existe pas
			throw new TableHachageException("Clé non trouvée "+key);
		}
		
		ObjetTableHachage o = table[index]; // Récupération du symbole
		
		while (o != null  && !(o.getCle()).equals(key)) {
			o = o.getObjetTableSuivant();
		}

		if(o != null) { // Si le symbole existe, on retourne les informations
			return o.getValeur();
		}
		else {
			throw new TableHachageException("Clé non trouvée "+key);
		}
	}

	public void remove(Object key) throws TableHachageException
	{
		if(nbrObjet == 0) {
			throw new TableHachageException("Table vide.");
		}
			
		int index = hash(key); // Calcul de l'indice
		
		if(table[index] == null) {
			throw new TableHachageException("Clé non trouvée");
		}
		
		// Suppression du noeud
		ObjetTableHachage o = table[index];
		
		
		while (o != null  && (!(o.getCle()).equals(key))) {
			o = o.getObjetTableSuivant();
		}

		if(o != null) { // Si le noeud existe, on le supprime
			
			//Si le noeud à un suivant alors on affecte au suivant le precedent du noeud
			if(o.getObjetTableSuivant() != null)
			{
				o.getObjetTableSuivant().setObjetTablePrecedent(o.getObjetTablePrecedent());
			}
			
			//Si le noeud à un precedent alors on affecte au precedent le suivant du noeud
			if(o.getObjetTablePrecedent() != null)
			{

				o.getObjetTablePrecedent().setObjetTableSuivant(o.getObjetTableSuivant());
			}else
			{
			//Sinon, le noeud est le premier element du tableau, donc on le remplace par son suivant.
				table[index] = o.getObjetTableSuivant();
			}
			nbrObjet--;
		}
		else {
			throw new TableHachageException("Clé non trouvée");
		}
	
	}
	

	public boolean contains(Object key)
	{
		if(nbrObjet == 0) {
			return false;
		}
		
		int index = hash(key); // Calcul de l'indice

		ObjetTableHachage o = table[index];
		while (o != null  && !(o.getCle()).equals(key)) {
			o = o.getObjetTableSuivant();
		}
			
		return (o != null); // Renvoie vrai si la liste existe et si elle contient la clé
	}

	/* retourne l'objetTableHachage correspond à la clé donnée */
	public ObjetTableHachage getObjetTableHachage(Object key) throws TableHachageException {
		
		if(nbrObjet == 0) {
			throw new TableHachageException("Table vide.");
		}
			
		int index = hash(key); // Calcul de l'indice
		if(table[index] == null) { // Si la liste n'existe pas
			throw new TableHachageException("Clé non trouvée "+key);
		}
		
		ObjetTableHachage o = table[index]; // Récupération du symbole
		
		while (o != null  && !(o.getCle()).equals(key)) {
			o = o.getObjetTableSuivant();
		}

		if(o != null) { // Si le symbole existe, on retourne les informations
			return o;
		}
		else {
			throw new TableHachageException("Clé non trouvée "+key);
		}
	}
	
	public int size() {
		return table.length;
	}
	
	public boolean equals(Object o)
	{
		if(o instanceof TableHachage && o != null)
		{
			TableHachage th = (TableHachage)o;
			
			return this.nbrObjet == th.nbrObjet && Arrays.equals(this.table, th.table);
		}else
		{
			return false;
		}
	}
	
	public String toString()
	{
		String s ="";
		for(int i = 0; i<table.length; i++)
		{
			if(table[i] != null)
			{
				s+=table[i].toString()+"\n";
			}
		}
		
		return s;
	}
	
	
}
