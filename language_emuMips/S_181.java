/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_181
    extends FinalState {

  static final S_181 instance = new S_181();

  private S_181() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$3(text, line, pos);
  }
}
