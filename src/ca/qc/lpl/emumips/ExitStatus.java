package ca.qc.lpl.emumips;

public enum ExitStatus {
	NORMAL(0), LABEL_DUPLICATE(-20), ARRAY_INTEGER(-30);
	
	private int code;
	private ExitStatus(int c) {
		code = c;
	}
	
	public int getStatus() {
		return code;
	}
}
