/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NCommonData_Asciiz
    extends NCommonData {

  private final int line;
  private final int pos;
  private final N$50 e$50;
  private final NConsoleString eConsoleString;

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
    walker.inCommonData_Asciiz(this);
    walker.caseCommonData_Asciiz(this);
    walker.outCommonData_Asciiz(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$50.apply(walker);
    this.eConsoleString.apply(walker);
  }

  NCommonData_Asciiz(int line, int pos, N$50 p$50, NConsoleString pConsoleString) {
    this.line = line;
    this.pos = pos;
    this.e$50 = p$50;
    this.eConsoleString = pConsoleString;
  }

  @Override
  public Type getType() {
    return Type.T_CommonData_Asciiz;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_CommonData;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_CommonData_Asciiz;
  }

  public NConsoleString get_ConsoleString() {
    return this.eConsoleString;
  }

  N$50 internalGet$50() {
    return this.e$50;
  }

  NConsoleString internalGetConsoleString() {
    return this.eConsoleString;
  }
}
