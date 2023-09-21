//TC = O(n)
//SC = O(n)
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
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if(root == null) {
            return true;
        }
        return validateBST(root, null, null);
    }
        private boolean validateBST(TreeNode root, Integer min, Integer max) {
            //base
            if(root == null) {
                return true;
            }
            boolean case1 = validateBST(root.left, min, root.val);
            boolean case2 = validateBST(root.right, root.val, max);
            if((min!=null && root.val <= min)|| (max!= null && root.val >=max) ) {
                return false;
        }
        
    return case1 && case2;
}
}