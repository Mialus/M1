package fr.univfcomte.comp4.tas;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fr.univfcomte.comp4.quadruplet.*;
import fr.univfcomte.comp4.table_hachage.TableHachage;
import fr.univfcomte.comp4.table_hachage.TableHachageException;

public class TestTas {

	
	@Test
	public void testCreerTas() throws Exception {
		Tas tRef = new Tas();
		
		Valeur taille = new ValeurEntier(11);
		Sorte type = new SortEntier();
		
		tRef.setIdTableId(1);
		tRef.setNbBlocLibre(501);
		
		InfoTas tInfo = new InfoTas(0,11);
		ValeurTab vtRef = new ValeurTab("0");
		tRef.getTableId().put(0, tInfo);
		
		Valeur[] memoire = tRef.getMemoire();
		for(int i=0; i<11; i++)
		{
			memoire[i] =type.createValeur();
			
		}
		
		TableHachage tBlocL = tRef.getTableBlocLibre();
		tBlocL.remove("9");
		tBlocL.put("0", 11);
		tBlocL.put("2", 12);
		tBlocL.put("4", 16);
		tBlocL.put("5", 32);
		tBlocL.put("6", 64);
		tBlocL.put("7", 128);
		tBlocL.put("8", 256);
		
		
		ValeurTab vtTest = null;
		Tas tTest = new Tas();
		vtTest = tTest.creerTas(taille, type, "tab");
	

		Assert.assertTrue(tRef.equals(tTest) && vtRef.equals(vtTest));
		
	}
	
	@Test
	public void testCreerDeuxTas() throws Exception {
		Tas tRef = new Tas();
		
		Valeur taille = new ValeurEntier(11);
		Sorte type = new SortEntier();
		
		Valeur taille2 = new ValeurEntier(7);
		Sorte type2 = new SortBooleen();
		
		tRef.setIdTableId(2);
		tRef.setNbBlocLibre(494);
		
		InfoTas tInfo = new InfoTas(0,11);
		InfoTas tInfo2 = new InfoTas(11,7);
		ValeurTab vtRef = new ValeurTab("1");
		tRef.getTableId().put(0, tInfo);
		tRef.getTableId().put(1, tInfo2);
		
		Valeur[] memoire = tRef.getMemoire();
		for(int i=0; i<11; i++)
		{
			memoire[i] =type.createValeur();
			
		}
		
		for(int i=11; i<18; i++)
		{
			memoire[i] =type2.createValeur();
			
		}
		
		TableHachage tBlocL = tRef.getTableBlocLibre();
		tBlocL.remove("9");
		tBlocL.put("1", 18);
		tBlocL.put("2", 20);
		tBlocL.put("3", 24);
		tBlocL.put("5", 32);
		tBlocL.put("6", 64);
		tBlocL.put("7", 128);
		tBlocL.put("8", 256);
		
		ValeurTab vtTest = null;
		Tas tTest = new Tas();
		tTest.creerTas(taille, type, "tab");
		vtTest = tTest.creerTas(taille2, type2, "tab2");
		

		Assert.assertTrue(tRef.equals(tTest) && vtRef.equals(vtTest));
		
	}
	
	@Test
	public void testGetIndiceMemoire() throws Exception
	{
		int nbElem = 11;
		Tas tRef = new Tas();
		tRef.setNbBlocLibre(501);
		
		TableHachage tBlocL = tRef.getTableBlocLibre();
		tBlocL.remove("9");
		tBlocL.put("0", 11);
		tBlocL.put("2", 12);
		tBlocL.put("4", 16);
		tBlocL.put("5", 32);
		tBlocL.put("6", 64);
		tBlocL.put("7", 128);
		tBlocL.put("8", 256);
		
		
		Tas tTest = new Tas();
		
		int idMemTest = tTest.getIndiceMemoire(nbElem);

		Assert.assertTrue(tRef.equals(tTest) && 0==idMemTest);
	}

	@Test
	public void testRetirerTas() throws Exception
	{
		Tas tRef = new Tas();
		tRef.setIdTableId(4);
		
		Tas tTest = new Tas();
		ValeurTab vtTest = tTest.creerTas(new ValeurEntier(5), new SortEntier(), "tab");
		ValeurTab vtTest1 = tTest.creerTas(new ValeurEntier(8), new SortEntier(), "tab1");
		tTest.ajouterRef(vtTest);
		ValeurTab vtTest2 = tTest.creerTas(new ValeurEntier(42), new SortEntier(), "tab2");
		ValeurTab vtTest3 = tTest.creerTas(new ValeurEntier(12), new SortEntier(), "tab3");
		tTest.retirerTas(vtTest);
		tTest.retirerTas(vtTest);
		tTest.retirerTas(vtTest2);
		tTest.retirerTas(vtTest3);
		tTest.retirerTas(vtTest1);
		
		Assert.assertEquals(tRef, tTest);
		
	}
	
	@Test
	public void testAffecterEtValeurTas() throws Exception {
		Tas tRef = new Tas();
		Valeur vRef = new ValeurEntier(5);
		Valeur taille = new ValeurEntier(11);
		Sorte type = new SortEntier();
		
		tRef.setIdTableId(1);
		tRef.setNbBlocLibre(501);
		
		InfoTas tInfo = new InfoTas(0,11);
		ValeurTab vtRef = new ValeurTab("0");
		tRef.getTableId().put(0, tInfo);
		
		Valeur[] memoire = tRef.getMemoire();
		for(int i=0; i<11; i++)
		{
			memoire[i] =type.createValeur();
			
		}
		
		memoire[5] = vRef;
		
		TableHachage tBlocL = tRef.getTableBlocLibre();
		tBlocL.remove("9");
		tBlocL.put("0", 11);
		tBlocL.put("2", 12);
		tBlocL.put("4", 16);
		tBlocL.put("5", 32);
		tBlocL.put("6", 64);
		tBlocL.put("7", 128);
		tBlocL.put("8", 256);
		
		
		ValeurTab vtTest = null;
		Tas tTest = new Tas();
		vtTest = tTest.creerTas(taille, type, "tab");
		tTest.affecterTas(vRef, 5, vtTest);
		Valeur vTest = tTest.valeurTas(vtTest, 5);
		
		Assert.assertTrue(tRef.equals(tTest) && vRef.equals(vTest));
		
	}
	
	@Test
	public void getTabInfo() throws Exception
	{	
		Tas tRef = new Tas();
		
		Valeur taille = new ValeurEntier(11);
		Sorte type = new SortEntier();
		
		tRef.setIdTableId(1);
		tRef.setNbBlocLibre(501);
		
		InfoTas tInfo = new InfoTas(0,11);
		tRef.getTableId().put(0, tInfo);
		
		Valeur[] memoire = tRef.getMemoire();
		for(int i=0; i<11; i++)
		{
			memoire[i] =type.createValeur();
			
		}
		
		TableHachage tBlocL = tRef.getTableBlocLibre();
		tBlocL.remove("9");
		tBlocL.put("0", 11);
		tBlocL.put("2", 12);
		tBlocL.put("4", 16);
		tBlocL.put("5", 32);
		tBlocL.put("6", 64);
		tBlocL.put("7", 128);
		tBlocL.put("8", 256);
		
		
		ValeurTab vtTest = null;
		Tas tTest = new Tas();
		vtTest = tTest.creerTas(taille, type, "tab");
		InfoTas tInfoTest = tTest.getTabInfo(vtTest);
	
		Assert.assertTrue(tRef.equals(tTest) && tInfo.equals(tInfoTest));
	
	}
	
	@Test(expected=TasException.class)
	public void testTasTailleNeg() throws Exception
	{
		Tas erreur = new Tas(-1);
		Assert.assertTrue(false);
	}
	
	@Test(expected=TasException.class)
	public void testTasTailleNonPuissance2() throws Exception
	{
		Tas erreur = new Tas(546);
		Assert.assertTrue(false);
	}
	
	@Test(expected=TasException.class)
	public void testCreerTasNeg() throws Exception
	{
		Tas erreur = new Tas();
		erreur.creerTas(new ValeurEntier(-1), new SortEntier(), "tab");
		Assert.assertTrue(false);
	}
	
	@Test(expected=TasException.class)
	public void testCreerTasTropGrand() throws Exception
	{
		Tas erreur = new Tas();
		erreur.creerTas(new ValeurEntier(1042), new SortEntier(), "tab");
		Assert.assertTrue(false);
	}
	
	@Test(expected=TasException.class)
	public void testValeurTasTropGrand() throws Exception
	{
		Tas erreur = new Tas();
		ValeurTab vt = erreur.creerTas(new ValeurEntier(10), new SortEntier(), "tab");
		erreur.valeurTas(vt,11 );
		Assert.assertTrue(false);
	}
	
	@Test(expected=TasException.class)
	public void testValeurNeg() throws Exception
	{
		Tas erreur = new Tas();
		ValeurTab vt = erreur.creerTas(new ValeurEntier(10), new SortEntier(), "tab");
		erreur.valeurTas(vt,-11 );
		Assert.assertTrue(false);
	}
	
	@Test(expected=TasException.class)
	public void testAffecterTasTropGrand() throws Exception
	{
		Tas erreur = new Tas();
		ValeurTab vt = erreur.creerTas(new ValeurEntier(10), new SortEntier(), "tab");
		erreur.affecterTas(new ValeurEntier(11), 11, vt);
		Assert.assertTrue(false);
	}
	
	@Test(expected=TasException.class)
	public void testAffecterNeg() throws Exception
	{
		Tas erreur = new Tas();
		ValeurTab vt = erreur.creerTas(new ValeurEntier(10), new SortEntier(), "tab");
		erreur.affecterTas(new ValeurEntier(11), -11, vt);
		Assert.assertTrue(false);
	}
	
}
