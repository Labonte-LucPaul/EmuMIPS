package ca.qc.lpl.emumips.memory;

import ca.qc.lpl.emumips.register.Reg$sp;
import ca.qc.lpl.util.Observer;
import ca.qc.lpl.util.PrintHexMemoryDump;



public class BuildMemoryStack extends Observer {

	private String[] memoryStack = new String[Character.MAX_VALUE];

	private final int STACK_MAX = 0x7FFFFFFC;
	private Reg$sp sp;
	private int it = 0;

	public BuildMemoryStack(Reg$sp sp) {
		this.sp = sp;

		for( int i = 0; i < memoryStack.length; i++ ) {
			resetMemory(i);
		}
		this.sp.addObserver(this);
		this.sp.setValue(this.STACK_MAX);
	}

	public void push(String word, int immediate) {
		int tmpIt = it - immediate;
		for( int i = 0; i < word.length(); i++ ) {
			this.memoryStack[tmpIt] = word.substring(i, i + 2);
			i++;
			tmpIt++;
		}
	}

	public String popWord(int immediate) {
		String buffer = "";
		for( int tmpIt = it - immediate; tmpIt < 4; tmpIt++ ) {
			buffer += this.memoryStack[tmpIt];
			resetMemory(tmpIt);
		}
		return buffer;
	}

	private void resetMemory(int i) {
		this.memoryStack[i] = String.format("%02X", (int)'\0');
	}

	public String getMemoryDump() {
		PrintHexMemoryDump dump = new PrintHexMemoryDump(PrintHexMemoryDump.MemoryType.STACK);
		return dump.getHexDump(STACK_MAX, memoryStack);
	}

	@Override
	public void update(Object o) {
		Reg$sp sp = (Reg$sp) o;
		this.it = STACK_MAX - sp.getValue();
	}
}
