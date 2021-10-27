package dataStructures;

public interface IBST<V> {

    public int getWeight();

    public void setWeight(int weight);

    public Node<V> getRoot();

    public void setRoot(Node<V> root);

    public Node<V> insert(V value);

    public V search(V value);

    public Node<V> succesor(Node<V> x);

    public Node<V> delete(V value);

}
