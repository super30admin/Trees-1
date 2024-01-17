// Time Complexity : O(N)
// Space Complexity : O(H), where H is the height of the binary tree
// Did this code successfully run on Leetcode : yes

// It uses a recursive approach to validate each node in the tree against a range defined by low and high
public class problem1 {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    public boolean validate(TreeNode node, Integer low, Integer high) {
        if(node == null) return true;

        if((low != null && node.val <= low) || (high != null && node.val >= high)) return false;

        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
