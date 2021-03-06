package ca.qc.lpl.emumips.register;

import java.util.ArrayList;

import ca.qc.lpl.util.Observer;
import ca.qc.lpl.util.SubjectObserver;

public class Reg$zero implements Register {
	
	private final int value = 0;
	private final int number = 0;
	private ArrayList<Observer> lstObservers = new ArrayList<Observer>();
	
	public Reg$zero() {
	}

	@Override
	public String getBinary() {
		return String.format("%05d", Integer.parseInt(Integer.toBinaryString(this.getRegisterNumber())));
	}

	@Override
	public String getHex() {
		return String.format( "%02X", this.getRegisterNumber() );
	}
	
	@Override
	public String getRegisterName() {
		return "$zero";
	}

	@Override
	public int getRegisterNumber() {
		return this.number;
	}

	@Override
	public String getRegisterUse() {
		return "The constant value 0.";
	}

	@Override
	public boolean isPreservedAcrossCall() {
		return false;
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
		// $zero is a const
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

}
