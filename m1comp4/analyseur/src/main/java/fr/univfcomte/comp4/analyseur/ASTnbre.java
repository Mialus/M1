/* Generated By:JJTree: Do not edit this line. ASTnbre.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package fr.univfcomte.comp4.analyseur;

public
class ASTnbre extends SimpleNode {
  public ASTnbre(int id) {
    super(id);
  }

  public ASTnbre(MiniJaja p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MiniJajaVisitor visitor, Object data) throws MiniJajaException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=1e287f15c158485e244bd35caadc628b (do not edit this line) */
