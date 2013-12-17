package ca.qc.lpl.emumips.interpreter;

import java.util.ArrayList;
import java.util.HashMap;

import language_emuMips.NCommonData_Ascii;
import language_emuMips.NCommonData_Asciiz;
import language_emuMips.NCommonData_Byte;
import language_emuMips.NCommonData_Float;
import language_emuMips.NCommonData_Half;
import language_emuMips.NCommonData_Lbl;
import language_emuMips.NCommonData_Space;
import language_emuMips.NCommonData_Word;
import language_emuMips.NDirectivesQte_Dirqt;
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
import language_emuMips.NStmt_Jmplnk;
import language_emuMips.NStmt_Jmpreg;
import language_emuMips.NStmt_La;
import language_emuMips.NStmt_Lbl;
import language_emuMips.NStmt_Lbu;
import language_emuMips.NStmt_Lhu;
import language_emuMips.NStmt_Ll;
import language_emuMips.NStmt_Lw;
import language_emuMips.NStmt_Nor;
import language_emuMips.NStmt_Or;
import language_emuMips.NStmt_Ori;
import language_emuMips.NStmt_Sb;
import language_emuMips.NStmt_Sc;
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
import language_emuMips.NStmt_Xor;
import language_emuMips.NStmt_Xori;
import language_emuMips.Node;
import language_emuMips.Walker;
import ca.qc.lpl.emumips.EmuMIPS;
import ca.qc.lpl.emumips.ExitStatus;
import ca.qc.lpl.emumips.interpreter.Exceptions.NegativeSpaceSizeException;
import ca.qc.lpl.emumips.interpreter.Exceptions.SignedOverflowException;
import ca.qc.lpl.util.UnsignedException;

public class ScopeAnalysis extends Walker {

	private String rs = "";
	private String rt = "";
	private String rd = "";
	private int imm = 0;

	private boolean isArray = false;
	private boolean isSigned = true;

	private StringBuilder lstScope;
	private HashMap<String, Integer> lblAssociation = new HashMap<String, Integer>();
	private HashMap<String, String> lblDataAssociation = new HashMap<String, String>();
	private ArrayList<StringBuilder> instructions = new ArrayList<StringBuilder>();

	private String currentLabel = "";
	private String currentLabelData = "";
	private int instructionCounter = 0; // Count the number of instructions. Usefull for addresses.

	public ScopeAnalysis(Node tree) {

		this.lstScope  = new StringBuilder();
		tree.apply(this);

		this.instructions.add(lstScope);
		this.lblAssociation.put(currentLabel, this.instructions.indexOf(lstScope));
		EmuMIPS.instructionCounter = this.instructionCounter;
		EmuMIPS.instructions = this.instructions;
		EmuMIPS.lblAssociation = this.lblAssociation;


	}

	public ArrayList<StringBuilder> getInstructions() {
		return this.instructions;
	}

	public HashMap<String, Integer> getLblAssociation() {
		return this.lblAssociation;
	}

	public HashMap<String, String> getLblDataAssociation() {
		return this.lblDataAssociation;
	}

	private void appendInstruction(String s) {
		this.lstScope.append(s + "\n");
		++this.instructionCounter;
	}

	private void isMultiple4(int val, int l, int c) {
		if( (val % 4) != 0 ) {
			System.out.printf("Error @(%d,%d): value '%d' is not a multiple of 4.\n"
					+ "Array Access must be of a multiple of 4: 0, 4, 8, 12, 16, ...\n",
					l, c, val);
			System.exit(ExitStatus.ARRAY_INTEGER.getStatus());
		}
		this.isArray = false;
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
		int err = 0;
		try {

			long val = Long.parseLong(node.getText());

			if( this.isSigned == true && (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE)  ) {
				err = ExitStatus.SIGNED_OVERFLOW.getStatus();
				throw new SignedOverflowException(node.getText(), node.getLine(), node.getPos());
			} else if( this.isSigned == false && val < 0 ) {
				err = ExitStatus.UNSIGNED_OVERFLOW.getStatus();
				throw new UnsignedException(node.getText(), node.getLine(), node.getPos());
			}

		} catch (SignedOverflowException | UnsignedException e) {
			System.out.println(e.getMessage());
			System.exit(err);
		} finally {
			this.isSigned = true;
		}
		this.imm = Integer.parseInt( node.getText() );

		if( this.isArray == true ) {
			this.isMultiple4(this.imm, node.getLine(), node.getPos());
		}
	}

//	@Override
//	public void caseStmt_Data(NStmt_Data node) {
//		node.get_CommonDatas().apply(this);
//	}
//
//	@Override
//	public void caseDirectivesQte(NDirectivesQte node) {
//		//System.out.println(node.getText());
//	}

//	@Override
//	public void caseCommonData_Word(NCommonData_Word node) {
//		node.get_DirectivesQte().apply(this);
//	}

	@Override
	public void caseStmt_Add(NStmt_Add node) {
		node.get_RegExpr().apply(this);
		appendInstruction(String.format("add %s, %s, %s", rd, rs, rt));
	}

	@Override
	public void caseStmt_Addi(NStmt_Addi node) {
		node.get_ImmExpr().apply(this);
		appendInstruction(String.format("addi %s, %s, %d", rt, rs, imm));
	}

	@Override
	public void caseStmt_Addu(NStmt_Addu node) {
		this.isSigned = false;
		node.get_RegExpr().apply(this);
		appendInstruction(String.format("addu %s, %s, %d", rd, rs, rt));
	}

	@Override
	public void caseStmt_Addiu(NStmt_Addiu node) {
		this.isSigned = false;
		node.get_ImmExpru().apply(this);
		appendInstruction(String.format("addiu %s, %s, %d", rt, rs, imm));
	}

	@Override
	public void caseStmt_Sub(NStmt_Sub node) {
		node.get_RegExpr().apply(this);
		appendInstruction(String.format("sub %s, %s, %s", rd, rs, rt));
	}

	@Override
	public void caseStmt_Subu(NStmt_Subu node) {
		this.isSigned = false;
		node.get_RegExpr().apply(this);
		appendInstruction(String.format("subu %s, %s, %s", rd, rs, rt));
	}

	@Override
	public void caseStmt_And(NStmt_And node) {
		node.get_RegExpr().apply(this);
		appendInstruction(String.format("and %s, %s, %s", rd, rs, rt));
	}

	@Override
	public void caseStmt_Andi(NStmt_Andi node) {
		node.get_ImmExpr().apply(this);
		appendInstruction(String.format("andi %s, %s, %s", rt, rs, this.imm));
	}

	@Override
	public void caseStmt_Or(NStmt_Or node) {
		node.get_RegExpr().apply(this);
		appendInstruction(String.format("or %s, %s, %s", rd, rs, rt));
	}

	@Override
	public void caseStmt_Ori(NStmt_Ori node) {
		node.get_ImmExpr().apply(this);
		appendInstruction(String.format("ori %s, %s, %s", rt, rs, this.imm));
	}

	@Override
	public void caseStmt_Nor(NStmt_Nor node) {
		node.get_RegExpr().apply(this);
		appendInstruction(String.format("nor %s, %s, %s", rd, rs, rt));
	}

	@Override
	public void caseStmt_Slt(NStmt_Slt node) {
		node.get_RegExpr().apply(this);
		appendInstruction(String.format("slt %s, %s, %s", rd, rs, rt));
	}

	@Override
	public void caseStmt_Slti(NStmt_Slti node) {
		node.get_ImmExpr().apply(this);
		appendInstruction(String.format("slti %s, %s, %s", rt, rs, this.imm));
	}

	@Override
	public void caseStmt_Sltu(NStmt_Sltu node) {
		this.isSigned = false;
		node.get_ImmExpr().apply(this);
		appendInstruction(String.format("sltu %s, %s, %s", rd, rs, rt));
	}

	@Override
	public void caseStmt_Sltiu(NStmt_Sltiu node) {
		this.isSigned = false;
		node.get_ImmExpru().apply(this);
		appendInstruction(String.format("sltiu %s, %s, %s", rt, rs, this.imm));
	}

	@Override
	public void caseStmt_Sll(NStmt_Sll node) {
		node.get_Shift().apply(this);
		appendInstruction(String.format("sll %s, %s, %s", rd, rt, imm));
	}

	@Override
	public void caseStmt_Srl(NStmt_Srl node) {
		node.get_Shift().apply(this);
		appendInstruction(String.format("subu %s, %s, %s", rd, rt, this.imm));
	}

	@Override
	public void caseStmt_Lbl(NStmt_Lbl node) {

		if( this.currentLabel.equals(node.get_String().getText()) == true ) {
			System.out.printf("Error @(%d,%d); Label '%s' already declared.\n",
					node.get_String().getLine(),
					node.get_String().getPos(),
					currentLabel);
			System.exit(ExitStatus.LABEL_DUPLICATE.getStatus());
		}
		this.instructions.add(lstScope);
		this.lblAssociation.put(currentLabel, this.instructions.indexOf(lstScope));
		this.currentLabel = node.get_String().getText();
		lstScope = new StringBuilder();

	}

	@Override
	public void caseStmt_Jmp(NStmt_Jmp node) {
		this.appendInstruction("j " + node.get_String().getText() );
	}

	@Override
	public void caseStmt_Xor(NStmt_Xor node) {
		node.get_RegExpr().apply(this);
		appendInstruction(String.format("xor %s, %s, %s", rd, rs, rt));
	}

	@Override
	public void caseStmt_Xori(NStmt_Xori node) {
		node.get_ImmExpr().apply(this);
		appendInstruction(String.format("xori %s, %s, %s", rt, rs, this.imm));
	}

	@Override
	public void caseStmt_Beq(NStmt_Beq node) {
		appendInstruction(String.format("beq %s, %s, %s", node.get_Rs().get_Register().getText(),
														node.get_Rt().get_Register().getText(),
														node.get_String().getText()));
	}

	@Override
	public void caseStmt_Bne(NStmt_Bne node) {
		appendInstruction(String.format("bne %s, %s, %s", node.get_Rs().get_Register().getText(),
				node.get_Rt().get_Register().getText(),
				node.get_String().getText()));
	}

	@Override
	public void caseStmt_Lbu(NStmt_Lbu node) {
		this.isSigned = false;
		this.isArray = true;
		node.get_Array().apply(this);
		appendInstruction(String.format("lbu %s, %d(%s)", rt, this.imm, rs));
	}

	@Override
	public void caseStmt_Lhu(NStmt_Lhu node) {
		this.isSigned = false;
		this.isArray = true;
		node.get_Array().apply(this);
		appendInstruction(String.format("lhu %s, %d(%s)", rt, this.imm, rs));
	}

	@Override
	public void caseStmt_Ll(NStmt_Ll node) {
		this.isSigned = false;
		this.isArray = true;
		node.get_Array().apply(this);
		appendInstruction(String.format("ll %s, %d(%s)", rt, this.imm, rs));
	}


	@Override
	public void caseStmt_Lw(NStmt_Lw node) {
		this.isSigned = false;
		this.isArray = true;
		node.get_Array().apply(this);
		appendInstruction(String.format("lw %s, %d(%s)", rt, this.imm, rs));
	}

	@Override
	public void caseStmt_Sb(NStmt_Sb node) {
		this.isSigned = false;
		this.isArray = true;
		node.get_Array().apply(this);
		appendInstruction(String.format("sb %s, %d(%s)", rt, this.imm, rs));
	}

	@Override
	public void caseStmt_Sc(NStmt_Sc node) {
		this.isSigned = false;
		this.isArray = true;
		node.get_Array().apply(this);
		appendInstruction(String.format("sc %s, %d(%s)", rt, this.imm, rs));
	}

	@Override
	public void caseStmt_Sh(NStmt_Sh node) {
		this.isSigned = false;
		this.isArray = true;
		node.get_Array().apply(this);
		appendInstruction(String.format("sh %s, %d(%s)", rt, this.imm, rs));
	}

	@Override
	public void caseStmt_Sw(NStmt_Sw node) {
		this.isSigned = false;
		this.isArray = true;
		node.get_Array().apply(this);
		appendInstruction(String.format("sw %s, %d(%s)", rt, this.imm, rs));
	}

	@Override
	public void caseStmt_Jmpreg(NStmt_Jmpreg node) {
		node.get_Rs().apply(this);
		this.appendInstruction("jr " + rs );
	}

	@Override
	public void caseStmt_Jmplnk(NStmt_Jmplnk node) {
		this.appendInstruction("jal " + node.get_String().getText() );
	}

	@Override
	public void caseCommonData_Lbl(NCommonData_Lbl node) {
		if( this.lblDataAssociation.containsKey(node.get_String().getText()) ) {
			System.out.println("Label Exist");
			System.exit(-30);
		}
		this.currentLabelData = node.get_String().getText();
	}

	private void associateDataLabel(String addr) {
		if( this.currentLabelData.length() > 0 ) {
			this.lblDataAssociation.put(this.currentLabelData, addr);
			this.currentLabelData = "";
		}
	}
	@Override
	public void caseCommonData_Asciiz(NCommonData_Asciiz node) {
		String addr = EmuMIPS.memoryData.addString(node.get_ConsoleString().getText(), true);
		associateDataLabel(addr);
	}

	@Override
	public void caseCommonData_Ascii(NCommonData_Ascii node) {
		String addr = EmuMIPS.memoryData.addString(node.get_ConsoleString().getText());
		associateDataLabel(addr);
	}

	private ArrayList<String> multiValues;

	@Override
	public void caseDirectivesQte_Dirqt(NDirectivesQte_Dirqt node) {
		this.multiValues.add(node.get_Number().getText());
	}

	@Override
	public void caseCommonData_Word(NCommonData_Word node) {
		this.multiValues = new ArrayList<String>();
		node.get_DirectivesQtes().apply(this);
		String addr = "";
		for(String s : this.multiValues) {
			if( addr.length() == 0 ) {
				addr = EmuMIPS.memoryData.addWord(s);
			} else {
				EmuMIPS.memoryData.addWord(s);
			}
		}
		associateDataLabel(addr);
	}

	@Override
	public void caseCommonData_Half(NCommonData_Half node) {
		this.multiValues = new ArrayList<String>();
		node.get_DirectivesQtes().apply(this);
		String addr = "";
		for(String s : this.multiValues) {
			if( addr.length() == 0 ) {
				addr = EmuMIPS.memoryData.addHalfWord(s);
			} else {
				EmuMIPS.memoryData.addHalfWord(s);
			}
		}
		associateDataLabel(addr);
	}

	@Override
	public void caseCommonData_Byte(NCommonData_Byte node) {
		this.multiValues = new ArrayList<String>();
		node.get_DirectivesQtes().apply(this);
		String addr = "";
		for(String s : this.multiValues) {
			if( addr.length() == 0 ) {
				addr = EmuMIPS.memoryData.addByte(s);
			} else {
				EmuMIPS.memoryData.addByte(s);
			}
		}
		associateDataLabel(addr);
	}

	@Override
	public void caseCommonData_Space(NCommonData_Space node) {
		int size = Integer.parseInt(node.get_Number().getText());
		if( size < 0 ) {
			try {
				throw new NegativeSpaceSizeException(size, node.get_Number().getLine(), node.get_Number().getPos());
			} catch (NegativeSpaceSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String addr = EmuMIPS.memoryData.malloc(size);
		associateDataLabel(addr);
	}
	@Override
	public void caseCommonData_Float(NCommonData_Float node) {
//		String addr = EmuMIPS.memoryData.addFloat(node.get_DirectivesQtes().getText());
//		this.lblDataAssociation.put(this.currentLabelData, addr);
	}

	@Override
	public void caseStmt_La(NStmt_La node) {
		this.appendInstruction("la " + node.get_Register().getText() + "," + node.get_String().getText() );
	}
}
