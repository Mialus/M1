/* Generated By:JJTree: Do not edit this line. ASTjcnil.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package fr.univfcomte.comp4.analyseur_JajaCode;

public
class ASTjcnil extends SimpleNode {
  public ASTjcnil(int id) {
    super(id);
  }

  public ASTjcnil(JajaCode p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(JajaCodeVisitor visitor, Object data) throws JajaCodeException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=fc125c15d5cced9a1ae63fbb924e569f (do not edit this line) */
