package dataStructures;

public class BST<V extends Comparable<V>> implements IBST<V> {

    private int weight;
    private Node<V> root;

    public BST() {
        this.weight = 0;
        this.root = null;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node<V> getRoot() {
        return this.root;
    }

    public void setRoot(Node<V> root) {
        this.root = root;
    }

    public Node<V> insert(V value) {
        Node<V> node = new Node<V>(value);
        if (root != null) {
            insert(root, node);
        } else {
            root = node;
        }
        weight++;
        return node;
    }

    public Node<V> insert(Node<V> node) {
        if (root != null) {
            insert(root, node);
        } else {
            root = node;
        }
        weight++;
        return node;
    }

    private void insert(Node<V> current, Node<V> node) {
        if (current != null) {
            if (node.getValue().compareTo(current.getValue()) < 0) {
                Node<V> left = current.getLeft();
                if (left != null) {
                    insert(left, node);
                } else {
                    current.setLeft(node);
                    node.setFather(current);
                }
            } else if (node.getValue().compareTo(current.getValue()) >= 0) {
                Node<V> right = current.getRight();
                if (right != null) {
                    insert(right, node);
                } else {
                    current.setRight(node);
                    node.setFather(current);
                }
            }
        }
    }

    public V search(V value) {
        return search(root, value).getValue();
    }

    private Node<V> search(Node<V> current, V value) {
        if (current == null || (current.getValue().compareTo(value)) == 0) {
            return current;
        } else if (value.compareTo(current.getValue()) < 0) {
            // System.out.println(current);
            return search(current.getLeft(), value);
        } else {
            return search(current.getRight(), value);
        }
    }

    public Node<V> succesor(Node<V> x) {
        if (x.getRight() != null) {
            return minimum(x.getRight());
        }
        Node<V> y = x.getFather();
        while (y != null && x == y.getRight()) {
            x = y;
            y = y.getFather();
        }
        return y;
    }

    private Node<V> minimum(Node<V> x) {

        while (x.getLeft() != null) {
            x = x.getLeft();
        }
        return x;
    }

    public Node<V> delete(V value) {
        Node<V> z = search(root, value);
        Node<V> x;
        Node<V> y;

        // If it is leaf
        if (z.getLeft() == null || z.getRight() == null) {
            y = z;
        } else {
            y = succesor(z);
        }

        // if it hava left
        if (z.getLeft() != null) {
            x = z.getLeft();
        } else {
            x = y.getRight();
        }

        // if it hava right
        if (z.getRight() != null) {
            x.setFather(y.getFather());
        }

        if (y.getFather() == null) {
            root = x;
        } else if (y == y.getFather().getLeft()) {
            y.getFather().setLeft(x);
        } else {
            y.getFather().setLeft(x);
        }

        if (y != z) {
            z.setValue(y.getValue());
        }

        return y;
    }

}
