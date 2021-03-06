package fr.univfcomte.comp4.interpreteur_MiniJaja;

import fr.univfcomte.comp4.memoire_MiniJaja.*;
import fr.univfcomte.comp4.analyseur.*;

public class MiniJajaRetraitVisitor implements MiniJajaVisitor{

	public Object visit(SimpleNode node, Object data) throws MiniJajaException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visit(ASTclasse node, Object data) throws MiniJajaException {
		String nom = (String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();
		node.jjtGetChild(2).jjtAccept(this, data);
		node.jjtGetChild(1).jjtAccept(this, data);
		((MemoireMiniJaja)data).retirerDecl(nom);
		return null;
	}

	public Object visit(ASTident node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTdecls node, Object data) throws MiniJajaException {
		for(int i =(node.jjtGetNumChildren()-1); i>=0; i--)
		{
			((SimpleNode)node.jjtGetChild(i)).jjtAccept(this, data);
		}
		return null;
	}

	public Object visit(ASTvnil node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTmethode node, Object data) throws MiniJajaException {
		String nom = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();
		((MemoireMiniJaja)data).retirerDecl(nom);
		return null;
	}

	public Object visit(ASTtableau node, Object data) throws MiniJajaException {
		String nom = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();
		((MemoireMiniJaja)data).retirerDecl(nom);
		return null;
	}

	public Object visit(ASTvar node, Object data) throws MiniJajaException {
		String nom = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();
		((MemoireMiniJaja)data).retirerDecl(nom);
		return null;
	}

	public Object visit(ASTcst node, Object data) throws MiniJajaException {
		String nom = (String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();
		((MemoireMiniJaja)data).retirerDecl(nom);
		return null;
	}

	public Object visit(ASTvars node, Object data) throws MiniJajaException {
		for(int i =(node.jjtGetNumChildren()-1); i>=0; i--)
		{
			((SimpleNode)node.jjtGetChild(i)).jjtAccept(this, data);
		}
		return null;
	}

	public Object visit(ASTomega node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTmain node, Object data) throws MiniJajaException {
		((SimpleNode)node.jjtGetChild(0)).jjtAccept(this,data);
		return null;
	}

	public Object visit(ASTenil node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTentetes node, Object data) throws MiniJajaException {
		for(int i =(node.jjtGetNumChildren()-1); i>=0; i--)
		{
			((SimpleNode)node.jjtGetChild(i)).jjtAccept(this, data);
		}
		return null;
	}

	public Object visit(ASTentete node, Object data) throws MiniJajaException {
		String nom =(String) ((SimpleNode)node.jjtGetChild(1)).jjtGetValue();
		((MemoireMiniJaja)data).retirerDecl(nom);
		return null;
	}

	public Object visit(ASTinstrs node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTinil node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTtab node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTaffectation node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTsomme node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTincrement node, Object data) throws MiniJajaException {
		return null;
	}

	
	public Object visit(ASTappelI node, Object data) throws MiniJajaException {
		String nom =(String) ((SimpleNode)node.jjtGetChild(0)).jjtGetValue();
		SimpleNode methode = (SimpleNode)((MemoireMiniJaja)data).val(nom).getVal();
		((SimpleNode)methode.jjtGetChild(3)).jjtAccept(this, data);
		((SimpleNode)methode.jjtGetChild(2)).jjtAccept(this, data);

		return null;
	}

	public Object visit(ASTretour node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTsi node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTtantque node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTexnil node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTlistexp node, Object data) throws MiniJajaException {
		for(int i =(node.jjtGetNumChildren()-1); i>=0; i--)
		{
			((SimpleNode)node.jjtGetChild(i)).jjtAccept(this, data);
		}
		return null;
	}

	public Object visit(ASTnot node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTet node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTou node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTegal node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTsupga node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTmoinsU node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTplus node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTmoinsB node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTmult node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTdiv node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTvrai node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTfaux node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTappelE node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTnbre node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTrien node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTentier node, Object data) throws MiniJajaException {
		return null;
	}

	public Object visit(ASTbooleen node, Object data) throws MiniJajaException {
		return null;
	}

}
