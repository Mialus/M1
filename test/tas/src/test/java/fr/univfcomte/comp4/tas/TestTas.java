package fr.univfcomte.comp4.tas;

import org.junit.*;
import fr.univfcomte.comp4.quadruplet.*;


/**
 * Unit test for simple App.
 */
public class TestTas 
{
	private Tas tas;
	
	@Test(expected=TasException.class)
	public void TestTailleNeg() throws Exception
	{
		try {
			tas = new Tas(-2);
		} catch (TasException e) {
			throw e;
		}
	}
	
	@Test(expected=TasException.class)
	public void TestTailleZero() throws Exception
	{
		try {
			tas = new Tas(0);
		} catch (TasException e) {
			throw e;
		}
	}
	
	@Test(expected=TasException.class)
	public void TestTailleNonLog2() throws Exception
	{
		try {
			tas = new Tas(42);
		} catch (TasException e) {
			throw e;
		}
	}
	
	@Test
	public void TestTailleOK()
	{
		try {
			tas = new Tas(128);
		} catch (TasException e) {
		}
	}
	
	@Test
	public void TestCreerTableau()
	{
		try {
			tas = new Tas(128);
			tas.creerTas(new ValeurEntier(15), new SortEntier(), "tab");
			InfoTas tInfo = tas.getTabInfo(new ValeurTab("tab"));
			boolean res = (tInfo.getTaille() == 15)&& (tInfo.getIndice() ==0 ) && tas.contain(new ValeurTab("tab"));
			Assert.assertTrue(res);
		} catch (TasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void TestCreerDeuxTableaux()
	{
		try {
			tas = new Tas(128);
			tas.creerTas(new ValeurEntier(2), new SortEntier(), "tab");
			tas.creerTas(new ValeurEntier(15), new SortEntier(), "tab2");
			InfoTas tInfo1 = tas.getTabInfo(new ValeurTab("tab"));
			InfoTas tInfo2 = tas.getTabInfo(new ValeurTab("tab2"));
			boolean res1 = (tInfo1.getTaille() == 2)&& (tInfo1.getIndice() ==0 ) && tas.contain(new ValeurTab("tab"));
			boolean res2 = (tInfo2.getTaille() == 15)&& (tInfo2.getIndice() ==16 ) && tas.contain(new ValeurTab("tab2"));
			Assert.assertTrue((res1 && res2));
		} catch (TasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test(expected=TasException.class)
	public void TestCreerTableauLongueurNull() throws TasException
	{
		try {
			tas = new Tas(128);
			tas.creerTas(new ValeurEntier(0), new SortEntier(), "tab");
		} catch (TasException e) {
			throw e;
		}
		
	}
	
	@Test(expected=TasException.class)
	public void TestCreerTableauLongueurNeg() throws TasException
	{
		try {
			tas = new Tas(128);
			tas.creerTas(new ValeurEntier(-15), new SortEntier(), "tab");
		} catch (TasException e) {
			throw e;
		}
		
	}
	
	@Test(expected=TasException.class)
	public void TestCreerTableauLongueurTropGrande() throws TasException
	{
		try {
			tas = new Tas(128);
			tas.creerTas(new ValeurEntier(150), new SortEntier(), "tab");
		} catch (TasException e) {
			throw e;
		}
		
	}
	
	
	@Test
	public void TestSupprimerTableau()
	{
		try {
			tas = new Tas(128);
			tas.creerTas(new ValeurEntier(150), new SortEntier(), "tab");
			tas.creerTas(new ValeurEntier(150), new SortEntier(), "tab2");
			tas.retirerTas(new ValeurTab("tab"));
			boolean res = (!tas.contain(new ValeurTab("tab"))) && tas.contain(new ValeurTab("tab2"));
			Assert.assertTrue(res);
		} catch (Exception e) {
			
		}
	}
	
	@Test(expected=TasException.class)
	public void TestAffecterHorsTableauSup() throws Exception
	{
		try {
			tas = new Tas(64);
			tas.creerTas(new ValeurEntier(12), new SortEntier(), "tab");
			tas.affecterTas(new ValeurEntier(12), 15, new ValeurTab("tab"));
		} catch (TasException e) {
			throw e;
		}
	}
	

	@Test(expected=TasException.class)
	public void TestAffecterHorsTableauNeg() throws Exception
	{
		try {
			tas = new Tas(64);
			tas.creerTas(new ValeurEntier(12), new SortEntier(), "tab");
			tas.affecterTas(new ValeurEntier(12), -15, new ValeurTab("tab"));
		} catch (TasException e) {
			throw e;
		}
	}
	
	
	@Test
	public void TestAffecterTableau() throws Exception
	{
		try {
			tas = new Tas(64);
			tas.creerTas(new ValeurEntier(12), new SortEntier(), "tab");
			tas.affecterTas(new ValeurEntier(12), 5, new ValeurTab("tab"));
			Valeur res = tas.valeurTas(new ValeurTab("tab"), 5);
			Assert.assertTrue(res.equals(new ValeurEntier(12)));
		} catch (TasException e) {
			throw e;
		}
	}
}
