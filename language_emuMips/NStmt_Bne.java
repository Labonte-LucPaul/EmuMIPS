/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Bne
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$20 e$20;
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
    walker.inStmt_Bne(this);
    walker.caseStmt_Bne(this);
    walker.outStmt_Bne(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$20.apply(walker);
    this.eImmExpr.apply(walker);
  }

  NStmt_Bne(int line, int pos, N$20 p$20, NImmExpr pImmExpr) {
    this.line = line;
    this.pos = pos;
    this.e$20 = p$20;
    this.eImmExpr = pImmExpr;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Bne;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Bne;
  }

  public NImmExpr get_ImmExpr() {
    return this.eImmExpr;
  }

  N$20 internalGet$20() {
    return this.e$20;
  }

  NImmExpr internalGetImmExpr() {
    return this.eImmExpr;
  }
}
