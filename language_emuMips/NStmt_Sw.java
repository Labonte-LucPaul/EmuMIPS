/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Sw
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$32 e$32;
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
    walker.inStmt_Sw(this);
    walker.caseStmt_Sw(this);
    walker.outStmt_Sw(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$32.apply(walker);
    this.eArray.apply(walker);
  }

  NStmt_Sw(int line, int pos, N$32 p$32, NArray pArray) {
    this.line = line;
    this.pos = pos;
    this.e$32 = p$32;
    this.eArray = pArray;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Sw;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Sw;
  }

  public NArray get_Array() {
    return this.eArray;
  }

  N$32 internalGet$32() {
    return this.e$32;
  }

  NArray internalGetArray() {
    return this.eArray;
  }
}