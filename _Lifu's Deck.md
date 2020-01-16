// Sort Character by Frequency:
// For Loop to add Entries from HashMap
for (Map.Entry<Character,Integer> entry: map.entrySet()){
    if(newMap.containsKey(entry.getValue())){
        newMap.get(entry.getValue()).add(entry.getKey());
    }
    else {
        List<Character> l = new ArrayList<>();
        l.add(entry.getKey());
        newMap.put(entry.getValue(),l);
    }
}

// binary search if condition selection
while (lo < hi) { 
    if (nums[mid] < target){
        lo = mid + 1;
    } else {
        hi = mid;
    } 
return lo;

// How many "1" are there in the bitwise-number
for (int i : n) {
    xor ^= i;
}
while (xor != 0) {
    xor &= (xor - 1);
}

// Implement maxHeap using PriorityQueue
PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

PriorityQueue<Integer> pq = new PriorityQueue<Integer> (
    defaultSize, new Comparator<Integer> () {
        public int compare(Integer a, Integer b) {
            return b - a; 
        } 
    }
);

// Delete Node in BST
// class Solution {
//     public TreeNode deleteNode(TreeNode root, int key) {
        
//     }
// }
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val){
            root.left = deleteNode(root.left, key);
        } else if (key > root.val){
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.val = minVal(root.right);
            root.right = deleteNode(root.right, minVal(root.right));
        }
        return root;
    }
    public int minVal(TreeNode root){
        if (root.left == null) return root.val;
        return minVal(root.left);
    }
}

// Recover Binary Search Tree
// class Solution {
//     public void recoverTree(TreeNode root) {

//     }
// }
class Solution {
    public void recoverTree(TreeNode root) {
        recover(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode recover(TreeNode root, int from, int to){
        if (root == null) return root;
        int val = root.val;
        if (val < from || val > to) return root;
        TreeNode left = recover(root.left, from, val-1);
        if (left != null) {
            if (left.val < from || left.val > to){
                return left;
            } else {
                root.val = left.val;
                left.val = val;
                return recover(root, from, to);
            }
        }
        val = root.val;
        TreeNode right = recover(root.right, val+1, to);
        if (right != null){
            if (right.val < from || right.val > to){
                return right;
            } else {
                root.val = right.val;
                right.val = val;
                return recover(root, from, to);
            }
        }
        return null;
    }
}


