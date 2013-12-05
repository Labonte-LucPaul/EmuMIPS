package ca.qc.lpl.emumips.memory;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBuildMemoryText {
	
	
	@Test
	public void test() {
		BuildMemoryText text = new BuildMemoryText(null);

		try {
			System.out.println("0x"+text.index2Address(0));
			System.out.println("0x"+text.index2Address(1));
			System.out.println("0x"+text.index2Address(2));
			System.out.println("0x"+text.index2Address(3));
			System.out.println("0x"+text.index2Address(4));
			
			System.out.println("0x"+text.index2Address(10));
			System.out.println("0x"+text.index2Address(12));
			System.out.println("0x"+text.index2Address(15));
			System.out.println("0x"+text.index2Address(20));
			
			System.out.println("0x"+text.index2Address(66060289));
		} catch( Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
