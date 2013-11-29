package ca.qc.lpl.emumips.register;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.qc.lpl.emumips.*;
import ca.qc.lpl.util.Observer;

public class TestObserver {

	@Test
	public void test() {
		Observer ob = new DummyObserver();
		Register reg = new Reg$at();
		reg.addObserver(ob);
		
		reg.notifyObserver();
		reg.setValue(31);
		reg.notifyObserver();
		reg.removeObserver(ob);
		
		

	}

}

class DummyObserver extends Observer {
	
	@Override
	public void update(Object o) {
		System.out.println(((Register)o).getBinaryValue());		
	}
}