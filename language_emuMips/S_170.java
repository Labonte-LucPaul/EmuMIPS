/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_170
    extends FinalState {

  static final S_170 instance = new S_170();

  private S_170() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(2);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$14(text, line, pos);
  }
}
