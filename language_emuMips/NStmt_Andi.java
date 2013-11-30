/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Andi
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$7 e$7;
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
    walker.inStmt_Andi(this);
    walker.caseStmt_Andi(this);
    walker.outStmt_Andi(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$7.apply(walker);
    this.eImmExpr.apply(walker);
  }

  NStmt_Andi(int line, int pos, N$7 p$7, NImmExpr pImmExpr) {
    this.line = line;
    this.pos = pos;
    this.e$7 = p$7;
    this.eImmExpr = pImmExpr;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Andi;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Andi;
  }

  public NImmExpr get_ImmExpr() {
    return this.eImmExpr;
  }

  N$7 internalGet$7() {
    return this.e$7;
  }

  NImmExpr internalGetImmExpr() {
    return this.eImmExpr;
  }
}
