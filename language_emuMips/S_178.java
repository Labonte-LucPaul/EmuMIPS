/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_178
    extends FinalState {

  static final S_178 instance = new S_178();

  private S_178() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(0);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$51(text, line, pos);
  }
}
