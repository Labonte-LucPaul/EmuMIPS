/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Lb
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$23 e$23;
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
    walker.inStmt_Lb(this);
    walker.caseStmt_Lb(this);
    walker.outStmt_Lb(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$23.apply(walker);
    this.eArray.apply(walker);
  }

  NStmt_Lb(int line, int pos, N$23 p$23, NArray pArray) {
    this.line = line;
    this.pos = pos;
    this.e$23 = p$23;
    this.eArray = pArray;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Lb;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Lb;
  }

  public NArray get_Array() {
    return this.eArray;
  }

  N$23 internalGet$23() {
    return this.e$23;
  }

  NArray internalGetArray() {
    return this.eArray;
  }
}
