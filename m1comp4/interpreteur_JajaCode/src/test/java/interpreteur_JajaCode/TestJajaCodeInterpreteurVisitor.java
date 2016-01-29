package interpreteur_JajaCode;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univfcomte.comp4.analyseur_JajaCode.JajaCode;
import fr.univfcomte.comp4.analyseur_JajaCode.JajaCodeException;
import fr.univfcomte.comp4.analyseur_JajaCode.ParseException;
import fr.univfcomte.comp4.analyseur_JajaCode.SimpleNode;
import fr.univfcomte.comp4.interpreteur_JajaCode.JajaCodeInterpreteurVisitor;
import fr.univfcomte.comp4.memoire.Memoire;
import fr.univfcomte.comp4.quadruplet.ObjetConstante;
import fr.univfcomte.comp4.quadruplet.ObjetTab;
import fr.univfcomte.comp4.quadruplet.ObjetVariable;
import fr.univfcomte.comp4.quadruplet.Quad;
import fr.univfcomte.comp4.quadruplet.SortBooleen;
import fr.univfcomte.comp4.quadruplet.SortEntier;
import fr.univfcomte.comp4.quadruplet.SortOmega;
import fr.univfcomte.comp4.quadruplet.SortVide;
import fr.univfcomte.comp4.quadruplet.Sorte;
import fr.univfcomte.comp4.quadruplet.Valeur;
import fr.univfcomte.comp4.quadruplet.ValeurBooleen;
import fr.univfcomte.comp4.quadruplet.ValeurEntier;
import fr.univfcomte.comp4.quadruplet.ValeurOmega;
import junit.framework.Assert;

public class TestJajaCodeInterpreteurVisitor {

	JajaCode parser = null;
	JajaCodeInterpreteurVisitor visitor = new JajaCodeInterpreteurVisitor();
	
	@Test
	public void testASTtype() throws ParseException, JajaCodeException {
		//Creation de la chaine a tester pour generer le noeud
		String str = "entier";
		parser = new JajaCode(str);
		
		//Parse la str pour et on appel la fonction permet de generer le noeud désirer
		SimpleNode n = parser.type();
		
		//Le visiteur prend en paramètre un noeud et une memoire de type Memoire
		//Il peut modifier la memoire en leur affectant ou retirant une valeur
		//Le constructeur prend en paramètre l'indice de la première ligne
		
		//On créer une memoire de reference. c'est la memoire attendue à la fin de l'excution du visiteur
		//On reprend dans le code les modifcations faites à la memoire lors de l'appel du visiteur
		Memoire memRef = new Memoire(1);
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		Memoire memTest = new Memoire(1);
		
		//On creer une valeur de retour reference car ici le visiteur retourne une valeur
		Sorte sRef = new SortEntier();
		
		Sorte sTest = null;
		
		sTest =(Sorte) n.jjtAccept(visitor, memTest);
		
		//On test deux elements mais on doit utiliser qu'un seul Assert
		Assert.assertTrue(sRef.equals(sTest) && memRef.equals(memTest));
	}
	
	@Test
	public void testASTtypeBooleen() throws ParseException, JajaCodeException {
		//Creation de la chaine a tester pour generer le noeud
		String str = "booleen";
		parser = new JajaCode(str);
		
		//Parse la str pour et on appel la fonction permet de generer le noeud désirer
		SimpleNode n = parser.type();
		
		//Le visiteur prend en paramètre un noeud et une memoire de type Memoire
		//Il peut modifier la memoire en leur affectant ou retirant une valeur
		//Le constructeur prend en paramètre l'indice de la première ligne
		
		//On créer une memoire de reference. c'est la memoire attendue à la fin de l'excution du visiteur
		//On reprend dans le code les modifcations faites à la memoire lors de l'appel du visiteur
		Memoire memRef = new Memoire(1);
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		Memoire memTest = new Memoire(1);
		
		//On creer une valeur de retour reference car ici le visiteur retourne une valeur
		Sorte sRef = new SortBooleen();
		
		Sorte sTest = null;
		
		sTest =(Sorte) n.jjtAccept(visitor, memTest);
		
		//On test deux elements mais on doit utiliser qu'un seul Assert
		Assert.assertTrue(sRef.equals(sTest) && memRef.equals(memTest));
	}
	
	@Test
	public void testASTtypeVide() throws ParseException, JajaCodeException {
		//Creation de la chaine a tester pour generer le noeud
		String str = "vide";
		parser = new JajaCode(str);
		
		//Parse la str pour et on appel la fonction permet de generer le noeud désirer
		SimpleNode n = parser.type();
		
		//Le visiteur prend en paramètre un noeud et une memoire de type Memoire
		//Il peut modifier la memoire en leur affectant ou retirant une valeur
		//Le constructeur prend en paramètre l'indice de la première ligne
		
		//On créer une memoire de reference. c'est la memoire attendue à la fin de l'excution du visiteur
		//On reprend dans le code les modifcations faites à la memoire lors de l'appel du visiteur
		Memoire memRef = new Memoire(1);
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		Memoire memTest = new Memoire(1);
		
		//On creer une valeur de retour reference car ici le visiteur retourne une valeur
		Sorte sRef = new SortVide();
		
		Sorte sTest = null;
		
		sTest =(Sorte) n.jjtAccept(visitor, memTest);
		
		//On test deux elements mais on doit utiliser qu'un seul Assert
		Assert.assertTrue(sRef.equals(sTest) && memRef.equals(memTest));
	}
	
	
	
		@Test
	public void testASTinvoke() throws ParseException, JajaCodeException {
		//Creation de la chaine a tester pour generer le noeud
		String str = "invoke(x)";
		parser = new JajaCode(str);
		
		//Parse la str pour et on appel la fonction permet de generer le noeud désirer
		SimpleNode n = parser.instrs();
		
		//Le visiteur prend en paramètre un noeud et une memoire de type Memoire
		//Il peut modifier la memoire en leur affectant ou retirant une valeur
		//Le constructeur prend en paramètre l'indice de la première ligne
		
		//On créer une memoire de reference. c'est la memoire attendue à la fin de l'excution du visiteur
		//On reprend dans le code les modifcations faites à la memoire lors de l'appel du visiteur
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("x",new ValeurEntier(6),new ObjetConstante(),new SortOmega());
		Quad q1 = new Quad("w",new ValeurEntier(2),new ObjetConstante(),new SortOmega());
		
		memRef.empiler(q);
		memRef.empiler(q1);
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		Memoire memTest = new Memoire(1);
		memTest.empiler(q);
		
		
		//On creer une valeur de retour reference car ici le visiteur retourne une valeur
		n.jjtAccept(visitor, memTest);
		
		
		int adresseTest = visitor.getLigneInstruction();
		//On test deux elements mais on doit utiliser qu'un seul Assert
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 6);
	}
		
	@Test
	public void testASTinit() throws ParseException, JajaCodeException {
		//Creation de la chaine a tester pour generer le noeud
		String str = "init";
		parser = new JajaCode(str);
		
		//Parse la str pour et on appel la fonction permet de generer le noeud désirer
		SimpleNode n = parser.instrs();
		
		//On créer une memoire de reference. c'est la memoire attendue à la fin de l'excution du visiteur
		//On reprend dans le code les modifcations faites à la memoire lors de l'appel du visiteur
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("x",new ValeurEntier(6),new ObjetConstante(),new SortOmega());
		
		memRef.empiler(q);
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		Memoire memTest = new Memoire(1);
		memTest.empiler(q);
				
		//On creer une valeur de retour reference car ici le visiteur retourne une valeur
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		//On test deux elements mais on doit utiliser qu'un seul Assert
		Assert.assertTrue(adresseTest == 2);
	}
	
	@Test
	public void testASTnop() throws ParseException, JajaCodeException {
		//Creation de la chaine a tester pour generer le noeud
		String str = "nop";
		parser = new JajaCode(str);
		
		//Parse la str pour et on appel la fonction permet de generer le noeud désirer
		SimpleNode n = parser.instrs();
		
		//On créer une memoire de reference. c'est la memoire attendue à la fin de l'excution du visiteur
		//On reprend dans le code les modifcations faites à la memoire lors de l'appel du visiteur
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("x",new ValeurEntier(6),new ObjetConstante(),new SortOmega());
		
		memRef.empiler(q);
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		Memoire memTest = new Memoire(1);
		memTest.empiler(q);
				
		//On creer une valeur de retour reference car ici le visiteur retourne une valeur
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		//On test deux elements mais on doit utiliser qu'un seul Assert
		Assert.assertTrue(adresseTest == 2);
	}
	
	@Test
	public void testASTjcstop() throws ParseException, JajaCodeException {
		//Creation de la chaine a tester pour generer le noeud
		String str = "jcstop";
		parser = new JajaCode(str);
		
		//Parse la str pour et on appel la fonction permet de generer le noeud désirer
		SimpleNode n = parser.instrs();
		
		//On créer une memoire de reference. c'est la memoire attendue à la fin de l'excution du visiteur
		//On reprend dans le code les modifcations faites à la memoire lors de l'appel du visiteur
		Memoire memRef = new Memoire(1);
		//Quad q = new Quad("x",new ValeurEntier(6),new ObjetConstante(),new SortOmega());
		//memRef.empiler(q);
		memRef.depiler();
		
		//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
		Memoire memTest = new Memoire(1);
		//memTest.empiler(q);
		memTest.depiler();
		
		//On creer une valeur de retour reference car ici le visiteur retourne une valeur
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		//On test deux elements mais on doit utiliser qu'un seul Assert
		Assert.assertTrue(adresseTest == -1);
	}
	
		
		@Test
		public void testASTinc() throws ParseException, JajaCodeException {
			//Creation de la chaine a tester pour generer le noeud
			String str = "inc(x)";
			parser = new JajaCode(str);
			
			//Parse la str pour et on appel la fonction permet de generer le noeud désirer
			SimpleNode n = parser.instrs();
			
			//Le visiteur prend en paramètre un noeud et une memoire de type Memoire
			//Il peut modifier la memoire en leur affectant ou retirant une valeur
			//Le constructeur prend en paramètre l'indice de la première ligne
			
			//On créer une memoire de reference. c'est la memoire attendue à la fin de l'excution du visiteur
			//On reprend dans le code les modifcations faites à la memoire lors de l'appel du visiteur
			Memoire memRef = new Memoire(1);
			Quad q = new Quad("x",new ValeurEntier(8),new ObjetConstante(),new SortOmega());
			memRef.empiler(q);
			
			//On creer une memoire de test correspondant à la memoire avant l'execution du visiteur
			Memoire memTest = new Memoire(1);
			
			q = new Quad("x",new ValeurEntier(6),new ObjetConstante(),new SortOmega());
			Quad q1 = new Quad("w",new ValeurEntier(2),new ObjetConstante(),new SortOmega());
			
			memTest.empiler(q);
			memTest.empiler(q1);
			
			//On creer une valeur de retour reference car ici le visiteur retourne une valeur
			n.jjtAccept(visitor, memTest);
			
			
			int adresseTest = visitor.getLigneInstruction();
			//On test deux elements mais on doit utiliser qu'un seul Assert
			Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
		}	
	
	
	@Test
	public void testASTMul() throws ParseException, JajaCodeException
	{
		// on test 2*3
		//Creation de la str
		String str = "mul";
		parser = new JajaCode(str);
		SimpleNode n = parser.oper2();
		
		//Creation de la memoire
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("w",new ValeurEntier(6),new ObjetConstante(),new SortOmega());
		memRef.empiler(q);
		
		Memoire memTest = new Memoire(1);
		//elemnt de gauche
		q = new Quad("w",new ValeurEntier(2),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		//element de droite
		q = new Quad("w",new ValeurEntier(3),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
	}
	
	@Test
	public void testSTdiv() throws ParseException, JajaCodeException
	{
		// on test 12/2
		//Creation de la str
		String str = "div";
		parser = new JajaCode(str);
		SimpleNode n = parser.oper2();
		
		//Creation de la memoire
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("w",new ValeurEntier(6),new ObjetConstante(),new SortOmega());
		memRef.empiler(q);
		
		Memoire memTest = new Memoire(1);
		//elemnt de gauche
		q = new Quad("w",new ValeurEntier(12),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		//element de droite
		q = new Quad("w",new ValeurEntier(2),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
	}
	
	
	
	@Test
	public void testSTor() throws ParseException, JajaCodeException
	{
		// on test false ou false
		//Creation de la str
		String str = "or";
		parser = new JajaCode(str);
		SimpleNode n = parser.oper2();
		
		//Creation de la memoire
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("w",new ValeurBooleen(false),new ObjetConstante(),new SortOmega());
		memRef.empiler(q);
		
		Memoire memTest = new Memoire(1);
		//elemnt de gauche
		q = new Quad("w",new ValeurBooleen(false),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		//element de droite
		q = new Quad("w",new ValeurBooleen(false),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
	}
	
	@Test
	public void testASTsup() throws ParseException, JajaCodeException
	{
		// on test 3 > 2
		//Creation de la str
		String str = "sup";
		parser = new JajaCode(str);
		SimpleNode n = parser.oper2();
		
		//Creation de la memoire
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("w",new ValeurBooleen(true),new ObjetConstante(),new SortOmega());
		memRef.empiler(q);
		
		Memoire memTest = new Memoire(1);
		//elemnt de gauche
		q = new Quad("w",new ValeurEntier(3),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		//element de droite
		q = new Quad("w",new ValeurEntier(2),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
	}
	
	@Test
	public void testASTcmp() throws ParseException, JajaCodeException
	{
		// on test 3 == 3
		//Creation de la str
		String str = "cmp";
		parser = new JajaCode(str);
		SimpleNode n = parser.oper2();
		
		//Creation de la memoire
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("w",new ValeurBooleen(true),new ObjetConstante(),new SortOmega());
		memRef.empiler(q);
		
		Memoire memTest = new Memoire(1);
		//elemnt de gauche
		q = new Quad("w",new ValeurEntier(3),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		//element de droite
		q = new Quad("w",new ValeurEntier(2),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
	}

	@Test
	public void testASTand() throws ParseException, JajaCodeException
	{
		// on test false and true
		//Creation de la str
		String str = "and";
		parser = new JajaCode(str);
		SimpleNode n = parser.oper2();
		
		//Creation de la memoire
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("w",new ValeurBooleen(false),new ObjetConstante(),new SortOmega());
		memRef.empiler(q);
		
		Memoire memTest = new Memoire(1);
		//elemnt de gauche
		q = new Quad("w",new ValeurBooleen(false),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		//element de droite
		q = new Quad("w",new ValeurBooleen(true),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
	}
	
	@Test
	public void testASTadd() throws ParseException, JajaCodeException
	{
		// on test 3 + 2
		//Creation de la str
		String str = "add";
		parser = new JajaCode(str);
		SimpleNode n = parser.oper2();
		
		//Creation de la memoire
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("w",new ValeurEntier(5),new ObjetConstante(),new SortOmega());
		memRef.empiler(q);
		
		Memoire memTest = new Memoire(1);
		//elemnt de gauche
		q = new Quad("w",new ValeurEntier(2),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		//element de droite
		q = new Quad("w",new ValeurEntier(3),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
	}
	
	@Test
	public void testASTsub() throws ParseException, JajaCodeException
	{
		// on test 3 - 2
		//Creation de la str
		String str = "sub";
		parser = new JajaCode(str);
		SimpleNode n = parser.oper2();
		
		//Creation de la memoire
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("w",new ValeurEntier(1),new ObjetConstante(),new SortOmega());
		memRef.empiler(q);
		
		Memoire memTest = new Memoire(1);
		//elemnt de gauche
		q = new Quad("w",new ValeurEntier(3),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		//element de droite
		q = new Quad("w",new ValeurEntier(2),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
	}
	
	@Test
	public void testASTnot() throws ParseException, JajaCodeException
	{
		// on test not 
		//Creation de la str
		String str = "not";
		parser = new JajaCode(str);
		SimpleNode n = parser.oper1();
		
		//Creation de la memoire
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("w",new ValeurBooleen(false),new ObjetConstante(),new SortOmega());
		memRef.empiler(q);
		
		Memoire memTest = new Memoire(1);
		//elemnt de gauche
		q = new Quad("w",new ValeurBooleen(true),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
	}
	
	@Test
	public void testASTneg() throws ParseException, JajaCodeException
	{
		// on test neg 1 -> -1 
		//Creation de la str
		String str = "neg";
		parser = new JajaCode(str);
		SimpleNode n = parser.oper1();
		
		//Creation de la memoire
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("w",new ValeurEntier(-1),new ObjetConstante(),new SortOmega());
		memRef.empiler(q);
		
		Memoire memTest = new Memoire(1);
		//elemnt de gauche
		q = new Quad("w",new ValeurEntier(1),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		
		
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
	}
	
	
		@Test
	public void testASTpush() throws ParseException, JajaCodeException
	{
		// on test push
		//Creation de la str
		String str = "push(5)";
		parser = new JajaCode(str);
		SimpleNode n = parser.instrs();
		
		//Creation de la memoire
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("w",new ValeurEntier(5),new ObjetConstante(),new SortOmega());
		memRef.empiler(q);
		
		Memoire memTest = new Memoire(1);
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
	}
	
		@Test
	public void testASTpop() throws ParseException, JajaCodeException
	{
		// on test pop
		//Creation de la str
		String str = "pop";
		parser = new JajaCode(str);
		SimpleNode n = parser.instrs();
		
		//Creation de la memoire
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("w",new ValeurEntier(5),new ObjetConstante(),new SortEntier());
		memRef.empiler(q);
		
		Memoire memTest = new Memoire(1);
		q = new Quad("w",new ValeurEntier(5),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		q = new Quad("w",new ValeurEntier(6),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
	}
		
		@Test
		public void testASTallerA() throws ParseException, JajaCodeException
		{
			// on test allerA
			//Creation de la str
			String str = "goto(5)";
			parser = new JajaCode(str);
			SimpleNode n = parser.instrs();
			
			//Creation de la memoire
			Memoire memRef = new Memoire(1);
			Quad q = new Quad("w",new ValeurEntier(1),new ObjetConstante(),new SortOmega());
			memRef.empiler(q);
			
			Memoire memTest = new Memoire(1);
			memTest.empiler(q);
			
			n.jjtAccept(visitor, memTest);
			
			int adresseTest = visitor.getLigneInstruction();
			Assert.assertTrue(memRef.equals(memTest) && adresseTest == 5);
		}
		
		
		@Test
		public void testASTsiFaux() throws ParseException, JajaCodeException
		{
			// on test si
			//Creation de la str
			String str = "if(5)";
			parser = new JajaCode(str);
			SimpleNode n = parser.instrs();
			
			//Creation de la memoire
			Memoire memRef = new Memoire(1);
			
			Memoire memTest = new Memoire(1);
			Quad q = new Quad("w",new ValeurBooleen(false),new ObjetConstante(),new SortOmega());
			memTest.empiler(q);
			n.jjtAccept(visitor, memTest);
			
			int adresseTest = visitor.getLigneInstruction();
			Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
		}	
		
		@Test
		public void testASTnewVal () throws ParseException, JajaCodeException
		{
			// on test newVal
			//Creation de la str
			String str = "new(x,entier,var,0)";
			parser = new JajaCode(str);
			SimpleNode n = parser.instrs();
			
			//Creation de la memoire
			Memoire memRef = new Memoire(1);
			Quad q = new Quad("x",new ValeurEntier(5),new ObjetVariable(),new SortEntier());
			memRef.empiler(q);
			
			Memoire memTest = new Memoire(1);
			Quad q1 = new Quad("a",new ValeurEntier(5),new ObjetConstante(),new SortEntier());
			memTest.empiler(q1);
			n.jjtAccept(visitor, memTest);
			
			int adresseTest = visitor.getLigneInstruction();
			Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
		}	
		
		@Test
		public void testASTswap () throws ParseException, JajaCodeException
		{
			// on test swap
			//Creation de la str
			String str = "swap";
			parser = new JajaCode(str);
			SimpleNode n = parser.instrs();
			
			//Creation de la memoire
			Memoire memRef = new Memoire(1);
			Quad q = new Quad("x",new ValeurEntier(5),new ObjetVariable(),new SortEntier());
			Quad q1 = new Quad("a",new ValeurEntier(8),new ObjetVariable(),new SortEntier());
			memRef.empiler(q);
			memRef.empiler(q1);
			
			Memoire memTest = new Memoire(1);
			memTest.empiler(q1);
			memTest.empiler(q);
			
			n.jjtAccept(visitor, memTest);
			
			int adresseTest = visitor.getLigneInstruction();
			Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
		}
		
		@Test
		public void testASTretour () throws ParseException, JajaCodeException
		{
			// on test retour
			//Creation de la str
			String str = "return";
			parser = new JajaCode(str);
			SimpleNode n = parser.instrs();
			
			//Creation de la memoire
			Memoire memRef = new Memoire(1);
			Quad q = new Quad("x",new ValeurEntier(5),new ObjetVariable(),new SortEntier());
			Quad q1 = new Quad("a",new ValeurEntier(8),new ObjetVariable(),new SortEntier());
			memRef.empiler(q);
			
			Memoire memTest = new Memoire(1);
			memTest.empiler(q);
			memTest.empiler(q1);
			
			
			n.jjtAccept(visitor, memTest);
			
			int adresseTest = visitor.getLigneInstruction();
			Assert.assertTrue(memRef.equals(memTest) && adresseTest == 8);
		}
		
		
		
		@Test
		public void testASTsiVrai() throws ParseException, JajaCodeException
		{
			// on test si
			//Creation de la str
			String str = "if(5)";
			parser = new JajaCode(str);
			SimpleNode n = parser.instrs();
			
			//Creation de la memoire
			Memoire memRef = new Memoire(1);
			
			Memoire memTest = new Memoire(1);
			Quad q = new Quad("w",new ValeurBooleen(true),new ObjetConstante(),new SortOmega());
			memTest.empiler(q);
			
			n.jjtAccept(visitor, memTest);
			
			int adresseTest = visitor.getLigneInstruction();
			Assert.assertTrue(memRef.equals(memTest) && adresseTest == 5);
		}
		
		
	@Test
	public void testASTload() throws ParseException, JajaCodeException
	{
		// on test load
		//Creation de la str
		String str = "load(x)";
		parser = new JajaCode(str);
		SimpleNode n = parser.instrs();
		
		//Creation de la memoire
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("x",new ValeurEntier(5),new ObjetConstante(),new SortEntier());
		Quad q1 = new Quad("w",new ValeurEntier(5),new ObjetConstante(),new SortOmega());
		memRef.empiler(q);
		memRef.empiler(q1);
		
		Memoire memTest = new Memoire(1);
		q = new Quad("x",new ValeurEntier(5),new ObjetConstante(),new SortEntier());
		memTest.empiler(q);
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
	}
	
	@Test
	public void testASTstore() throws ParseException, JajaCodeException
	{
		// on test store
		//Creation de la str
		String str = "store(x)";
		parser = new JajaCode(str);
		SimpleNode n = parser.instrs();
		
		//Creation de la memoire
		Memoire memRef = new Memoire(1);
		Quad q = new Quad("w",new ValeurEntier(5),new ObjetConstante(),new SortEntier());
		memRef.empiler(q);
		
		Memoire memTest = new Memoire(1);
		q = new Quad("x",new ValeurEntier(5),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		q = new Quad("a",new ValeurEntier(6),new ObjetConstante(),new SortOmega());
		memTest.empiler(q);
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
	}
	
	
	
	@Test
	public void testASTobject() throws ParseException, JajaCodeException
	{
		// on test object
		//Creation de la str
		String str = "var";
		parser = new JajaCode(str);
		SimpleNode n = parser.objet();
		
		
		String test = (String) n.jjtAccept(visitor, null);
		
		Assert.assertEquals(test,str);
			
	}
	
	@Test
	public void testASTVrai() throws ParseException, JajaCodeException
	{
		// on test vrai
		//Creation de la str
		String str = "jcvrai";
		parser = new JajaCode(str);
		SimpleNode n = parser.valeur();
		
		Valeur test = (Valeur)n.jjtAccept(visitor,null);
		assertEquals(test, new ValeurBooleen(true));
			
	}
	
	@Test
	public void testASTFaux() throws ParseException, JajaCodeException
	{
		// on test faux
		//Creation de la str
		String str = "jcfaux";
		parser = new JajaCode(str);
		SimpleNode n = parser.valeur();
		
		Valeur test = (Valeur)n.jjtAccept(visitor,null);
		assertEquals(test, new ValeurBooleen(false));
			
	}
	
	@Test
	public void testASTOmega() throws ParseException, JajaCodeException
	{
		// on test omega
		//Creation de la str
		String str = "w";
		parser = new JajaCode(str);
		SimpleNode n = parser.valeur();
		
		Valeur test = (Valeur)n.jjtAccept(visitor,null);
		assertEquals(test, new ValeurOmega());
			
	}
	
	@Test
	public void testNewArray() throws Exception
	{
		String str="newarray(tab,entier)";
		parser = new JajaCode(str);
		SimpleNode n = parser.instrs();

		Memoire memRef = new Memoire(1);
		memRef.declTab("tab", new ValeurEntier(5), new SortEntier());
		
		Memoire memTest = new Memoire(1);
		memTest.declCst("w", new ValeurEntier(5), new SortOmega());
		
		n.jjtAccept(visitor, memTest);
		
		int adresseTest = visitor.getLigneInstruction();
		Assert.assertTrue(memRef.equals(memTest) && adresseTest == 2);
		
	}
	
}
