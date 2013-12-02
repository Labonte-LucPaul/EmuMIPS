package ca.qc.lpl.emumips.register;

import java.util.ArrayList;

import ca.qc.lpl.util.Observer;

public class Reg$k0 implements Register {

	private ArrayList<Observer> lstObserver = new ArrayList<Observer>();
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
		this.lstObserver.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		this.lstObserver.remove(o);
	}

	@Override
	public void notifyObserver() {
		for(Observer o : this.lstObserver) {
			o.update(this);
		}
	}

	@Override
	public String getRegisterName() {
		return "$k0";
	}

	@Override
	public int getRegisterNumber() {
		return 26;
	}

	@Override
	public String getRegisterUse() {
		return "Reserved for OS Kernel.";
	}

	@Override
	public boolean isPreservedAcrossCall() {
		return false;
	}

	@Override
	public String getBinaryValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHexValue() {
		// TODO Auto-generated method stub
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
