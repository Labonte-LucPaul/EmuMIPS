package ca.qc.lpl.emumips.interpreter.Exceptions;

public class NegativeSpaceSizeException extends Exception {

	private int val;
	private int l;
	private int c;

	public NegativeSpaceSizeException(int val, int l, int c) {
		this.val = val;
		this.c = c;
		this.l = l;
	}

	@Override
	public String getMessage() {
		return String.format("Error @(%d, %d). Wrong value '%d'. Space allocation size must be > 0.", l, c, val);
	}

	public int getVal() {
		return val;
	}

	public int getL() {
		return l;
	}

	public int getC() {
		return c;
	}
}
