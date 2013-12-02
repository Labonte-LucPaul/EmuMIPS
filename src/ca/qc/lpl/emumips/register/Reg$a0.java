package ca.qc.lpl.emumips.register;

import java.util.ArrayList;

import ca.qc.lpl.util.Observer;

public class Reg$a0 implements Register {

	private ArrayList<Observer> lstObserver = new ArrayList<Observer>();
	private int value = 0;

	@Override
	public void notifyObserver() {
		for(Observer o : this.lstObserver) {
			o.update(this);
		}
	}

	@Override
	public String getRegisterName() {
		return "$a0";
	}

	@Override
	public int getRegisterNumber() {
		return 4;
	}

	@Override
	public String getRegisterUse() {
		return "Argument";
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

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getBinary() {
		return String.format("%05d", Integer.parseInt(Integer.toBinaryString(this.getRegisterNumber())));
	}

	@Override
	public String getHex() {
		return String.format( "%02X", this.getRegisterNumber() );
	}
	
}
