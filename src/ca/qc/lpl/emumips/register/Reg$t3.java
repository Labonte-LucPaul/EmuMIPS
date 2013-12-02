package ca.qc.lpl.emumips.register;

import java.util.ArrayList;

import ca.qc.lpl.util.Observer;

public class Reg$t3 implements Register {

	private ArrayList<Observer> lstObservers = new ArrayList<Observer>();
	private int value;

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
		return "$t3";
	}

	@Override
	public int getRegisterNumber() {
		return 11;
	}

	@Override
	public String getRegisterUse() {
		
		return "Temporary";
	}

	@Override
	public boolean isPreservedAcrossCall() {
		
		return false;
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
