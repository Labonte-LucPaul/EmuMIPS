package ca.qc.lpl.emumips.interpreter.instructions;

import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAJumpException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotARegisterException;
import ca.qc.lpl.util.UnsignedException;

public class Sltiu extends BasicInstructionInfo {

	public Sltiu() {
		super(11, 0);
	}
	
	public int sltiu( int l_val, int r_val ) throws UnsignedException {
		
		if( l_val < 0 ) {
			throw new UnsignedException("l_val", "sltiu");
		} else if( r_val < 0 ) {
			throw new UnsignedException("r_val", "sltiu");
		}
		return this.getStructInstructions().value = l_val < r_val?1:0;
	}

	@Override
	public void setRegFormat(String rd, String rs, String rt, int sh) throws NotARegisterException {
		throw new NotARegisterException("sltiu");
	}

	@Override
	public void setJmpFormat(int addr) throws NotAJumpException {
		throw new NotAJumpException("sltiu");
	}
}
