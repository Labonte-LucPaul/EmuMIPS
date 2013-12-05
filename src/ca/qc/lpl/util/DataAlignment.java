package ca.qc.lpl.util;

public enum DataAlignment {
	DOUBLE_WORD(32), WORD(16), HALF_WORD(8), BYTE(4);
	
	private int val;
	private DataAlignment(int v) {
		val = v;
	}
	
	public int getValue() {
		return val;
	}
}
