/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NCommonData_Align
    extends NCommonData {

  private final int line;
  private final int pos;
  private final N$54 e$54;
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
    walker.inCommonData_Align(this);
    walker.caseCommonData_Align(this);
    walker.outCommonData_Align(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$54.apply(walker);
    this.eNumber.apply(walker);
  }

  NCommonData_Align(int line, int pos, N$54 p$54, NNumber pNumber) {
    this.line = line;
    this.pos = pos;
    this.e$54 = p$54;
    this.eNumber = pNumber;
  }

  @Override
  public Type getType() {
    return Type.T_CommonData_Align;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_CommonData;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_CommonData_Align;
  }

  public NNumber get_Number() {
    return this.eNumber;
  }

  N$54 internalGet$54() {
    return this.e$54;
  }

  NNumber internalGetNumber() {
    return this.eNumber;
  }
}