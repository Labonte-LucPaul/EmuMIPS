package ca.qc.lpl.emumips.interpreter.instructions.Exceptions;

public class NotAJumpException extends Exception {

	private String ins = "";
	
	public NotAJumpException(String ins) {
		this.ins = ins;
	}

	public String getMessage() {
		return "The instruction '" + this.ins + "' is NOT a Jump Instruction.";
	}
	
}
