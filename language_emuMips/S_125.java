/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_125
    extends FinalState {

  static final S_125 instance = new S_125();

  private S_125() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$18(text, line, pos);
  }
}
