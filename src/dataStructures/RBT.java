package dataStructures;

import java.util.Comparator;

public class RBT<K extends Comparable<K>> extends BST<K> implements IRBT<K>{

	private NodeRBT<K> nullNode;
	
	public RBT(Comparator<K> comparator) {
		super(comparator);
		nullNode = new NodeRBT<K>(null);
		nullNode.setC(0);
		
	}
	public NodeRBT<K> rotateRight(NodeRBT<K> node) {
		if(node.getLeft() == null) {
			return node;
		} else {
			NodeRBT<K> left = (NodeRBT<K>)node.getLeft();
			NodeRBT<K> parent = (NodeRBT<K>)node.getFather();
			if(node != getRoot()) {
				if(parent.getLeft() == node) {
					parent.setLeft(left);
				} else {
					parent.setRight(left);
				}	
			} else {
				setRoot(left);
			}			
			node.setFather(left);
			node.setLeft(left.getRight());
			if(left.getRight() != null) {
				left.getRight().setFather(node);
			}
			left.setFather(parent);
			left.setRight(node);
			node.modifiedNode();
			left.modifiedNode();
			if(parent != null) {
				parent.modifiedNode();
			}
			return left;
		}	
	}
	public NodeRBT<K> rotateLeft(NodeRBT<K> node) {
		if(node.getRight() == null) {
			return node;
		} else {
			NodeRBT<K> right = (NodeRBT<K>)node.getRight();
			NodeRBT<K> parent = (NodeRBT<K>)node.getFather();
			if(node != getRoot()) {
				if(parent.getRight() == node) {
					parent.setRight(right);
				} else {
					parent.setLeft(right);
				}	
			} else {
				setRoot(right);
			}			
			node.setFather(right);
			node.setRight(right.getLeft());
			if(right.getLeft() != null) {
				right.getLeft().setFather(node);
			}
			right.setFather(parent);
			right.setLeft(node);
			node.modifiedNode();
			right.modifiedNode();
			if(parent != null) {
				parent.modifiedNode();
			}
			return right;
		}	
	}
	public boolean insertNode(K k) {
		boolean add=false;
		NodeRBT<K> newNode = new NodeRBT<K>(k);
		insert(newNode);
		newNode.setLeft(nullNode);
		newNode.setRight(nullNode);
		if(newNode==getRoot() || newNode.getFather()==null) {	
			add=true;
		} else {
			insertF(newNode);					
			add=true;
		}
		return add;
	}
	public void insertF(NodeRBT<K> node){
		while(((NodeRBT<K>)node.getFather()).getC() == 1) {
			NodeRBT<K> uncle;
			if(node.getFather() == node.getFather().getFather().getLeft()) {
				uncle = (NodeRBT<K>)node.getFather().getFather().getRight();
				if(uncle.getC() ==1) {
					((NodeRBT<K>) node.getFather()).setC(0);
					uncle.setC(0);
					((NodeRBT<K>) node.getFather().getFather()).setC(1);
					node = (NodeRBT<K>) node.getFather().getFather();

				} else { 
					if(node== node.getFather().getRight()) {
						node= (NodeRBT<K>) node.getFather();
						rotateLeft(node);
					}
					((NodeRBT<K>) node.getFather()).setC(0);
					((NodeRBT<K>) node.getFather().getFather()).setC(1);
					rotateRight((NodeRBT<K>) node.getFather().getFather());
				}
			} else {
				uncle = (NodeRBT<K>)node.getFather().getFather().getLeft();
				if(uncle.getC() ==1) {
					((NodeRBT<K>) node.getFather()).setC(0);
					uncle.setC(0);
					((NodeRBT<K>) node.getFather().getFather()).setC(1);
					node= (NodeRBT<K>) node.getFather().getFather();
				} else { 
					if(node == node.getFather().getLeft()) {
						node= (NodeRBT<K>) node.getFather();
						rotateRight(node);
					}
					((NodeRBT<K>) node.getFather()).setC(0);
					((NodeRBT<K>) node.getFather().getFather()).setC(1);
					rotateLeft((NodeRBT<K>) node.getFather().getFather());
				}
			}
		}
		((NodeRBT<K>)getRoot()).setC(0);
	}
}
