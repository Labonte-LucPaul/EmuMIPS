package ca.qc.lpl.emumips.interpreter.instructions;

public class StructInstructions {

	public String binary;
	public String hex;
	public String deci;
	public int value;
	
	public StructInstructions() {
		this.binary = "";
		this.hex = "";
		this.deci = "";
		this.value = 0;
	}
	
	public StructInstructions( String bin, String hex, String deci, int val ) {
		this.binary = bin;
		this.hex = hex;
		this.deci = deci;
		this.value = val;
	}
}
