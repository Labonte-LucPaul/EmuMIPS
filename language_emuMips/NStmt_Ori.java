/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Ori
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$9 e$9;
  private final NImmExpr eImmExpr;

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
    walker.inStmt_Ori(this);
    walker.caseStmt_Ori(this);
    walker.outStmt_Ori(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$9.apply(walker);
    this.eImmExpr.apply(walker);
  }

  NStmt_Ori(int line, int pos, N$9 p$9, NImmExpr pImmExpr) {
    this.line = line;
    this.pos = pos;
    this.e$9 = p$9;
    this.eImmExpr = pImmExpr;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Ori;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Ori;
  }

  public NImmExpr get_ImmExpr() {
    return this.eImmExpr;
  }

  N$9 internalGet$9() {
    return this.e$9;
  }

  NImmExpr internalGetImmExpr() {
    return this.eImmExpr;
  }
}
