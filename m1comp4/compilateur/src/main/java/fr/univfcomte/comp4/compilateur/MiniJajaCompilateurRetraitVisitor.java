package fr.univfcomte.comp4.compilateur;
import fr.univfcomte.comp4.analyseur.*;

import java.util.ArrayList;

public class MiniJajaCompilateurRetraitVisitor implements MiniJajaVisitor{

    private ArrayList<String> instructions;

    public void resetInstruction()
    {
    	this.instructions.clear();
    }
    
    public ArrayList<String> getInstructions()
    {
    	return this.instructions;
    }
    
    public MiniJajaCompilateurRetraitVisitor()
    {
        super();
        this.instructions = new ArrayList<String>();
    }

    public Object visit(SimpleNode node, Object data) throws MiniJajaException {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(ASTclasse node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTident node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTdecls node, Object data) throws MiniJajaException {
    	int n = (Integer)data;
    	int nds = (Integer)node.jjtGetChild(1).jjtAccept(this, n);      // liste de déclarations
    	int ndss = (Integer)node.jjtGetChild(0).jjtAccept(this, n + nds);      // déclaration

        return ndss + nds;
    }

    public Object visit(ASTvnil node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTmethode node, Object data) throws MiniJajaException {
    	int n = (Integer)data;
        this.instructions.add(n+" swap;\n");
        this.instructions.add((n+1)+" pop;\n");

        return 2;
    }

    public Object visit(ASTtableau node, Object data) throws MiniJajaException {
    	int n = (Integer)data;
    	this.instructions.add(n+" swap;\n");
    	this.instructions.add((n+1)+" pop;\n");

    	return 2;
    }

    public Object visit(ASTvar node, Object data) throws MiniJajaException {
    	int n = (Integer)data;
    	this.instructions.add(n+" swap;\n");
    	this.instructions.add((n+1)+" pop;\n");

    	return 2;
    }

    public Object visit(ASTcst node, Object data) throws MiniJajaException {
    	int n = (Integer)data;
    	this.instructions.add(n+" swap;\n");
    	this.instructions.add((n+1)+" pop;\n");

    	return 2;
    }

    public Object visit(ASTvars node, Object data) throws MiniJajaException {
    	int n = (Integer)data;
    	int nds = (Integer)node.jjtGetChild(1).jjtAccept(this, n);      // liste de déclarations de variables
    	int ndss = (Integer)node.jjtGetChild(0).jjtAccept(this, nds + n);      // déclaration de variable

        return ndss + nds;
    }

    public Object visit(ASTomega node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTmain node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTenil node, Object data) throws MiniJajaException {
        return 0;
    }

    public Object visit(ASTentetes node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTentete node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTinstrs node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTinil node, Object data) throws MiniJajaException {
        return 0;
    }

    public Object visit(ASTtab node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTaffectation node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTsomme node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTincrement node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTappelI node, Object data) throws MiniJajaException {


        return 0;
    }

    public Object visit(ASTretour node, Object data) throws MiniJajaException {



        return 0;
    }

    public Object visit(ASTsi node, Object data) throws MiniJajaException {


        return 0;
    }

    public Object visit(ASTtantque node, Object data) throws MiniJajaException {



        return 0;
    }

    public Object visit(ASTexnil node, Object data) throws MiniJajaException {
        return 0;
    }

    public Object visit(ASTlistexp node, Object data) throws MiniJajaException {
    	int n = (Integer)data;
    	this.instructions.add(n+" swap;\n");
    	this.instructions.add((n+1)+" pop;\n");
    	int nlexp = (Integer)node.jjtGetChild(1).jjtAccept(this, n+2);      // liste d'expressions

        return nlexp+2;
    }

    public Object visit(ASTnot node, Object data) throws MiniJajaException {



        return 0;
    }

    public Object visit(ASTet node, Object data) throws MiniJajaException {



        return 0;
    }

    public Object visit(ASTou node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTegal node, Object data) throws MiniJajaException {


        return 0;
    }

    public Object visit(ASTsupga node, Object data) throws MiniJajaException {


        return 0;
    }

    public Object visit(ASTmoinsU node, Object data) throws MiniJajaException {


        return 0;
    }

    public Object visit(ASTplus node, Object data) throws MiniJajaException {


        return 0;
    }

    public Object visit(ASTmoinsB node, Object data) throws MiniJajaException {
        return 0;
    }

    public Object visit(ASTmult node, Object data) throws MiniJajaException {


        return 0;
    }

    public Object visit(ASTdiv node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTvrai node, Object data) throws MiniJajaException {


        return 0;
    }

    public Object visit(ASTfaux node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTappelE node, Object data) throws MiniJajaException {


        return 0;
    }

    public Object visit(ASTnbre node, Object data) throws MiniJajaException {

        return 0;
    }

    public Object visit(ASTrien node, Object data) throws MiniJajaException {
        return 0;
    }

    public Object visit(ASTentier node, Object data) throws MiniJajaException {
        return 0;
    }

    public Object visit(ASTbooleen node, Object data) throws MiniJajaException {
        return 0;
    }

    //Règles pour le retrait des déclarations


}
