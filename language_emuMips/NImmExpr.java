/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NImmExpr
    extends Node {

  private final int line;
  private final int pos;
  private final NRt eRt;
  private final N$20 e$20$1;
  private final NRs eRs;
  private final N$20 e$20$2;
  private final NImmediate eImmediate;

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
    walker.inImmExpr(this);
    walker.caseImmExpr(this);
    walker.outImmExpr(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.eRt.apply(walker);
    this.e$20$1.apply(walker);
    this.eRs.apply(walker);
    this.e$20$2.apply(walker);
    this.eImmediate.apply(walker);
  }

  NImmExpr(int line, int pos, NRt pRt, N$20 p$20$1, NRs pRs, N$20 p$20$2, NImmediate pImmediate) {
    this.line = line;
    this.pos = pos;
    this.eRt = pRt;
    this.e$20$1 = p$20$1;
    this.eRs = pRs;
    this.e$20$2 = p$20$2;
    this.eImmediate = pImmediate;
  }

  @Override
  public Type getType() {
    return Type.T_ImmExpr;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_ImmExpr;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_ImmExpr;
  }

  public NRt get_Rt() {
    return this.eRt;
  }

  public NRs get_Rs() {
    return this.eRs;
  }

  public NImmediate get_Immediate() {
    return this.eImmediate;
  }

  NRt internalGetRt() {
    return this.eRt;
  }

  N$20 internalGet$20$1() {
    return this.e$20$1;
  }

  NRs internalGetRs() {
    return this.eRs;
  }

  N$20 internalGet$20$2() {
    return this.e$20$2;
  }

  NImmediate internalGetImmediate() {
    return this.eImmediate;
  }
}
