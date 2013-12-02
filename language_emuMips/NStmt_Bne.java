/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NStmt_Bne
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$21 e$21;
  private final NRs eRs;
  private final N$20 e$20$1;
  private final NRt eRt;
  private final N$20 e$20$2;
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
    walker.inStmt_Bne(this);
    walker.caseStmt_Bne(this);
    walker.outStmt_Bne(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$21.apply(walker);
    this.eRs.apply(walker);
    this.e$20$1.apply(walker);
    this.eRt.apply(walker);
    this.e$20$2.apply(walker);
    this.eString.apply(walker);
  }

  NStmt_Bne(int line, int pos, N$21 p$21, NRs pRs, N$20 p$20$1, NRt pRt, N$20 p$20$2, NString pString) {
    this.line = line;
    this.pos = pos;
    this.e$21 = p$21;
    this.eRs = pRs;
    this.e$20$1 = p$20$1;
    this.eRt = pRt;
    this.e$20$2 = p$20$2;
    this.eString = pString;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Bne;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Bne;
  }

  public NRs get_Rs() {
    return this.eRs;
  }

  public NRt get_Rt() {
    return this.eRt;
  }

  public NString get_String() {
    return this.eString;
  }

  N$21 internalGet$21() {
    return this.e$21;
  }

  NRs internalGetRs() {
    return this.eRs;
  }

  N$20 internalGet$20$1() {
    return this.e$20$1;
  }

  NRt internalGetRt() {
    return this.eRt;
  }

  N$20 internalGet$20$2() {
    return this.e$20$2;
  }

  NString internalGetString() {
    return this.eString;
  }
}
