/* Generated By:JJTree: Do not edit this line. ASTinvoke.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package fr.univfcomte.comp4.analyseur_JajaCode;

public
class ASTinvoke extends SimpleNode {
  public ASTinvoke(int id) {
    super(id);
  }

  public ASTinvoke(JajaCode p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(JajaCodeVisitor visitor, Object data) throws JajaCodeException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=60a6c784f25a9d5b4b0fbb94566a0585 (do not edit this line) */