package fr.univfcomte.comp4.compilateur;


import fr.univfcomte.comp4.analyseur.MiniJaja;
import fr.univfcomte.comp4.analyseur.MiniJajaException;
import fr.univfcomte.comp4.analyseur.ParseException;
import fr.univfcomte.comp4.analyseur.SimpleNode;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App
{
    String test = "class C {\n" +
"	int x = 4;\n" +
"	boolean y = true;\n" +
"	int x1;\n" +
"	boolean y2;\n" +
"\n" +
"	final int x = 4;\n" +
"	final boolean y = true;\n" +
"	final int x1;\n" +
"	final boolean y2;\n" +
"\n" +
"	\n" +
"	int t1[4];\n" +
"	boolean t2[taille];\n" +
"\n" +
"	void f(int a, int b, int c){};\n" +
"	boolean f(){};\n" +
"	int f(){};\n" +
"\n" +
"	main{\n" +
"		f(1,2,3);\n" +
"	}\n" +
"}";
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        MiniJajaCompilateurVisitor compilateurVisitor = new MiniJajaCompilateurVisitor();
        SimpleNode asa;
        MiniJaja parseur;
        ArrayList<String> jajaCode = new ArrayList<String>();

        try
        {
        	Paire memoire = new Paire();
            parseur = new MiniJaja(test);
            asa = parseur.classe();
            //On commence à la ligne n = 1
            memoire = (Paire)asa.jjtAccept(compilateurVisitor, 1);
            System.out.println(memoire.getInstructions());
            //jajaCode = memoire.getInstructions();
        }
        catch (java.io.FileNotFoundException e)
        {
            System.out.println("JavaCC Parser:  File :D/1.mjj not found.");
        }
        catch (ParseException e)
        {
            System.out.println("JavaCC Parser:  " + e.getMessage());
        }
        catch(MiniJajaException e)
        {
            System.out.println("MiniJajaException :  " + e.getMessage());
        }

        System.out.println("JajaCode : \n");

        int i = 0;
        for(String s : jajaCode) {
            i++;
            System.out.print(i + " : ");
            System.out.println(s);
        }
    }
}
