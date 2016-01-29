package fr.univfcomte.comp4.table_hachage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.univfcomte.comp4.quadruplet.ObjetConstante;
import fr.univfcomte.comp4.quadruplet.ObjetVariable;
import fr.univfcomte.comp4.quadruplet.Quad;
import fr.univfcomte.comp4.quadruplet.SortBooleen;
import fr.univfcomte.comp4.quadruplet.SortEntier;
import fr.univfcomte.comp4.quadruplet.ValeurBooleen;
import fr.univfcomte.comp4.quadruplet.ValeurEntier;

public class TestInfo {
	
	private static Info info1;
	private static Info info2;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		info1 = new Info("var", "entier", "main");
		info1.setValeur(new Quad(	"x", 
									new ValeurEntier(5), 
									new ObjetVariable(), 
									new SortEntier())
						, null);
		info1.setValeur(new Quad(	"x", 
									new ValeurEntier(10), 
									new ObjetVariable(), 
									new SortEntier())
						, null);
		info2 = new Info("cst", "booleen", "main");
		info2.setValeur(new Quad(	"x", 
									new ValeurBooleen(true), 
									new ObjetConstante(), 
									new SortBooleen())
						, null);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRetirerValeur() {
		fail("Not yet implemented");
	}

}
