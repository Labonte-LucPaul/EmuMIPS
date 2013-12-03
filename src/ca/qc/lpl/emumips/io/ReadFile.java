package ca.qc.lpl.emumips.io;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFile {

	private String path = "";
	
	public ReadFile(String path) {
		this.path = path;
	}
	
	public String readFile() {
		
		StringBuilder content = new StringBuilder();
		
		try {
			BufferedReader read = new BufferedReader(new FileReader(this.path));
		
			String tmp = "";
			while( (tmp = read.readLine()) != null ) {
				content.append(tmp + "\n");
			}
			
		} catch( Exception e ) {
			System.out.println(e.getMessage());
		}
		
		return content.toString();
	}
}
