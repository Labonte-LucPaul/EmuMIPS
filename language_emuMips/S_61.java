/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_61
    extends FinalState {

  static final S_61 instance = new S_61();

  private S_61() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$11(text, line, pos);
  }
}