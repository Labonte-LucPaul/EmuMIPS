/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_186
    extends FinalState {

  static final S_186 instance = new S_186();

  private S_186() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(0);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$52(text, line, pos);
  }
}