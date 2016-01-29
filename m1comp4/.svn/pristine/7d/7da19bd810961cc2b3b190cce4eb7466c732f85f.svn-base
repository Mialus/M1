package fr.univfcomte.comp4.pile;

import static org.junit.Assert.*;
import org.junit.Test;

import junit.framework.Assert;

public class TestPile{
	
	@Test
	public void testPush()
	{
		Pile ref = new Pile();
		Element hp = new Element();
		Element suivant = new Element();
		suivant.suivant = null;
		suivant.valeur = 2;
		hp.suivant = suivant;
		hp.valeur = 1;
		ref.hautPile = hp;
		
		Pile test = new Pile();
		test.push(2);
		test.push(1);
		
		assertEquals(ref, test);
	}
	
	@Test
	public void testPop()
	{
		Pile ref = new Pile();
		Pile test = new Pile();

		Object testPop = null;
		ref.push(2);
		test.push(2);
		test.push(1);
		testPop = test.pop();
		
		assertTrue(ref.equals(test) && testPop.equals(1));
	}
	
	@Test
	public void testPopPileVide()
	{
		Pile ref = new Pile();
		Pile test = new Pile();

		Object testPop = null;
		testPop = test.pop();
		
		assertTrue(ref.equals(test) && testPop == null);
	}
	
	@Test
	public void testGetHautPile()
	{
		Pile ref = new Pile();
		Element refHp = new Element();
		Element testHp = null;
		
		ref.push(1);
		refHp.suivant = null;
		refHp.valeur = 1;
		
		testHp = ref.getHautPile();
		
		assertEquals(refHp, testHp);
	}
	
	
	
	@Test
	public void testSetHautPile()
	{
		Pile ref = new Pile();
		Pile test = new Pile();
		Element refHp = new Element();
		
		ref.push(1);
		refHp.suivant = null;
		refHp.valeur = 1;
		test.setHautPile(refHp);
		
		assertEquals(ref, test);
	}
	
	@Test
	public void testSwap()
	{
		Pile ref = new Pile();
		Pile test = new Pile();
		ref.push(2);
		ref.push(1);
		test.push(1);
		test.push(2);
		test.swap();
		assertEquals(ref,test);
	}
	
	@Test
	public void testSwapPileUnElement()
	{
		Pile ref = new Pile();
		ref.push(1);
		Pile test = new Pile();
		test.push(1);
		test.swap();
		
		Assert.assertEquals(ref, test);
	}
	
	@Test
	public void testSwapPileVide()
	{
		Pile ref = new Pile();
		Pile test = new Pile();
		test.swap();
		
		Assert.assertEquals(ref, test);
	}
	
	@Test
	public void testEquals()
	{
		Pile ref = new Pile();
		Pile test = new Pile();
		ref.push(1);
		ref.push(2);
		test.push(1);
		test.push(2);
		assertEquals(ref,test);
	}
	
}
