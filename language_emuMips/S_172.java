/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_172
    extends FinalState {

  static final S_172 instance = new S_172();

  private S_172() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$5(text, line, pos);
  }
}
