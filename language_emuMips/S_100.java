/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_100
    extends FinalState {

  static final S_100 instance = new S_100();

  private S_100() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$43(text, line, pos);
  }
}
