package ca.qc.lpl.emumips.interpreter.Exceptions;

public class SignedOverflowException extends Exception {

	private String val = "";
	
	public SignedOverflowException(String val) {
		this.val = val;
	}
	
	public String getMessage() {
		return String.format("Error,  value '%s' is not within 2^32 bits.\n"
				+ "Values must be between '%s' and '%s'.\n", val, Integer.MIN_VALUE,
				Integer.MAX_VALUE);
	}
}
