/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Slti
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$14 e$14;
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
    walker.inStmt_Slti(this);
    walker.caseStmt_Slti(this);
    walker.outStmt_Slti(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$14.apply(walker);
    this.eImmExpr.apply(walker);
  }

  NStmt_Slti(int line, int pos, N$14 p$14, NImmExpr pImmExpr) {
    this.line = line;
    this.pos = pos;
    this.e$14 = p$14;
    this.eImmExpr = pImmExpr;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Slti;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Slti;
  }

  public NImmExpr get_ImmExpr() {
    return this.eImmExpr;
  }

  N$14 internalGet$14() {
    return this.e$14;
  }

  NImmExpr internalGetImmExpr() {
    return this.eImmExpr;
  }
}
