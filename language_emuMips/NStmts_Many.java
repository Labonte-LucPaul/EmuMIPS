/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmts_Many
    extends NStmts {

  private final int line;
  private final int pos;
  private final NStmt eStmt;
  private final NStmts eStmts;

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
    walker.inStmts_Many(this);
    walker.caseStmts_Many(this);
    walker.outStmts_Many(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.eStmt.apply(walker);
    this.eStmts.apply(walker);
  }

  public NStmts_Many(int line, int pos, NStmt pStmt, NStmts pStmts) {
    this.line = line;
    this.pos = pos;
    this.eStmt = pStmt;
    this.eStmts = pStmts;
  }

  @Override
  public Type getType() {
    return Type.T_Stmts_Many;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmts;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmts_Many;
  }

  public NStmt get_Stmt() {
    return this.eStmt;
  }

  public NStmts get_Stmts() {
    return this.eStmts;
  }

  NStmt internalGetStmt() {
    return this.eStmt;
  }

  NStmts internalGetStmts() {
    return this.eStmts;
  }
}
