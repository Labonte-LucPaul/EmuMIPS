/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Lbl
    extends NStmt {

  private final int line;
  private final int pos;
  private final NString eString;

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
    walker.inStmt_Lbl(this);
    walker.caseStmt_Lbl(this);
    walker.outStmt_Lbl(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.eString.apply(walker);
  }

  public NStmt_Lbl(int line, int pos, NString pString) {
    this.line = line;
    this.pos = pos;
    this.eString = pString;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Lbl;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Lbl;
  }

  public NString get_String() {
    return this.eString;
  }

  NString internalGetString() {
    return this.eString;
  }
}