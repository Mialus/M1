/* Generated By:JJTree: Do not edit this line. ASTappelE.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package fr.univfcomte.comp4.analyseur;

public
class ASTappelE extends SimpleNode {
  public ASTappelE(int id) {
    super(id);
  }

  public ASTappelE(MiniJaja p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MiniJajaVisitor visitor, Object data) throws MiniJajaException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=0d016f090e8d1d3f73aec169cb1fc289 (do not edit this line) */