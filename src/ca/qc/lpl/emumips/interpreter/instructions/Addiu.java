package ca.qc.lpl.emumips.interpreter.instructions;

import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAJumpException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotARegisterException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAnImmediateException;
import ca.qc.lpl.util.UnsignedException;

public class Addiu extends BasicInstructionInfo {

	public Addiu() {
		super(9, 0);
	}
	
	public int addiu( int l_val, int r_val ) throws UnsignedException {
		
		if( l_val < 0 ) {
			throw new UnsignedException("l_val", "addiu");
		} else if( r_val < 0 ) {
			throw new UnsignedException("r_val", "addiu");
		}
		return this.getStructInstructions().value = l_val + r_val;
	}

	@Override
	public void setRegFormat(String rd, String rs, String rt, int sh) throws NotARegisterException {
		throw new NotARegisterException("addiu");
	}
	
	@Override
	public void setJmpFormat(int addr) throws NotAJumpException {
		throw new NotAJumpException("addiu");
	}
}
