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
		//System.out.printf("%s\n", String.format("%32s", Integer.toBinaryString(this.value)).replace(' ', '0'));
		return String.format("%32s", Integer.toBinaryString(this.value)).replace(' ', '0');
		//return String.format("%032d", Long.parseLong(Integer.toBinaryString(this.value), 2));
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

	@Override
	public void addObserver(Observer o) {
		this.lstObserver.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		this.lstObserver.remove(0);
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
