package ca.qc.lpl.util;

public class UnsignedException extends Exception {

	private String msg = "";

	public UnsignedException(String arg, String ins) {

		this.msg = "Invalid '" + arg + "' in instruction '" + ins + "' must be unsigned.";
	}
	
	public UnsignedException(String val) {
		this.msg = String.format("Invalid value '%s'. Unsigned integers must be between '0' and '4294967295'.\n",val);
	}

	public String getMessage() {
		return this.msg;
	}

}
