package interpreteur_MiniJaja;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univfcomte.comp4.analyseur.MiniJaja;
import fr.univfcomte.comp4.analyseur.ParseException;
import fr.univfcomte.comp4.analyseur.SimpleNode;
import fr.univfcomte.comp4.interpreteur_MiniJaja.MiniJajaRetraitVisitor;
import fr.univfcomte.comp4.memoire_MiniJaja.MemoireMiniJaja;
import fr.univfcomte.comp4.quadruplet.SortBooleen;
import fr.univfcomte.comp4.quadruplet.SortEntier;
import fr.univfcomte.comp4.quadruplet.SortVide;
import fr.univfcomte.comp4.quadruplet.ValeurBooleen;
import fr.univfcomte.comp4.quadruplet.ValeurEntier;
import fr.univfcomte.comp4.quadruplet.ValeurMethode;
import fr.univfcomte.comp4.quadruplet.ValeurOmega;
import fr.univfcomte.comp4.table_hachage.Info;
import fr.univfcomte.comp4.table_hachage.Symbole;
import fr.univfcomte.comp4.table_hachage.TableSymbole;
import junit.framework.Assert;

public class TestMiniJajaRetraitVisitor {
	
	 MiniJaja parser;
	//Creation du visiteur
	 MiniJajaRetraitVisitor visitor = new MiniJajaRetraitVisitor();
	
	@Test
	public void testASTDecls() throws Exception {
		String str =  "void test(){};"+  
					  "int x;"+
					  "int y = 10;"+
					  "final boolean b1 = false;"+
					  "boolean b2;"
					  + "int tab[12];";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.decls();

		TableSymbole ts = new TableSymbole();
		ts.put(new Symbole("test","class"), new Info("meth","vide","class","vide"));
		ts.put(new Symbole("x","class"), new Info("var","entier","class"));
		ts.put(new Symbole("y","class"), new Info("var","entier","class"));
		ts.put(new Symbole("b1","class"), new Info("cst","booleen","class"));
		ts.put(new Symbole("b2","class"), new Info("var","booleen","class"));
		ts.put(new Symbole("tab","class"), new Info("tab","booleen","class"));
		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("test","class"), new Info("meth","vide","class","vide"));
		tsTest.put(new Symbole("x","class"), new Info("var","entier","class"));
		tsTest.put(new Symbole("y","class"), new Info("var","entier","class"));
		tsTest.put(new Symbole("b1","class"), new Info("cst","booleen","class"));
		tsTest.put(new Symbole("b2","class"), new Info("var","booleen","class"));
		tsTest.put(new Symbole("tab","class"), new Info("tab","booleen","class"));

		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("class");
		
		memRef.getTas().setIdTableId(1);
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("class");
		
		
		memTest.declMeth("test",new ValeurMethode(n.jjtGetChild(0)),new SortVide());
		memTest.declVar("x", new ValeurOmega(), new SortEntier());
		memTest.declVar("y", new ValeurEntier(10), new SortEntier());
		memTest.declCst("b1", new ValeurBooleen(false), new SortBooleen());
		memTest.declVar("b2", new ValeurOmega(), new SortBooleen());
		memTest.declTab("tab", new ValeurEntier(12),  new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
		
	}
	
	@Test
	public void testASTVars() throws Exception {
		
		String str = "class C {main{int x;}}";
		
		parser = new MiniJaja(str);
		SimpleNode n = parser.classe();
		
		TableSymbole ts = new TableSymbole();	
		ts.put(new Symbole("C","class"), new Info("var","entier","class"));
		ts.put(new Symbole("x","main"), new Info("var","entier","class"));

		
		TableSymbole tsTest = new TableSymbole();
		tsTest.put(new Symbole("C","class"), new Info("var","entier","class"));
		tsTest.put(new Symbole("x","main"), new Info("var","entier","class"));

		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("main");
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		
		memTest.setPortee("class");	
		memTest.declVar("C", new ValeurOmega(), new SortEntier());

		memTest.setPortee("main");
		memTest.declVar("x", new ValeurOmega(), new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		

		Assert.assertEquals(memRef, memTest);
		
	}

	@Test
	public void testRetraitAppelI() throws Exception
	{

		String strMeth = "void test(int a){int b;};";
		parser = new MiniJaja(strMeth);
		SimpleNode nMeth =(SimpleNode) parser.decls().jjtGetChild(0);
		
		String str = "test(2);";
		parser = new MiniJaja(str);
		SimpleNode n =(SimpleNode) parser.instrs().jjtGetChild(0);

		TableSymbole ts = new TableSymbole();	

		ts.put(new Symbole("test","class"), new Info("meth","vide","class","entier"));
		ts.put(new Symbole("a","test"), new Info("var","entier","test"));
		ts.put(new Symbole("b","test"), new Info("var","entier","test"));

		
		TableSymbole tsTest = new TableSymbole();

		tsTest.put(new Symbole("test","class"), new Info("meth","vide","class","entier"));
		tsTest.put(new Symbole("a","test"), new Info("var","entier","test"));
		tsTest.put(new Symbole("b","test"), new Info("var","entier","test"));

		MemoireMiniJaja memRef = new MemoireMiniJaja(ts);
		memRef.setNomClass("C");
		memRef.setPortee("class");
		
		memRef.declMeth("test",new ValeurMethode(nMeth), new SortVide());
		memRef.setPortee("test");
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		MemoireMiniJaja memTest = new MemoireMiniJaja(tsTest);
		memTest.setNomClass("C");
		memTest.setPortee("class");
		
		memTest.declMeth("test",new ValeurMethode(nMeth), new SortVide());
		memTest.setPortee("test");
		memTest.declVar("a", new ValeurEntier(2), new SortEntier());
		memTest.declVar("b", new ValeurOmega(), new SortEntier());
		
		//Appel du visiteur
		n.jjtAccept(visitor, memTest);
		
		Assert.assertEquals(memRef, memTest);
		
	}
}
