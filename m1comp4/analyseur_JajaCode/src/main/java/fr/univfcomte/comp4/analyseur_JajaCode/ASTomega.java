/* Generated By:JJTree: Do not edit this line. ASTomega.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package fr.univfcomte.comp4.analyseur_JajaCode;

public
class ASTomega extends SimpleNode {
  public ASTomega(int id) {
    super(id);
  }

  public ASTomega(JajaCode p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(JajaCodeVisitor visitor, Object data) throws JajaCodeException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=1896dec71a16269d3dd930b71f4cac50 (do not edit this line) */
