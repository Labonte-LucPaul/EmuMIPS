package ca.qc.lpl.emumips.interpreter.instructions;

import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAJumpException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotARegisterException;

public class Ori extends BasicInstructionInfo {

	public Ori() {
		super(13, 0);
	}
	
	public int ori( int l_val, int r_val ) {
		return this.getStructInstructions().value = l_val | r_val;
	}

	@Override
	public void setRegFormat(String rd, String rs, String rt, int sh) throws NotARegisterException {
		throw new NotARegisterException("ori");
	}
	
	@Override
	public void setJmpFormat(int addr) throws NotAJumpException {
		throw new NotAJumpException("ori");
	}
}
