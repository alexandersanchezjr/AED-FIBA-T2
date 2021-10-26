package dataStructures;


public interface IAVL<K extends Comparable<K>> extends IBST<K>   {
	public NodeAVL<K> rotateL(NodeAVL<K> node);
	public NodeAVL<K> rotateR(NodeAVL<K> node);
	public NodeAVL<K> balance (NodeAVL<K>node);
	public Node<K> insert(K key);
}
