package ca.qc.lpl.emumips.interpreter.instructions.Exceptions;

public class NotAnImmediateException extends Exception {

	private String inst = "";
	
	public NotAnImmediateException(String ins) {
		this.inst = ins;
	}
	
	public String getMessage() {
		return "The instruction '" + this.inst + "' is NOT an Immediate Instruction.";
	}
}
