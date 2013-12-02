package ca.qc.lpl.emumips.interpreter.instructions;

import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAJumpException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotARegisterException;

public class Xori extends BasicInstructionInfo {

	public Xori() {
		super(14, 0);
	}
	
	public int xori( int l_val, int r_val ) {
		return this.getStructInstructions().value = l_val ^ r_val;
	}

	@Override
	public void setRegFormat(String rd, String rs, String rt, int sh) throws NotARegisterException {
		throw new NotARegisterException("xori");
	}
	
	@Override
	public void setJmpFormat(int addr) throws NotAJumpException {
		throw new NotAJumpException("xori");
	}
}
