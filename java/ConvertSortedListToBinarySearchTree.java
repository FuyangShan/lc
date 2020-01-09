//recursion, find Mid : O(NlogN), O(logN)
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        if (head == mid) return root;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        
        return root;
        
    }
    private ListNode findMid(ListNode head) {
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) prev.next = null;
        
        return slow;
    }
}

//Recursion, Inorder simulation, O(N), O(logN)
class Solution {
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int size = size(this.head);
        return convertListToBST(0, size - 1);
        
    }
    private TreeNode convertListToBST(int lo, int hi) {
        //base case
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        
        TreeNode left = convertListToBST(lo, mid - 1);
        TreeNode root = new TreeNode(this.head.val);
        
        root.left = left;
        this.head = this.head.next;
        
        root.right = convertListToBST(mid + 1, hi);
        
        return root;
    }
    private int size(ListNode head) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        return size;
    }
}