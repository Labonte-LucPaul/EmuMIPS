/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NCommonData_Half
    extends NCommonData {

  private final int line;
  private final int pos;
  private final N$47 e$47;
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
    walker.inCommonData_Half(this);
    walker.caseCommonData_Half(this);
    walker.outCommonData_Half(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$47.apply(walker);
    this.eDirectivesQtes.apply(walker);
  }

  NCommonData_Half(int line, int pos, N$47 p$47, NDirectivesQtes pDirectivesQtes) {
    this.line = line;
    this.pos = pos;
    this.e$47 = p$47;
    this.eDirectivesQtes = pDirectivesQtes;
  }

  @Override
  public Type getType() {
    return Type.T_CommonData_Half;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_CommonData;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_CommonData_Half;
  }

  public NDirectivesQtes get_DirectivesQtes() {
    return this.eDirectivesQtes;
  }

  N$47 internalGet$47() {
    return this.e$47;
  }

  NDirectivesQtes internalGetDirectivesQtes() {
    return this.eDirectivesQtes;
  }
}