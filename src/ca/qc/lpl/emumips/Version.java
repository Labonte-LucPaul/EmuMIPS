package ca.qc.lpl.emumips;

public class Version {

	private static Version v = new Version();
	
	private String version = "0.0.1";
	private String codeName = "ATLANTIS";
	private String description = "A simple emulator for MIPS.";
	private String author = "Luc Paul Labonté";
	
	private Version() {
	
	}
	
	public static Version getInstance() {
		return v;
	}
	
	public static String getVersion() {
		return Version.getInstance().version;
	}

	public void printFullInfos() {
		System.out.printf("EmuMIPS: %s : %s - %s\nBy: %s\n", version, codeName, description, author);
	}
}
