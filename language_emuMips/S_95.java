/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_95
    extends FinalState {

  static final S_95 instance = new S_95();

  private S_95() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(2);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$2(text, line, pos);
  }
}