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

		sp.setValue( sp.getValue() - 4 );
		stack.push(expected, 4);
		System.out.println(stack.getMemoryDump());
		String result = stack.popWord(4);

		assertEquals(expected, result);

		System.out.println(stack.getMemoryDump());

	}

}
