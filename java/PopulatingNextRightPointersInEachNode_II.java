class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Node origin = root;
        Node dummy = new Node(0, null, null, null);
        Node prev = dummy;
        while (root != null) {
            if (root.left != null) {
                prev.next = root.left;
                prev = prev.next;
            }
            if (root.right != null) {
                prev.next = root.right;
                prev = prev.next;
            }
            root = root.next;
            if (root == null) {
                prev = dummy;
                root = dummy.next;
                dummy.next = null;
            }
        }
        return origin;
    }
}