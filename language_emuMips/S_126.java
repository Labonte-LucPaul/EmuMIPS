/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_126
    extends FinalState {

  static final S_126 instance = new S_126();

  private S_126() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(2);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$31(text, line, pos);
  }
}
