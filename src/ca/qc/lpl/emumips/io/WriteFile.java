package ca.qc.lpl.emumips.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import ca.qc.lpl.util.FileType;

public class WriteFile {

	private boolean rename = false;
	private String path = "";
	private String newPath = "";
	private FileType fType;

	public WriteFile(String path, boolean rename, FileType type) {
		this.rename = rename;
		this.path = path;
		this.fType = type;
		renameFile();
	}

	public void setFileType( FileType ft ) {
		this.fType = ft;
		renameFile();
	}

	private void renameFile() {

		if( rename ) {
			String[] tmp = path.split("\\.");
			StringBuilder sb = new StringBuilder();
			for( int i = 0; i < tmp.length - 1; ++i ) {
				sb.append(tmp[i]);
			}

			switch( this.fType ) {
				case REGISTERS:
					sb.append(".registers_dump.txt");
				break;

				case MEMORY_DATA:
					sb.append(".memory_data_dump.txt");
				break;

				case MEMORY_DATA_BIN:
					sb.append(".memory_data_bin_dump.txt");
				break;

				default:
					sb.append(".txt");
			}

			this.newPath = sb.toString();
		}
	}

	public void writeFile(String content) {

		try {
		File file = new File(newPath);

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

		} catch( Exception e ) {
			System.out.println(e.getMessage());
		}
	}

	public String getNewPath() {
		return this.newPath;
	}
}
