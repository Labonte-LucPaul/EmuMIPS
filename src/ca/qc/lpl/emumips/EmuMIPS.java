/**
 * @date 28/11/2013
 * @author Luc Paul Labont�
 */

package ca.qc.lpl.emumips;

import java.util.HashMap;

import ca.qc.lpl.emumips.interpreter.Interpreter;
import ca.qc.lpl.emumips.io.ReadFile;
import ca.qc.lpl.emumips.io.WriteFile;
import ca.qc.lpl.emumips.register.*;
import ca.qc.lpl.emumips.ui.MainWindow;

public class EmuMIPS {


	public static HashMap<String, Register> registers = new HashMap<String, Register>();
	private HashMap<String, Register> registersBin = new HashMap<String, Register>();
	private String sourceContent = "";

//	private String[] memory = new String[2147483645];
	
	public static void main(String[] args) {
		
		Arguments.progArguments(args);
		MainWindow mw;
		EmuMIPS self = new EmuMIPS();
		self.initRegisters();
		

//		try {
//			Add add = new Add();
//			add.setRegFormat(self.registers.get("$t0").getBinary(), self.registers.get("$a0").getBinary(), self.registers.get("$a1").getBinary(), 0);
//			System.out.println( add.getStructInstructions().binary );
//			System.out.println( "0x" + add.getStructInstructions().hex );
//			System.out.println(add.getBinTrimmed() );
//		} catch( Exception e) {
//			System.out.println(e.getMessage());
//		}

		if( Arguments.printVersion ) {
			Version.getInstance().printFullInfos();
			System.exit(0);
		}
		
		if( Arguments.windowMode ) {
			mw = new MainWindow();
		} else {
			ReadFile rf = new ReadFile(Arguments.sourcePath);
			self.sourceContent = rf.readFile();
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
			WriteFile wf = new WriteFile(Arguments.sourcePath, true);
			wf.writeFile(getRegistersValues());
			System.out.printf("Saved registers do path: '%s'\n", wf.getPath());
		} catch( Exception e ) {
			System.out.printf(e.getMessage());
		}
	}

	private String getRegistersValues() {
		StringBuilder reg = new StringBuilder();
		reg.append( String.format("%s   %s      %s             %s\n", "REGISTER", "DECIMAL", "HEXADECIMAL", "BINARY") );
		for( String key : registers.keySet() ) {
			reg.append( String.format("%-6s->   % 10d   0x%s   %s\r",  
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
