/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NRegExpr
    extends Node {

  private final int line;
  private final int pos;
  private final NRs eRs;
  private final N$17 e$17$1;
  private final NRt eRt;
  private final N$17 e$17$2;
  private final NRd eRd;

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
    walker.inRegExpr(this);
    walker.caseRegExpr(this);
    walker.outRegExpr(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.eRs.apply(walker);
    this.e$17$1.apply(walker);
    this.eRt.apply(walker);
    this.e$17$2.apply(walker);
    this.eRd.apply(walker);
  }

  NRegExpr(int line, int pos, NRs pRs, N$17 p$17$1, NRt pRt, N$17 p$17$2, NRd pRd) {
    this.line = line;
    this.pos = pos;
    this.eRs = pRs;
    this.e$17$1 = p$17$1;
    this.eRt = pRt;
    this.e$17$2 = p$17$2;
    this.eRd = pRd;
  }

  @Override
  public Type getType() {
    return Type.T_RegExpr;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_RegExpr;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_RegExpr;
  }

  public NRs get_Rs() {
    return this.eRs;
  }

  public NRt get_Rt() {
    return this.eRt;
  }

  public NRd get_Rd() {
    return this.eRd;
  }

  NRs internalGetRs() {
    return this.eRs;
  }

  N$17 internalGet$17$1() {
    return this.e$17$1;
  }

  NRt internalGetRt() {
    return this.eRt;
  }

  N$17 internalGet$17$2() {
    return this.e$17$2;
  }

  NRd internalGetRd() {
    return this.eRd;
  }
}
