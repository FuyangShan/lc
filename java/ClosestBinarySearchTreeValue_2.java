/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> list = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return Math.abs(a - target) > Math.abs(b - target)? 1: -1;
            }
        });
        closestKValues(root, target, k, list);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++){
            res.add(list.poll());
        }
        // Collections.reverse(res);
        return res;
    }
    public void closestKValues(TreeNode root, double target, int k, PriorityQueue<Integer> list){
        if (root == null) return;
        list.add(root.val);
        closestKValues(root.left, target, k, list);
        closestKValues(root.right, target, k, list);
        // if (list.size() > k) list.poll();
    }
}