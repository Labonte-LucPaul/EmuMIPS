/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_93
    extends FinalState {

  static final S_93 instance = new S_93();

  private S_93() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$3(text, line, pos);
  }
}