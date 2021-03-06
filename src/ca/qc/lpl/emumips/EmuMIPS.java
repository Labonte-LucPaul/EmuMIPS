/**
 * @date 28/11/2013
 * @author Luc Paul Labont�
 */

package ca.qc.lpl.emumips;

import java.util.ArrayList;
import java.util.HashMap;

import ca.qc.lpl.emumips.interpreter.Interpreter;
import ca.qc.lpl.emumips.io.ReadFile;
import ca.qc.lpl.emumips.io.WriteFile;
import ca.qc.lpl.emumips.memory.BuildMemoryData;
import ca.qc.lpl.emumips.memory.BuildMemoryStack;
import ca.qc.lpl.emumips.register.Reg$a0;
import ca.qc.lpl.emumips.register.Reg$a1;
import ca.qc.lpl.emumips.register.Reg$a2;
import ca.qc.lpl.emumips.register.Reg$a3;
import ca.qc.lpl.emumips.register.Reg$at;
import ca.qc.lpl.emumips.register.Reg$fp;
import ca.qc.lpl.emumips.register.Reg$gp;
import ca.qc.lpl.emumips.register.Reg$k0;
import ca.qc.lpl.emumips.register.Reg$k1;
import ca.qc.lpl.emumips.register.Reg$ra;
import ca.qc.lpl.emumips.register.Reg$s0;
import ca.qc.lpl.emumips.register.Reg$s1;
import ca.qc.lpl.emumips.register.Reg$s2;
import ca.qc.lpl.emumips.register.Reg$s3;
import ca.qc.lpl.emumips.register.Reg$s4;
import ca.qc.lpl.emumips.register.Reg$s5;
import ca.qc.lpl.emumips.register.Reg$s6;
import ca.qc.lpl.emumips.register.Reg$s7;
import ca.qc.lpl.emumips.register.Reg$sp;
import ca.qc.lpl.emumips.register.Reg$t0;
import ca.qc.lpl.emumips.register.Reg$t1;
import ca.qc.lpl.emumips.register.Reg$t2;
import ca.qc.lpl.emumips.register.Reg$t3;
import ca.qc.lpl.emumips.register.Reg$t4;
import ca.qc.lpl.emumips.register.Reg$t5;
import ca.qc.lpl.emumips.register.Reg$t6;
import ca.qc.lpl.emumips.register.Reg$t7;
import ca.qc.lpl.emumips.register.Reg$t8;
import ca.qc.lpl.emumips.register.Reg$t9;
import ca.qc.lpl.emumips.register.Reg$v0;
import ca.qc.lpl.emumips.register.Reg$v1;
import ca.qc.lpl.emumips.register.Reg$zero;
import ca.qc.lpl.emumips.register.Register;
import ca.qc.lpl.emumips.ui.MainWindow;
import ca.qc.lpl.util.FileType;

public class EmuMIPS {


	public static HashMap<String, Register> registers = new HashMap<String, Register>();
	//private HashMap<String, Register> registersBin = new HashMap<String, Register>();
	public static String sourceContent = "";
	public static HashMap<String, Integer> lblAssociation;
	public static ArrayList<StringBuilder> instructions;
	public static BuildMemoryData memoryData;
	public static BuildMemoryStack memoryStack;

	public static int instructionCounter = 0; // Count the number of instructions. Usefull for addresses.

	public static void main(String[] args) {

		Arguments.progArguments(args);
		MainWindow mw;
		EmuMIPS self = new EmuMIPS();
		self.initRegisters();

		memoryData = new BuildMemoryData();
		memoryStack = new BuildMemoryStack((Reg$sp)registers.get("$sp"));

		if( Arguments.printVersion ) {
			Version.getInstance().printFullInfos();
			System.exit(0);
		}

		if( Arguments.windowMode ) {
			mw = new MainWindow();
		} else {
			ReadFile rf = new ReadFile(Arguments.sourcePath);
			sourceContent = rf.readFile();
			self.startInterpreter();
		}
//
//		for(String key : self.registers.keySet()) {
//			System.out.print("'"+self.registers.get(key).getRegisterName() + "' | ");
//		}
	}

	private void startInterpreter() {

		try {

			Interpreter i = new Interpreter(this.sourceContent);

			WriteFile wf = new WriteFile(Arguments.sourcePath, true, FileType.REGISTERS);
			wf.writeFile(getRegistersValues());
			System.out.printf("Saved registers to path: '%s'\n", wf.getNewPath());

			wf.setFileType(FileType.MEMORY_DATA);
			wf.writeFile(memoryData.getMemoryDump());
			System.out.printf("Saved Memory DATA to path: '%s'\n", wf.getNewPath());

			wf.setFileType(FileType.MEMORY_DATA_BIN);
			wf.writeFile(memoryData.getMemoryDumpBinary());
			System.out.printf("Saved Memory DATA Binary to path: '%s'\n", wf.getNewPath());

		} catch( Exception e ) {
			System.out.printf(e.getMessage());
		}
	}

	private String getRegistersValues() {
		StringBuilder reg = new StringBuilder();
		reg.append( String.format("%s    %s      %s             %s\n", "REGISTER", "DECIMAL", "HEXADECIMAL", "BINARY") );
		for( String key : registers.keySet() ) {
			reg.append( String.format("%-6s->   % 11d   0x%s   %s\r",
					registers.get(key).getRegisterName(),
					registers.get(key).getValue(),
					registers.get(key).getHexValue(),
					registers.get(key).getBinaryValue()) );
		}

		return reg.toString();
	}
	private void initRegisters() {

		registers.put("$zero", new Reg$zero());
		registers.put("$a0", new Reg$a0());
		registers.put("$a1", new Reg$a1());
		registers.put("$a2", new Reg$a2());
		registers.put("$a3", new Reg$a3());
		registers.put("$at", new Reg$at());
		registers.put("$fp", new Reg$fp());
		registers.put("$gp", new Reg$gp());
		registers.put("$k0", new Reg$k0());
		registers.put("$k1", new Reg$k1());
		registers.put("$ra", new Reg$ra());
		registers.put("$s0", new Reg$s0());
		registers.put("$s1", new Reg$s1());
		registers.put("$s2", new Reg$s2());
		registers.put("$s3", new Reg$s3());
		registers.put("$s4", new Reg$s4());
		registers.put("$s5", new Reg$s5());
		registers.put("$s6", new Reg$s6());
		registers.put("$s7", new Reg$s7());
		registers.put("$sp", new Reg$sp());
		registers.put("$t0", new Reg$t0());
		registers.put("$t1", new Reg$t1());
		registers.put("$t2", new Reg$t2());
		registers.put("$t3", new Reg$t3());
		registers.put("$t4", new Reg$t4());
		registers.put("$t5", new Reg$t5());
		registers.put("$t6", new Reg$t6());
		registers.put("$t7", new Reg$t7());
		registers.put("$t8", new Reg$t8());
		registers.put("$t9", new Reg$t9());
		registers.put("$v0", new Reg$v0());
		registers.put("$v1", new Reg$v1());

//		for( String key : registers.keySet() ) {
//			registersBin.put(registers.get(key).getBinary(), registers.get(key));
//		}
	}
}
