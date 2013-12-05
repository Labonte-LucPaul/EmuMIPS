package ca.qc.lpl.emumips.memory.Exceptions;

public class OverMemorySizeException extends Exception {

	private int min = 0;
	private int max = 0;
	
	public OverMemorySizeException(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public String getMessage() {
		return String.format("Memory out of bounce. Must be between '0x%s' and '0x%s'.\n",
				Integer.toHexString(min),Integer.toHexString(max));
	}
}
