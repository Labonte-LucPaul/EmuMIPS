package ca.qc.lpl.emumips.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteFile {

	private boolean rename = false;
	private String path = "";

	public WriteFile(String path, boolean rename) {
		this.rename = rename;
		this.path = path;
		
		renameFile();
	}
	
	
	private void renameFile() {
		
		if( rename ) {
			String[] tmp = path.split("\\.");
			StringBuilder sb = new StringBuilder();
			for( int i = 0; i < tmp.length - 1; ++i ) {
				sb.append(tmp[i]);
			}
			sb.append(".registers_dump.txt");
			this.path = sb.toString();
		}
	}
	
	public void writeFile(String content) {
		
		try {
		File file = new File(path);
		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
	
		} catch( Exception e ) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getPath() {
		return this.path;
	}
}
