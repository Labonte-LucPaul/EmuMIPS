package ca.qc.lpl.emumips.memory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.qc.lpl.emumips.register.Reg$sp;

public class TestBuildMemoryStack {

	@Test
	public void test() {
		String expected = "001E3A5F";
		Reg$sp sp = new Reg$sp();
		BuildMemoryStack stack = new BuildMemoryStack(sp);
		stack.push(expected);
		System.out.println(stack.getMemoryDump());
		String result = stack.popWord();

		assertEquals(expected, result);


	}

}
