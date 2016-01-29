package fr.univfcomte.comp4.memoire_MiniJaja;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univfcomte.comp4.pile.Element;
import fr.univfcomte.comp4.quadruplet.*;
import fr.univfcomte.comp4.table_hachage.Info;
import fr.univfcomte.comp4.table_hachage.Instance;
import fr.univfcomte.comp4.table_hachage.Symbole;
import fr.univfcomte.comp4.table_hachage.TableHachageException;
import junit.framework.Assert;

public class TestMemoireMiniJaja {

	@Test
	public void testDeclVar() throws Exception {
		MemoireMiniJaja memRef = new MemoireMiniJaja();
		memRef.setNomClass("C");
		memRef.setPortee("class");
		MemoireMiniJaja memTest = new MemoireMiniJaja();
		memTest.setNomClass("C");
		memTest.setPortee("class");
		Valeur v = new ValeurEntier(5);
		Sorte t = new SortEntier();
		
		Info info = memRef.getTableSymbole().get(new Symbole("x", "class"));
		Quad val = new Quad("x",v, new ObjetVariable(), t);
    	info.setValeur(val, memRef.getTableSymbole().getHautPile());
    	memRef.getTableSymbole().updateHautPile();
    	
    	memTest.declVar("x", v, t);
    	
    	Assert.assertEquals(memRef, memTest);
    	
	}
	
	@Test
	public void testDeclMeth() throws Exception {
		MemoireMiniJaja memRef = new MemoireMiniJaja();
		memRef.setNomClass("C");
		memRef.setPortee("class");
		MemoireMiniJaja memTest = new MemoireMiniJaja();
		memTest.setNomClass("C");
		memTest.setPortee("class");
		Valeur v = new ValeurMethode("NoeudMethode");
		Sorte t = new SortEntier();
		
		Info info = memRef.getTableSymbole().get(new Symbole("meth", "class"));
		Quad val = new Quad("meth",v, new ObjetMethode(), t);
    	info.setValeur(val, memRef.getTableSymbole().getHautPile());
    	memRef.getTableSymbole().updateHautPile();
    	
    	memTest.declMeth("meth", v, t);
    	
    	Assert.assertEquals(memRef, memTest);
	}
	
	@Test
	public void testDeclCst() throws Exception {
		MemoireMiniJaja memRef = new MemoireMiniJaja();
		memRef.setNomClass("C");
		memRef.setPortee("class");
		MemoireMiniJaja memTest = new MemoireMiniJaja();
		memTest.setNomClass("C");
		memTest.setPortee("class");
		Valeur v = new ValeurEntier(5);
		Sorte t = new SortEntier();
		
		Info info = memRef.getTableSymbole().get(new Symbole("y1", "class"));
		Quad val = new Quad("y1",v, new ObjetConstante(), t);
    	info.setValeur(val, memRef.getTableSymbole().getHautPile());
    	memRef.getTableSymbole().updateHautPile();
    	
    	Info info2 = memRef.getTableSymbole().get(new Symbole("y2", "class"));
		Quad val2 = new Quad("y2",new ValeurOmega(), new ObjetVconstante(), t);
    	info2.setValeur(val2, memRef.getTableSymbole().getHautPile());
    	memRef.getTableSymbole().updateHautPile();
    	
    	memTest.declCst("y1", v, t);
    	memTest.declCst("y2", new ValeurOmega(), t);
    	
    	Assert.assertEquals(memRef, memTest);
    	
	}
	
	@Test
	public void testDeclTab() throws Exception {
		MemoireMiniJaja memRef = new MemoireMiniJaja();
		memRef.setNomClass("C");
		memRef.setPortee("class");
		MemoireMiniJaja memTest = new MemoireMiniJaja();
		memTest.setNomClass("C");
		memTest.setPortee("class");
		Valeur v = new ValeurEntier(5);
		Sorte t = new SortEntier();
		
		Info info = memRef.getTableSymbole().get(new Symbole("tab", "class"));
		Quad valeur = null;

	    ValeurTab val = memRef.getTas().creerTas(v, t, "tab");
	    valeur = new Quad("tab",val,new ObjetTab(),t);

    	info.setValeur(valeur, memRef.getTableSymbole().getHautPile());
    	memRef.getTableSymbole().updateHautPile();
    	
    	memTest.declTab("tab", v, t);
    	
    	Assert.assertEquals(memRef, memTest);
    	
	}
	
	@Test
	public void testRetirerDecl() throws Exception
	{
		MemoireMiniJaja memRef = new MemoireMiniJaja();
		memRef.setNomClass("C");
		memRef.setPortee("class");
		MemoireMiniJaja memTest = new MemoireMiniJaja();
		memTest.setNomClass("C");
		memTest.setPortee("class");
		
		Valeur v = new ValeurEntier(5);
		Sorte t = new SortEntier();
		memRef.declCst("y1", v, t);
		
		Info info = memRef.getTableSymbole().get(new Symbole("y1", "class"));
    	Instance hp = info.retirerValeur();

    	memRef.getTableSymbole().setHautPile(hp);
    	
    	
    	memTest.declCst("y1", v, t);
    	memTest.retirerDecl("y1");
    	
    	Assert.assertEquals(memRef, memTest);
    	
	}

	
	@Test
	public void testRetirerDeclTab() throws Exception {
		MemoireMiniJaja memRef = new MemoireMiniJaja();
		memRef.setNomClass("C");
		memRef.setPortee("class");
		MemoireMiniJaja memTest = new MemoireMiniJaja();
		memTest.setNomClass("C");
		memTest.setPortee("class");
		Valeur v = new ValeurEntier(5);
		Sorte t = new SortEntier();		
    	
		Info info = memRef.getTableSymbole().get(new Symbole("tab", "class"));
		Quad valeur = null;

	    ValeurTab val = memRef.getTas().creerTas(v, t, "tab");
	    valeur = new Quad("tab",val,new ObjetTab(),t);

    	info.setValeur(valeur, memRef.getTableSymbole().getHautPile());
    	memRef.getTableSymbole().updateHautPile();
    	Instance hp = info.retirerValeur();

    	memRef.getTableSymbole().setHautPile(hp);
    	memRef.getTas().retirerTas(val);
    	
    	memTest.declTab("tab", v, t);
    	memTest.retirerDecl("tab");
    	
    	Assert.assertEquals(memRef, memTest);
    	
	}
	
	@Test
	public void testVariableClasse() throws Exception
	{
		MemoireMiniJaja memRef = new MemoireMiniJaja();
		memRef.setNomClass("C");
		memRef.setPortee("class");
		MemoireMiniJaja memTest = new MemoireMiniJaja();
		memTest.setNomClass("C");
		memTest.setPortee("class");
		
		Valeur vRef = new ValeurEntier(5);
		memRef.declVar("C", vRef, new SortOmega());
		memTest.declVar("C", vRef, new SortOmega());
		
		memTest.affecterVariableClasse(vRef);
		Valeur vTest = memTest.variableClasse();
		
		Assert.assertTrue(memRef.equals(memTest) &&  vRef.equals(vTest));
	}
	
	@Test
	public void testAffecterVal() throws Exception
	{
		MemoireMiniJaja memRef = new MemoireMiniJaja();
		memRef.setNomClass("C");
		memRef.setPortee("class");
		MemoireMiniJaja memTest = new MemoireMiniJaja();
		memTest.setNomClass("C");
		memTest.setPortee("class");
		Valeur vRef = new ValeurEntier(10);
		
		memRef.declCst("y1", new ValeurEntier(5), new SortEntier());
		memRef.declCst("y2",vRef , new SortEntier());
		memRef.declVar("x", vRef, new SortEntier());
		memRef.declTab("tab", new ValeurEntier(5), new SortEntier());
		memRef.declTab("tab2", new ValeurEntier(10), new SortEntier());
		
		Info info = memRef.getTableSymbole().get(new Symbole("tab", "class"));
		ValeurTab vTab = (ValeurTab)info.getValeur().getVal();
		
		Info info2 = memRef.getTableSymbole().get(new Symbole("tab2", "class"));
		ValeurTab vTab2 = (ValeurTab)info2.getValeur().getVal();
		memRef.getTas().ajouterRef(vTab2);
		memRef.getTas().retirerTas(vTab);
		info.getValeur().setVal(vTab2);
		memRef.getTas().affecterTas(new ValeurEntier(10), 0, vTab2);
		
		
		memTest.declCst("y1", new ValeurEntier(5), new SortEntier());
		memTest.declCst("y2",new ValeurOmega() , new SortEntier());
		memTest.declVar("x", new ValeurEntier(5), new SortEntier());
		memTest.declTab("tab", new ValeurEntier(5), new SortEntier());
		memTest.declTab("tab2", new ValeurEntier(10), new SortEntier());
		Info infoTest = memTest.getTableSymbole().get(new Symbole("tab2", "class"));
		ValeurTab vTabTest = (ValeurTab)infoTest.getValeur().getVal();
		
		memTest.affecterVal("y1",vRef);
		memTest.affecterVal("y2",vRef);
		memTest.affecterVal("x", vRef);
		memTest.affecterVal("tab", vTabTest);
		memTest.affecterValT(vTabTest, vRef, new ValeurEntier(0));
		
		
		Assert.assertTrue(memRef.equals(memTest) && vRef.equals(memTest.val("x")) && vRef.equals(memTest.valT("tab",0)));
	}
	
	@Test
	public void testExpParam() throws Exception
	{
		MemoireMiniJaja memRef = new MemoireMiniJaja();
		memRef.setNomClass("C");
		memRef.setPortee("f");
		MemoireMiniJaja memTest = new MemoireMiniJaja();
		memTest.setNomClass("C");
		memTest.setPortee("f");
		
		Quad q1 = new Quad("p", new ValeurOmega(), new ObjetVariable(), new SortEntier());
		Quad q2 = new Quad("p", new ValeurOmega(), new ObjetVariable(), new SortEntier());
		Element lparam = new Element();
		Element lparamSuivant = new Element();
		
		Valeur v1 = new ValeurEntier(2);
		Valeur v2 = new ValeurEntier(1);
		Element lexp = new Element();
		Element lexpSuivant = new Element();
		
		memTest.expParam(lexp, lparam);
		
		lparamSuivant.setValeur(q2);
		lparam.setValeur(q1);
		lparam.setSuivant(lparamSuivant);
		
		
		lexpSuivant.setValeur(v2);
		lexp.setValeur(v1);
		lexp.setSuivant(lexpSuivant);
		
		memRef.declVar(q1.getId(), v1, q1.getType());
		memRef.declVar(q2.getId(), v2, q2.getType());
		
		memTest.expParam(lexp, lparam);
		
		Assert.assertEquals(memRef, memTest);
	}
}
