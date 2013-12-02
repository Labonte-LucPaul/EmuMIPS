package ca.qc.lpl.emumips.interpreter.instructions;

import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAJumpException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAnImmediateException;

public class Add extends BasicInstructionInfo {

	public Add() {
		super(0, 32);
	}
	
	public int add( int l_val, int r_val ) {
		return this.getStructInstructions().value = l_val + r_val;
	}

	@Override
	public void setImmFormat(String rt, String rs, int imm) throws NotAnImmediateException {
		throw new NotAnImmediateException("add");
	}
	
	@Override
	public void setJmpFormat(int addr) throws NotAJumpException {
		throw new NotAJumpException("add");
	}
}
