package dataStructures;

public class NodeAVL<K extends Comparable<K>> extends Node<K>  {

	private int balanceF;	
	public NodeAVL(K k) {
		super(k);
		balanceF = 0;	
	}
	public void modifiedNodeAVL() {	
		int leftH=0;
		int rightH=0;
		if(getLeft()!=null) {
			leftH=left.getHeight();
		}
		if(getRight()!=null) {
			rightH=getRight().getHeight();
		}
		if(leftH>rightH) {
			setHeight(leftH+1);
		}
		else {
			setHeight(rightH+1);
		}
		balanceF = rightH-leftH;	
	}
	public int getBalanceF() {
		return balanceF;
	}
	public void setBalanceF(int balanceF) {
		this.balanceF = balanceF;
	}

}
