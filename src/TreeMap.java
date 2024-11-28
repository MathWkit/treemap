import com.sun.source.tree.Tree;

public class TreeMap<K, V> {
    static final boolean RED = true;
    static final boolean BLACK = false;

    public class TreeMapNode {
        public K key;
        public V value;
        public TreeMapNode parent, left, right;
        public boolean color;

        TreeMapNode(K key, V value, boolean color, TreeMapNode parent) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.parent = parent;
        }
    }

    TreeMapNode root = null;
    private int size = 0;

    public TreeMap() {

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getHeight(TreeMapNode node) {
        return (node == null) ? -1 : Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public int getHeight() {
        return getHeight(root);
    }

    // вспомогательные методы:
    private boolean colorOf(TreeMapNode node) {
        return node == null ? BLACK : node.color;
    }

    private boolean isRed(TreeMapNode node) {
        return colorOf(node) == RED;
    }

    private boolean isBlack(TreeMapNode node) {
        return colorOf(node) == BLACK;
    }

    private void setColor(TreeMapNode node, boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    private TreeMapNode parentOf(TreeMapNode node) {
        return node == null ? null : node.parent;
    }

    private TreeMapNode grandparentOf(TreeMapNode node) {
        return (node == null || node.parent == null) ? null : node.parent.parent;
    }

    private TreeMapNode leftOf(TreeMapNode node) {
        return node == null ? null : node.left;
    }

    private TreeMapNode rightOf(TreeMapNode node) {
        return node == null ? null : node.right;
    }

    private TreeMapNode siblingOf(TreeMapNode node) {
        return (node == null || node.parent == null)
                ? null
                : (node == node.parent.left)
                    ? node.parent.left : node.parent.right;
    }
}
