/* Generated By:JJTree: Do not edit this line. ASTrien.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package fr.univfcomte.comp4.analyseur;

public
class ASTrien extends SimpleNode {
  public ASTrien(int id) {
    super(id);
  }

  public ASTrien(MiniJaja p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MiniJajaVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=54bf157a0dfb41aa2ccf6b0a8a7dcb9a (do not edit this line) */
