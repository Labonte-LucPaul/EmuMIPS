/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_129
    extends FinalState {

  static final S_129 instance = new S_129();

  private S_129() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$13(text, line, pos);
  }
}
