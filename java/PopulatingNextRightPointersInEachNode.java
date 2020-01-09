class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node curr;
        while (!q.isEmpty()) {
            int size = q.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                curr = q.poll();
                if (prev != null) prev.next = curr;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                prev = curr;
            }
            prev.next = null;
        }
        return root;
    }
}