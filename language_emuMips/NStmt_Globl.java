/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Globl
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$39 e$39;
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
    walker.inStmt_Globl(this);
    walker.caseStmt_Globl(this);
    walker.outStmt_Globl(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$39.apply(walker);
    this.eString.apply(walker);
  }

  NStmt_Globl(int line, int pos, N$39 p$39, NString pString) {
    this.line = line;
    this.pos = pos;
    this.e$39 = p$39;
    this.eString = pString;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Globl;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Globl;
  }

  public NString get_String() {
    return this.eString;
  }

  N$39 internalGet$39() {
    return this.e$39;
  }

  NString internalGetString() {
    return this.eString;
  }
}