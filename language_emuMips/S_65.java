/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_65
    extends FinalState {

  static final S_65 instance = new S_65();

  private S_65() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$28(text, line, pos);
  }
}
