/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_107
    extends FinalState {

  static final S_107 instance = new S_107();

  private S_107() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(2);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$23(text, line, pos);
  }
}
