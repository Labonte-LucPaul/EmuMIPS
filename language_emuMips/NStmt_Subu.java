/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Subu
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$5 e$5;
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
    walker.inStmt_Subu(this);
    walker.caseStmt_Subu(this);
    walker.outStmt_Subu(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$5.apply(walker);
    this.eRegExpr.apply(walker);
  }

  NStmt_Subu(int line, int pos, N$5 p$5, NRegExpr pRegExpr) {
    this.line = line;
    this.pos = pos;
    this.e$5 = p$5;
    this.eRegExpr = pRegExpr;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Subu;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Subu;
  }

  public NRegExpr get_RegExpr() {
    return this.eRegExpr;
  }

  N$5 internalGet$5() {
    return this.e$5;
  }

  NRegExpr internalGetRegExpr() {
    return this.eRegExpr;
  }
}
