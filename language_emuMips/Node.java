/* This file was generated by SableCC ( http://sablecc.org ). */

package language_emuMips;

public abstract class Node {

  public abstract Type getType();

  public static enum Type {
    T_String,
    T_Register,
    T_Number,
    T_Numberu,
    T_Stmts_Many,
    T_Stmts_One,
    T_Stmt_Add,
    T_Stmt_Addi,
    T_Stmt_Addu,
    T_Stmt_Addiu,
    T_Stmt_Sub,
    T_Stmt_Subu,
    T_Stmt_And,
    T_Stmt_Andi,
    T_Stmt_Or,
    T_Stmt_Ori,
    T_Stmt_Nor,
    T_Stmt_Slt,
    T_Stmt_Slti,
    T_Stmt_Sltu,
    T_Stmt_Sltiu,
    T_Stmt_Sll,
    T_Stmt_Srl,
    T_Stmt_Lbl,
    T_RegExpr,
    T_ImmExpr,
    T_Shift,
    T_Rs,
    T_Rt,
    T_Rd,
    T_Immediate_Signed,
    T_Immediate_Unsigned,
    T_JmpExpr_Lbl,
    T_Address,
    TEnd,
    TAnonymous;
  }

  public abstract ProductionType getProductionType();

  public static enum ProductionType {
    T_$Start,
    T_Stmts,
    T_Stmt,
    T_RegExpr,
    T_ImmExpr,
    T_Shift,
    T_Rs,
    T_Rt,
    T_Rd,
    T_Immediate,
    T_JmpExpr,
    T_Address,
    TNotAProduction;
  }

  public abstract String getText();
  public abstract int getLine();
  public abstract int getPos();
  public abstract void apply(Walker walker);
  public abstract void applyOnChildren(Walker walker);

  private Node parent;

  public Node getParent() {
    return this.parent;
  }

  void setParent(Node parent) {
    this.parent = parent;
  }

  @Override
  public String toString() {
    return "\"" + getText() + "\"@(" + getLine() + "," + getPos() + ")";
  }

  abstract InternalType getInternalType();

  static enum InternalType {
    T_$0,
    T_$1,
    T_$2,
    T_$3,
    T_$4,
    T_$5,
    T_$6,
    T_$7,
    T_$8,
    T_$9,
    T_$10,
    T_$11,
    T_$12,
    T_$13,
    T_$14,
    T_$15,
    T_$16,
    T_String,
    T_$17,
    T_$18,
    T_Register,
    T_Number,
    T_Numberu,
    T_$Start,
    T_Stmts_Many,
    T_Stmts_One,
    T_Stmt_Add,
    T_Stmt_Addi,
    T_Stmt_Addu,
    T_Stmt_Addiu,
    T_Stmt_Sub,
    T_Stmt_Subu,
    T_Stmt_And,
    T_Stmt_Andi,
    T_Stmt_Or,
    T_Stmt_Ori,
    T_Stmt_Nor,
    T_Stmt_Slt,
    T_Stmt_Slti,
    T_Stmt_Sltu,
    T_Stmt_Sltiu,
    T_Stmt_Sll,
    T_Stmt_Srl,
    T_Stmt_Lbl,
    T_RegExpr,
    T_ImmExpr,
    T_Shift,
    T_Rs,
    T_Rt,
    T_Rd,
    T_Immediate_Signed,
    T_Immediate_Unsigned,
    T_JmpExpr_Lbl,
    T_Address,
    TEnd;
  }
}
