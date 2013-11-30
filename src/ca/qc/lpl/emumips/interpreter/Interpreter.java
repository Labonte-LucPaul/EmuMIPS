package ca.qc.lpl.emumips.interpreter;

import java.io.StringReader;
import java.util.HashMap;

import ca.qc.lpl.emumips.register.Register;
import language_emuMips.*;

public class Interpreter extends Walker {

	private String rs = "";
	private String rt = "";
	private String rd = "";
	private int immediate = 0;

	private HashMap<String, Register> registers;
	
	public Interpreter( HashMap<String,Register> r ) throws Exception {
		
		Parser p = new Parser( new StringReader("nor $t0, $t1, $s0") );

		Node tree = p.parse();
		
		this.registers = r;
		this.registers.get("$t0").setValue(5);
		this.registers.get("$t1").setValue(6);

		tree.apply(this);
	}

	@Override
	public void caseRs(NRs node) {
		this.rs = node.get_Register().getText();
	}
	
	@Override
	public void caseRt(NRt node) {
		this.rt = node.get_Register().getText();
	}

	@Override
	public void caseRd(NRd node) {
		this.rd = node.get_Register().getText();
	}
	
	@Override
	public void caseImmediate_Signed(NImmediate_Signed node) {
		this.immediate = Integer.parseInt( node.get_Number().getText() );
	}

	@Override
	public void caseImmediate_Unsigned(NImmediate_Unsigned node) {
		this.immediate = Integer.parseInt( node.get_Numberu().getText() );
	}
	
	@Override
	public void caseStmt_Add(NStmt_Add node) {
		node.get_RegExpr().apply(this);
		int add = this.registers.get(rs).getValue() + this.registers.get(rt).getValue();	
		this.registers.get(rd).setValue(add);
	}
	
	@Override
	public void caseStmt_Addi(NStmt_Addi node) {
		node.get_ImmExpr().apply(this);
		int addi = this.registers.get(rs).getValue() + this.immediate;
		this.registers.get(rt).setValue(addi);
	}

	@Override
	public void caseStmt_Addu(NStmt_Addu node) {
		node.get_RegExpr().apply(this);
		int addu = this.registers.get(rs).getValue() + this.registers.get(rt).getValue();
		this.registers.get(rd).setValue(addu);
	}
	
	@Override
	public void caseStmt_Addiu(NStmt_Addiu node) {
		node.get_ImmExpr().apply(this);
		int addiu = this.registers.get(rs).getValue() + this.registers.get(rt).getValue();
		this.registers.get(rd).setValue(addiu);
	}
	
	@Override
	public void caseStmt_Sub(NStmt_Sub node) {
		node.get_RegExpr().apply(this);
		int sub = this.registers.get(rs).getValue() - this.registers.get(rt).getValue();
		this.registers.get(rd).setValue(sub);
	}
	
	@Override
	public void caseStmt_Subu(NStmt_Subu node) {
		node.get_RegExpr().apply(this);
		int subu = this.registers.get(rs).getValue() - this.registers.get(rt).getValue();
		this.registers.get(rd).setValue(subu);
	}
	
	@Override
	public void caseStmt_And(NStmt_And node) {
		node.get_RegExpr().apply(this);
		int and = this.registers.get(rs).getValue() & this.registers.get(rt).getValue();
		this.registers.get(rd).setValue(and);
	}
	
	@Override
	public void caseStmt_Andi(NStmt_Andi node) {
		node.get_ImmExpr().apply(this);
		int and = this.registers.get(rs).getValue() & this.immediate;
		this.registers.get(rt).setValue(and);
		System.out.println(and);
	}

	@Override
	public void caseStmt_Or(NStmt_Or node) {
		node.get_RegExpr().apply(this);
		int or = this.registers.get(rs).getValue() | this.registers.get(rt).getValue();
		this.registers.get(rd).setValue(or);
	}
	
	@Override
	public void caseStmt_Ori(NStmt_Ori node) {
		node.get_ImmExpr().apply(this);
		int ori = this.registers.get(rs).getValue() | this.immediate;
		this.registers.get(rt).setValue(ori);

	}

	@Override
	public void caseStmt_Nor(NStmt_Nor node) {
		node.get_RegExpr().apply(this);
		int nor = (this.registers.get(rs).getValue() ^ this.registers.get(rt).getValue());
		this.registers.get(rd).setValue(nor);
	}
	
	@Override
	public void caseStmt_Slt(NStmt_Slt node) {
		node.get_RegExpr().apply(this);
		int res = (this.registers.get(rs).getValue() < this.registers.get(rt).getValue()) ? 1:0;
		this.registers.get(rd).setValue(res);
	}
	
	@Override
	public void caseStmt_Slti(NStmt_Slti node) {
		node.get_ImmExpr().apply(this);
		int res = (this.registers.get(rs).getValue() < this.immediate) ? 1:0;
		this.registers.get(rt).setValue(res);
	}
	
	@Override
	public void caseStmt_Sltu(NStmt_Sltu node) {
		node.get_ImmExpr().apply(this);
		int res = (this.registers.get(rs).getValue() < this.registers.get(rt).getValue()) ? 1:0;
		this.registers.get(rd).setValue(res);
	}
	
	@Override
	public void caseStmt_Sltiu(NStmt_Sltiu node) {
		node.get_ImmExpr().apply(this);
		int res = (this.registers.get(rs).getValue() < this.immediate) ? 1:0;
		this.registers.get(rt).setValue(res);
	}

	@Override
	public void caseStmt_Sll(NStmt_Sll node) {
		node.get_Shift().apply(this);
		int res = this.registers.get(rt).getValue() << this.immediate ;
		this.registers.get(rd).setValue(res);
	}
	
	@Override
	public void caseStmt_Srl(NStmt_Srl node) {
		node.get_Shift().apply(this);
		int res = this.registers.get(rt).getValue() >> this.immediate ;
		this.registers.get(rd).setValue(res);
	}
}
