package fr.univfcomte.comp4.interpreteur_MiniJaja;

import fr.univfcomte.comp4.analyseur.*;
import fr.univfcomte.comp4.memoire_MiniJaja.MemoireMiniJaja;
import fr.univfcomte.comp4.table_hachage.*;

public class Main {
	public static void main(String args[]) throws Exception {
        MiniJaja parser;
    if (args.length == 0) {
      System.out.println("JavaCC Parser:  Reading from standard input . . .");
      parser = new MiniJaja(System.in);
    } else if (args.length == 1) {
      System.out.println("JavaCC Parser:  Reading from file " + args[0] + " . . .");
      try {
        parser = new MiniJaja(new java.io.FileInputStream(args[0]));
      } catch (java.io.FileNotFoundException e) {
        System.out.println("JavaCC Parser:  File " + args[0] + " not found.");
        return;
      }
    } else {
      System.out.println("JavaCC Parser:  Usage is one of:");
      System.out.println("         java MiniJaja < inputfile");
      System.out.println("OR");
      System.out.println("         java MiniJaja inputfile");
      return;
    }
    try {
    	MemoireMiniJaja memoire = new MemoireMiniJaja();
        SimpleNode n = parser.classe();
        MiniJajaInterpreteurVisitor visitor = new MiniJajaInterpreteurVisitor();
        System.out.println(n.dump(""));
        try{
        	n.jjtAccept(visitor, memoire);
        }catch(MiniJajaException e){
        	System.err.println(e.getMessage());
        }

      System.out.println("JavaCC Parser:  Java program parsed successfully.");
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      System.out.println("JavaCC Parser:  Encountered errors during parse.");
    }
		
	}
}
