package ca.qc.lpl.emumips.memory.Exceptions;

public class OverMemorySizeException extends Exception {

	private int min = 0;
	//private int max = 0;

	public OverMemorySizeException(int min) {
		this.min = min;
		//this.max = max;
	}

	@Override
	public String getMessage() {
		return String.format("Memory out of bounce. Must be between '0x%s' and Stack Pointer value.\n",
				Integer.toHexString(min));
	}
}
