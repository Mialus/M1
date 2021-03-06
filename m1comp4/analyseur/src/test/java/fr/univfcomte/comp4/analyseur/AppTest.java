package fr.univfcomte.comp4.analyseur;

import org.junit.*;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigourous Test :-)
     */
	private MiniJaja parser;
	
	@After
    public void tearDown() {
        parser = null;
    }
    
	
    @Test
    public void testParserOK() throws Exception
    {
		parser = new MiniJaja(new java.io.FileInputStream("./src/test/java/fr/univfcomte/comp4/analyseur/MiniJajaOK.mjj"));
		parser.classe();
    }
    
    @Test(expected=ParseException.class)
    public void testParserKO() throws Exception
    {
    	try
    	{
    		parser = new MiniJaja(new java.io.FileInputStream("./src/test/java/fr/univfcomte/comp4/analyseur/MiniJajaKO.mjj"));
    		parser.classe();
    	}catch(Exception e)
    	{
    		throw e;
    	}    
    }
}
