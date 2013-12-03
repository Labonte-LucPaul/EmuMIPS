/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NShift
    extends Node {

  private final int line;
  private final int pos;
  private final NRd eRd;
  private final N$20 e$20$1;
  private final NRt eRt;
  private final N$20 e$20$2;
  private final NNumber eNumber;

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
    walker.inShift(this);
    walker.caseShift(this);
    walker.outShift(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.eRd.apply(walker);
    this.e$20$1.apply(walker);
    this.eRt.apply(walker);
    this.e$20$2.apply(walker);
    this.eNumber.apply(walker);
  }

  NShift(int line, int pos, NRd pRd, N$20 p$20$1, NRt pRt, N$20 p$20$2, NNumber pNumber) {
    this.line = line;
    this.pos = pos;
    this.eRd = pRd;
    this.e$20$1 = p$20$1;
    this.eRt = pRt;
    this.e$20$2 = p$20$2;
    this.eNumber = pNumber;
  }

  @Override
  public Type getType() {
    return Type.T_Shift;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Shift;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Shift;
  }

  public NRd get_Rd() {
    return this.eRd;
  }

  public NRt get_Rt() {
    return this.eRt;
  }

  public NNumber get_Number() {
    return this.eNumber;
  }

  NRd internalGetRd() {
    return this.eRd;
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

  NNumber internalGetNumber() {
    return this.eNumber;
  }
}
