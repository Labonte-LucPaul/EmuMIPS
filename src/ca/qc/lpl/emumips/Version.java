package ca.qc.lpl.emumips;

public class Version {

	private static Version v = new Version();
	
	private String version = "0.0.1";
	
	private Version() {
	
	}
	
	public static Version getInstance() {
		return v;
	}
	
	public static String getVersion() {
		return Version.getInstance().version;
	}
}
