/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_105
    extends FinalState {

  static final S_105 instance = new S_105();

  private S_105() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$22(text, line, pos);
  }
}
