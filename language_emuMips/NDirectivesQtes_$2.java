/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class NDirectivesQtes_$2
    extends NDirectivesQtes {

  private final int line;
  private final int pos;
  private final NDirectivesQte eDirectivesQte;

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
    walker.defaultIn(this);
    walker.defaultCase(this);
    walker.defaultOut(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.eDirectivesQte.apply(walker);
  }

  NDirectivesQtes_$2(int line, int pos, NDirectivesQte pDirectivesQte) {
    this.line = line;
    this.pos = pos;
    this.eDirectivesQte = pDirectivesQte;
  }

  @Override
  public Type getType() {
    return Type.TAnonymous;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_DirectivesQtes;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_DirectivesQtes_$2;
  }

  NDirectivesQte internalGetDirectivesQte() {
    return this.eDirectivesQte;
  }
}
