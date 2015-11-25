package fr.univfcomte.comp4.compilateur;
import fr.univfcomte.comp4.analyseur.*;

import sun.java2d.pipe.SpanShapeRenderer;

import java.util.ArrayList;

public class MiniJajaCompilateurVisitor implements MiniJajaVisitor{

	private int k = 0; // k un compteur à gérer pour le nombre d'ente d'une méthode
    private ArrayList<String> instructions;
    private MiniJajaCompilateurRetraitVisitor retraitVisitor;

    public MiniJajaCompilateurVisitor()
    {
        super();
        this.retraitVisitor = new MiniJajaCompilateurRetraitVisitor();
        this.instructions = new ArrayList<String>();
    }

    public Object visit(SimpleNode node, Object data) throws MiniJajaException {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(ASTclasse node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	int n = (Integer)data;
        mem.add("init;\n");
        
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
        
        mem.add("pop;\n");
        mem.add("jcstop;\n");
        mem.incAdresse( ndss + nmma + nrdss + 3);
        
        return mem;
    }

    public Object visit(ASTident node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
        String ident = (String) node.jjtGetValue();

        mem.add("load(" + ident + ");\n");
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
        
        mem.add("push(" + (n+3) + ");\n");
        mem.add("new(" + ident + ", " + type + ", meth, 0);\n");
        mem.add("goto("+(n+ nens + ndvs+ niss + nrdvs + 5 + indiceRien)+");\n");
        mem.add(tmp.getInstructions());
        mem.add(tmp1.getInstructions());
        mem.add(tmp2.getInstructions());
        
        if(type.equals("vide"))
        {
        	mem.add("push(0);\n");
        }
        
        mem.add(rDecls);
        mem.add("swap;\n");
        mem.add("return;\n");

        mem.incAdresse(nens + ndvs+ niss + nrdvs + 5 + indiceRien);
        return mem;
    }

    public Object visit(ASTtableau node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	int n = (Integer)data;
        String type = (String)(node.jjtGetChild(0)).jjtAccept(this, null);              // type
        String ident = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();        // ident
        
        mem = (Paire) node.jjtGetChild(2).jjtAccept(this, n);                              // expression
        mem.add("newarray(" + ident + ", " + type + ");\n");
        mem.incAdresse(1);
        
        return mem;
    }

    public Object visit(ASTvar node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	int n = (Integer)data;
        String type = (String)(node.jjtGetChild(0)).jjtAccept(this, null);
        String ident = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();

        mem = (Paire) node.jjtGetChild(2).jjtAccept(this, n);                              // expression
        mem.add("new(" + ident + ", " + type + ", var, 0);\n");
        mem.incAdresse(1);
        
        return mem;
    }

    public Object visit(ASTcst node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	int n = (Integer)data;
        String type = (String)(node.jjtGetChild(0)).jjtAccept(this, n);
        String ident = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();

        mem = (Paire) node.jjtGetChild(2).jjtAccept(this, n);                              // expression
        mem.add("new(" + ident + ", " + type + ", cst, 0);\n");
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
        return new Paire("push(w);\n",1);
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
    	
        mem.add( "push(0);\n");
        
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
    	
    	tmp = (Paire)node.jjtGetChild(1).jjtAccept(this, nen);        // liste d'en-têtes
    	int nens = tmp.getAdresse();
    	mem.add(tmp.getInstructions());
    	
    	mem.incAdresse(nens+nen);

        return mem;
    }

    public Object visit(ASTentete node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
        String type = (String)(node.jjtGetChild(0)).jjtAccept(this, null);
        String ident = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();

        mem.add("new(" + ident + ", " + type + ", var, "+k+");\n");      // k : compteur à gérer
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
        
    	mem.add("aload(" + ident + ");\n");
    	mem.incAdresse(1);
        return mem;
    }

    public Object visit(ASTaffectation node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
        String ident = (String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();
        int n = (Integer)data;
        mem = (Paire)node.jjtGetChild(1).jjtAccept(this, n);        // expression
        
        mem.add("store(" + ident + ");\n");
        mem.incAdresse(1);
        return mem;
    }

    public Object visit(ASTsomme node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();    	
    	SimpleNode premierFils = (SimpleNode)node.jjtGetChild(0);
    	System.out.println("ASTsomme : " + premierFils);
    	int n = (Integer)data;
    	
    	if(premierFils instanceof ASTident) {
	        String ident = (String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();	        
	        mem = (Paire)node.jjtGetChild(1).jjtAccept(this, n);        // expression
	        mem.add("inc(" + ident + ");\n");	        
	        mem.incAdresse(1);
    	}
    	
    	if(premierFils instanceof ASTtab) {
    		System.out.println("ASTtsomme");
    		
	        String ident = (String) ((SimpleNode)premierFils.jjtGetChild(0)).jjtGetValue();
	        
	        Paire tmp = new Paire();
	        tmp = (Paire)premierFils.jjtGetChild(1).jjtAccept(this, n);
	        mem.add(tmp.getInstructions());
	        int ne1 = tmp.getAdresse();
	        
	        tmp = (Paire)node.jjtGetChild(1).jjtAccept(this, n + ne1);
	        mem.add(tmp.getInstructions());
	        int ne = tmp.getAdresse();
	        
	        mem.add("ainc(" + ident + ");\n");	        
	        mem.incAdresse(ne + ne1 + 1);
    	}
        return mem;
    }

    public Object visit(ASTincrement node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
        String ident = (String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();

        mem.add("push(1);\n");
        mem.add("inc(" + ident + ");\n");
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
        
        mem.add("invoke(" + ident + ");\n");
        
        this.retraitVisitor.resetInstruction();
        int nrlexp = (Integer)node.jjtGetChild(1).jjtAccept(this.retraitVisitor, nlexp + n +1);
        ArrayList<String> rDecls = this.retraitVisitor.getInstructions();
        mem.add(rDecls);
        
        mem.add("pop;\n");
        mem.incAdresse(nrlexp+nlexp+2);
        
        return mem;
    }

    public Object visit(ASTretour node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	int n = (Integer)data;
    	mem = (Paire)node.jjtGetChild(0).jjtAccept(this, n);        // expression

        return mem;
    }

    public Object visit(ASTsi node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
        Paire tmp = new Paire();

        int n = (Integer)data;
        
        tmp = (Paire)node.jjtGetChild(0).jjtAccept(this, n);  // expression  
        int ne = tmp.getAdresse();
        mem.add(tmp.getInstructions());
        
        tmp = (Paire)node.jjtGetChild(2).jjtAccept(this, n+ne);  // instruction else
        int niss1 = tmp.getAdresse();
        
        mem.add("if("+(n+ne+niss1+2)+");\n");
        mem.add(tmp.getInstructions()); //piss1
        
        tmp = (Paire)node.jjtGetChild(1).jjtAccept(this, n+niss1+ne+2);  // instruction 
        int niss = tmp.getAdresse();
        
        mem.add("goto("+(n+ne+niss+niss1+2)+");\n");
        mem.add(tmp.getInstructions()); //piss
      

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
    	
        mem.add("not;\n");
        mem.add("if(" + (n+ne+niss+3) + ");\n");
        mem.add(tmp.getInstructions());
        mem.add("goto(" + n + ");\n");
        

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
    	 	
    	mem.add("not;\n");
    	
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
    	
    	mem.add("and;\n");
    	
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
    	
    	mem.add("or;\n");
    	
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
    	
    	mem.add("cmp;\n");
    	
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
    	
    	mem.add("sup;\n");
    	
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
    	 	
    	mem.add("neg;\n");
    	
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
    	
    	mem.add("add;\n");
    	
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
    	
    	mem.add("sub;\n");
    	
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
    	
    	mem.add("mul;\n");
    	
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
    	
    	mem.add("div;\n");
    	mem.incAdresse(ne1+ne+1);
        return mem;
    }

    public Object visit(ASTvrai node, Object data) throws MiniJajaException {
    	return new Paire("jcvrai;\n",1);
    }

    public Object visit(ASTfaux node, Object data) throws MiniJajaException {
        return new Paire("jcfaux;\n",1);
    }

    public Object visit(ASTappelE node, Object data) throws MiniJajaException {
    	Paire mem = new Paire();
    	Paire tmp = new Paire();
    	 int n = (Integer)data;
    	 
        String ident = (String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();
       
        tmp = (Paire)node.jjtGetChild(1).jjtAccept(this, n); // liste d'expressions
        int nlexp = tmp.getAdresse();
        mem.add(tmp.getInstructions());
        
        mem.add("invoke(" + ident + ");\n");
        
        this.retraitVisitor.resetInstruction();
        int nrlexp = (Integer)node.jjtGetChild(1).jjtAccept(this.retraitVisitor, n + nlexp+1);
        ArrayList<String> rDecls = this.retraitVisitor.getInstructions();
        
        mem.add(rDecls);
        mem.incAdresse(nlexp + nrlexp + 1);
        return mem;
    }

    public Object visit(ASTnbre node, Object data) throws MiniJajaException {
        return new Paire("push(" + node.jjtGetValue() + ");\n", 1);
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
}