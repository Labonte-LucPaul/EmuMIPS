/**
 * @date 28/11/2013
 * @author Luc Paul Labont�
 */

package ca.qc.lpl.emumips;

import java.util.HashMap;

import ca.qc.lpl.emumips.interpreter.Interpreter;
import ca.qc.lpl.emumips.register.*;
import ca.qc.lpl.emumips.ui.MainWindow;

public class EmuMIPS {


	private HashMap<String, Register> registers = new HashMap<String, Register>();

	public static void main(String[] args) {
		
		Arguments.progArguments(args);
		MainWindow mw;
		EmuMIPS self = new EmuMIPS();
		
		self.initRegisters();
		
		if( Arguments.printVersion ) {
			System.out.printf("Emu MIPS v.: %s - A simple MIPS emulator!", Version.getVersion());
			System.exit(0);
		}
		
		if( Arguments.windowMode ) {
			mw = new MainWindow();
		} else {
			self.startInterpreter();
		}
//		
//		for(String key : self.registers.keySet()) {
//			System.out.print("'"+self.registers.get(key).getRegisterName() + "' | ");
//		}
	}
	
	private void startInterpreter() {
		
		try {
			Interpreter i = new Interpreter(this.registers);
		} catch( Exception e ) {
			System.out.printf(e.getMessage());
		}
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
	}
}
