/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NRs
    extends Node {

  private final int line;
  private final int pos;
  private final NRegister eRegister;

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
    walker.inRs(this);
    walker.caseRs(this);
    walker.outRs(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.eRegister.apply(walker);
  }

  public NRs(int line, int pos, NRegister pRegister) {
    this.line = line;
    this.pos = pos;
    this.eRegister = pRegister;
  }

  @Override
  public Type getType() {
    return Type.T_Rs;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Rs;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Rs;
  }

  public NRegister get_Register() {
    return this.eRegister;
  }

  NRegister internalGetRegister() {
    return this.eRegister;
  }
}
