// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ValidateBSTSolved {
    public boolean isValidBST(TreeNode root) {
        long minVal = Long.MIN_VALUE;
        long maxVal =  Long.MAX_VALUE;
        return helper(root, minVal,maxVal);
    }
    private boolean helper(TreeNode root, long minVal, long maxVal){
        if (root == null){
            return true;

        }

        if (root.val>minVal && root.val<maxVal && helper(root.left, minVal, root.val ) && helper(root.right, root.val, maxVal) ){
            return true;
        }
        else{
            return false;
        }
    }
}
