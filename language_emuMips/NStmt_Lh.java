/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Lh
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$27 e$27;
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
    walker.inStmt_Lh(this);
    walker.caseStmt_Lh(this);
    walker.outStmt_Lh(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$27.apply(walker);
    this.eArray.apply(walker);
  }

  NStmt_Lh(int line, int pos, N$27 p$27, NArray pArray) {
    this.line = line;
    this.pos = pos;
    this.e$27 = p$27;
    this.eArray = pArray;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Lh;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Lh;
  }

  public NArray get_Array() {
    return this.eArray;
  }

  N$27 internalGet$27() {
    return this.e$27;
  }

  NArray internalGetArray() {
    return this.eArray;
  }
}
