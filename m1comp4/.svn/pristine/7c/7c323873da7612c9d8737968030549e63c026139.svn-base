package fr.univfcomte.comp4.pile;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestElement {

	@Test
	public void testEquals()
	{
		Element ref = new Element();
		Element test = new Element();
		Element suivant = new Element();
		
	
		suivant.valeur = -42;
		suivant.suivant = null;
		ref.valeur="42";
		ref.suivant=suivant;
		test.valeur="42";
		test.suivant=suivant;
		

		assertTrue(ref.equals(test));
	}
	
	@Test
	public void testGetSuivant() 
	{
		Element base = new Element();
		Element testSuivant = null;
		Element refSuivant = new Element();
		
		refSuivant.suivant = null;
		refSuivant.valeur = 1;
		base.suivant = refSuivant;
		base.valeur = 0;
		
		testSuivant = base.getSuivant();
		
		assertEquals(refSuivant, testSuivant);
	}

	@Test
	public void testGetValeur() 
	{
		Element base = new Element();
		Object testValeur = null;
		
		base.suivant = null;
		base.valeur = "42";
		
		testValeur = base.getValeur();
		
		assertEquals("42", testValeur);
	}
	
	@Test
	public void testSets()
	{
		Element ref = new Element();
		Element test = new Element();
		Element suivant = new Element();
		
		
		suivant.valeur = -42;
		suivant.suivant = null;
		ref.valeur = 12;
		ref.suivant = suivant;
		test.setValeur(12);
		test.setSuivant(suivant);
		
		assertEquals(ref, test);
	}
	

}
