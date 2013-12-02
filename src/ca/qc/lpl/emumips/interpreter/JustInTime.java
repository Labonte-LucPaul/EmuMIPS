package ca.qc.lpl.emumips.interpreter;

import java.io.StringReader;
import java.util.ArrayList;

import language_emuMips.Node;
import language_emuMips.Parser;

public class JustInTime {

	private ArrayList<Node> preCompiled = new ArrayList<Node>();
	
	public JustInTime(ArrayList<StringBuilder> instructions) {
		
		Parser p;

		try {
			for(StringBuilder lst : instructions) {
				if( lst.length() > 0 ) {
					p = new Parser( new StringReader(lst.toString()) );
					this.preCompiled.add(p.parse());
				} else {
					this.preCompiled.add(null);
				}
			}
		} catch( Exception e ) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Node> getPreCompiled() {
		return this.preCompiled;
	}
}
