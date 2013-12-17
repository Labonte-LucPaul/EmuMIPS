package ca.qc.lpl.util;

public enum DataAlignment {
	//DOUBLE_WORD(32), WORD(16), HALF_WORD(8), BYTE(4);
	DOUBLE_WORD(64), WORD(32), HALF_WORD(16), BYTE(8);

	private int val;
	private DataAlignment(int v) {
		val = v;
	}

	public int getValue() {
		return val;
	}
}
