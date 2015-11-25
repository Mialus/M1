package fr.univfcomte.comp4.interpreteur_MiniJaja;
import fr.univfcomte.comp4.analyseur.*;
import fr.univfcomte.comp4.memoire_MiniJaja.*;
import fr.univfcomte.comp4.quadruplet.*;
import fr.univfcomte.comp4.pile.*;

public class MiniJajaInterpreteurVisitor implements MiniJajaVisitor{

	public final String PORTEE_CLASSE = "class";
	private MemoireListener ecouteur;

	// constructeur par défaut
	public MiniJajaInterpreteurVisitor() {
		super();
	}

	public MiniJajaInterpreteurVisitor(MemoireListener ecouteur) {
		super();
		this.ecouteur = ecouteur;
	}

	public Object visit(SimpleNode node, Object data) throws MiniJajaException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visit(ASTclasse node, Object data) throws MiniJajaException {
		String nom = (String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();
		((MemoireMiniJaja)data).declVar(nom, new ValeurOmega(), new SortOmega());
		((MemoireMiniJaja)data).setNomClass(nom);
		((MemoireMiniJaja)data).setPortee(PORTEE_CLASSE);
		
		node.jjtGetChild(1).jjtAccept(this, data);
		node.jjtGetChild(2).jjtAccept(this, data);
		/*System.out.println("_____________\nFin traitement :\n");
		((Memoire)data).afficherPile();
		((Memoire)data).afficherTas();*/
		this.ecouteur.onMemoireChangedMain((MemoireMiniJaja) data);

		MiniJajaRetraitVisitor visiteurR = new MiniJajaRetraitVisitor();
		((SimpleNode)node).jjtAccept(visiteurR, data);
		/*System.out.println("_____________\nAprès retrait :\n");
		((Memoire)data).afficherPile();
		((Memoire)data).afficherPile();*/
		this.ecouteur.onMemoireChangedMainRetrait((MemoireMiniJaja) data);

		return null;
	}

	public Object visit(ASTident node, Object data) throws MiniJajaException {
		Valeur valeur = ((MemoireMiniJaja)data).val(node.jjtGetValue().toString());
		return valeur;
	}

	public Object visit(ASTdecls node, Object data) throws MiniJajaException {
		for(int i =0; i<node.jjtGetNumChildren(); i++)
		{
			node.jjtGetChild(i).jjtAccept(this, data);
			this.ecouteur.onInstruction((MemoireMiniJaja)data);
		}
		return null;
	}

	public Object visit(ASTvnil node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTmethode node, Object data) throws MiniJajaException {
		Sorte type =(Sorte) ((SimpleNode)node.jjtGetChild(0)).jjtAccept(this, data);
		String nom = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();
		Valeur valeur =new ValeurMethode(node);
		((MemoireMiniJaja)data).declMeth(nom, valeur, type);
		return null;
	}

	public Object visit(ASTtableau node, Object data) throws MiniJajaException {
		Sorte type =(Sorte) ((SimpleNode)node.jjtGetChild(0)).jjtAccept(this, data);
		String nom = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();
		Valeur valeur =(Valeur) ((SimpleNode)node.jjtGetChild(2)).jjtAccept(this, data);
		((MemoireMiniJaja)data).declTab(nom, valeur, type);
		return null;
	}

	public Object visit(ASTvar node, Object data) throws MiniJajaException {
		Sorte type =(Sorte) ((SimpleNode)node.jjtGetChild(0)).jjtAccept(this, data);
		String nom = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();
		Valeur valeur =(Valeur) ((SimpleNode)node.jjtGetChild(2)).jjtAccept(this, data);
		((MemoireMiniJaja)data).declVar(nom, valeur, type);
		return null;
	}

	public Object visit(ASTcst node, Object data) throws MiniJajaException {
		Sorte type =(Sorte) ((SimpleNode)node.jjtGetChild(0)).jjtAccept(this, data);
		String nom = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();
		Valeur valeur =(Valeur) ((SimpleNode)node.jjtGetChild(2)).jjtAccept(this, data);
		((MemoireMiniJaja)data).declCst(nom, valeur, type);
		return null;
	}

	public Object visit(ASTvars node, Object data) throws MiniJajaException {
		for(int i =0; i<node.jjtGetNumChildren(); i++)
		{
			node.jjtGetChild(i).jjtAccept(this, data);
			this.ecouteur.onInstruction((MemoireMiniJaja)data);
		}
		return null;
	}

	public Object visit(ASTomega node, Object data) throws MiniJajaException {
		return new ValeurOmega();
	}

	public Object visit(ASTmain node, Object data) throws MiniJajaException {
		((MemoireMiniJaja)data).setPortee("main");
		for(int i =0; i<node.jjtGetNumChildren(); i++)
		{
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		((MemoireMiniJaja)data).setPortee("class");
		return null;
	}

	public Object visit(ASTenil node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTentetes node, Object data) throws MiniJajaException {
		Element res = new Element();
		res.setValeur(((SimpleNode)node.jjtGetChild(0)).jjtAccept(this, data));
		if(node.jjtGetChild(1) instanceof ASTentetes)
		{
			res.setSuivant((Element)((SimpleNode)node.jjtGetChild(1)).jjtAccept(this, data));
		}
		return res;
	}

	public Object visit(ASTentete node, Object data) throws MiniJajaException {
		Sorte type =(Sorte) ((SimpleNode)node.jjtGetChild(0)).jjtAccept(this, data);
		String nom = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();
		Quad q = new Quad(nom, new ValeurOmega(), new ObjetVariable(), type);
		
		return q;
	}

	public Object visit(ASTinstrs node, Object data) throws MiniJajaException {
		for(int i =0; i<node.jjtGetNumChildren(); i++)
		{
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	public Object visit(ASTinil node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTtab node, Object data) throws MiniJajaException {
		String nom = (String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();
		Valeur valeur = (ValeurEntier) ((SimpleNode)node.jjtGetChild(1)).jjtAccept(this, data);
		return ((MemoireMiniJaja)data).valT(nom, (Integer) valeur.getVal());
	}

	public Object visit(ASTaffectation node, Object data) throws MiniJajaException {
		String nom="";
		SimpleNode fils1 =(SimpleNode) node.jjtGetChild(0);
		if( fils1 instanceof ASTident)
		{
			nom = (String) fils1.jjtGetValue();
			Valeur valeur = (Valeur) ((SimpleNode)node.jjtGetChild(1)).jjtAccept(this, data);
			((MemoireMiniJaja)data).affecterVal(nom, valeur);
		}
		
		if(fils1 instanceof ASTtab)
		{
			
			nom =(String) ((SimpleNode)fils1.jjtGetChild(0)).jjtGetValue();
			ValeurTab tab =(ValeurTab) ((MemoireMiniJaja)data).val(nom);
			Valeur indice =(ValeurEntier) ((SimpleNode)fils1.jjtGetChild(1)).jjtAccept(this, data);
			Valeur valeur = (Valeur) ((SimpleNode)node.jjtGetChild(1)).jjtAccept(this, data);
			((MemoireMiniJaja)data).affecterValT(tab, valeur, indice);
		}
		return null;
	}

	public Object visit(ASTsomme node, Object data) throws MiniJajaException {
		String nom="";
		SimpleNode fils1 =(SimpleNode) node.jjtGetChild(0);
		if( fils1 instanceof ASTident)
		{
			nom = (String) fils1.jjtGetValue();
			Valeur valeur1 = ((MemoireMiniJaja)data).val(nom);
			Valeur valeur2 = (Valeur) ((SimpleNode)node.jjtGetChild(1)).jjtAccept(this, data);
			Valeur somme = new ValeurEntier(valeur1.getValEntier() + valeur2.getValEntier());
			((MemoireMiniJaja)data).affecterVal(nom,somme);
		}
		
		if(fils1 instanceof ASTtab)
		{
			nom =(String) ((SimpleNode)fils1.jjtGetChild(0)).jjtGetValue();
			ValeurTab tab =(ValeurTab) ((MemoireMiniJaja)data).val(nom);
			Valeur indice =(ValeurEntier) ((SimpleNode)fils1.jjtGetChild(1)).jjtAccept(this, data);
			Valeur valeur1 = (Valeur) fils1.jjtAccept(this, data);
			Valeur valeur2 = (Valeur) ((SimpleNode)node.jjtGetChild(1)).jjtAccept(this, data);
			Valeur somme = new ValeurEntier(valeur1.getValEntier() + valeur2.getValEntier());
			((MemoireMiniJaja)data).affecterValT(tab,somme, indice);
		}
		return null;
	}

	public Object visit(ASTincrement node, Object data) throws MiniJajaException {
		String nom="";
		SimpleNode fils1 =(SimpleNode) node.jjtGetChild(0);
		if( fils1 instanceof ASTident)
		{
			nom = (String) fils1.jjtGetValue();
			Valeur valeur1 = ((MemoireMiniJaja)data).val(nom);
			Valeur somme = new ValeurEntier(valeur1.getValEntier() + 1);
			((MemoireMiniJaja)data).affecterVal(nom,somme);
		}
		
		if(fils1 instanceof ASTtab)
		{
			nom =(String) ((SimpleNode)fils1.jjtGetChild(0)).jjtGetValue();
			ValeurTab tab =(ValeurTab) ((MemoireMiniJaja)data).val(nom);
			Valeur indice =(ValeurEntier) ((SimpleNode)fils1.jjtGetChild(1)).jjtAccept(this, data);
			Valeur valeur1 = (Valeur) fils1.jjtAccept(this, data);
			Valeur somme = new ValeurEntier(valeur1.getValEntier() + 1);
			((MemoireMiniJaja)data).affecterValT(tab,somme, indice);
		}
		return null;
	}

	public Object visit(ASTappelI node, Object data) throws MiniJajaException {
		String nom =(String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();
		String fctAppel = ((MemoireMiniJaja)data).getPortee();
	
		
		Element lexp = (Element)((SimpleNode)node.jjtGetChild(1)).jjtAccept(this, data);
		((MemoireMiniJaja)data).setPortee(nom);
		Element lparam = new Element();
		SimpleNode methode = (SimpleNode)((MemoireMiniJaja)data).val(nom).getVal();
		
		if(!(methode instanceof ASTmethode))
		{
			throw new MiniJajaException("appelI : pas de methode");
		}
		
		lparam = (Element) methode.jjtGetChild(2).jjtAccept(this, data);
		((MemoireMiniJaja)data).expParam(lexp, lparam);
		((SimpleNode)methode.jjtGetChild(3)).jjtAccept(this, data);
		((SimpleNode)methode.jjtGetChild(4)).jjtAccept(this, data);
		
		/*System.out.println("________________\nfonction : "+nom);
		((Memoire)data).afficherPile();
		((Memoire)data).afficherTas();
		System.out.println("________________");*/
		ecouteur.onMemoireChangedAppelI((MemoireMiniJaja)data, nom);
		MiniJajaRetraitVisitor visiteurR = new MiniJajaRetraitVisitor();
		((SimpleNode)node).jjtAccept(visiteurR, data);
		((MemoireMiniJaja)data).setPortee(fctAppel);
		return null;
	}

	public Object visit(ASTretour node, Object data) throws MiniJajaException {
		Valeur valeur = (Valeur) ((SimpleNode)node.jjtGetChild(0)).jjtAccept(this, data);
		((MemoireMiniJaja)data).affecterVariableClasse(valeur);
		return null;
	}

	public Object visit(ASTsi node, Object data) throws MiniJajaException {
		boolean condition =(Boolean) ((ValeurBooleen)(node.jjtGetChild(0)).jjtAccept(this, data)).getVal();
		if(condition)
		{
			((SimpleNode)node.jjtGetChild(1)).jjtAccept(this, data);
		}else
		{
			((SimpleNode)node.jjtGetChild(2)).jjtAccept(this, data);
		}
		return null;
	}

	public Object visit(ASTtantque node, Object data) throws MiniJajaException {
		boolean condition =(Boolean) ((ValeurBooleen)(node.jjtGetChild(0)).jjtAccept(this, data)).getVal();
		if(condition)
		{
			((SimpleNode)node.jjtGetChild(1)).jjtAccept(this, data);
			((SimpleNode)node).jjtAccept(this, data);
		}
		return null;
	}

	public Object visit(ASTexnil node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTlistexp node, Object data) throws MiniJajaException {
		Element res = new Element();
		res.setValeur(((SimpleNode)node.jjtGetChild(0)).jjtAccept(this, data));
		if(node.jjtGetChild(1) instanceof ASTlistexp)
		{
			res.setSuivant((Element)((SimpleNode)node.jjtGetChild(1)).jjtAccept(this, data));
		}
		return res;
	}

	public Object visit(ASTnot node, Object data) throws MiniJajaException {
		boolean f1 =((Valeur)(node.jjtGetChild(0)).jjtAccept(this, data)).getValBooleen();
		return new ValeurBooleen(!f1);
	}

	public Object visit(ASTet node, Object data) throws MiniJajaException {
		boolean f1 =((Valeur)(node.jjtGetChild(0)).jjtAccept(this, data)).getValBooleen();
		boolean f2 =((Valeur)(node.jjtGetChild(1)).jjtAccept(this, data)).getValBooleen();
		return new ValeurBooleen((f1 && f2));
	}

	public Object visit(ASTou node, Object data) throws MiniJajaException {
		boolean f1 =((Valeur)(node.jjtGetChild(0)).jjtAccept(this, data)).getValBooleen();
		boolean f2 =((Valeur)(node.jjtGetChild(1)).jjtAccept(this, data)).getValBooleen();
		return new ValeurBooleen((f1 || f2));
	}

	public Object visit(ASTegal node, Object data) throws MiniJajaException {
		Valeur f1 =(Valeur)(node.jjtGetChild(0)).jjtAccept(this, data);
		Valeur f2 =(Valeur)(node.jjtGetChild(1)).jjtAccept(this, data);
		return new ValeurBooleen(((f1.getVal()) == (f2.getVal())));
	}

	public Object visit(ASTsupga node, Object data) throws MiniJajaException {
		int f1 =((Valeur)(node.jjtGetChild(0)).jjtAccept(this, data)).getValEntier();
		int f2 =((Valeur)(node.jjtGetChild(1)).jjtAccept(this, data)).getValEntier();
		return new ValeurBooleen((f1>f2));
	}

	public Object visit(ASTmoinsU node, Object data) throws MiniJajaException {
		int f1 =((Valeur)(node.jjtGetChild(0)).jjtAccept(this, data)).getValEntier();
		return new ValeurEntier(-f1);
	}

	public Object visit(ASTplus node, Object data) throws MiniJajaException {
		int f1 =((Valeur)(node.jjtGetChild(0)).jjtAccept(this, data)).getValEntier();
		int f2 =((Valeur)(node.jjtGetChild(1)).jjtAccept(this, data)).getValEntier();
		return new ValeurEntier((f1+f2));
	}

	public Object visit(ASTmoinsB node, Object data) throws MiniJajaException {
		int f1 =((Valeur)(node.jjtGetChild(0)).jjtAccept(this, data)).getValEntier();
		int f2 =((Valeur)(node.jjtGetChild(1)).jjtAccept(this, data)).getValEntier();
		return new ValeurEntier((f1-f2));
	}

	public Object visit(ASTmult node, Object data) throws MiniJajaException {
		int f1 =((Valeur)(node.jjtGetChild(0)).jjtAccept(this, data)).getValEntier();
		int f2 =((Valeur)(node.jjtGetChild(1)).jjtAccept(this, data)).getValEntier();
		return new ValeurEntier((f1*f2));
	}

	public Object visit(ASTdiv node, Object data) throws MiniJajaException {
		int f1 =((Valeur)(node.jjtGetChild(0)).jjtAccept(this, data)).getValEntier();
		int f2 =((Valeur)(node.jjtGetChild(1)).jjtAccept(this, data)).getValEntier();
		if(f2 == 0)
		{
			throw new MiniJajaException("Division par 0");
		}
		return new ValeurEntier(f1/f2);
	}

	public Object visit(ASTvrai node, Object data) throws MiniJajaException {
		return new ValeurBooleen(true);
	}

	public Object visit(ASTfaux node, Object data) throws MiniJajaException {
		return new ValeurBooleen(false);
	}

	public Object visit(ASTappelE node, Object data) throws MiniJajaException {
		ASTappelI nodeI = new ASTappelI(-1);
		for(int i=0; i<node.jjtGetNumChildren();i++)
		{
			nodeI.jjtAddChild(node.jjtGetChild(i), i);
		}
		nodeI.jjtAccept(this, data);
		Valeur v = ((MemoireMiniJaja)data).variableClasse();

		return v;
	}

	public Object visit(ASTnbre node, Object data) throws MiniJajaException {
		return new ValeurEntier(Integer.parseInt((String)node.jjtGetValue()));
	}

	public Object visit(ASTrien node, Object data) throws MiniJajaException {
		return new SortVide();
	}

	public Object visit(ASTentier node, Object data) throws MiniJajaException {
		return new SortEntier();
	}

	public Object visit(ASTbooleen node, Object data) throws MiniJajaException {
		return new SortBooleen();
	}

}