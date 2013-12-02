package ca.qc.lpl.emumips.interpreter.instructions.Exceptions;

public class NotARegisterException extends Exception {

	String instruction = "";
	
	public NotARegisterException(String ins) {
		this.instruction = ins;
	}

	public String getMessage() {
		return "The instruction '" + this.instruction + "' is NOT a Register Instruction.";
	}
	
}
