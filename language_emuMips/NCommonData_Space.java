/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NCommonData_Space
    extends NCommonData {

  private final int line;
  private final int pos;
  private final N$53 e$53;
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
    walker.inCommonData_Space(this);
    walker.caseCommonData_Space(this);
    walker.outCommonData_Space(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$53.apply(walker);
    this.eNumber.apply(walker);
  }

  NCommonData_Space(int line, int pos, N$53 p$53, NNumber pNumber) {
    this.line = line;
    this.pos = pos;
    this.e$53 = p$53;
    this.eNumber = pNumber;
  }

  @Override
  public Type getType() {
    return Type.T_CommonData_Space;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_CommonData;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_CommonData_Space;
  }

  public NNumber get_Number() {
    return this.eNumber;
  }

  N$53 internalGet$53() {
    return this.e$53;
  }

  NNumber internalGetNumber() {
    return this.eNumber;
  }
}
