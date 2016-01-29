package fr.univfcomte.comp4.compilateur;
import fr.univfcomte.comp4.analyseur.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class MiniJajaCompilateurVisitor implements MiniJajaVisitor{

	private int k = 0; // k un compteur à gérer pour le nombre d'ente d'une méthode
	private int adresseRetrait = -1;
    private ArrayList<String> instructions;
    private MiniJajaCompilateurRetraitVisitor retraitVisitor;
    private HashMap<Integer, Integer[]> tableCorrespondance;

    public MiniJajaCompilateurVisitor()
    {
        super();
        this.retraitVisitor = new MiniJajaCompilateurRetraitVisitor();
        this.instructions = new ArrayList<String>();
        this.tableCorrespondance = new HashMap<Integer, Integer[]>();
    }

    public int getAdresseRetrait(){return this.adresseRetrait;}
    
    public Object visit(SimpleNode node, Object data) throws MiniJajaException {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(ASTclasse node, Object data) throws MiniJajaException {
    	     	
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	Integer n = (Integer)data;
    	Integer tab[] = {n, n};
    	int key = node.jjtGetFirstToken().beginLine*100+node.jjtGetFirstToken().beginColumn;
    	this.tableCorrespondance.put(key, tab);
        mem.add(n+" init;\n");
               
        tmp = (Paire) node.jjtGetChild(1).jjtAccept(this, n+1); // liste de déclarations
        int ndss = tmp.getAdresse();
        mem.add(tmp.getInstructions());
        
        tmp = (Paire) node.jjtGetChild(2).jjtAccept(this, n + ndss+ 1); // méthode main
        int nmma = tmp.getAdresse();
        mem.add(tmp.getInstructions());
        
        this.retraitVisitor.resetInstruction();					//Retrait
        int nrdss =(Integer) node.jjtGetChild(1).jjtAccept(this.retraitVisitor, n + ndss + nmma + 1);
        ArrayList<String> rDecls = this.retraitVisitor.getInstructions();

        mem.add(rDecls);
        mem.add((ndss + nmma + nrdss + 2)+" pop;\n");
        mem.add((ndss + nmma + nrdss + 3)+" jcstop;\n");
        mem.incAdresse( ndss + nmma + nrdss + 3);
        
        return mem;
    }

    public Object visit(ASTident node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
        String ident = (String) node.jjtGetValue();
        int n = (Integer)data;
        
        mem.add(n+" load(" + ident + ");\n");
        mem.incAdresse(1);
        return mem;
    }

    public Object visit(ASTdecls node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp=(Paire)node.jjtGetChild(0).jjtAccept(this, n);       //déclaration
        int nds =tmp.getAdresse();
        mem.add(tmp.getInstructions());		
        
        tmp=(Paire) node.jjtGetChild(1).jjtAccept(this, n + nds);       // liste de déclarations
        int ndss = tmp.getAdresse();
        mem.add(tmp.getInstructions());
       
        mem.incAdresse(nds+ndss);
        return mem;
    }

    public Object visit(ASTvnil node, Object data) throws MiniJajaException {

        return new Paire();
    }

    public Object visit(ASTmethode node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	Paire tmp1 = new Paire();
    	Paire tmp2= new Paire();
    	int n = (Integer)data;
    	int indiceRien = 0;

        String type = (String)(node.jjtGetChild(0)).jjtAccept(this, null);
        String ident = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();
        
        if(type.equals("vide"))
        {
        	indiceRien = 1;
        }
        
        compterEntete(node.jjtGetChild(2));
        tmp = (Paire)(node.jjtGetChild(2)).jjtAccept(this, n+3);	//entetes
        int nens = tmp.getAdresse();
        k=0;
        
        tmp1 = (Paire)(node.jjtGetChild(3)).jjtAccept(this, n+nens+3);	//declarations
        int ndvs = tmp1.getAdresse();
        
        tmp2 = (Paire)(node.jjtGetChild(4)).jjtAccept(this, n+nens+ndvs+3);	//instructions
        int niss = tmp2.getAdresse();
        
        this.retraitVisitor.resetInstruction();
        int nrdvs = (Integer) node.jjtGetChild(3).jjtAccept(this.retraitVisitor, n+nens+ndvs+niss+3+ indiceRien);
        ArrayList<String> rDecls = this.retraitVisitor.getInstructions();

        Integer tab[] = {n, n + 2};
        
        SimpleNode premierFils = ((SimpleNode)node.jjtGetChild(0));
        int key = premierFils.jjtGetFirstToken().beginLine*100+premierFils.jjtGetFirstToken().beginColumn;
        this.tableCorrespondance.put(key, tab);
        mem.add(n+" push(" + (n+3) + ");\n");
        mem.add((n+1)+" new(" + ident + ", " + type + ", meth, 0);\n");
        mem.add((n+2)+" goto("+(n+ nens + ndvs+ niss + nrdvs + 5 + indiceRien)+");\n");
        mem.add(tmp.getInstructions());
        mem.add(tmp1.getInstructions());
        mem.add(tmp2.getInstructions());
        
        if(type.equals("vide"))
        {
        	mem.add((n+nens+ndvs+niss+3)+" push(0);\n");
        }
        
        mem.add(rDecls);
        mem.add((n+nens + ndvs+ niss + nrdvs + 3 + indiceRien)+" swap;\n");
        mem.add((n+nens + ndvs+ niss + nrdvs + 4 + indiceRien)+" return;\n");

        mem.incAdresse(nens + ndvs+ niss + nrdvs + 5 + indiceRien);
        return mem;
    }

    public Object visit(ASTtableau node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	int n = (Integer)data;
        String type = (String)(node.jjtGetChild(0)).jjtAccept(this, null);              // type
        String ident = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();        // ident
        

        
        mem = (Paire) node.jjtGetChild(2).jjtAccept(this, n);                              // expression
        mem.add((n+mem.getAdresse())+" newarray(" + ident + ", " + type + ");\n");
        Integer tab[] = {n, n + mem.getAdresse()};
        int key = node.jjtGetFirstToken().beginLine*100+node.jjtGetFirstToken().beginColumn;
        this.tableCorrespondance.put(key, tab);
        mem.incAdresse(1);
        
        return mem;
    }

    public Object visit(ASTvar node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	int n = (Integer)data;
        String type = (String)(node.jjtGetChild(0)).jjtAccept(this, null);
        String ident = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();

        mem = (Paire) node.jjtGetChild(2).jjtAccept(this, n);                              // expression

        
        
        mem.add((n+mem.getAdresse())+" new(" + ident + ", " + type + ", var, 0);\n");
        Integer tab[] = {n, n + mem.getAdresse()};
        int key = node.jjtGetFirstToken().beginLine*100+node.jjtGetFirstToken().beginColumn;
        this.tableCorrespondance.put(key, tab);

        mem.incAdresse(1);
        
        
        return mem;
    }

    public Object visit(ASTcst node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	int n = (Integer)data;
        String type = (String)(node.jjtGetChild(0)).jjtAccept(this, n);
        String ident = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();

        
        
        mem = (Paire) node.jjtGetChild(2).jjtAccept(this, n);                              // expression
        mem.add((n+mem.getAdresse())+" new(" + ident + ", " + type + ", cst, 0);\n");
        
        Integer tab[] = {n, n + mem.getAdresse()};
        int key = node.jjtGetFirstToken().beginLine*100+node.jjtGetFirstToken().beginColumn;
        this.tableCorrespondance.put(key, tab);
        
        mem.incAdresse(1);
        

        
        return mem;
    }

    public Object visit(ASTvars node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);       // déclaration de variable
    	int ndv = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	tmp = (Paire)node.jjtGetChild(1).jjtAccept(this, n+ndv);       // liste de déclarations de variables
    	int ndvs = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	mem.incAdresse(ndv+ndvs);
        return mem;
    }

    public Object visit(ASTomega node, Object data) throws MiniJajaException {
    	int n = (Integer)data;
        return new Paire(n+" push(w);\n",1);
    }

    public Object visit(ASTmain node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);    // liste déclarations de variables
    	int ndvs = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	tmp = (Paire)node.jjtGetChild(1).jjtAccept(this, n+ndvs);             // listes d'instructions
    	int niss = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
        mem.add((n + ndvs + niss)+" push(0);\n");

       this.adresseRetrait = n + ndvs + niss;
        
        this.retraitVisitor.resetInstruction();
        int nrdvs = (Integer)node.jjtGetChild(0).jjtAccept(this.retraitVisitor, n + ndvs + niss + 1);
        ArrayList<String> rDecls = this.retraitVisitor.getInstructions();
        mem.add(rDecls);
        
        mem.incAdresse(ndvs+niss+nrdvs+1);
        return mem;
    }

    public Object visit(ASTenil node, Object data) throws MiniJajaException {
        return new Paire();
    }

    public Object visit(ASTentetes node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // en-tête
    	int nen = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	k--; //entete consommée
    	
    	tmp = (Paire)node.jjtGetChild(1).jjtAccept(this, n+nen);        // liste d'en-têtes
    	int nens = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	mem.incAdresse(nens+nen);

        return mem;
    }

    public Object visit(ASTentete node, Object data) throws MiniJajaException {
    	int n = (Integer)data;
    	Paire mem = new Paire();
        String type = (String)(node.jjtGetChild(0)).jjtAccept(this, null);
        String ident = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();

        mem.add(n+" new(" + ident + ", " + type + ", var, "+k+");\n");      // k : compteur à gérer
        mem.incAdresse(1);
        
        return mem;
    }

    public Object visit(ASTinstrs node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // instruction
    	int nis = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	tmp = (Paire)node.jjtGetChild(1).jjtAccept(this, n + nis);        // liste d'instructions
    	int niss = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	mem.incAdresse(nis+niss);
        return mem;
    }

    public Object visit(ASTinil node, Object data) throws MiniJajaException {
        return new Paire();
    }

    public Object visit(ASTtab node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	int n = (Integer)data;
        String ident = (String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();

    	mem = (Paire)node.jjtGetChild(1).jjtAccept(this, n);        // expression
        
    	mem.add((n+mem.getAdresse())+" aload(" + ident + ");\n");
    	mem.incAdresse(1);
        return mem;
    }

    public Object visit(ASTaffectation node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();    	
    	SimpleNode premierFils = (SimpleNode)node.jjtGetChild(0);
    	int n = (Integer)data;
    	if(premierFils instanceof ASTident) {
    		String ident = (String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();
	        mem = (Paire)node.jjtGetChild(1).jjtAccept(this, n);        // expression
	        mem.add((n+mem.getAdresse())+" store(" + ident + ");\n");
	        Integer tab[] = {n, n + mem.getAdresse()};
	        int key = node.jjtGetFirstToken().beginLine*100+node.jjtGetFirstToken().beginColumn;
	        this.tableCorrespondance.put(key, tab);
	        mem.incAdresse(1);
    	}
    	
    	if(premierFils instanceof ASTtab) {
    		String ident = (String) ((SimpleNode)premierFils.jjtGetChild(0)).jjtGetValue();
    		 
    		Paire tmp = new Paire();
			tmp = (Paire)premierFils.jjtGetChild(1).jjtAccept(this, n);
			mem.add(tmp.getInstructions());
			int ne = tmp.getAdresse();
			
			tmp = (Paire)node.jjtGetChild(1).jjtAccept(this, n + ne);
	        mem.add(tmp.getInstructions());
	        int ne1 = tmp.getAdresse();
            Integer tab[] = {n, n + ne + ne1};
            int key = node.jjtGetFirstToken().beginLine*100+node.jjtGetFirstToken().beginColumn;
            this.tableCorrespondance.put(key, tab);
	        mem.add((n+ne+ne1)+" astore(" + ident + ");\n");
	        mem.incAdresse(ne + ne1 + 1);
    	}
    	
        return mem;
    }

    public Object visit(ASTsomme node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();    	
    	SimpleNode premierFils = (SimpleNode)node.jjtGetChild(0);
    	int n = (Integer)data;
    	
    	if(premierFils instanceof ASTident) {
	        String ident = (String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();	        
	        mem = (Paire)node.jjtGetChild(1).jjtAccept(this, n);        // expression

            Integer tab[] = {n, n + mem.getAdresse()};
            int key = node.jjtGetFirstToken().beginLine*100+node.jjtGetFirstToken().beginColumn;
            this.tableCorrespondance.put(key, tab);

	        mem.add((n+mem.getAdresse())+" inc(" + ident + ");\n");	        
	        mem.incAdresse(1);
    	}
    	
    	if(premierFils instanceof ASTtab) {
    		
	        String ident = (String) ((SimpleNode)premierFils.jjtGetChild(0)).jjtGetValue();
	        
	        Paire tmp = new Paire();
	        tmp = (Paire)premierFils.jjtGetChild(1).jjtAccept(this, n);
	        mem.add(tmp.getInstructions());
	        int ne1 = tmp.getAdresse();
	        
	        tmp = (Paire)node.jjtGetChild(1).jjtAccept(this, n + ne1);
	        mem.add(tmp.getInstructions());
	        int ne = tmp.getAdresse();

            Integer tab[] = {n, n + ne + ne1};
            int key = node.jjtGetFirstToken().beginLine*100+node.jjtGetFirstToken().beginColumn;
            this.tableCorrespondance.put(key, tab);

	        mem.add((n+ne+ne1)+" ainc(" + ident + ");\n");	        
	        mem.incAdresse(ne + ne1 + 1);
    	}
        return mem;
    }

    public Object visit(ASTincrement node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	int n = (Integer)data;
        String ident = (String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();

        Integer tab[] = {n, n + 1};
        int key = node.jjtGetFirstToken().beginLine*100+node.jjtGetFirstToken().beginColumn;
        this.tableCorrespondance.put(key, tab);

        mem.add(n+" push(1);\n");
        mem.add((n+1)+" inc(" + ident + ");\n");
        mem.incAdresse(2);
        return mem;
    }

    public Object visit(ASTappelI node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
        String ident = (String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();
        
        tmp = (Paire)node.jjtGetChild(1).jjtAccept(this, n);        // liste d'expressions
        int nlexp = tmp.getAdresse();
        mem.add(tmp.getInstructions());
        
        mem.add((n+nlexp)+" invoke(" + ident + ");\n");
        
        this.retraitVisitor.resetInstruction();
        int nrlexp = (Integer)node.jjtGetChild(1).jjtAccept(this.retraitVisitor, nlexp + n +1);
        ArrayList<String> rDecls = this.retraitVisitor.getInstructions();
        mem.add(rDecls);
        mem.add((n+nrlexp+nlexp+1)+" pop;\n");
        mem.incAdresse(nrlexp+nlexp+2);

        Integer tab[] = {n, n + nlexp + nrlexp + 1};
        int key = node.jjtGetFirstToken().beginLine*100+node.jjtGetFirstToken().beginColumn;
        this.tableCorrespondance.put(key, tab);

        return mem;
    }

    public Object visit(ASTretour node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	int n = (Integer)data;
    	
    	mem = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // expression
    	Integer tab[] = {n, n + mem.getAdresse()};
    	int key = node.jjtGetFirstToken().beginLine*100+node.jjtGetFirstToken().beginColumn;
        this.tableCorrespondance.put(key, tab);
        return mem;
    }

    public Object visit(ASTsi node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
        Paire tmp = new Paire();

        int n = (Integer)data;
        
        tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);  // expression  
        int ne = tmp.getAdresse();
        mem.add(tmp.getInstructions());
        
        tmp = (Paire)node.jjtGetChild(2).jjtAccept(this, n+ne+1);  // instruction else
        int niss1 = tmp.getAdresse();
        
        mem.add((n+ne)+" if("+(n+ne+niss1+2)+");\n");
        mem.add(tmp.getInstructions()); //piss1
        
        tmp = (Paire)node.jjtGetChild(1).jjtAccept(this, n+niss1+ne+2);  // instruction 
        int niss = tmp.getAdresse();
        
        mem.add((n+ne+niss1+1)+" goto("+(n+ne+niss+niss1+2)+");\n");
        mem.add(tmp.getInstructions()); //piss
      

        Integer tab[] = {n, n + ne};
        int key = node.jjtGetFirstToken().beginLine*100+node.jjtGetFirstToken().beginColumn;
        this.tableCorrespondance.put(key, tab);
        
        mem.incAdresse(ne+niss1+niss+2);
       
        return mem;
    }

    public Object visit(ASTtantque node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp =(Paire) node.jjtGetChild(0).jjtAccept(this, n); // expression
    	int ne = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	tmp =(Paire) node.jjtGetChild(1).jjtAccept(this, n+ne+2); // instructions
    	int niss = tmp.getAdresse();
    	
        mem.add((n+ne)+" not;\n");
        mem.add((n+ne+1)+" if(" + (n+ne+niss+3) + ");\n");
        mem.add(tmp.getInstructions());
        mem.add((n+ne+niss+2)+" goto(" + n + ");\n");
        

        Integer tab[] = {n, n + ne+niss+3};
        int key = node.jjtGetFirstToken().beginLine*100+node.jjtGetFirstToken().beginColumn;
        this.tableCorrespondance.put(key, tab);
        
        mem.incAdresse(ne+niss+3);
        return mem;
    }

    public Object visit(ASTexnil node, Object data) throws MiniJajaException {
        return new Paire();
    }

    public Object visit(ASTlistexp node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // listes d'expressions
    	int ne = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	tmp = (Paire)node.jjtGetChild(1).jjtAccept(this, n+ne);        // expression
    	int nlexp = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	mem.incAdresse(ne+nlexp);
        return mem;
    }

    public Object visit(ASTnot node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // expression
    	int ne = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	 	
    	mem.add((n+ne)+" not;\n");
    	
    	mem.incAdresse(ne+1);
        return mem;
    }

    public Object visit(ASTet node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // expression
    	int ne = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	tmp  = (Paire)node.jjtGetChild(1).jjtAccept(this, n + ne);        // expression
    	int ne1 = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	mem.add((n+ne1+ne)+" and;\n");
    	
    	mem.incAdresse(ne1+ne+1);
        return mem;
    }

    public Object visit(ASTou node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // expression
    	int ne = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	tmp  = (Paire)node.jjtGetChild(1).jjtAccept(this, n + ne);        // expression
    	int ne1 = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	mem.add((n+ne1+ne)+" or;\n");
    	
    	mem.incAdresse(ne1+ne+1);
        return mem;
    }

    public Object visit(ASTegal node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // expression
    	int ne = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	tmp  = (Paire)node.jjtGetChild(1).jjtAccept(this, n + ne);        // expression
    	int ne1 = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	mem.add((n+ne1+ne)+" cmp;\n");
    	
    	mem.incAdresse(ne1+ne+1);
        return mem;
    }

    public Object visit(ASTsupga node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // expression
    	int ne = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	tmp  = (Paire)node.jjtGetChild(1).jjtAccept(this, n + ne);        // expression
    	int ne1 = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	mem.add((n+ne1+ne)+" sup;\n");
    	
    	mem.incAdresse(ne1+ne+1);
        return mem;
    }

    public Object visit(ASTmoinsU node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // expression
    	int ne = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	 	
    	mem.add((n+ne)+" neg;\n");
    	
    	mem.incAdresse(ne+1);
        return mem;
    }

    public Object visit(ASTplus node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // expression
    	int ne = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	tmp  = (Paire)node.jjtGetChild(1).jjtAccept(this, n + ne);        // expression
    	int ne1 = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	mem.add((n+ne1+ne)+" add;\n");
    	
    	mem.incAdresse(ne1+ne+1);
        return mem;
    }

    public Object visit(ASTmoinsB node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // expression
    	int ne = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	tmp  = (Paire)node.jjtGetChild(1).jjtAccept(this, n + ne);        // expression
    	int ne1 = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	mem.add((n+ne1+ne)+" sub;\n");
    	
    	mem.incAdresse(ne1+ne+1);
        return mem;
    }

    public Object visit(ASTmult node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // expression
    	int ne = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	tmp  = (Paire)node.jjtGetChild(1).jjtAccept(this, n + ne);        // expression
    	int ne1 = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	mem.add((n+ne1+ne)+" mul;\n");
    	
    	mem.incAdresse(ne1+ne+1);
        return mem;
    }

    public Object visit(ASTdiv node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	
    	tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // expression
    	int ne = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	tmp  = (Paire)node.jjtGetChild(1).jjtAccept(this, n + ne);        // expression
    	int ne1 = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	mem.add((n+ne1+ne)+" div;\n");
    	mem.incAdresse(ne1+ne+1);
        return mem;
    }

    public Object visit(ASTvrai node, Object data) throws MiniJajaException {
    	int n = (Integer)data;
    	return new Paire(n+" push(jcvrai);\n",1);
    }

    public Object visit(ASTfaux node, Object data) throws MiniJajaException {
    	int n = (Integer)data;
        return new Paire(n+" push(jcfaux);\n",1);
    }

    public Object visit(ASTappelE node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
    	 
        String ident = (String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();
       
        tmp = (Paire)node.jjtGetChild(1).jjtAccept(this, n); // liste d'expressions
        int nlexp = tmp.getAdresse();
        mem.add(tmp.getInstructions());
        
        mem.add((n+nlexp)+" invoke(" + ident + ");\n");
        
        this.retraitVisitor.resetInstruction();
        int nrlexp = (Integer)node.jjtGetChild(1).jjtAccept(this.retraitVisitor, n + nlexp+1);
        ArrayList<String> rDecls = this.retraitVisitor.getInstructions();
        
        Integer tab[] = {n, n + nlexp + nrlexp + 1};
        int key = node.jjtGetFirstToken().beginLine*100+node.jjtGetFirstToken().beginColumn;
        this.tableCorrespondance.put(key, tab);
        
        mem.add(rDecls);
        mem.incAdresse(nlexp + nrlexp + 1);
        return mem;
    }

    public Object visit(ASTnbre node, Object data) throws MiniJajaException {
    	int n = (Integer)data;
        return new Paire(n+" push(" + node.jjtGetValue() + ");\n", 1);
    }

    public Object visit(ASTrien node, Object data) throws MiniJajaException {
        return "vide";
    }

    public Object visit(ASTentier node, Object data) throws MiniJajaException {
        return "entier";
    }

    public Object visit(ASTbooleen node, Object data) throws MiniJajaException {
        return "booleen";
    }

    public void compterEntete(Node node)
    {
    	if(node instanceof ASTentetes)
    	{
    		k++;
    		compterEntete(node.jjtGetChild(1));
    	}
    }
    
    public HashMap<Integer, Integer[]> getTable() {
    	return this.tableCorrespondance;
    }
    
    public void afficherTable() {

    	for(Entry<Integer, Integer[]> entry : this.tableCorrespondance.entrySet()) {
    	    Integer key = entry.getKey();
    	    Integer[] value = entry.getValue();

    	    // do what you have to do here
    	    // In your case, an other loop.
    	    
    	    System.out.println(key + " : " + value[0] + ", " + value[1]);
    	}
    }
}
