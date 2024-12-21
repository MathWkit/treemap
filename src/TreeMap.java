import com.sun.source.tree.Tree;

public class TreeMap<K extends Comparable<K>, V> {
    static final boolean RED = true;
    static final boolean BLACK = false;

    public class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> parent, left, right;
        public boolean color;

        Node(K key, V value, boolean color, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.parent = parent;
        }
    }

    Node root;
    private int size;

    public TreeMap() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getHeight(Node<K, V> node) {
        return (node == null) ? -1 : Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public int getHeight() {
        return getHeight(root);
    }

    public Node<K, V> getRoot() {
        return root;
    }

    public Node<K, V> getNode(K key) {
        Node<K, V> current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public V getValue(K key) {
        Node<K, V> node = getNode(key);
        return node == null ? null : node.value;
    }

    public void add(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value, true, null);
            ++size;
            return;
        }

        Node<K, V> current = root;
        Node<K, V> parent = null;

        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                current.value = value;
                return;
            }
        }

        Node<K, V> newNode = new Node<>(key, value, true, parent);

        if (key.compareTo(parent.key) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        ++size;

        //fixAfterAdd();
    }

    // вспомогательные методы:
    private boolean colorOf(Node node) {
        return node == null ? BLACK : node.color;
    }

    private boolean isRed(Node node) {
        return colorOf(node) == RED;
    }

    private boolean isBlack(Node node) {
        return colorOf(node) == BLACK;
    }

    private void setColor(Node node, boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    private Node parentOf(Node node) {
        return node == null ? null : node.parent;
    }

    private Node leftOf(Node node) {
        return node == null ? null : node.left;
    }

    private Node rightOf(Node node) {
        return node == null ? null : node.right;
    }
}
