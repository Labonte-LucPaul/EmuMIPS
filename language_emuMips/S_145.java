/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_145
    extends FinalState {

  static final S_145 instance = new S_145();

  private S_145() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$13(text, line, pos);
  }
}
