/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_156
    extends FinalState {

  static final S_156 instance = new S_156();

  private S_156() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(2);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$25(text, line, pos);
  }
}
