/* Generated By:JJTree: Do not edit this line. ASTmoinsU.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package fr.univfcomte.comp4.analyseur;

public
class ASTmoinsU extends SimpleNode {
  public ASTmoinsU(int id) {
    super(id);
  }

  public ASTmoinsU(MiniJaja p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MiniJajaVisitor visitor, Object data) throws MiniJajaException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=e1b5a38520810334ebfc3f384fee4c0c (do not edit this line) */
