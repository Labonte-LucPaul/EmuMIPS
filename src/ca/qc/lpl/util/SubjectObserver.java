package ca.qc.lpl.util;

public interface SubjectObserver {

	public void addObserver(Observer o);
	
	public void removeObserver(Observer o);
	
	public void notifyObserver();
	
}
