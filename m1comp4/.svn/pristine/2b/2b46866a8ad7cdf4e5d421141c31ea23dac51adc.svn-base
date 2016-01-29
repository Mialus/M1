package fr.univfcomte.comp4.controle_type;

import static org.junit.Assert.*;

import org.junit.Test;
import fr.univfcomte.comp4.analyseur.*;
import fr.univfcomte.comp4.table_hachage.Info;
import fr.univfcomte.comp4.table_hachage.Symbole;
import junit.framework.Assert;

public class TestControleTypeVisitor {

	MiniJaja parser = null;
	//Creation du visiteur
	ControleTypeVisitor visitor = new ControleTypeVisitor();
	
	@Test
	public void testASTClasse() throws ParseException, MiniJajaException {
		//Creation du noeud de l'AST a tester
		//Ecrit une str qui represent le noeud
		String str = "class C {"+
					"main{}}";
		
		//Parse la str pour et on appel la fonction permet de generer le noeud désirer
		parser = new MiniJaja(str);
		SimpleNode n = parser.classe();
		
		//Le visiteur prend en paramètre un noeud et une memoire de type DataControleType
		//Il modifie la memoire en y ajoutant les variable déclarée lors du controle de type
		
		//On créer une memoire de reference. c'est la memoire attendue à la fin de l'excution du visiteur
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("class");
		cdRef.getTableSymbole().put(new Symbole("C","class"), 
				new Info("var","omega","class"));
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		DataControleType cdTest = new DataControleType();
		
		//Appel du visiteur
		n.jjtAccept(visitor, cdTest);
		
		Assert.assertEquals(cdRef, cdTest);
	}
	
	@Test(expected= MiniJajaException.class)
	public void testASTidentException() throws ParseException, MiniJajaException
	{
		String str = "a";
		parser = new MiniJaja(str);
		SimpleNode n = parser.ident();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("class");
		
		n.jjtAccept(visitor, cdRef);
		
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void testASTident() throws ParseException, MiniJajaException
	{
		String str = "a";
		parser = new MiniJaja(str);
		SimpleNode n = parser.ident();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("class");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("class");
		
		Info infoRef = new Info("var","entier","class");
		Info infoTest = null;
		cdRef.getTableSymbole().put(new Symbole("a","class"),infoRef);
		cdTest.getTableSymbole().put(new Symbole("a","class"),infoRef);
		
		infoTest = (Info)n.jjtAccept(visitor, cdTest);
		
		Assert.assertTrue(infoRef.equals(infoTest) && cdRef.equals(cdTest));
		
	}
	
	
	@Test(expected=MiniJajaException.class)
	public void testASTmethodeFail() throws ParseException, MiniJajaException
	{
		//Test si le nom a déjà été déclaré
		String str ="void f (){};";
		parser = new MiniJaja(str);
		SimpleNode n = parser.decl();
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("class");
		
		cdTest.getTableSymbole().put(new Symbole("f","class"),new Info("meth","vide","class", "vide"));
		
		n.jjtAccept(visitor, cdTest);
		
		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTtabFail1() throws ParseException, MiniJajaException
	{
		//Test si de "a" dans le cas où a n'est pas un entier
		String str ="int tab[a];";
		parser = new MiniJaja(str);
		SimpleNode n = parser.decl();
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("class");
		cdTest.getTableSymbole().put(new Symbole("a","class"),new Info("var","vide","class", "vide"));
		cdTest.getTableSymbole().put(new Symbole("f","class"),new Info("meth","vide","class", "vide"));
		
		n.jjtAccept(visitor, cdTest);
		
		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTtabFail2() throws ParseException, MiniJajaException
	{
		//Test si de "a" dans le cas où a n'est pas une constante ou une var
		String str ="int tab[a];";
		parser = new MiniJaja(str);
		SimpleNode n = parser.decl();
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("class");
		cdTest.getTableSymbole().put(new Symbole("a","class"),new Info("meth","vide","class", "vide"));
		cdTest.getTableSymbole().put(new Symbole("f","class"),new Info("meth","vide","class", "vide"));
		
		n.jjtAccept(visitor, cdTest);
		
		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTvarAvecObjectNonVarOuCst() throws ParseException, MiniJajaException
	{
		//Test si de "a" dans le cas où a n'est pas une constante ou une var
		String str ="int x = a;";
		parser = new MiniJaja(str);
		SimpleNode n = parser.decl();
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("class");
		cdTest.getTableSymbole().put(new Symbole("a","class"),new Info("meth","vide","class", "vide"));
		
		
		n.jjtAccept(visitor, cdTest);
		
		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTvarAvecTypeDifferent() throws ParseException, MiniJajaException
	{
		//Test si de "a" dans le cas où a n'est pas une constante ou une var
		String str ="int x = a;";
		parser = new MiniJaja(str);
		SimpleNode n = parser.decl();
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("class");
		cdTest.getTableSymbole().put(new Symbole("a","class"),new Info("var","booleen","class"));
		
		n.jjtAccept(visitor, cdTest);
		
		Assert.assertTrue(false);
	}
	
	
	@Test
	public void testASTdecls() throws ParseException, MiniJajaException
	{
		//Test des différentes déclarations possibles
		String str = "int a; "
				+ "int c = 5;"
				+ "final int b;"
				+ "boolean tab[5];"
				+ "void f (){};";
		parser = new MiniJaja(str);
		SimpleNode n = parser.decls();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("class");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("class");
		
		cdRef.getTableSymbole().put(new Symbole("a","class"),new Info("var","entier","class"));
		cdRef.getTableSymbole().put(new Symbole("b","class"),new Info("cst","entier","class"));
		cdRef.getTableSymbole().put(new Symbole("c","class"),new Info("var","entier","class"));
		cdRef.getTableSymbole().put(new Symbole("tab","class"),new Info("tab","booleen","class"));
		cdRef.getTableSymbole().put(new Symbole("f","class"),new Info("meth","vide","class", "vide"));
		
		n.jjtAccept(visitor, cdTest);
		
		Assert.assertEquals(cdRef, cdTest);
	}
	
	@Test
	public void testASTvars() throws ParseException, MiniJajaException
	{
		//Test des différentes déclarations possibles
		String str = "int a; "
				+ "int c = 5;";
		parser = new MiniJaja(str);
		SimpleNode n = parser.vars();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("class");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("class");
		
		cdRef.getTableSymbole().put(new Symbole("a","class"),new Info("var","entier","class"));
		cdRef.getTableSymbole().put(new Symbole("c","class"),new Info("var","entier","class"));
		
		n.jjtAccept(visitor, cdTest);
		
		Assert.assertEquals(cdRef, cdTest);
	}

	@Test
	public void testEntetes() throws ParseException, MiniJajaException
	{
		String str = "int a, boolean b, int c";
		parser = new MiniJaja(str);
		SimpleNode n = parser.entetes();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("fct");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("fct");
		
		cdRef.getTableSymbole().put(new Symbole("a","fct"),new Info("var","entier","fct"));
		cdRef.getTableSymbole().put(new Symbole("b","fct"),new Info("var","booleen","fct"));
		cdRef.getTableSymbole().put(new Symbole("c","fct"),new Info("var","entier","fct"));
		
		String res = (String) n.jjtAccept(visitor, cdTest);
		
		Assert.assertTrue(res.equals("entierXbooleenXentier") && cdRef.equals(cdTest));
	}
	
	@Test
	public void testInstrs() throws ParseException, MiniJajaException
	{
		//Test de toutes les instructions possibles
		String str = "if(true){a=5;}else{a+=5;};"+
		"while(tab[a]>10){a++;};"+
		"tab = tab2;"+
		"f3(1,true);"+
		"return f2(a);";
		
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();

		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("f");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("f");
		
		cdRef.getTableSymbole().put(new Symbole("a","f"),new Info("var","entier","f"));
		cdRef.getTableSymbole().put(new Symbole("tab","class"), new Info("tab","entier","class"));
		cdRef.getTableSymbole().put(new Symbole("tab2","class"), new Info("tab","entier","class"));
		cdRef.getTableSymbole().put(new Symbole("f","class"),new Info("meth","booleen","class","vide"));
		cdRef.getTableSymbole().put(new Symbole("f2","class"),new Info("meth","booleen","class","entier"));
		cdRef.getTableSymbole().put(new Symbole("f3","class"),new Info("meth","booleen","class","entierXbooleen"));
		
		cdTest.getTableSymbole().put(new Symbole("a","f"),new Info("var","entier","f"));
		cdTest.getTableSymbole().put(new Symbole("tab","class"), new Info("tab","entier","class"));
		cdTest.getTableSymbole().put(new Symbole("tab2","class"), new Info("tab","entier","class"));
		cdTest.getTableSymbole().put(new Symbole("f","class"),new Info("meth","booleen","class","vide"));
		cdTest.getTableSymbole().put(new Symbole("f2","class"),new Info("meth","booleen","class","entier"));
		cdTest.getTableSymbole().put(new Symbole("f3","class"),new Info("meth","booleen","class","entierXbooleen"));
		n.jjtAccept(visitor, cdTest);
		Assert.assertEquals(cdRef, cdTest);
	}
	
	@Test
	public void testOperations() throws ParseException, MiniJajaException
	{
		String str = "x=1+1; x=1*1; x=1-1; x=1/1; x=-1;"+
					"y=true && false; y=true || false; y=true == false; y=!f(x);";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();

		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		cdRef.getTableSymbole().put(new Symbole("y","main"),new Info("var","booleen","main"));
		cdRef.getTableSymbole().put(new Symbole("f","class"),new Info("meth","booleen","class","entier"));
		
		cdTest.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		cdTest.getTableSymbole().put(new Symbole("y","main"),new Info("var","booleen","main"));
		cdTest.getTableSymbole().put(new Symbole("f","class"),new Info("meth","booleen","class","entier"));
		

		n.jjtAccept(visitor, cdTest);

		Assert.assertEquals(cdRef, cdTest);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTtabAvecVariableNonTab() throws ParseException, MiniJajaException
	{
		String str = "x = a[1];";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		cdRef.getTableSymbole().put(new Symbole("a","main"),new Info("var","entier","main"));
		
		cdTest.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		cdTest.getTableSymbole().put(new Symbole("a","main"),new Info("var","entier","main"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTASTtabAvecIndiceNonEntier() throws ParseException, MiniJajaException
	{
		String str = "x = tab[true];";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		cdRef.getTableSymbole().put(new Symbole("tab","main"),new Info("tab","entier","main"));
		
		cdTest.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		cdTest.getTableSymbole().put(new Symbole("tab","main"),new Info("tab","entier","main"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTAffectationTabVar() throws ParseException, MiniJajaException
	{
		String str = "tab = x;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		cdRef.getTableSymbole().put(new Symbole("tab","main"),new Info("tab","entier","main"));
		
		cdTest.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		cdTest.getTableSymbole().put(new Symbole("tab","main"),new Info("tab","entier","main"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTAffectationVarTab() throws ParseException, MiniJajaException
	{
		String str = "x = tab;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		cdRef.getTableSymbole().put(new Symbole("tab","main"),new Info("tab","entier","main"));
		
		cdTest.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		cdTest.getTableSymbole().put(new Symbole("tab","main"),new Info("tab","entier","main"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTAffectationTabsTypeDiff() throws ParseException, MiniJajaException
	{
		String str = "tab = tab2;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("tab","main"),new Info("tab","entier","main"));
		cdRef.getTableSymbole().put(new Symbole("tab2","main"),new Info("tab","booleen","main"));
		
		cdTest.getTableSymbole().put(new Symbole("tab","main"),new Info("tab","entier","main"));
		cdTest.getTableSymbole().put(new Symbole("tab2","main"),new Info("tab","booleen","main"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTAffectationMethode() throws ParseException, MiniJajaException
	{
		String str = "meth = x;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		cdRef.getTableSymbole().put(new Symbole("meth","class"),new Info("meth","entier","class","entier"));
		
		cdTest.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		cdTest.getTableSymbole().put(new Symbole("meth","class"),new Info("meth","entier","class","entier"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTAffectationTypesDifferents() throws ParseException, MiniJajaException
	{
		String str = "y = x;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		cdRef.getTableSymbole().put(new Symbole("y","main"),new Info("var","booleen","main"));
		
		cdTest.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		cdTest.getTableSymbole().put(new Symbole("y","main"),new Info("var","booleen","main"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTSommeTab() throws ParseException, MiniJajaException
	{
		String str = "tab += 5;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("tab","main"),new Info("tab","entier","main"));
		
		cdTest.getTableSymbole().put(new Symbole("tab","main"),new Info("tab","entier","main"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTSommeMeth() throws ParseException, MiniJajaException
	{
		String str = "meth += 5;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("meth","class"),new Info("meth","entier","class","vide"));
		
		cdTest.getTableSymbole().put(new Symbole("meth","class"),new Info("meth","entier","class","vide"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTSommeVarAvecBoolen() throws ParseException, MiniJajaException
	{
		String str = "x += true;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		
		cdTest.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTAppelIAvecVar() throws ParseException, MiniJajaException
	{
		String str = "x();";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		
		cdTest.getTableSymbole().put(new Symbole("x","main"),new Info("var","entier","main"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTAppelIAvecMauvaisParam() throws ParseException, MiniJajaException
	{
		String str = "f(true,1);";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("f","class"),new Info("meth","entier","class","entierXboolen"));
		
		cdTest.getTableSymbole().put(new Symbole("f","class"),new Info("meth","entier","class","entierXboolen"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTRetourMauvaisTypeRetour() throws ParseException, MiniJajaException
	{
		String str = "return 9;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("f");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("f");
		
		cdRef.getTableSymbole().put(new Symbole("f","class"),new Info("meth","booleen","class","vide"));
		
		cdTest.getTableSymbole().put(new Symbole("f","class"),new Info("meth","booleen","class","vide"));

		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTRetourMethNonDecl() throws ParseException, MiniJajaException
	{
		String str = "return meth();";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("f");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("f");
		
		cdRef.getTableSymbole().put(new Symbole("meth","class"),new Info("meth","entier","class","vide"));

		cdTest.getTableSymbole().put(new Symbole("meth","class"),new Info("meth","entier","class","vide"));

		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTRetourMauvaisObjet() throws ParseException, MiniJajaException
	{
		String str = "return meth;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("f");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("f");
		
		cdRef.getTableSymbole().put(new Symbole("f","class"),new Info("meth","entier","class","vide"));
		cdRef.getTableSymbole().put(new Symbole("meth","class"),new Info("meth","entier","class","vide"));

		cdTest.getTableSymbole().put(new Symbole("f","class"),new Info("meth","entier","class","vide"));
		cdTest.getTableSymbole().put(new Symbole("meth","class"),new Info("meth","entier","class","vide"));

		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testASTSiCondNonBool() throws ParseException, MiniJajaException
	{
		String str = "if(1){f();};";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("f");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("f");
		
		cdRef.getTableSymbole().put(new Symbole("f","class"),new Info("meth","entier","class","vide"));
		
		cdTest.getTableSymbole().put(new Symbole("f","class"),new Info("meth","entier","class","vide"));

		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testOp2MauvaisType() throws ParseException, MiniJajaException
	{
		String str = "x = true && y;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("x","main"),new Info("var","booleen","main"));
		cdRef.getTableSymbole().put(new Symbole("y","main"),new Info("var","entier","main"));

		cdTest.getTableSymbole().put(new Symbole("x","main"),new Info("var","booleen","class"));
		cdTest.getTableSymbole().put(new Symbole("y","main"),new Info("var","entier","class"));

		n.jjtAccept(visitor, cdTest);
		
		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testOp2MauvaisObjetDroite() throws ParseException, MiniJajaException
	{
		String str = "x = 1 && f;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("f","class"),new Info("meth","booleen","class","vide"));
		cdRef.getTableSymbole().put(new Symbole("x","main"),new Info("var","booleen","main"));

		cdTest.getTableSymbole().put(new Symbole("x","main"),new Info("var","booleen","main"));
		cdTest.getTableSymbole().put(new Symbole("f","class"),new Info("meth","booleen","class","vide"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testOp2MauvaisObjetGauche() throws ParseException, MiniJajaException
	{
		String str = "x = f && 1;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("f","class"),new Info("meth","booleen","class","vide"));
		cdRef.getTableSymbole().put(new Symbole("x","main"),new Info("var","booleen","main"));

		cdTest.getTableSymbole().put(new Symbole("x","main"),new Info("var","booleen","main"));
		cdTest.getTableSymbole().put(new Symbole("f","class"),new Info("meth","booleen","class","vide"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testOp1MauvaisType() throws ParseException, MiniJajaException
	{
		String str = "x =!1;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("f","class"),new Info("meth","booleen","class","vide"));
		cdRef.getTableSymbole().put(new Symbole("x","main"),new Info("var","booleen","main"));

		cdTest.getTableSymbole().put(new Symbole("x","main"),new Info("var","booleen","main"));
		cdTest.getTableSymbole().put(new Symbole("f","class"),new Info("meth","booleen","class","vide"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
	
	@Test(expected=MiniJajaException.class)
	public void testOp1MauvaisObjetDroite() throws ParseException, MiniJajaException
	{
		String str = "x = !f;";
		parser= new MiniJaja(str);
		SimpleNode n = parser.instrs();
		
		DataControleType cdRef = new DataControleType();
		cdRef.setPorteeCourante("main");
		
		DataControleType cdTest = new DataControleType();
		cdTest.setPorteeCourante("main");
		
		cdRef.getTableSymbole().put(new Symbole("f","class"),new Info("meth","booleen","class","vide"));
		cdRef.getTableSymbole().put(new Symbole("x","main"),new Info("var","booleen","main"));

		cdTest.getTableSymbole().put(new Symbole("x","main"),new Info("var","booleen","main"));
		cdTest.getTableSymbole().put(new Symbole("f","class"),new Info("meth","booleen","class","vide"));
		
		n.jjtAccept(visitor, cdTest);

		Assert.assertTrue(false);
	}
}


