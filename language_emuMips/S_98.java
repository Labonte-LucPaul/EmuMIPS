/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_98
    extends FinalState {

  static final S_98 instance = new S_98();

  private S_98() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$20(text, line, pos);
  }
}
