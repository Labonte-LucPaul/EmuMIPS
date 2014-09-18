package ca.qc.lpl.emumips.memory;

import ca.qc.lpl.emumips.register.Reg$sp;
import ca.qc.lpl.util.PrintHexMemoryDump;



public class BuildMemoryStack {

	private String[] memoryStack = new String[Character.MAX_VALUE];

	private final int STACK_MAX = 0x7FFFFFFC;
	private Reg$sp sp;
	private int it = 0;

	public BuildMemoryStack(Reg$sp sp) {
		this.sp = sp;
		this.sp.setValue(this.STACK_MAX);
		while(it < memoryStack.length) {
			resetMemory();
			it++;
		}
		it = 0;
	}

	public void push(String word) {
		for( int i = 0; i < word.length(); i++ ) {
			this.memoryStack[it] = word.substring(i, i + 2);
			i++;
			it++;
		}
		updateStackPointer();
	}

	public String popWord() {
		String buffer = "";
		for( int i = 0; i < 4; i++ ) {
			it--;
			buffer = this.memoryStack[it] + buffer;
			resetMemory();
		}
		updateStackPointer();

		return buffer;
	}

	private void resetMemory() {
		this.memoryStack[it] = String.format("%02X", (int)'\0');
	}

	private void updateStackPointer() {
		this.sp.setValue( this.STACK_MAX - it );
	}

	public String getMemoryDump() {
		PrintHexMemoryDump dump = new PrintHexMemoryDump(PrintHexMemoryDump.MemoryType.STACK);
		return dump.getHexDump(STACK_MAX, memoryStack);
	}
}
