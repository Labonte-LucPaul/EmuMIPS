/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Sll
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$17 e$17;
  private final NShift eShift;

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
    walker.inStmt_Sll(this);
    walker.caseStmt_Sll(this);
    walker.outStmt_Sll(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$17.apply(walker);
    this.eShift.apply(walker);
  }

  NStmt_Sll(int line, int pos, N$17 p$17, NShift pShift) {
    this.line = line;
    this.pos = pos;
    this.e$17 = p$17;
    this.eShift = pShift;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Sll;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Sll;
  }

  public NShift get_Shift() {
    return this.eShift;
  }

  N$17 internalGet$17() {
    return this.e$17;
  }

  NShift internalGetShift() {
    return this.eShift;
  }
}
