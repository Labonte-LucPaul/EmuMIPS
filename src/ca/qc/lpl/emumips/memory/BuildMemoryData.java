package ca.qc.lpl.emumips.memory;

import ca.qc.lpl.emumips.memory.Exceptions.OverMemorySizeException;
import ca.qc.lpl.util.DataAlignment;
import ca.qc.lpl.util.PrintHexMemoryDump;

public class BuildMemoryData {

	private String[] memoryData = new String[Character.MAX_VALUE];

	//private final int DATA_MAX = 0x7FFFFFFC;
	private final int DATA_MIN = 0x10008000;

	private int it = 0;
	private int itTemp = 0;

	public BuildMemoryData() {
		for( int i = 0; i < this.memoryData.length; ++i ) {
			this.memoryData[i] = String.format("%02X", (int)'\0');
		}
	}

//	private void inc() {
//		++this.it;
//	}
//
//	private void dec() {
//		--this.it;
//	}

	private void add(String s, int nb) {
		itTemp = it;
		for( int i = 0; i < nb; ++i ) {
			if( i < s.length() ) {
				this.memoryData[it] = String.format("%02X", (int) s.charAt(i));
			} else {
				this.memoryData[it] = String.format("%02X", (int)'\0');
			}
			++it;
		}
	}

	public String addString(String string, boolean end) {
		int len = 0;
		if( end ) {
			len = 1;
		}
		string = string.substring(1, string.length() -1);
		this.add(string, string.length() + len);
		return Integer.toHexString(DATA_MIN + itTemp);
	}

	public String addString(String string) {
		return this.addString(string, false);
	}

	private void addInteger(String s, int sz) {
		itTemp = it;
		for( int i = 0; i < s.length(); ++i ) {
			String hex = "";
			hex += s.charAt(i);
			++i;
			hex += s.charAt(i);
			this.memoryData[it] = hex;
			++it;
		}
	}

	private void addInteger(String s, int sz, int addr) {
		int tmpIt = this.it;
		it = addr;
		this.addInteger(s, sz);
		this.it = tmpIt;
	}

	public String malloc(int size) {
		add("\0", size);
		return Integer.toHexString(DATA_MIN + itTemp);
	}

	public String addWord(String word) {
		this.addInteger(String.format("%08X", Integer.valueOf(word)), DataAlignment.WORD.getValue());
		return Integer.toHexString(DATA_MIN + itTemp);
	}

	public String addWord(String word, int address) {
		this.addInteger(word, DataAlignment.WORD.getValue(), address - DATA_MIN);
		return null;
	}

	public String addDoubleWord(String dWord) {
		this.addInteger(String.format("%016X", Integer.valueOf(dWord)), DataAlignment.DOUBLE_WORD.getValue());
		return Integer.toHexString(DATA_MIN + itTemp);
	}

	public String addHalfWord(String hWord) {
		this.addInteger(String.format("%04X", Integer.valueOf(hWord)), DataAlignment.HALF_WORD.getValue());
		return Integer.toHexString(DATA_MIN + itTemp);
	}

	public String addHalfWord(String hWord, int address) {
		this.addInteger(hWord, DataAlignment.HALF_WORD.getValue(), address - DATA_MIN);
		return null;
	}

	public String addByte(String BYTE) {
		this.addInteger(String.format("%02X", Integer.valueOf(BYTE)), DataAlignment.BYTE.getValue());
		return Integer.toHexString(DATA_MIN + itTemp);
	}

	public String addByte(String BYTE, int address) {
		this.addInteger(BYTE, DataAlignment.BYTE.getValue(), address - DATA_MIN);
		return null;
	}

	private String get(String s, int nb) {
		StringBuilder sb = new StringBuilder();
		int tmp = Integer.parseInt(s, 16) - this.DATA_MIN;
		nb = nb / 8;	// Hex values are grouped by bytes in each position in array

		for(int i = 0; i < nb; ++i) {
			sb.append(this.memoryData[tmp+i]);
		}

		return sb.toString();
	}

	public String getWord(String addressHexa) {
		return this.get(addressHexa, DataAlignment.WORD.getValue());
	}

	public String getDoubleWord(String addressHexa) {
		return this.get(addressHexa, DataAlignment.DOUBLE_WORD.getValue());
	}


	public String getHalfWord(String addressHexa) {
		return this.get(addressHexa, DataAlignment.HALF_WORD.getValue());
	}

	public String getByte(String addressHexa) {
		return this.get(addressHexa, DataAlignment.BYTE.getValue());
	}

	public String getString(String addressHexa) {
		StringBuilder sb = new StringBuilder();
		int tmp = Integer.parseInt(addressHexa, 16) - this.DATA_MIN;

		int i = 0;
		while( this.memoryData[tmp+i].equals("00") == false ) {
			int val = Integer.valueOf(this.memoryData[tmp+i], 16);
			sb.append((char)val);
			++i;
		}

		return sb.toString();
	}

	public String index2Address(int index) throws OverMemorySizeException {

		if( index < 0 || index > 66060288) {
			throw new OverMemorySizeException(DATA_MIN);
		}
		return Integer.toHexString(DATA_MIN + (index * 4));
	}

	public String getMemoryDump() {
		PrintHexMemoryDump dump = new PrintHexMemoryDump(PrintHexMemoryDump.MemoryType.HEAP);
		return dump.getHexDump(DATA_MIN, memoryData);
	}

	public String getMemoryDumpBinary() {
		StringBuilder sb = new StringBuilder();

		int i = 0;
		while( i < 500 ) {
			String tmp = "";
			int j = 0;
			while( i < this.memoryData.length && j < 4 ) {
				tmp += this.memoryData[i];
				++i;
				++j;
			}

			int val = (int) Long.parseLong(tmp, 16);
			sb.append( String.format("%32s", Integer.toBinaryString(val)).replace(' ', '0') );
			sb.append(" ");

			if( (i % 16) == 0 ) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}
