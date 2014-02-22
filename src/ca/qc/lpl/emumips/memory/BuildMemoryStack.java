package ca.qc.lpl.emumips.memory;


public class BuildMemoryStack {

	//private Stack<String> memoryDataStack = new Stack<String>();
	private String[] memoryStack = new String[Character.MAX_VALUE];

	private final int STACK_MAX = 0x7FFFFFFC;

	private int it = 0;

	public BuildMemoryStack() {

	}

}
