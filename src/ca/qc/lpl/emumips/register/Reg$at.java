package ca.qc.lpl.emumips.register;

import java.util.ArrayList;
import ca.qc.lpl.util.Observer;

public class Reg$at implements Register {

	private int regNumber = 1;
	private int value;
	private ArrayList<Observer> lstObservers = new ArrayList<Observer>();

	@Override
	public String getRegisterName() {
		return "$at";
	}

	@Override
	public int getRegisterNumber() {
		return this.regNumber;
	}

	@Override
	public String getRegisterUse() {
		return "Assembleur Temporary.";
	}

	@Override
	public boolean isPreservedAcrossCall() {
		return false;
	}

	@Override
	public String getBinaryValue() {
		return Integer.toBinaryString(this.value);
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