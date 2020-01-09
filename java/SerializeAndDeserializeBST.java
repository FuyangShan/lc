public class Codec {

    // Encodes integer to bytes string
    public String intToString(int x) {
        char[] bytes = new char[4];
        for (int i = 3; i > -1; --i) {
            bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
        }
        return new String(bytes);
    }
    
    // Decodes bytes string to integer
    public int stringToInt(String bytesStr) {
        int result = 0;
        for (char b : bytesStr.toCharArray()) {
            result = (result << 8) + (int) b;
        }
        return result;
    }
    
    // Encodes a tree to a list.
    public void postorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        postorder(root.left, sb);
        postorder(root.right, sb);
        sb.append(intToString(root.val));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postorder(root, sb);
        return sb.toString();
    }

    // Decodes list to tree.
    public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
        if (nums.isEmpty()) return null;
        
        int root_val = nums.getLast();
        if (root_val < lower || root_val > upper) return null;
        nums.removeLast();
        
        TreeNode root = new TreeNode(root_val);
        root.right = helper(root_val, upper, nums);
        root.left = helper(lower, root_val, nums);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (int i = 0; i < data.length();) {
            nums.add(stringToInt(data.substring(i, i + 4)));
            i += 4;
        }
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }
}






