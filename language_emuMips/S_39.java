/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_39
    extends FinalState {

  static final S_39 instance = new S_39();

  private S_39() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$8(text, line, pos);
  }
}