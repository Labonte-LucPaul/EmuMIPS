/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_185
    extends FinalState {

  static final S_185 instance = new S_185();

  private S_185() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(0);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$50(text, line, pos);
  }
}
