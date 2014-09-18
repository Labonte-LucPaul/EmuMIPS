package ca.qc.lpl.util;

public class PrintHexMemoryDump {

	public enum MemoryType {
		STACK,
		HEAP,
		TEXT;
	}

	private MemoryType type;

	public PrintHexMemoryDump(MemoryType t) {
		this.type = t;
	}

	public String getHexDump( int startAddress, String[] memory ) {
		StringBuilder sb = new StringBuilder();
		int address = startAddress;
		String hex = "";
		String ascii = "";

		for(int i = 0; i < 500; ++i) {
			if( (i % 16) == 0 && i > 0 ) {
				sb.append("\n");
				sb.append("[0x"+String.format("%08X", address)+"] ");
				sb.append(hex);
				sb.append("  ");
				sb.append(ascii);
				hex = "";
				ascii = "";
				address = updateAddress(i, startAddress);
			}

			if( (i % 4) == 0 ) {
				hex += " ";
			}
			hex += memory[i];

			ascii += memory[i].equals("00") ? "." : String.format("%c",Integer.valueOf(memory[i], 16));
			ascii += " ";
		}

		return sb.toString();
	}

	private int updateAddress( int valueToCalculate, int address ) {

		switch(this.type) {
			case STACK:
				return address - valueToCalculate;

			case HEAP:
				return address + valueToCalculate;

			case TEXT:
				return address;
			default:
				return address;
		}
	}
}
