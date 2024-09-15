// Time Complexity :O(n)
// Space Complexity :O(nlogn)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this : Failed Test Case
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        int minVal = Integer.MIN_VALUE;
        int maxVal =  Integer.MAX_VALUE;
        return helper(root, minVal,maxVal);
    }
    private boolean helper(TreeNode root, int minVal, int maxVal){
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