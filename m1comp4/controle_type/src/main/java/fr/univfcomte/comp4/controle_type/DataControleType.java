package fr.univfcomte.comp4.controle_type;

import fr.univfcomte.comp4.table_hachage.*;

/* objet d'informations à passer dans tous les noeuds pour le visiteur du
 * controle de type
 */
public class DataControleType {
	
	/* table des symboles */
	private TableSymbole tableSymbole;
	
	/* permet d'avoir la portée des noeuds visités */
	private String porteeCourante;

	public DataControleType() {
		tableSymbole = new TableSymbole();
	}

	public TableSymbole getTableSymbole() {
		return tableSymbole;
	}

	public String getPorteeCourante() {
		return porteeCourante;
	}

	public void setPorteeCourante(String porteeCourante) {
		this.porteeCourante = porteeCourante;
	}

	public boolean equals(Object o)
	{
		if(o instanceof DataControleType && o != null)
		{
			DataControleType ct = (DataControleType)o;
			return this.porteeCourante.equals(ct.porteeCourante) && this.tableSymbole.equals(ct.tableSymbole);
		}else
		{
			return false;
		}
	}
}
