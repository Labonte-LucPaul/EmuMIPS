package ca.qc.lpl.emumips.memory;

import java.util.ArrayList;

import ca.qc.lpl.emumips.memory.Exceptions.OverMemorySizeException;

public class BuildMemoryText {

	private ArrayList<String> memoryText = new ArrayList<String>();
	private final int TEXT_START = 0x400000;
	private final int TEXT_END   = 0x10000000;

	public BuildMemoryText(ArrayList<String> src) {
		if( src != null ) {
			for(String s : src) {
				String[] tmp = s.split("\n");
				for(String ss : tmp) {
					this.memoryText.add(ss);
				}
			}
		}
	}

	public String index2Address(int index) throws OverMemorySizeException {

		if( index < 0 || index > 66060288) {
			//throw new OverMemorySizeException(TEXT_START);
		}
		return Integer.toHexString(TEXT_START + (index * 4));
	}

}
