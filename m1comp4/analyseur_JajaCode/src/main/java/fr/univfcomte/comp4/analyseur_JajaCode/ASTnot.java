/* Generated By:JJTree: Do not edit this line. ASTnot.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package fr.univfcomte.comp4.analyseur_JajaCode;

public
class ASTnot extends SimpleNode {
  public ASTnot(int id) {
    super(id);
  }

  public ASTnot(JajaCode p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(JajaCodeVisitor visitor, Object data) throws JajaCodeException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=40b88f4b9e5c4269d9c39633f175599f (do not edit this line) */