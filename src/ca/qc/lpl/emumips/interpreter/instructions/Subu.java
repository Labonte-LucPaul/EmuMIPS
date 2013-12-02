package ca.qc.lpl.emumips.interpreter.instructions;

import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAJumpException;
import ca.qc.lpl.emumips.interpreter.instructions.Exceptions.NotAnImmediateException;
import ca.qc.lpl.util.UnsignedException;

public class Subu extends BasicInstructionInfo {

	public Subu() {
		super(0, 35);
	}
	
	public int subu( int l_val, int r_val ) throws UnsignedException {
		if( l_val < 0 ) {
			throw new UnsignedException("l_val", "subu");
		} else if( r_val < 0 ) {
			throw new UnsignedException("r_val", "subu");
		}
		return this.getStructInstructions().value = l_val - r_val;
	}

	@Override
	public void setImmFormat(String rt, String rs, int imm) throws NotAnImmediateException {
		throw new NotAnImmediateException("subu");
	}
	
	@Override
	public void setJmpFormat(int addr) throws NotAJumpException {
		throw new NotAJumpException("subu");
	}
}
