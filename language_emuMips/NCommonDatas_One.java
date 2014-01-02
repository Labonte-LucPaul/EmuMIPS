/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NCommonDatas_One
    extends NCommonDatas {

  private final int line;
  private final int pos;
  private final NCommonData eCommonData;

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
    walker.inCommonDatas_One(this);
    walker.caseCommonDatas_One(this);
    walker.outCommonDatas_One(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.eCommonData.apply(walker);
  }

  public NCommonDatas_One(int line, int pos, NCommonData pCommonData) {
    this.line = line;
    this.pos = pos;
    this.eCommonData = pCommonData;
  }

  @Override
  public Type getType() {
    return Type.T_CommonDatas_One;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_CommonDatas;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_CommonDatas_One;
  }

  public NCommonData get_CommonData() {
    return this.eCommonData;
  }

  NCommonData internalGetCommonData() {
    return this.eCommonData;
  }
}