/* Generated By:JJTree: Do not edit this line. ASTtab.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package fr.univfcomte.comp4.analyseur;

public
class ASTtab extends SimpleNode {
  public ASTtab(int id) {
    super(id);
  }

  public ASTtab(MiniJaja p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MiniJajaVisitor visitor, Object data) throws MiniJajaException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=6d0aaa0cc9ccc494042067ec85022996 (do not edit this line) */