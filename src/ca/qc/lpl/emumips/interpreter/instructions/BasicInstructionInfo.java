package ca.qc.lpl.emumips.interpreter.instructions;

import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAJumpException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotARegisterException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAnImmediateException;

public class BasicInstructionInfo {
	
	private int opcode;
	private int funct;
	private StructInstructions struct;

	public BasicInstructionInfo( int op, int fn ) {
		this.opcode = op;
		this.funct = fn;
		this.struct = new StructInstructions();
	}
	
	public String getBinTrimmed() {
		return this.struct.binary.replaceAll("\\s", "");
	}
	public StructInstructions getStructInstructions() {
		return this.struct;
	}

	public String getOpcodeBinary() {
		return String.format("%06d", Integer.parseInt(Integer.toBinaryString(opcode)));
	}
	
	public String getOpcodeHex() {
		return String.format("%02X", opcode);
	}
	
	public String getFunctionBinary() {
		return String.format("%06d", Integer.parseInt(Integer.toBinaryString(funct)));
	}
	
	public String getFunctionHex() {
		return String.format("%02X", funct);
	}

	public void setRegFormat(String rd, String rs, String rt, int sh) throws NotARegisterException {
		this.struct.binary = String.format("%s %s %s %s %05d %s", getOpcodeBinary(), rs, rt, rd, Integer.parseInt(Integer.toBinaryString(sh)), getFunctionBinary());
		this.struct.hex = getBin2Hex(this.struct.binary);
	}
	
	public void setImmFormat(String rt, String rs, int imm) throws NotAnImmediateException {
		this.struct.binary = String.format("%s %s %s %016d", getOpcodeBinary(), rs, rt, Integer.parseInt(Integer.toBinaryString(imm)));
		this.struct.hex = this.getBin2Hex(this.struct.binary);
	}
	
	public void setJmpFormat(int addr) throws NotAJumpException {
		this.struct.binary = String.format("%s %026d", getOpcodeBinary(), Integer.parseInt(Integer.toBinaryString(addr)));
		this.struct.hex = this.getBin2Hex(this.struct.binary);
	}
	
	public String getBin2Hex( String bin ) {
		bin = bin.replaceAll("\\s", "");
		return String.format( "%08X", Integer.parseInt(bin, 2) );
	}

}
