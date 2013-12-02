package ca.qc.lpl.emumips.interpreter.instructions;

import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAJumpException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotARegisterException;

public class Slti extends BasicInstructionInfo {

	public Slti() {
		super(10, 0);
	}
	
	public int slti( int l_val, int r_val ) {
		return this.getStructInstructions().value = l_val < r_val?1:0;
	}

	@Override
	public void setRegFormat(String rd, String rs, String rt, int sh) throws NotARegisterException {
		throw new NotARegisterException("slti");
	}
	
	@Override
	public void setJmpFormat(int addr) throws NotAJumpException {
		throw new NotAJumpException("slti");
	}
}
