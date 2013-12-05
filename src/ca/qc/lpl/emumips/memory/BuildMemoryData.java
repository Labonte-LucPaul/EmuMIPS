package ca.qc.lpl.emumips.memory;

import java.util.Stack;

import ca.qc.lpl.emumips.memory.Exceptions.OverMemorySizeException;
import ca.qc.lpl.util.DataAlignment;

public class BuildMemoryData {

	//private HashMap<String, String> memoryData = new HashMap<String, String>();
	private char[] memoryData = new char[Character.MAX_VALUE];
	private Stack<String> memoryDataStack = new Stack<String>();

	private final int DATA_MAX = 0x7FFFFFFC;
	private final int DATA_MIN = 0x10008000;
	
	private int it = 0;
	private int itTemp = 0;

	public BuildMemoryData() {
		
	}
	
	private void add(String s, int nb) {
		itTemp = it;
		for( int i = 0; i < nb; ++i ) {
			if( i < s.length() ) {
				this.memoryData[it] = s.charAt(i);
			} else {
				this.memoryData[it] = '\0';
			}
			++it;
		}
	}

	public String addString(String string) {
		this.add(string, string.length() + 1);
		return Integer.toHexString(DATA_MIN + itTemp);
	}

	public String addWord(String word) {
		this.add(word, DataAlignment.WORD.getValue());
		return Integer.toHexString(DATA_MIN + itTemp);
	}

	public String addDoubleWord(String dWord) {
		this.add(dWord, DataAlignment.DOUBLE_WORD.getValue());
		return Integer.toHexString(DATA_MIN + itTemp);
	}

	public String addHalfWord(String hWord) {
		this.add(hWord, DataAlignment.HALF_WORD.getValue());
		return Integer.toHexString(DATA_MIN + itTemp);
	}

	public String addByte(String BYTE) {
		this.add(BYTE, DataAlignment.BYTE.getValue());
		return Integer.toHexString(DATA_MIN + itTemp);
	}

	private String get(String s, int nb) {
		StringBuilder sb = new StringBuilder();
		int tmp = Integer.parseInt(s, 16) - this.DATA_MIN;
		
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
		//for(int i = 0; i < nb; ++i) {
		while( this.memoryData[tmp+i] != '\0' ) {
			sb.append(this.memoryData[tmp+i]);
			++i;
		}
		
		return sb.toString();
	}

	public String index2Address(int index) throws OverMemorySizeException {
		
		if( index < 0 || index > 66060288) {
			throw new OverMemorySizeException(DATA_MIN, DATA_MAX);
		}
		return Integer.toHexString(DATA_MIN + (index * 4));
	}
	
	public String getMemoryDump() {
		StringBuilder sb = new StringBuilder();
		int address = DATA_MIN;
		String hex = "";
		String ascii = "";
		
		for(int i = 0; i < 100; ++i) {
			if( (i % 16) == 0 && i > 0 ) {	// && i != 0
				sb.append("\n");
				sb.append("[0x"+String.format("%08X", address)+"] ");
				sb.append(hex);
				sb.append("  ");
				sb.append(ascii);
				hex = "";
				ascii = "";
				address = DATA_MIN + i;
			}

			if( (i % 4) == 0 ) {
				hex += " ";
			}
			hex += String.format("%02X", (int)this.memoryData[i]);
			ascii += this.memoryData[i] == '\0' ? "." : this.memoryData[i];
			ascii += " ";
		}
		
		return sb.toString();
	}
}
