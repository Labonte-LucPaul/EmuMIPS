/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_142
    extends FinalState {

  static final S_142 instance = new S_142();

  private S_142() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$10(text, line, pos);
  }
}
