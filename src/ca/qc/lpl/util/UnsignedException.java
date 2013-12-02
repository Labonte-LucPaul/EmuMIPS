package ca.qc.lpl.util;

public class UnsignedException extends Exception {

	private String arg = "";
	private String ins = "";
	
	public UnsignedException(String arg, String ins) {
		this.arg = arg;
		this.ins = ins;
	}
	
	public String getMessage() {
		return "Invalid '" + this.arg + "' in instruction '" + this.ins + "' must be unsigned.";
	}
}
