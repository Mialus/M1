package fr.univfcomte.comp4.controle_type;

import fr.univfcomte.comp4.table_hachage.*;

/* objet d'informations à passer dans tous les noeuds pour le visiteur du
 * controle de type
 */
public class DataControleType {
	
	/* table des symboles */
	private TableHachage tableSymbole;
	
	/* permet d'avoir la portée des noeuds visités */
	private String porteeCourante;
	
	/* permet de savoir si on doit visiter le noeud ident en tant que déclaration ou non */
	private boolean declaration;
	
	/* permet de savoir de quel genre (var, cst, meth, tab) est l'identificateur
	 *  lorsqu'on passe dans le noeud ident
	 *  la valeur "defaut" est défini pour dire que l'ident correspond à une variable ou une constante */
	private String genreIdent;
	
	/* permet de savoir si dans un noeud affectation, on a affaire à une affectation de tableau ou non */
	private boolean affectationTableau;
	
	/* permet de savoir si l'ident doit être visité en tant qu'expression */
	private boolean expression;

	public DataControleType() {
		tableSymbole = new TableHachage();
		genreIdent = "defaut";
		affectationTableau = false;
		expression = false;
	}

	public TableHachage getTableSymbole() {
		return tableSymbole;
	}

	public String getPorteeCourante() {
		return porteeCourante;
	}

	public void setPorteeCourante(String porteeCourante) {
		this.porteeCourante = porteeCourante;
	}

	public boolean isDeclaration() {
		return declaration;
	}

	public void setDeclaration(boolean declaration) {
		this.declaration = declaration;
	}

	public String getGenreIdent() {
		return genreIdent;
	}

	public void setGenreIdent(String genreIdent) {
		this.genreIdent = genreIdent;
	}

	public boolean isAffectationTableau() {
		return affectationTableau;
	}

	public void setAffectationTableau(boolean affectationTableau) {
		this.affectationTableau = affectationTableau;
	}

	public boolean isExpression() {
		return expression;
	}

	public void setExpression(boolean expression) {
		this.expression = expression;
	}

}
