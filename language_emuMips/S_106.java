/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_106
    extends FinalState {

  static final S_106 instance = new S_106();

  private S_106() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$8(text, line, pos);
  }
}
