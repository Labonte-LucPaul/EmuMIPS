/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Addu
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$2 e$2;
  private final NRegExpr eRegExpr;

  @Override
  public int getLine() {
    return this.line;
  }

  @Override
  public int getPos() {
    return this.pos;
  }

  @Override
  public String getText() {
    return null;
  }

  @Override
  public void apply(Walker walker) {
    walker.inStmt_Addu(this);
    walker.caseStmt_Addu(this);
    walker.outStmt_Addu(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$2.apply(walker);
    this.eRegExpr.apply(walker);
  }

  NStmt_Addu(int line, int pos, N$2 p$2, NRegExpr pRegExpr) {
    this.line = line;
    this.pos = pos;
    this.e$2 = p$2;
    this.eRegExpr = pRegExpr;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Addu;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Addu;
  }

  public NRegExpr get_RegExpr() {
    return this.eRegExpr;
  }

  N$2 internalGet$2() {
    return this.e$2;
  }

  NRegExpr internalGetRegExpr() {
    return this.eRegExpr;
  }
}
