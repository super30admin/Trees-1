//Time: O(n)
//Space: O(1)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class validBST {
    public boolean isValidBST(TreeNode root) {
               
        return helper(root, null, null);
    }
    public boolean helper(TreeNode root, Integer min, Integer max) {
        //null case
        if(root == null) {
            return true;
        }
        
        if(min!=null && root.val <= min) return false;
        if(max!=null && root.val >= max) return false;
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
