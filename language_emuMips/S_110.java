/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_110
    extends FinalState {

  static final S_110 instance = new S_110();

  private S_110() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$31(text, line, pos);
  }
}
