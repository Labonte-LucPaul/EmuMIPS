/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_88
    extends FinalState {

  static final S_88 instance = new S_88();

  private S_88() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(2);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$16(text, line, pos);
  }
}