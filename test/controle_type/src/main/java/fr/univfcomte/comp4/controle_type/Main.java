package fr.univfcomte.comp4.controle_type;

import fr.univfcomte.comp4.analyseur.*;
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
        SimpleNode n = parser.classe();
        ControleTypeVisitor visitor = new  ControleTypeVisitor();
        DataControleType dataCT = new DataControleType();
        try{
        	n.jjtAccept(visitor, dataCT);
        }catch(MiniJajaException e){
        	System.err.println(e.getMessage());
        }
        System.out.println(dataCT);
        //System.out.println(n.dump(""));
      System.out.println("JavaCC Parser:  Java program parsed successfully.");
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      System.out.println("JavaCC Parser:  Encountered errors during parse.");
    }
		
	}
}