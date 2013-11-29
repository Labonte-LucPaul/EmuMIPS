/**
 * @date 28/11/2013
 * @author Luc Paul Labonté
 */

package ca.qc.lpl.emumips;

import ca.qc.lpl.emumips.ui.MainWindow;

public class EmuMIPS {



	public static void main(String[] args) {
		
		Arguments.progArguments(args);
		MainWindow mw;
		
		if( Arguments.printVersion ) {
			System.out.printf("Emu MIPS v.: %s - A simple MIPS emulator!", Version.getVersion());
			System.exit(0);
		}
		
		if( Arguments.windowMode ) {
			mw = new MainWindow();
		}
	}
}
