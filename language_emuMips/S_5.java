/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_5
    extends FinalState {

  static final S_5 instance = new S_5();

  private S_5() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(0);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$44(text, line, pos);
  }
}
