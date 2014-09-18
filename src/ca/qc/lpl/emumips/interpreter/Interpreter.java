package ca.qc.lpl.emumips.interpreter;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

import language_emuMips.NNumber;
import language_emuMips.NRd;
import language_emuMips.NRs;
import language_emuMips.NRt;
import language_emuMips.NStmt_Add;
import language_emuMips.NStmt_Addi;
import language_emuMips.NStmt_Addiu;
import language_emuMips.NStmt_Addu;
import language_emuMips.NStmt_And;
import language_emuMips.NStmt_Andi;
import language_emuMips.NStmt_Beq;
import language_emuMips.NStmt_Bne;
import language_emuMips.NStmt_Jmp;
import language_emuMips.NStmt_La;
import language_emuMips.NStmt_Lb;
import language_emuMips.NStmt_Lbu;
import language_emuMips.NStmt_Lh;
import language_emuMips.NStmt_Lhu;
import language_emuMips.NStmt_Lui;
import language_emuMips.NStmt_Lw;
import language_emuMips.NStmt_Nor;
import language_emuMips.NStmt_Or;
import language_emuMips.NStmt_Ori;
import language_emuMips.NStmt_Sb;
import language_emuMips.NStmt_Sh;
import language_emuMips.NStmt_Sll;
import language_emuMips.NStmt_Slt;
import language_emuMips.NStmt_Slti;
import language_emuMips.NStmt_Sltiu;
import language_emuMips.NStmt_Sltu;
import language_emuMips.NStmt_Srl;
import language_emuMips.NStmt_Sub;
import language_emuMips.NStmt_Subu;
import language_emuMips.NStmt_Sw;
import language_emuMips.Node;
import language_emuMips.Parser;
import language_emuMips.Walker;
import ca.qc.lpl.emumips.EmuMIPS;
import ca.qc.lpl.emumips.register.Register;

public class Interpreter extends Walker {

	private String rs = "";
	private String rt = "";
	private String rd = "";
	private int imm = 0;

	private Node tree;

	private HashMap<String, Register> registers;
	private HashMap<String, Integer> lblAssociation;// = new HashMap<String, Integer>();
	private HashMap<String, String> lblDataAssociation;

	private ArrayList<Node> preCompiled;

	public int iterator = 0;

	public Interpreter( String source ) throws Exception {

		PreParse pp = new PreParse(source);
		source = pp.getSource();
		Parser p = new Parser( new StringReader(source) );

		this.tree = p.parse();

		ScopeAnalysis sa = new ScopeAnalysis(this.tree);
		this.lblAssociation = sa.getLblAssociation();
		this.lblDataAssociation = sa.getLblDataAssociation();
		JustInTime jit = new JustInTime(sa.getInstructions());
		this.preCompiled = jit.getPreCompiled();

		this.registers = EmuMIPS.registers;


		while( this.iterator < this.preCompiled.size() ) {
			if( this.preCompiled.get(iterator) != null ) {
				this.preCompiled.get(iterator).apply(this);
			}
			++this.iterator;
		}

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
	public void caseNumber(NNumber node) {
		this.imm = Integer.parseInt( node.getText() );
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
		int addi = this.registers.get(rs).getValue() + this.imm;
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
		node.get_ImmExpru().apply(this);
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
		int and = this.registers.get(rs).getValue() & this.imm;
		this.registers.get(rt).setValue(and);
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
		int ori = this.registers.get(rs).getValue() | this.imm;
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
		int res = (this.registers.get(rs).getValue() < this.imm) ? 1:0;
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
		node.get_ImmExpru().apply(this);
		int res = (this.registers.get(rs).getValue() < this.imm) ? 1:0;
		this.registers.get(rt).setValue(res);
	}

	@Override
	public void caseStmt_Sll(NStmt_Sll node) {
		node.get_Shift().apply(this);
		int res = this.registers.get(rt).getValue() << this.imm ;
		this.registers.get(rd).setValue(res);
	}

	@Override
	public void caseStmt_Srl(NStmt_Srl node) {
		node.get_Shift().apply(this);
		int res = this.registers.get(rt).getValue() >> this.imm ;
		this.registers.get(rd).setValue(res);
	}

	@Override
	public void caseStmt_Lw(NStmt_Lw node) {
		node.get_Array().apply(this);
		int rs = this.registers.get(this.rs).getValue();
		String rt;
		if( isSourceSP(rs) ) {
			rt = EmuMIPS.memoryStack.popWord(this.imm + rs);
		} else {
			rt = EmuMIPS.memoryData.getWord(String.format("%X", this.imm + rs));
		}
		long val = Long.parseLong(rt, 16);
		this.registers.get(this.rt).setValue((int)val);
	}

	@Override
	public void caseStmt_Sw(NStmt_Sw node) {
		node.get_Array().apply(this);
		int rs = this.registers.get(this.rs).getValue();
		int rt = this.registers.get(this.rt).getValue();

		String word = String.format("%08X",rt);
		if( isSourceSP(rs) ) {
			EmuMIPS.memoryStack.push(word, rs+this.imm);
		} else {
			EmuMIPS.memoryData.addWord(word, rs+this.imm);
		}
	}

	private boolean isSourceSP(int rs) {
		return rs == this.registers.get("$sp").getValue();
	}
	@Override
	public void caseStmt_Sb(NStmt_Sb node) {
		node.get_Array().apply(this);
		int rs = this.registers.get(this.rs).getValue();
		int rt = this.registers.get(this.rt).getValue();
		EmuMIPS.memoryData.addByte(String.format("%02X",rt), rs+this.imm);
	}

	@Override
	public void caseStmt_Lh(NStmt_Lh node) {
		node.get_Array().apply(this);
		int rs = this.registers.get(this.rs).getValue();
		String rt = EmuMIPS.memoryData.getHalfWord(String.format("%X", this.imm + rs));
		long val = Long.parseLong(rt, 16);
		this.registers.get(this.rt).setValue((int)val);
	}

	@Override
	public void caseStmt_Lui(NStmt_Lui node) {
		int imm = Integer.parseInt( node.get_Number().getText() );
		String rt = node.get_Rt().getText();
		this.registers.get(rt).setValue(imm * 65536);
	}

	@Override
	public void caseStmt_Lhu(NStmt_Lhu node) {
		node.get_Array().apply(this);
		int rs = this.registers.get(this.rs).getValue();
		String rt = EmuMIPS.memoryData.getHalfWord(String.format("%X", this.imm + rs));
		long val = Long.parseLong(rt, 16);
		if( val < 0 ) {
			val *= -1;
		}
		this.registers.get(this.rt).setValue((int)val);
	}

	@Override
	public void caseStmt_Sh(NStmt_Sh node) {
		node.get_Array().apply(this);
		int rs = this.registers.get(this.rs).getValue();
		int rt = this.registers.get(this.rt).getValue();
		EmuMIPS.memoryData.addHalfWord(String.format("%016X",rt), rs+this.imm);
	}

	@Override
	public void caseStmt_Lb(NStmt_Lb node) {
		node.get_Array().apply(this);
		int rs = this.registers.get(this.rs).getValue();
		String rt = EmuMIPS.memoryData.getByte(String.format("%X", this.imm + rs));
		long val = Long.parseLong(rt, 16);
		this.registers.get(this.rt).setValue((int)val);
	}

	@Override
	public void caseStmt_Lbu(NStmt_Lbu node) {
		node.get_Array().apply(this);
		int rs = this.registers.get(this.rs).getValue();
		String rt = EmuMIPS.memoryData.getByte(String.format("%X", this.imm + rs));
		long val = Long.parseLong(rt, 16);
		if( val < 0 ) {
			val *= -1;
		}
		this.registers.get(this.rt).setValue((int)val);
	}

	@Override
	public void caseStmt_Jmp(NStmt_Jmp node) {
		this.iterator = (this.lblAssociation.get(node.get_String().getText()) -1);
	}

	@Override
	public void caseStmt_Bne(NStmt_Bne node) {
		node.get_Rs().apply(this);
		node.get_Rt().apply(this);
		if( this.registers.get(rs).getValue() != this.registers.get(rt).getValue() ) {
			this.iterator = this.lblAssociation.get(node.get_String().getText()) -1;
		}
	}

	@Override
	public void caseStmt_Beq(NStmt_Beq node) {
		node.get_Rs().apply(this);
		node.get_Rt().apply(this);
		if( this.registers.get(rs).getValue() == this.registers.get(rt).getValue() ) {
			this.iterator = this.lblAssociation.get(node.get_String().getText()) -1;
		}
	}

	@Override
	public void caseStmt_La(NStmt_La node) {
		String reg = node.get_Register().getText();
		String address = this.lblDataAssociation.get(node.get_String().getText());
		this.registers.get(reg).setValue(Integer.parseInt(address, 16));
	}
}
