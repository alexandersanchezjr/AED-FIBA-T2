package dataStructures;

import java.util.ArrayList;

public class Node<V> {
    private ArrayList<V> value;
    private Node<V> father;
    protected Node<V> left;
    private Node<V> right;
    private int height;
    private int h1;
    private int h2;


    public Node(V v) {
        this.value=new ArrayList<V>();
		value.add(v);
        this.father = null;
        this.left = null;
        this.right = null;
        height = 1;
    }

    

    public ArrayList<V> getValue() {
		return value;
	}
	public void setValue(ArrayList<V> value) {
		this.value = value;
	}

    public Node<V> getFather() {
        return this.father;
    }

    public void setFather(Node<V> father) {
        this.father = father;
    }

    public Node<V> getLeft() {
        return this.left;
    }

    public void setLeft(Node<V> left) {
        this.left = left;
    }

    public Node<V> getRight() {
        return this.right;
    }

    public void setRight(Node<V> right) {
        this.right = right;
    }


    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public void modifiedNode() {	
		int leftH=0;
		int rightH=0;
		if(left!=null) {
			leftH=left.height;
		}
		if(right!=null) {
			rightH=right.height;
		}
		if(leftH>rightH) {
			height=leftH+1;
		}
		else {
			height=rightH+1;
		}

	}
	public int getBFactor() {
		return h2-h1;
	}


}
