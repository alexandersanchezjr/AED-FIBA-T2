package dataStructures;

public class Node<V>  {
    private V value;
    private Node<V> father;
    private Node<V> left;
    private Node<V> right;



    public Node(V value) {
        this.value = value;
        this.father = null;
        this.left = null;
        this.right = null;
    }


    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
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

}
