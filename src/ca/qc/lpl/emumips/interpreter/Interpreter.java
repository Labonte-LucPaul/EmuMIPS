package ca.qc.lpl.emumips.interpreter;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ca.qc.lpl.emumips.interpreter.instructions.*;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotARegisterException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAnImmediateException;
import ca.qc.lpl.emumips.register.Register;
import language_emuMips.*;

public class Interpreter extends Walker {

	private String rs = "";
	private String rt = "";
	private String rd = "";
	private int imm = 0;

	private Node tree;

	private HashMap<String, Register> registers;
	private HashMap<String, Register> registersBin;
	private ArrayList<String> lstScope;
	private HashMap<String, Integer> lblAssociation = new HashMap<String, Integer>();
	private ArrayList<ArrayList<String>> instructions = new ArrayList<ArrayList<String>>();


	private String currentLabel = "";

	public Interpreter( HashMap<String,Register> r, HashMap<String, Register> registersBin, String source ) throws Exception {
		
		Parser p = new Parser( new StringReader("fuck: fuck2: add $a0, $a0, $a0 test: addi $a0, $a0, 1 add $a0, $a0, $a0 j test") );

		this.tree = p.parse();
		ScopeAnalysis sa = new ScopeAnalysis(this.tree);
	
		this.registers = r;
		this.registersBin = registersBin;
		this.lstScope = new ArrayList<String>();
	
		//this.tree.apply(this);
		
//		if(currentLabel.length() > 0) {
//			lstScope.add(0, currentLabel + ":");
//		}
//		this.instructions.add(lstScope);
//		this.lblAssociation.put(currentLabel, this.instructions.indexOf(lstScope));
//		
//		for(ArrayList<String> lst : instructions) {
//			for(String lst2 : lst) {
//				System.out.println(lst2.toString());
//			}
//		}
		
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
		this.imm = Integer.parseInt( node.get_Number().getText() );
	}

	@Override
	public void caseImmediate_Unsigned(NImmediate_Unsigned node) {
		this.imm = Integer.parseInt( node.get_Numberu().getText() );
	}
	
	@Override
	public void caseStmt_Add(NStmt_Add node) {
		node.get_RegExpr().apply(this);
		lstScope.add(String.format("add %s,  %s, %s", rd, rs, rs));
//		int add = this.registers.get(rs).getValue() + this.registers.get(rt).getValue();	
//		this.registers.get(rd).setValue(add);
//		BasicInstructionInfo tmp = new Add();
//		try {
//			tmp.setRegFormat(this.registers.get(rd).getBinary(), this.registers.get(rs).getBinary(), this.registers.get(rt).getBinary(), 0);
//			this.lstScope.add(tmp);
//		} catch (NotARegisterException e) {
//			System.out.println(e.getMessage());
//		}
	}
	
	@Override
	public void caseStmt_Addi(NStmt_Addi node) {
		node.get_ImmExpr().apply(this);
		lstScope.add(String.format("addi %s,  %s, %d", rs, rt, imm));
//		int addi = this.registers.get(rs).getValue() + this.imm;
//		this.registers.get(rt).setValue(addi);
//		System.out.println(addi);
//		BasicInstructionInfo tmp = new Addi();
//		try {
//			tmp.setImmFormat(this.registers.get(rt).getBinary(), this.registers.get(rs).getBinary(), imm);
//			this.lstScope.add(tmp);
//		} catch (NotAnImmediateException e) {
//			System.out.println(e.getMessage());
//		}
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
		node.get_ImmExpr().apply(this);
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
	public void caseStmt_Lbl(NStmt_Lbl node) {
//		if(currentLabel.length() > 0) {
//			lstScope.add(0, currentLabel + ":");
//		}
		this.instructions.add(lstScope);
		this.lblAssociation.put(currentLabel, this.instructions.indexOf(lstScope));
		this.currentLabel = node.get_String().getText();
		lstScope = new ArrayList<String>();
//		this.instructions.put(currentLabel, lstScope);
//		this.lstScope = new ArrayList<BasicInstructionInfo>();
//		this.currentLabel = node.get_String().getText();
		//lbl.put(node.get_String().getText(), node);
		//System.out.println(node.get_String().getText());

		//node.get_Stmts().apply(this);
		//node.get_Eop().apply(this);
	}
	
	@Override
	public void caseStmt_Jmp(NStmt_Jmp node) {
		//this.lbl.get(node.get_String().getText()).apply(this);
		this.lstScope.add("j " + node.get_String().getText() );
	}
}
