package ca.qc.lpl.emumips.memory;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBuildMemoryData {

	@Test
	public void test() {
		BuildMemoryData data = new BuildMemoryData();
		
		System.out.println("0x"+ data.addWord("Ceci est un test"));
		
		System.out.println(data.getWord("10008000"));
		System.out.println("0x"+ data.addString("Ceci est une \"string\" 'insérée'!"));
		System.out.println("0x"+ data.addHalfWord("Un autre test"));
		System.out.println(data.getWord("10008010"));
		System.out.println(data.getWord("10008010"));
		System.out.println(data.getDoubleWord("10008000"));
		System.out.println(data.getWord("10008015"));
		
		System.out.println(data.getString("10008010"));
		System.out.println("Memory dump:");
		System.out.println(data.getMemoryDump());
	}

}
