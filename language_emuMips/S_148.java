/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_148
    extends FinalState {

  static final S_148 instance = new S_148();

  private S_148() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$18(text, line, pos);
  }
}
