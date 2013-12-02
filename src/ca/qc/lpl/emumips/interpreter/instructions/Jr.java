package ca.qc.lpl.emumips.interpreter.instructions;

import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAJumpException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAnImmediateException;

public class Jr extends BasicInstructionInfo {

	public Jr() {
		super(0, 8);
	}

	@Override
	public void setImmFormat(String rt, String rs, int imm) throws NotAnImmediateException {
		throw new NotAnImmediateException("j");
	}

	@Override
	public void setJmpFormat(int addr) throws NotAJumpException {
		throw new NotAJumpException("addu");
	}

}
