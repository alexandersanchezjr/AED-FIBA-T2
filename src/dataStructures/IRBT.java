package dataStructures;

public interface IRBT<K extends Comparable<K>>extends IBST<K>{

	public NodeRBT<K> rotateRight(NodeRBT<K> node);
	public NodeRBT<K> rotateLeft(NodeRBT<K> node);
	public boolean insertNode(K k);
	public void insertF(NodeRBT<K> node);
}
