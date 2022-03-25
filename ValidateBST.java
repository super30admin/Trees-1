/**
 * Time complexity is O(n)
 * 
 * space complexity is O(1) - no additional space allocated - O(h) - stack size
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    private boolean isValid(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }
        
        return (min == null || min < root.val) 
            && (max == null || root.val < max) 
            && isValid(root.left, min, root.val) 
            && isValid(root.right, root.val, max);
    }
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
}