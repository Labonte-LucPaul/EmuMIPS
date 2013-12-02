package ca.qc.lpl.emumips.register;

import java.util.ArrayList;

import ca.qc.lpl.util.Observer;

public class Reg$s7 implements Register {

	private ArrayList<Observer> lstObservers = new ArrayList<Observer>();
	private int value = 0;

	@Override
	public String getBinary() {
		return String.format("%05d", Integer.parseInt(Integer.toBinaryString(this.getRegisterNumber())));
	}

	@Override
	public String getHex() {
		return String.format( "%02X", this.getRegisterNumber() );
	}
	
	@Override
	public void addObserver(Observer o) {
		this.lstObservers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		this.lstObservers.remove(o);
	}

	@Override
	public void notifyObserver() {
		for(Observer o : this.lstObservers) {
			o.update(this);
		}
	}

	@Override
	public String getRegisterName() {
		return "$s7";
	}

	@Override
	public int getRegisterNumber() {
		return 23;
	}

	@Override
	public String getRegisterUse() {
		
		return "Saved Temporary";
	}

	@Override
	public boolean isPreservedAcrossCall() {
		
		return true;
	}

	@Override
	public String getBinaryValue() {
		return null;
	}

	@Override
	public String getHexValue() {
		return null;
	}

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public void setValue(int value) {
		this.value = value;
	}


}
