package ca.qc.lpl.emumips.interpreter.instructions;

import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAJumpException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAnImmediateException;

public class Sub extends BasicInstructionInfo {

	public Sub() {
		super(0, 34);
	}
	
	public int sub( int l_val, int r_val ) {
		return this.getStructInstructions().value = l_val - r_val;
	}

	@Override
	public void setImmFormat(String rt, String rs, int imm) throws NotAnImmediateException {
		throw new NotAnImmediateException("sub");
	}
	
	@Override
	public void setJmpFormat(int addr) throws NotAJumpException {
		throw new NotAJumpException("sub");
	}

}
