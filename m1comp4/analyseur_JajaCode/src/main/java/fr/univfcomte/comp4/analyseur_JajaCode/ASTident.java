/* Generated By:JJTree: Do not edit this line. ASTident.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package fr.univfcomte.comp4.analyseur_JajaCode;

public
class ASTident extends SimpleNode {
  public ASTident(int id) {
    super(id);
  }

  public ASTident(JajaCode p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(JajaCodeVisitor visitor, Object data) throws JajaCodeException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=98ded3756b850376daba552cf90bafd9 (do not edit this line) */
