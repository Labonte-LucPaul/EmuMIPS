/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_177
    extends FinalState {

  static final S_177 instance = new S_177();

  private S_177() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(2);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$7(text, line, pos);
  }
}