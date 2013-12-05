package ca.qc.lpl.emumips;

public class Version {

	private static Version v = new Version();
	
	private String version = "0.0.1";
	private String codeName = "ATLANTIS";
	private String description = "A simple emulator for MIPS.";
	private String author = "Luc Paul Labonté";
	private String contact = "Contact: labonte.luc_paul@gmail.com\n"
						   + "-----------------------------------\n"
						   + "For subject field use one of the description below, copy-paste with brackets included:\n"
						   + "For questions       : [EmuMIPS question]\n"
						   + "For a bug           : [EmuMIPS bug]\n"
						   + "For features request: [EmuMIPS feature]\n"
						   + "Comments            : [EmuMIPS comments]";
	private Version() {
	
	}
	
	public static Version getInstance() {
		return v;
	}
	
	public static String getVersion() {
		return Version.getInstance().version;
	}

	public void printFullInfos() {
		System.out.printf("EmuMIPS: - %s\nVersion: %s\nCode name: %s \nBy: %s\n%s", description, version, codeName, author, contact);
	}
}
