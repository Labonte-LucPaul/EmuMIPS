/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NCommonData_Float
    extends NCommonData {

  private final int line;
  private final int pos;
  private final N$51 e$51;
  private final NDirectivesQtes eDirectivesQtes;

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
    walker.inCommonData_Float(this);
    walker.caseCommonData_Float(this);
    walker.outCommonData_Float(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$51.apply(walker);
    this.eDirectivesQtes.apply(walker);
  }

  NCommonData_Float(int line, int pos, N$51 p$51, NDirectivesQtes pDirectivesQtes) {
    this.line = line;
    this.pos = pos;
    this.e$51 = p$51;
    this.eDirectivesQtes = pDirectivesQtes;
  }

  @Override
  public Type getType() {
    return Type.T_CommonData_Float;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_CommonData;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_CommonData_Float;
  }

  public NDirectivesQtes get_DirectivesQtes() {
    return this.eDirectivesQtes;
  }

  N$51 internalGet$51() {
    return this.e$51;
  }

  NDirectivesQtes internalGetDirectivesQtes() {
    return this.eDirectivesQtes;
  }
}
