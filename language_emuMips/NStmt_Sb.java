/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Sb
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$26 e$26;
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
    walker.inStmt_Sb(this);
    walker.caseStmt_Sb(this);
    walker.outStmt_Sb(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$26.apply(walker);
    this.eImmExpr.apply(walker);
  }

  NStmt_Sb(int line, int pos, N$26 p$26, NImmExpr pImmExpr) {
    this.line = line;
    this.pos = pos;
    this.e$26 = p$26;
    this.eImmExpr = pImmExpr;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Sb;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Sb;
  }

  public NImmExpr get_ImmExpr() {
    return this.eImmExpr;
  }

  N$26 internalGet$26() {
    return this.e$26;
  }

  NImmExpr internalGetImmExpr() {
    return this.eImmExpr;
  }
}
