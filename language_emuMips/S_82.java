/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_82
    extends FinalState {

  static final S_82 instance = new S_82();

  private S_82() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(1);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$6(text, line, pos);
  }
}
