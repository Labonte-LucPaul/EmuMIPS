package ca.qc.lpl.emumips.interpreter.Exceptions;

public class SignedOverflowException extends Exception {

	private String val = "";
	private int l;
	private int c;
	
	public SignedOverflowException(String val, int l, int c) {
		this.val = val;
		this.l = l;
		this.c = c;
	}
	
	public String getMessage() {
		return String.format("Error,  value '%s' @(%s,%s) is not within 2^32 bits.\n"
				+ "Values must be between '%d' and '%d'.\n", val, l, c, Integer.MIN_VALUE,
				Integer.MAX_VALUE);
	}
}
