/* Generated By:JJTree: Do not edit this line. ASTdiv.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package fr.univfcomte.comp4.analyseur;

public
class ASTdiv extends SimpleNode {
  public ASTdiv(int id) {
    super(id);
  }

  public ASTdiv(MiniJaja p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MiniJajaVisitor visitor, Object data) throws MiniJajaException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=21d7c7c916dcd54e4d98377212362105 (do not edit this line) */
