/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_111
    extends FinalState {

  static final S_111 instance = new S_111();

  private S_111() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$16(text, line, pos);
  }
}
