/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_116
    extends FinalState {

  static final S_116 instance = new S_116();

  private S_116() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$25(text, line, pos);
  }
}
