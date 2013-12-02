package ca.qc.lpl.emumips.interpreter.instructions;

import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAJumpException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotARegisterException;

public class Addi extends BasicInstructionInfo {

	public Addi() {
		super(12, 0);
	}

	public int addi( int l_val, int r_val ) {
		return this.getStructInstructions().value = l_val + r_val;
	}

	@Override
	public void setRegFormat(String rd, String rs, String rt, int sh) throws NotARegisterException {
		throw new NotARegisterException("addi");
	}
	
	@Override
	public void setJmpFormat(int addr) throws NotAJumpException {
		throw new NotAJumpException("addi");
	}
}
