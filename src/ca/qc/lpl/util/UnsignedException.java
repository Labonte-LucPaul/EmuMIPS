package ca.qc.lpl.util;

public class UnsignedException extends Exception {

	private String msg = "";

	public UnsignedException(String arg, String ins) {
		this.msg = "Invalid '" + arg + "' in instruction '" + ins + "' must be unsigned.";
	}
	
	public UnsignedException(String val, int l, int c) {
		this.msg = String.format("Invalid value '%s' @(%d,%d). Unsigned integers must be between '0' and '4294967295'.\n", val, l, c);
	}

	public String getMessage() {
		return this.msg;
	}

}
