package dataStructures;

public class NodeRBT<K> extends Node<K> {

	public final static int RED=1;
	public final static int BLACK=0;
	
	public int c;
	
	public NodeRBT(K k) {
		super(k);
		c=1;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}


}
