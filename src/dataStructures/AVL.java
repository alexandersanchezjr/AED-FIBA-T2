package dataStructures;

import java.util.Comparator;

public class AVL<K> extends BST<K> implements IAVL<K>{

	public AVL(Comparator<K> comparator) {
		super(comparator);
	}

	
	public NodeAVL<K> rotateL(NodeAVL<K> node) {
		if(node.getRight()==null) {
			return node;
		} else {
			NodeAVL<K> right = (NodeAVL<K>) node.getRight();
			NodeAVL<K> father= (NodeAVL<K>) node.getFather();
			if(node != getRoot()) {
				if(father.getRight() == node) {
					father.setRight(right);
				} else {
					father.setLeft(right);
				}	
			} else {
				setRoot(right);
			}		
			node.setFather(right);
			node.setRight(right.getLeft());
			if(right.getLeft() != null) {
				right.getLeft().setFather(node);
			}		
			right.setFather(father);
			right.setLeft(node);
			node.modifiedNodeAVL();
			right.modifiedNodeAVL();
			if(father != null) {
				father.modifiedNodeAVL();
			}
			return right;
		}	

	}
	
	public NodeAVL<K> rotateR(NodeAVL<K> node) {
		if(node.getLeft() == null) {
			return node;
		} else {
			NodeAVL<K> left = (NodeAVL<K>)node.getLeft();
			NodeAVL<K> father = (NodeAVL<K>)node.getFather();
			if(node != getRoot()) {
				if(father.getLeft() == node) {
					father.setLeft(left);
				} else {
					father.setRight(left);
				}	
			} else {
				setRoot(left);
			}			
			node.setFather(left);
			node.setLeft(left.getRight());
			if(left.getRight() != null) {
				left.getRight().setFather(node);
			}
			left.setFather(father);
			left.setRight(node);
			node.modifiedNodeAVL();
			left.modifiedNodeAVL();
			if(father != null) {
				father.modifiedNodeAVL();	
			}
			return left;
		}	
	}
	
	public NodeAVL<K> balance(NodeAVL<K>node){
		int nodeBalanceF = node.getBalanceF();
		if(Math.abs(nodeBalanceF) > 1 ) {
			if(nodeBalanceF > 1 && node.getRight() != null) {
				NodeAVL<K> right =  (NodeAVL<K>) node.getRight();
				if(right.getBalanceF() < 0) {
					rotateR(right);
				}
				return rotateL(node);
			} else if(nodeBalanceF < -1 && node.getLeft() != null){
				NodeAVL<K> left =  (NodeAVL<K>) node.getLeft();
				if(left.getBalanceF() >= 0) {
					rotateL(left);
				}
				return rotateR(node);
			} else {
				return node;
			}
		} else {
			return node;
		}
	}
	
	public Node<K> insert(K key) {
		NodeAVL<K> addedNode = new NodeAVL<>(key);
		insert(addedNode);					
		if(addedNode == getRoot() || addedNode.getFather() == null) {
		} else {
			NodeAVL<K> currentNode = (NodeAVL<K>)addedNode.getFather();
			while(currentNode != null) {
				currentNode.modifiedNodeAVL();
				balance(currentNode);	
				currentNode = (NodeAVL<K>) currentNode.getFather();
			}					
		}
		return addedNode;		
	}
}
