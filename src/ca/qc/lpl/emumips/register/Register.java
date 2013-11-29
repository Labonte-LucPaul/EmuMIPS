package ca.qc.lpl.emumips.register;

import ca.qc.lpl.util.SubjectObserver;

public interface Register extends SubjectObserver {

	public String getRegisterName();
	
	public int getRegisterNumber();
	
	public String getRegisterUse();
	
	public boolean isPreservedAcrossCall();

	public String getBinaryValue();
	
	public String getHexValue();
	
	public int getValue();
	
	public void setValue( int value );

}
