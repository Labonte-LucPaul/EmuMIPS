package ca.qc.lpl.emumips.interpreter.instructions;

import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAJumpException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAnImmediateException;
import ca.qc.lpl.util.UnsignedException;

public class Sltu extends BasicInstructionInfo {

	public Sltu() {
		super(0, 43);
	}
	
	public int sltu( int l_val, int r_val ) throws UnsignedException {
		
		if( l_val < 0 ) {
			throw new UnsignedException("l_val", "sltu");
		} else if( r_val < 0 ) {
			throw new UnsignedException("r_val", "sltu");
		}
		return this.getStructInstructions().value = l_val < r_val?1:0;
	}

	@Override
	public void setImmFormat(String rt, String rs, int imm) throws NotAnImmediateException {
		throw new NotAnImmediateException("sltu");
	}
	
	@Override
	public void setJmpFormat(int addr) throws NotAJumpException {
		throw new NotAJumpException("sltu");
	}
}
