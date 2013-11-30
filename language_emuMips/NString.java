/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public class NString
    extends Token {

  public NString(String text, int line, int pos) {
    super(text, line, pos);
  }

  @Override
  public Type getType() {
    return Type.T_String;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_String;
  }

  @Override
  public void apply(Walker walker) {
    walker.inString(this);
    walker.caseString(this);
    walker.outString(this);
  }
}
