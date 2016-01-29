package interpreteur_MiniJaja;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univfcomte.comp4.analyseur.MiniJaja;
import fr.univfcomte.comp4.analyseur.MiniJajaException;
import fr.univfcomte.comp4.analyseur.ParseException;
import fr.univfcomte.comp4.analyseur.SimpleNode;
//import fr.univfcomte.comp4.controle_type.ControleTypeVisitor;
//import fr.univfcomte.comp4.controle_type.DataControleType;
import fr.univfcomte.comp4.interpreteur_MiniJaja.MiniJajaInterpreteurVisitor;
import fr.univfcomte.comp4.memoire_MiniJaja.MemoireMiniJaja;
import fr.univfcomte.comp4.pile.Element;
import fr.univfcomte.comp4.quadruplet.ObjetVariable;
import fr.univfcomte.comp4.quadruplet.Quad;
import fr.univfcomte.comp4.quadruplet.SortBooleen;
import fr.univfcomte.comp4.quadruplet.SortEntier;
import fr.univfcomte.comp4.quadruplet.SortOmega;
import fr.univfcomte.comp4.quadruplet.SortVide;
import fr.univfcomte.comp4.quadruplet.ValeurBooleen;
import fr.univfcomte.comp4.quadruplet.ValeurEntier;
import fr.univfcomte.comp4.quadruplet.ValeurMethode;
import fr.univfcomte.comp4.quadruplet.ValeurOmega;
import fr.univfcomte.comp4.quadruplet.ValeurTab;
import fr.univfcomte.comp4.table_hachage.Info;
import fr.univfcomte.comp4.table_hachage.Symbole;
import fr.univfcomte.comp4.table_hachage.TableSymbole;
import junit.framework.Assert;

public class TestInterpreteurMiniJajaVisitor {

	MiniJaja parser;
	//Creation du visiteur
	MiniJajaInterpreteurVisitor visitor = new MiniJajaInterpreteurVisitor();
	
	@Test
	public void testASTClasse() throws ParseException, MiniJajaException {
		//Creation du noeud de l'AST a tester
		//Ecrit une str qui represent le noeud
		String str = "class C {"+
						   "main {"+
						   "}"+
						"}";
		
		//Parse la str pour et on appel la fonction permet de generer le noeud désirer
		parser = new MiniJaja(str);
		SimpleNode n = parser.classe();
		
		//Le visiteur prend en paramètre un noeud et une memoire de type MemoireMiniJaja
		//Il peut modifier la memoire en leur affectant ou retirant une valeur
		
		//Creation de la table des symboles qui sera passé en paramètre de la memoire
		//on y défini toutes les déclarations presentes dans la str
		TableSymbole ts = new TableSymbole();
		TableSymbole tsTest = new TableSymbole();
		
		//instruction d'ajout : ts.put(Symbole, Info)
		//Exemple : final int x dans la fonction fct
		// Symbole = Symbole("x", "fct")
		// Info = Info("cst", "entier", "fct")
		
		//Ici on déclare que la variable de classe
		ts.put(new Symbole("C","class"), new Info("var","entier","class"));
		
		tsTest.put(new Symbole("C","class"), new Info("var","entier","class"));
		
		//On créer une memoire de reference. c'est la memoire attendue à la fin de l'excution du visiteur
		//On reprend dans le code les modifcations faites à la memoire lors de l'appel du visiteur
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("class");
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
	}
	
	
	@Test(expected = MiniJajaException.class)
	public void testASTClasseFail() throws ParseException, MiniJajaException {
		//Creation du noeud de l'AST a tester pour generer l'erreur
		//Ecrit une str qui represent le noeud
		String str = "class C {"+
					"main{}}";
		
		//Parse la str pour et on appel la fonction permet de generer le noeud désirer
		parser = new MiniJaja(str);
		SimpleNode n = parser.classe();
		
		//Le visiteur prend en paramètre un noeud et une memoire de type DataControleType
		//Il modifie la memoire en y ajoutant les variable déclarée lors du controle de type
		
		//Creation de la table des symboles qui sera passé en paramètre de la memoire
		//on y défini toutes les déclarations presentes dans la str
		TableSymbole ts = new TableSymbole();
		
		//instruction d'ajout : ts.put(Symbole, Info)
		//Exemple : final int x dans la fonction fct
		// Symbole = Symbole("x", "fct")
		// Info = Info("cst", "entier", "fct")
		
		//Ici on déclare pasla variable de classe, car l'erreur doit prevenir
		//de la nom declaration dans la TableSymbole de cette variable
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(ts);
		
		//Appel du visiteur
		//Doit retourner l'erreur
		n.jjtAccept(visitor, memTest);
		
		//On ne doit pas arriver ici
		Assert.assertTrue(false);
	}
	
	@Test
	public void testASTsiVrai() throws Exception {
		//Creation du noeud de l'AST a tester
		//Ecrit une str qui represent le noeud
		String str = "if(true){x=2;}else{x=4;};";
		
		//Parse la str pour et on appel la fonction permet de generer le noeud désirer
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		TableSymbole ts = new TableSymbole();
		ts.put(new Symbole("x","main"), new Info("var","entier","main"));
		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("x","main"), new Info("var","entier","main"));
		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		memRef.declVar("x", new ValeurEntier(2), new SortEntier());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");
		memTest.declVar("x", new ValeurOmega(), new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
	}
	
	@Test
	public void testASTsiFaux() throws Exception {
		//Creation du noeud de l'AST a tester
		//Ecrit une str qui represent le noeud
		String str = "if(false){x=2;}else{x=4;};";
		
		//Parse la str pour et on appel la fonction permet de generer le noeud désirer
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		TableSymbole ts = new TableSymbole();
		ts.put(new Symbole("x","main"), new Info("var","entier","main"));
		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("x","main"), new Info("var","entier","main"));
		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		memRef.declVar("x", new ValeurEntier(4), new SortEntier());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");
		memTest.declVar("x", new ValeurOmega(), new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
	}
	
	@Test
	public void testASTtantQue() throws Exception {
		//Creation du noeud de l'AST a tester
		//Ecrit une str qui represent le noeud
		String str = "while(2>x){x++;};";
		
		//Parse la str pour et on appel la fonction permet de generer le noeud désirer
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		TableSymbole ts = new TableSymbole();
		ts.put(new Symbole("x","main"), new Info("var","entier","main"));
		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("x","main"), new Info("var","entier","main"));
		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		memRef.declVar("x", new ValeurEntier(2), new SortEntier());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");
		memTest.declVar("x", new ValeurEntier(0), new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
	}
	
	
	@Test
	public void testASTSomme() throws Exception {
		//Creation du noeud de l'AST a tester
		//Ecrit une str qui represent le noeud
		String str = "x += 2;";
		
		//Parse la str pour et on appel la fonction permet de generer le noeud désirer
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		TableSymbole ts = new TableSymbole();
		ts.put(new Symbole("x","main"), new Info("var","entier","main"));
		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("x","main"), new Info("var","entier","main"));
		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		memRef.declVar("x", new ValeurEntier(4), new SortEntier());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");
		memTest.declVar("x", new ValeurEntier(2), new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
	}
	
	
	@Test
	public void testASTet() throws Exception {
		String str =  "x = true && false;";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();

		TableSymbole ts = new TableSymbole();
		ts.put(new Symbole("x","main"), new Info("var","booleen","main"));
		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("x","main"), new Info("var","booleen","main"));
		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		
		memRef.declVar("x", new ValeurBooleen(false), new SortBooleen());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");
		memTest.declVar("x", new ValeurOmega(), new SortBooleen());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);

	}
	
	@Test
	public void testASTlisteExp() throws Exception {
		String str =  "1,2";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.listexp();

		TableSymbole ts = new TableSymbole();
		
		Element e = new Element();
		e.setValeur(new ValeurEntier(1));
		Element eSuivant = new Element();
		eSuivant.setValeur(new ValeurEntier(2));
		e.setSuivant(eSuivant);
		
		Element test =new Element();
		
		TableSymbole tsTest = new TableSymbole();
		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("f");
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("f");
		
		//Appel du visiteur
		test = (Element) n.jjtAccept(visitor, memTest);
		
		Assert.assertTrue(memRef.equals(memTest)&& e.equals(test));

	}
	
	
	@Test
	public void testASTentetes() throws Exception {
		String str =  "int x, int a";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.entetes();

		TableSymbole ts = new TableSymbole();
		ts.put(new Symbole("x","f"), new Info("var","entier","f"));
		ts.put(new Symbole("a","f"), new Info("var","entier","f"));
		
		Quad q1 = new Quad("x", new ValeurOmega(), new ObjetVariable(), new SortEntier());
		Quad q2 = new Quad("a", new ValeurOmega(), new ObjetVariable(), new SortEntier());
		
		Element e = new Element();
		e.setValeur(q1);
		Element eSuivant = new Element();
		eSuivant.setValeur(q2);
		e.setSuivant(eSuivant);
		
		Element test =new Element();
		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("x","f"), new Info("var","entier","f"));
		tsTest.put(new Symbole("a","f"), new Info("var","entier","f"));
		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("f");
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("f");
		
		//Appel du visiteur
		test = (Element) n.jjtAccept(visitor, memTest);
		
		Assert.assertTrue(memRef.equals(memTest)&& e.equals(test));

	}
	
	@Test
	public void testASTretour() throws Exception {
		String str =  "return 2;";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();

		TableSymbole ts = new TableSymbole();
		ts.put(new Symbole("C","class"), new Info("var","booleen","class"));
		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("C","class"), new Info("var","booleen","class"));
		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("class");
		
		memRef.declVar("C", new ValeurEntier(2), new SortOmega());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("class");
		memTest.declVar("C", new ValeurOmega(), new SortOmega());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);

	}
	
	
	@Test
	public void testASTDecls() throws Exception {
		String str =  "void test(){};"+  
					  "int x;"+
					  "int y = 10;"+
					  "final boolean b1 = false;"+
					  "boolean b2;";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.decls();

		TableSymbole ts = new TableSymbole();
				
		ts.put(new Symbole("test","class"), new Info("meth","vide","class","vide"));
		ts.put(new Symbole("x","class"), new Info("var","entier","class"));
		ts.put(new Symbole("y","class"), new Info("var","entier","class"));
		ts.put(new Symbole("b1","class"), new Info("cst","booleen","class"));
		ts.put(new Symbole("b2","class"), new Info("var","booleen","class"));
		
		
		TableSymbole tsTest = new TableSymbole();
		
		tsTest.put(new Symbole("test","class"), new Info("meth","vide","class","vide"));
		tsTest.put(new Symbole("x","class"), new Info("var","entier","class"));
		tsTest.put(new Symbole("y","class"), new Info("var","entier","class"));
		tsTest.put(new Symbole("b1","class"), new Info("cst","booleen","class"));
		tsTest.put(new Symbole("b2","class"), new Info("var","booleen","class"));

		

		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("class");
		
		memRef.declMeth("test",new ValeurMethode(n.jjtGetChild(0)),new SortVide());
		memRef.declVar("x", new ValeurOmega(), new SortEntier());
		memRef.declVar("y", new ValeurEntier(10), new SortEntier());
		memRef.declCst("b1", new ValeurBooleen(false), new SortBooleen());
		memRef.declVar("b2", new ValeurOmega(), new SortBooleen());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("class");
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		

		Assert.assertEquals(memRef, memTest);
		
	}
	
	@Test
	public void testASTPlus() throws Exception {
		String str =  "x = 10 + 12;";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();

		TableSymbole ts = new TableSymbole();
	
		ts.put(new Symbole("x","main"), new Info("var","entier","main"));
		
		TableSymbole tsTest = new TableSymbole();
		
		tsTest.put(new Symbole("x","main"), new Info("var","entier","main"));

		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		
		memRef.declVar("x", new ValeurEntier(22), new SortEntier());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");
		memTest.declVar("x", new ValeurOmega(), new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
		
	}
	
	@Test
	public void testASTDiv() throws Exception {
		String str =  "x = 30 / 2;";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();

		TableSymbole ts = new TableSymbole();
	
		ts.put(new Symbole("x","main"), new Info("var","entier","main"));
		
		TableSymbole tsTest = new TableSymbole();
		
		tsTest.put(new Symbole("x","main"), new Info("var","entier","main"));

		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		
		memRef.declVar("x", new ValeurEntier(15), new SortEntier());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");
		memTest.declVar("x", new ValeurOmega(), new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
		
	}
	
	
	
	@Test
	public void testASTMult() throws Exception {
		String str =  "x = 30 * 2;";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();

		TableSymbole ts = new TableSymbole();
	
		ts.put(new Symbole("x","main"), new Info("var","entier","main"));
		
		TableSymbole tsTest = new TableSymbole();
		
		tsTest.put(new Symbole("x","main"), new Info("var","entier","main"));

		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		
		memRef.declVar("x", new ValeurEntier(60), new SortEntier());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");
		memTest.declVar("x", new ValeurOmega(), new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
		
	}
	
	@Test
	public void testASTMoins() throws Exception {
		String str =  "x = 30 - 2;";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();

		TableSymbole ts = new TableSymbole();
	
		ts.put(new Symbole("x","main"), new Info("var","entier","main"));
		
		TableSymbole tsTest = new TableSymbole();
		
		tsTest.put(new Symbole("x","main"), new Info("var","entier","main"));

		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		
		memRef.declVar("x", new ValeurEntier(28), new SortEntier());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");
		memTest.declVar("x", new ValeurOmega(), new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
		
	}
	
	@Test
	public void testASTNeg() throws Exception {
		String str =  "x = -30 ;";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();

		TableSymbole ts = new TableSymbole();
	
		ts.put(new Symbole("x","main"), new Info("var","entier","main"));
		
		TableSymbole tsTest = new TableSymbole();
		
		tsTest.put(new Symbole("x","main"), new Info("var","entier","main"));

		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		
		memRef.declVar("x", new ValeurEntier(-30), new SortEntier());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");
		memTest.declVar("x", new ValeurOmega(), new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
		
	}
	
	@Test
	public void testASTNot() throws Exception {
		String str =  "x =! true;";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();

		TableSymbole ts = new TableSymbole();
		ts.put(new Symbole("x","main"), new Info("var","booleen","main"));
		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("x","main"), new Info("var","booleen","main"));
		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		
		memRef.declVar("x", new ValeurBooleen(false), new SortBooleen());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");
		memTest.declVar("x", new ValeurOmega(), new SortBooleen());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
		
	}
	
	
	@Test
	public void testASTEgal() throws Exception {
		String str = "x=1 == 2;";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();

		TableSymbole ts = new TableSymbole();
		ts.put(new Symbole("x","main"), new Info("var","booleen","main"));
		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("x","main"), new Info("var","booleen","main"));
		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		memRef.declVar("x", new ValeurBooleen(false), new SortBooleen());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");
		memTest.declVar("x", new ValeurOmega(), new SortBooleen());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
		
	}
	

	@Test
	public void testASTOu() throws Exception {
		String str =  "x = true || false;";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();

		TableSymbole ts = new TableSymbole();
		ts.put(new Symbole("x","main"), new Info("var","booleen","main"));
		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("x","main"), new Info("var","booleen","main"));
		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		
		memRef.declVar("x", new ValeurBooleen(true), new SortBooleen());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");
		memTest.declVar("x", new ValeurOmega(), new SortBooleen());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
	}
	
	
	
	@Test
	public void testASTSup() throws Exception {
		String str =  "x = 30 > 2;";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();

		TableSymbole ts = new TableSymbole();
	
		ts.put(new Symbole("x","main"), new Info("var","booleen","main"));
		
		TableSymbole tsTest = new TableSymbole();
		
		tsTest.put(new Symbole("x","main"), new Info("var","booleen","main"));

		
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		
		memRef.declVar("x", new ValeurBooleen(true), new SortBooleen());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");
		memTest.declVar("x", new ValeurOmega(), new SortBooleen());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
		
	}
	
	
	
	
	
	@Test
	public void testASTVars() throws Exception {
		String str = "int tab[5];";
	
	parser = new MiniJaja(str);
	SimpleNode n = parser.vars();

	TableSymbole ts = new TableSymbole();
			
	ts.put(new Symbole("tab","main"), new Info("tab","entier","main"));
	
	
	TableSymbole tsTest = new TableSymbole();
	
	tsTest.put(new Symbole("tab","main"), new Info("tab","entier","main"));

	MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
	memRef.setNomClass("C");
	memRef.setPortee("main");
	
	memRef.declTab("tab", new ValeurEntier(5), new SortEntier());
	
	//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
	MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
	memTest.setNomClass("C");
	memTest.setPortee("main");
	
	//Appel du visiteur
	n.jjtAccept(visitor, memTest);
	
	Assert.assertEquals(memRef, memTest);
	
	}
	
	@Test
	public void testASTtab() throws Exception {
		String str = "tab[4]=5; tab[4]+=2; tab[4]++;";
	
	parser = new MiniJaja(str);
	SimpleNode n = parser.instrs();

	TableSymbole ts = new TableSymbole();	
	ts.put(new Symbole("tab","main"), new Info("tab","entier","main"));
	
	TableSymbole tsTest = new TableSymbole();
	tsTest.put(new Symbole("tab","main"), new Info("tab","entier","main"));

	MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
	memRef.setNomClass("C");
	memRef.setPortee("main");
	
	memRef.declTab("tab", new ValeurEntier(5), new SortEntier());
	ValeurTab vtab = (ValeurTab) memRef.val("tab");
	memRef.affecterValT(vtab, new ValeurEntier(8),new ValeurEntier(4));
	
	//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
	MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
	memTest.setNomClass("C");
	memTest.setPortee("main");
	memTest.declTab("tab", new ValeurEntier(5), new SortEntier());
	
	//Appel du visiteur
	n.jjtAccept(visitor, memTest);
	
	Assert.assertEquals(memRef, memTest);
	
	}
	
	@Test
	public void testASTAppelE() throws Exception {
		String strMeth = "int anthony(){return 2;};";
		parser = new MiniJaja(strMeth);
		SimpleNode nMethode = (SimpleNode) (parser.decls()).jjtGetChild(0);
		
		String str = "x = anthony();";
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();
	
		TableSymbole ts = new TableSymbole();
		ts.put(new Symbole("C","class"), new Info("var","omega","class"));
		ts.put(new Symbole("anthony","class"), new Info("anthony","entier","class", "vide"));
		ts.put(new Symbole("x","main"), new Info("x","entier","main"));
		
		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("C","class"), new Info("var","omega","class"));
		tsTest.put(new Symbole("anthony","class"), new Info("anthony","entier","class","vide"));
		tsTest.put(new Symbole("x","main"), new Info("x","entier","main"));
		
	
		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("class");
		memRef.declVar("C", new ValeurEntier(2), new SortOmega());
		memRef.declMeth("anthony", new ValeurMethode(nMethode), new SortEntier());
		memRef.setPortee("main");
		
		
		memRef.declVar("x", new ValeurEntier(2), new SortEntier());
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("class");
		memTest.declVar("C", new ValeurOmega(), new SortOmega());
		memTest.declMeth("anthony", new ValeurMethode(nMethode), new SortEntier());
		memTest.setPortee("main");
		
		memTest.declVar("x", new ValeurOmega(), new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
	
	}
	
	@Test(expected=MiniJajaException.class)
	public void testIdentTableSymboleAbsent() throws Exception
	{
		String str = "int x;";
		parser = new MiniJaja(str);
		SimpleNode n = parser.vars();

		
		TableSymbole tsTest = new TableSymbole();

		
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");	
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testTabTropGrand() throws Exception
	{
		String str = "int x[1020];";
		parser = new MiniJaja(str);
		SimpleNode n = parser.vars();

		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("x","main"), new Info("x","entier","main"));
		
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");	
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testTabTailleNeg() throws Exception
	{
		String str = "int x[-12];";
		parser = new MiniJaja(str);
		SimpleNode n = parser.vars();

		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("x","main"), new Info("x","entier","main"));
		
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");	
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testTabHorsTab() throws Exception
	{
		String str = "int x[12]; int y = x[12];";
		parser = new MiniJaja(str);
		SimpleNode n = parser.vars();

		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("x","main"), new Info("x","entier","main"));
		tsTest.put(new Symbole("y","main"), new Info("y","entier","main"));
		
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");	
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testAppeliNoeudAbsent() throws Exception
	{
		String str = "f();";
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("f","class"), new Info("f","entier","class","vide"));
		
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("class");	
		
		memTest.declVar("f", new ValeurMethode(n), new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
				
		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testDiv() throws Exception
	{
		String str = "x=1/0;";
		parser = new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("x","main"), new Info("x","entier","main"));
		
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("main");	
		
		memTest.declVar("x", new ValeurEntier(5), new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
				
		Assert.assertTrue(false);
	}
}


