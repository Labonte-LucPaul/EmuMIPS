/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_163
    extends FinalState {

  static final S_163 instance = new S_163();

  private S_163() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(0);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$38(text, line, pos);
  }
}
