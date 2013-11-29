package ca.qc.lpl.util;

//import java.util.ArrayList;

public interface SubjectObserver {
//public abstract class SubjectObserver {

	public void addObserver(Observer o);
	
	public void removeObserver(Observer o);
	
	public void notifyObserver();
	
//	private ArrayList<Observer> lstObserver = new ArrayList<Observer>();
//
//	public void addObserver(Observer o) {
//		this.lstObserver.add(o);
//	}
//	
//	public void removeObserver(Observer o) {
//		this.lstObserver.remove(o);
//	}
//	
//	public void notifyObserver() {
//		for( Observer o : this.lstObserver ) {
//			o.update(this);
//		}
//	}
}
