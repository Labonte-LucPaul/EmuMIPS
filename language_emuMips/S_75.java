/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_75
    extends FinalState {

  static final S_75 instance = new S_75();

  private S_75() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$28(text, line, pos);
  }
}
