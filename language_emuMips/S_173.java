/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

class S_173
    extends FinalState {

  static final S_173 instance = new S_173();

  private S_173() {
  }

  Token getToken(Lexer lexer) {
    String text = lexer.accept(2);
    int line = lexer.getAcceptLine();
    int pos = lexer.getAcceptPos();

    return new N$15(text, line, pos);
  }
}
