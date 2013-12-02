package ca.qc.lpl.emumips.interpreter;

import java.util.ArrayList;
import java.util.HashMap;

import ca.qc.lpl.emumips.ExitStatus;
import ca.qc.lpl.emumips.register.Register;
import language_emuMips.NImmediate_Signed;
import language_emuMips.NImmediate_Unsigned;
import language_emuMips.NRd;
import language_emuMips.NRs;
import language_emuMips.NRt;
import language_emuMips.NStmt_Add;
import language_emuMips.NStmt_Addi;
import language_emuMips.NStmt_Addiu;
import language_emuMips.NStmt_Addu;
import language_emuMips.NStmt_And;
import language_emuMips.NStmt_Andi;
import language_emuMips.NStmt_Jmp;
import language_emuMips.NStmt_Lbl;
import language_emuMips.NStmt_Nor;
import language_emuMips.NStmt_Or;
import language_emuMips.NStmt_Ori;
import language_emuMips.NStmt_Sll;
import language_emuMips.NStmt_Slt;
import language_emuMips.NStmt_Slti;
import language_emuMips.NStmt_Sltiu;
import language_emuMips.NStmt_Sltu;
import language_emuMips.NStmt_Srl;
import language_emuMips.NStmt_Sub;
import language_emuMips.NStmt_Subu;
import language_emuMips.NStmts_One;
import language_emuMips.Node;
import language_emuMips.Walker;

public class ScopeAnalysis extends Walker {

	private String rs = "";
	private String rt = "";
	private String rd = "";
	private int imm = 0;

//	private HashMap<String, Register> registers;
	private ArrayList<String> lstScope;
	private HashMap<String, Integer> lblAssociation = new HashMap<String, Integer>();
	private ArrayList<ArrayList<String>> instructions = new ArrayList<ArrayList<String>>();

	private String currentLabel = "";
	
	public ScopeAnalysis(Node tree) {
		
		this.lstScope = new ArrayList<String>();
		tree.apply(this);
		
		this.instructions.add(lstScope);
		this.lblAssociation.put(currentLabel, this.instructions.indexOf(lstScope));
		
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
		lstScope.add(String.format("add %s,  %s, %s", rd, rs, rt));
	}
	
	@Override
	public void caseStmt_Addi(NStmt_Addi node) {
		node.get_ImmExpr().apply(this);
		lstScope.add(String.format("addi %s,  %s, %d", rt, rs, imm));
	}

	@Override
	public void caseStmt_Addu(NStmt_Addu node) {
		node.get_RegExpr().apply(this);
		lstScope.add(String.format("addu %s,  %s, %d", rd, rs, rt));
	}
	
	@Override
	public void caseStmt_Addiu(NStmt_Addiu node) {
		node.get_ImmExpr().apply(this);
		lstScope.add(String.format("addiu %s,  %s, %d", rt, rs, imm));
	}
	
	@Override
	public void caseStmt_Sub(NStmt_Sub node) {
		node.get_RegExpr().apply(this);
		lstScope.add(String.format("sub %s,  %s, %s", rd, rs, rt));
	}
	
	@Override
	public void caseStmt_Subu(NStmt_Subu node) {
		node.get_RegExpr().apply(this);
		lstScope.add(String.format("subu %s,  %s, %s", rd, rs, rt));
	}
	
	@Override
	public void caseStmt_And(NStmt_And node) {
		node.get_RegExpr().apply(this);
		lstScope.add(String.format("and %s,  %s, %s", rd, rs, rt));
	}
	
	@Override
	public void caseStmt_Andi(NStmt_Andi node) {
		node.get_ImmExpr().apply(this);
		lstScope.add(String.format("andi %s,  %s, %s", rt, rs, this.imm));
	}

	@Override
	public void caseStmt_Or(NStmt_Or node) {
		node.get_RegExpr().apply(this);
		lstScope.add(String.format("or %s,  %s, %s", rd, rs, rt));
	}
	
	@Override
	public void caseStmt_Ori(NStmt_Ori node) {
		node.get_ImmExpr().apply(this);
		lstScope.add(String.format("ori %s,  %s, %s", rt, rs, this.imm));
	}

	@Override
	public void caseStmt_Nor(NStmt_Nor node) {
		node.get_RegExpr().apply(this);
		lstScope.add(String.format("nor %s,  %s, %s", rd, rs, rt));
	}
	
	@Override
	public void caseStmt_Slt(NStmt_Slt node) {
		node.get_RegExpr().apply(this);
		lstScope.add(String.format("slt %s,  %s, %s", rd, rs, rt));
	}
	
	@Override
	public void caseStmt_Slti(NStmt_Slti node) {
		node.get_ImmExpr().apply(this);
		lstScope.add(String.format("slti %s,  %s, %s", rt, rs, this.imm));
	}
	
	@Override
	public void caseStmt_Sltu(NStmt_Sltu node) {
		node.get_ImmExpr().apply(this);
		lstScope.add(String.format("sltu %s,  %s, %s", rd, rs, rt));
	}
	
	@Override
	public void caseStmt_Sltiu(NStmt_Sltiu node) {
		node.get_ImmExpr().apply(this);
		lstScope.add(String.format("sltiu %s,  %s, %s", rt, rs, this.imm));
	}

	@Override
	public void caseStmt_Sll(NStmt_Sll node) {
		node.get_Shift().apply(this);
		lstScope.add(String.format("sll %s,  %s, %s", rd, rt, imm));
	}
	
	@Override
	public void caseStmt_Srl(NStmt_Srl node) {
		node.get_Shift().apply(this);
		lstScope.add(String.format("subu %s,  %s, %s", rd, rt, this.imm));
	}
	
	@Override
	public void caseStmt_Lbl(NStmt_Lbl node) {
		
		if( this.lblAssociation.containsKey(node.get_String().getText()) == true ) {
			System.out.printf("Error @(%d,%d); Label '%s' already declared.\n",
					node.get_String().getLine(),
					node.get_String().getPos(),
					currentLabel);
			System.exit(ExitStatus.LABEL.getStatus());
		}
		this.instructions.add(lstScope);
		this.lblAssociation.put(currentLabel, this.instructions.indexOf(lstScope));
		this.currentLabel = node.get_String().getText();
		lstScope = new ArrayList<String>();

	}
	
	@Override
	public void caseStmt_Jmp(NStmt_Jmp node) {
		this.lstScope.add("j " + node.get_String().getText() );
	}
	
}
