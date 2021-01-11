// Time Complexity : The time complexity is O(n) where n is the number of nodes in the tree.
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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

    // variable which stores the previous root
    TreeNode global = null;

    public boolean isValidBST(TreeNode root) {

        boolean leftSearch = true;
        boolean rightSearch = true;

        if(root.left != null){
            leftSearch = isValidBST(root.left);
        }

        // If the previous root is greater than or equal to current root return false
        if(!leftSearch || (global != null && global.val >= root.val)){
            return false;
        }

        global = root;

        if(root.right != null){
            rightSearch = isValidBST(root.right);
        }

        return rightSearch;

    }
}