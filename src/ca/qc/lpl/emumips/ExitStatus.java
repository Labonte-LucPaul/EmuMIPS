package ca.qc.lpl.emumips;

public enum ExitStatus {
	NORMAL(0), LABEL(-20);
	
	private int code;
	private ExitStatus(int c) {
		code = c;
	}
	
	public int getStatus() {
		return code;
	}
}
