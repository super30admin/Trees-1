
// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max)
    {
        if(null == root) return true;
        if((null != max && root.val >= max) || (null != min && root.val <= min))
        {
            return false;
        }
        boolean leftvalid = helper(root.left, min, root.val);
        boolean rightvalid = helper(root.right, root.val, max);
        return leftvalid && rightvalid;
    }
}