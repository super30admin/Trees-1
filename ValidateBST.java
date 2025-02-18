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

        //We will compare each node with min range and max range. If the value if not within the range then return false
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer lower, Integer upper) {

        if(root == null)
            return true;

        boolean low = true;
        boolean up = true;

        //The node's value should be greater than lower range and lesser than upper range
        if(lower != null && root.val <= lower)
            low = false;
        
        if(upper != null && root.val >= upper)
            up = false;
        
        return low && up && helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
    }
}

//Time complexity: O(n)
//Space complexity: O(n) :- If the tree is skewed O(h) == O(n)