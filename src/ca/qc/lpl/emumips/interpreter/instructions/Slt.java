package ca.qc.lpl.emumips.interpreter.instructions;

import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAJumpException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAnImmediateException;

public class Slt extends BasicInstructionInfo {

	public Slt() {
		super(0, 42);
	}
	
	public int slt( int l_val, int r_val ) {
		return this.getStructInstructions().value = l_val < r_val ? 1:0;
	}

	@Override
	public void setImmFormat(String rt, String rs, int imm) throws NotAnImmediateException {
		throw new NotAnImmediateException("slt");
	}
	
	@Override
	public void setJmpFormat(int addr) throws NotAJumpException {
		throw new NotAJumpException("slt");
	}
}
