package fr.univfcomte.comp4.controle_type;

import fr.univfcomte.comp4.analyseur.*;
import fr.univfcomte.comp4.table_hachage.*;

public class ControleTypeVisitor implements MiniJajaVisitor{
	
	public static final String PORTEE_CLASSE = "classe";

	public Object visit(SimpleNode node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTclasse node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		dataCT.setDeclaration(true);
		dataCT.setGenreIdent("defaut");
		node.jjtGetChild(0).jjtAccept(this, data);
		dataCT.setPorteeCourante(PORTEE_CLASSE);
		node.jjtGetChild(1).jjtAccept(this, data);
		node.jjtGetChild(2).jjtAccept(this, data);
		return null;
	}

	public Object visit(ASTident node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		if (dataCT.isDeclaration()) {
			// si le nom de l'identificateur est déjà utilisé
			if (dataCT.getTableSymbole().contains(
					new Symbole((String)node.jjtGetValue(),dataCT.getPorteeCourante()))) {
				throw new MiniJajaException("Cet identificateur '"+node.jjtGetValue()+"' est déjà utilisé");
			}
			return (String)node.jjtGetValue();
		}
		else {
			Info infoIdent;
			
			// test de l'existence de l'identificateur et récupération de ses infos
			try {
				infoIdent = (Info)dataCT.getTableSymbole().get(new Symbole
						((String)node.jjtGetValue(),dataCT.getPorteeCourante()));
			} catch (TableHachageException e) {
				try {
					infoIdent = (Info)dataCT.getTableSymbole().get(new Symbole
							((String)node.jjtGetValue(),PORTEE_CLASSE));
				} catch (TableHachageException e1) {
					throw new MiniJajaException("Identificateur '"+node.jjtGetValue()+"' non déclaré");
				}
			}
			
			// test du genre de l'identificateur
			if (dataCT.getGenreIdent().equals("defaut")) {
				if (infoIdent.getGenre().equals("meth")) {
					throw new MiniJajaException("Identificateur '"+node.jjtGetValue()
					+"' déclaré en tant que "+infoIdent.getGenre());
				}
				else if (infoIdent.getGenre().equals("tab")) {
					if (dataCT.isExpression()) {
						dataCT.setAffectationTableau(false);
					}
					else {
						dataCT.setAffectationTableau(true);
					}
					return infoIdent;
				}
				if (dataCT.isExpression()) {
					return infoIdent.getType();
				}
				else {
					return infoIdent;
				}
				
			}
			else {
				if (!infoIdent.getGenre().equals(dataCT.getGenreIdent())) {
					throw new MiniJajaException("Identificateur '"+node.jjtGetValue()
					+"' déclaré en tant que "+infoIdent.getGenre());
				}
				return infoIdent;
			}
			
		}
		
	}

	public Object visit(ASTdecls node, Object data) throws MiniJajaException {
		node.jjtGetChild(0).jjtAccept(this, data);
		node.jjtGetChild(1).jjtAccept(this, data);
		return null;
	}

	public Object visit(ASTvnil node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTmethode node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		
		dataCT.setDeclaration(true);
		String typeMeth = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String ident = (String) node.jjtGetChild(1).jjtAccept(this, data);
		
		String porteeParent = dataCT.getPorteeCourante();
		dataCT.setPorteeCourante(ident);
		String typeEntetes = (String) node.jjtGetChild(2).jjtAccept(this, data);
		dataCT.getTableSymbole().put(new Symbole(ident,porteeParent)
				, new Info("meth","vide",porteeParent,typeEntetes,typeMeth));
		
		node.jjtGetChild(3).jjtAccept(this, data);
		node.jjtGetChild(4).jjtAccept(this, data);
		
		dataCT.setPorteeCourante(porteeParent);
		
		return null;
	}

	public Object visit(ASTtableau node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		dataCT.setDeclaration(true);
		String typeIdent = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String ident = (String) node.jjtGetChild(1).jjtAccept(this, data);
		dataCT.setDeclaration(false);
		dataCT.setExpression(true);
		String typeExp = (String) node.jjtGetChild(2).jjtAccept(this, data);
		dataCT.setExpression(false);
		
		if(!typeExp.equals("entier"))
		{
			throw new MiniJajaException("la taille du tableau doit être un entier");
		}
		
		dataCT.getTableSymbole().put(new Symbole(ident,dataCT.getPorteeCourante())
				, new Info("tab",typeIdent,dataCT.getPorteeCourante()));
		
		return null;
	}

	public Object visit(ASTvar node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		
		dataCT.setDeclaration(true);
		String typeIdent = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String ident = (String) node.jjtGetChild(1).jjtAccept(this, data);
		dataCT.setDeclaration(false);
		dataCT.setExpression(true);
		String typeValeur = (String) node.jjtGetChild(2).jjtAccept(this, data);
		dataCT.setExpression(false);
		
		if(!typeIdent.equals(typeValeur) && !typeValeur.equals("omega"))
		{
			throw new MiniJajaException("La variable "+ident+" est de type "+typeIdent);
		}
		
		dataCT.getTableSymbole().put(new Symbole(ident,dataCT.getPorteeCourante())
				, new Info("var",typeIdent,dataCT.getPorteeCourante()));
		
		return null;
	}

	public Object visit(ASTcst node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		
		dataCT.setDeclaration(true);
		String typeIdent = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String ident = (String) node.jjtGetChild(1).jjtAccept(this, data);
		dataCT.setDeclaration(false);
		dataCT.setExpression(true);
		String typeValeur = (String) node.jjtGetChild(2).jjtAccept(this, data);
		dataCT.setExpression(false);
		
		if(!typeIdent.equals(typeValeur) && !typeValeur.equals("omega"))
		{
			throw new MiniJajaException("La constante "+ident+" est de type "+typeIdent);
		}
		
		dataCT.getTableSymbole().put(new Symbole(ident,dataCT.getPorteeCourante())
				, new Info("cst",typeIdent,dataCT.getPorteeCourante()));
		
		return null;
	}

	public Object visit(ASTvars node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		dataCT.setDeclaration(true);
		node.jjtGetChild(0).jjtAccept(this, data);
		node.jjtGetChild(1).jjtAccept(this, data);
		return null;
	}

	public Object visit(ASTomega node, Object data) throws MiniJajaException {
		return "omega";
	}

	public Object visit(ASTmain node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		String porteeParent = dataCT.getPorteeCourante();
		dataCT.setPorteeCourante("main");
		node.jjtGetChild(0).jjtAccept(this, data);
		node.jjtGetChild(1).jjtAccept(this, data);
		dataCT.setPorteeCourante(porteeParent);
		return null;
	}

	public Object visit(ASTenil node, Object data) throws MiniJajaException {
		return "vide";
	}

	public Object visit(ASTentetes node, Object data) throws MiniJajaException {
		String typeEntete1 = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String typeEntete2 = (String) node.jjtGetChild(1).jjtAccept(this, data);
		if (typeEntete2.equals("vide")) {
			return typeEntete1;
		}
		else {
			return typeEntete1+"X"+typeEntete2;
		}
	}

	public Object visit(ASTentete node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		
		String type = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String ident = (String) node.jjtGetChild(1).jjtAccept(this, data);
		
		// ajouter les variables entete
		dataCT.getTableSymbole().put(new Symbole(ident,dataCT.getPorteeCourante())
				, new Info("var",type,dataCT.getPorteeCourante()));
		
		return type;
	}

	public Object visit(ASTinstrs node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		dataCT.setDeclaration(false);
		node.jjtGetChild(0).jjtAccept(this, data);
		node.jjtGetChild(1).jjtAccept(this, data);
		return null;
	}

	public Object visit(ASTinil node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTtab node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		
		dataCT.setDeclaration(false);
		dataCT.setGenreIdent("tab");
		Info infoTab = (Info) node.jjtGetChild(0).jjtAccept(this, data);
		dataCT.setGenreIdent("defaut");
		
		dataCT.setExpression(true);
		String typeExp = (String) node.jjtGetChild(1).jjtAccept(this, data);
		dataCT.setExpression(false);
		
		if (!typeExp.equals("entier")) {
			throw new MiniJajaException("l'indice du tableau doit correspondre à un entier");
		}
		
		return infoTab.getType();
	}

	public Object visit(ASTaffectation node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		
		Info infoIdent = (Info) node.jjtGetChild(0).jjtAccept(this, data);
		dataCT.setExpression(true);
		
		if (dataCT.isAffectationTableau()) {
			Info infoTab = (Info) node.jjtGetChild(1).jjtAccept(this, data);
			if (!infoTab.getGenre().equals("tab")) {
				throw new MiniJajaException("L'affectation de tableaux doit concerné deux tableaux");
			}
			else if (!infoTab.getType().equals(infoIdent.getGenre())) {
				throw new MiniJajaException("Les types des tableaux ne sont pas compatibles");
			}
		}
		else {
			String typeExp = (String) node.jjtGetChild(1).jjtAccept(this, data);
			if (!infoIdent.getType().equals(typeExp)) {
				throw new MiniJajaException("l'ident et l'expression sont incompatibles");
			}
		}
		
		dataCT.setExpression(false);
		
		return null;
	}

	public Object visit(ASTsomme node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		
		Info infoIdent = (Info) node.jjtGetChild(0).jjtAccept(this, data);
		dataCT.setExpression(true);
		String typeExp = (String) node.jjtGetChild(1).jjtAccept(this, data);
		dataCT.setExpression(false);
		if (!infoIdent.getType().equals("entier")) {
			throw new MiniJajaException("l'ident doit être un entier");
		}
		else if (!typeExp.equals("entier")) {
			throw new MiniJajaException("l'expression doit être un entier");
		}
		return null;
	}

	public Object visit(ASTincrement node, Object data) throws MiniJajaException {
		String typeIdent = (String) node.jjtGetChild(0).jjtAccept(this, data);
		if (!typeIdent.equals("entier")) {
			throw new MiniJajaException("la variable doit être un entier");
		}
		return null;
	}

	public Object visit(ASTappelI node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;

		dataCT.setGenreIdent("meth");
		Info infoMethode = (Info) node.jjtGetChild(0).jjtAccept(this, data);
		dataCT.setGenreIdent("defaut");
		
		dataCT.setExpression(true);
		String typeListExp = (String) node.jjtGetChild(1).jjtAccept(this, data);
		dataCT.setExpression(false);
		
		// verifie le bon nombre d arguments et le bon typage de ceux-ci avec les entetes
		if (!infoMethode.getTypeEntetes().equals(typeListExp)) {
			throw new MiniJajaException("erreur sur le nombre d'arguments ou le typage de ceux-ci");
		}
		
		return null;
	}

	public Object visit(ASTretour node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;

		// vérifier que l'on retourne bien le type de retour de la methode
		dataCT.setExpression(true);
		String typeExp = (String) node.jjtGetChild(0).jjtAccept(this, data);
		dataCT.setExpression(false);
		Info infoMethode;
		try {
			infoMethode = (Info)dataCT.getTableSymbole().get(new Symbole
					(dataCT.getPorteeCourante(),PORTEE_CLASSE));
		} catch (TableHachageException e) {
			throw new MiniJajaException ("methode non declarée");
		}
		
		if (!infoMethode.getTypeRetour().equals(typeExp)) {
			throw new MiniJajaException ("type de retour non compatible");
		}
		return null;
	}

	public Object visit(ASTsi node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		
		dataCT.setExpression(true);
		String typeExp = (String) node.jjtGetChild(0).jjtAccept(this, data);
		dataCT.setExpression(false);
		if (!typeExp.equals("booleen")) {
			throw new MiniJajaException ("l'expression du si doit être un booléen");
		}
		
		node.jjtGetChild(1).jjtAccept(this, data);
		node.jjtGetChild(2).jjtAccept(this, data);
		return null;
	}

	public Object visit(ASTtantque node, Object data) throws MiniJajaException {
		DataControleType dataCT = (DataControleType)data;
		
		dataCT.setExpression(true);
		String typeExp = (String) node.jjtGetChild(0).jjtAccept(this, data);
		dataCT.setExpression(false);
		if (!typeExp.equals("booleen")) {
			throw new MiniJajaException ("l'expression du tant que doit être un booléen");
		}
		
		node.jjtGetChild(1).jjtAccept(this, data);
		return null;
	}

	public Object visit(ASTexnil node, Object data) throws MiniJajaException {
		return "vide";
	}

	public Object visit(ASTlistexp node, Object data) throws MiniJajaException {
		String typeExp1 = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String typeExp2 = (String) node.jjtGetChild(1).jjtAccept(this, data);
		if (typeExp2.equals("vide")) {
			return typeExp1;
		}
		else {
			return typeExp1+"X"+typeExp2;
		}
	}

	public Object visit(ASTnot node, Object data) throws MiniJajaException {
		String typeExp = (String) node.jjtGetChild(0).jjtAccept(this, data);
		if(!typeExp.equals("booleen"))
		{
			throw new MiniJajaException("not");
		}
		return "booleen";
	}

	public Object visit(ASTet node, Object data) throws MiniJajaException {
		String typeExp1 = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String typeExp2 = (String) node.jjtGetChild(1).jjtAccept(this, data);
		if(!typeExp1.equals("booleen") || !typeExp1.equals(typeExp2))
		{
			throw new MiniJajaException("et");
		}
		return "booleen";
	}

	public Object visit(ASTou node, Object data) throws MiniJajaException {
		String typeExp1 = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String typeExp2 = (String) node.jjtGetChild(1).jjtAccept(this, data);
		if(!typeExp1.equals("booleen") || !typeExp1.equals(typeExp2))
		{
			throw new MiniJajaException("ou("+typeExp1+","+typeExp2+")");
		}
		return "booleen";
	}

	public Object visit(ASTegal node, Object data) throws MiniJajaException{
		String typeExp1 = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String typeExp2 = (String) node.jjtGetChild(1).jjtAccept(this, data);
		if(!typeExp1.equals(typeExp2))
		{
			throw new MiniJajaException("==");
		}
		return "booleen";
	}

	public Object visit(ASTsupga node, Object data) throws MiniJajaException{
		String typeExp1 = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String typeExp2 = (String) node.jjtGetChild(1).jjtAccept(this, data);
		if(!typeExp1.equals("entier") || !typeExp1.equals(typeExp2))
		{
			throw new MiniJajaException(">");
		}
		return "booleen";
	}

	public Object visit(ASTmoinsU node, Object data) throws MiniJajaException{
		String typeExp = (String) node.jjtGetChild(0).jjtAccept(this, data);
		if(!typeExp.equals("entier"))
		{
			throw new MiniJajaException("moinsU");
		}
		return "entier";
	}

	public Object visit(ASTplus node, Object data) throws MiniJajaException{
		String typeExp1 = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String typeExp2 = (String) node.jjtGetChild(1).jjtAccept(this, data);
		if(!typeExp1.equals("entier") || !typeExp1.equals(typeExp2))
		{
			throw new MiniJajaException("plus");
		}
		return "entier";
	}

	public Object visit(ASTmoinsB node, Object data) throws MiniJajaException{
		String typeExp1 = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String typeExp2 = (String) node.jjtGetChild(1).jjtAccept(this, data);
		if(!typeExp1.equals("entier") || !typeExp1.equals(typeExp2))
		{
			throw new MiniJajaException("moinsB");
		}
		return "entier";
	}

	public Object visit(ASTmult node, Object data) throws MiniJajaException{
		String typeExp1 = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String typeExp2 = (String) node.jjtGetChild(1).jjtAccept(this, data);
		if(!typeExp1.equals("entier") || !typeExp1.equals(typeExp2))
		{
			throw new MiniJajaException("mult");
		}
		return "entier";
	}

	public Object visit(ASTdiv node, Object data) throws MiniJajaException{
		String typeExp1 = (String) node.jjtGetChild(0).jjtAccept(this, data);
		String typeExp2 = (String) node.jjtGetChild(1).jjtAccept(this, data);
		if(!typeExp1.equals("entier") || !typeExp1.equals(typeExp2))
		{
			throw new MiniJajaException("div");
		}
		return "entier";
	}

	public Object visit(ASTvrai node, Object data) throws MiniJajaException{
		return "booleen";
	}

	public Object visit(ASTfaux node, Object data) throws MiniJajaException{
		return "booleen";
	}

	public Object visit(ASTappelE node, Object data) throws MiniJajaException{
		DataControleType dataCT = (DataControleType)data;
		
		dataCT.setGenreIdent("meth");
		Info infoMethode = (Info) node.jjtGetChild(0).jjtAccept(this, data);
		dataCT.setGenreIdent("defaut");
		
		String typeListExp = (String) node.jjtGetChild(1).jjtAccept(this, data);
		
		// verifie le bon nombre d arguments et le bon typage de ceux-ci avec les entetes
		if (!infoMethode.getTypeEntetes().equals(typeListExp)) {
			throw new MiniJajaException("erreur sur le nombre d'arguments ou le typage de ceux-ci");
		}
		
		// retourne le type de retour de la methode
		return infoMethode.getTypeRetour();
	}

	public Object visit(ASTnbre node, Object data) throws MiniJajaException{
		return "entier";
	}

	public Object visit(ASTrien node, Object data) throws MiniJajaException{
		return "vide";
	}

	public Object visit(ASTentier node, Object data) throws MiniJajaException{
		return "entier";
	}

	public Object visit(ASTbooleen node, Object data) throws MiniJajaException{
		return "booleen";
	}

}
