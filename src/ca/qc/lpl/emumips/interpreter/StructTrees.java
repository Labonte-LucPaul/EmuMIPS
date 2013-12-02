package ca.qc.lpl.emumips.interpreter;

import language_emuMips.Node;

public class StructTrees {

	private Node tree;
	private int index;
	
	public StructTrees(Node tree, int index) {
		this.tree = tree;
		this.index = index;
	}
	
	public Node getTree() {
		return this.tree;
	}
	
	public int getIndex() {
		return this.index;
	}
}
