/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Lw
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$28 e$28;
  private final NArray eArray;

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
    walker.inStmt_Lw(this);
    walker.caseStmt_Lw(this);
    walker.outStmt_Lw(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$28.apply(walker);
    this.eArray.apply(walker);
  }

  NStmt_Lw(int line, int pos, N$28 p$28, NArray pArray) {
    this.line = line;
    this.pos = pos;
    this.e$28 = p$28;
    this.eArray = pArray;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Lw;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Lw;
  }

  public NArray get_Array() {
    return this.eArray;
  }

  N$28 internalGet$28() {
    return this.e$28;
  }

  NArray internalGetArray() {
    return this.eArray;
  }
}