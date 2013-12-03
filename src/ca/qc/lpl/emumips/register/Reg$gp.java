package ca.qc.lpl.emumips.register;

import java.util.ArrayList;

import ca.qc.lpl.util.Observer;

public class Reg$gp implements Register {

	private ArrayList<Observer> lstObserver = new ArrayList<Observer>();
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
		return "$gp";
	}

	@Override
	public int getRegisterNumber() {
		return 28;
	}

	@Override
	public String getRegisterUse() {
		return "Global Pointer.";
	}

	@Override
	public boolean isPreservedAcrossCall() {
		return true;
	}

	@Override
	public String getBinaryValue() {
		return String.format("%32s", Integer.toBinaryString(this.value)).replace(' ', '0');
	}

	@Override
	public String getHexValue() {
		return String.format("%08X", this.value);
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
