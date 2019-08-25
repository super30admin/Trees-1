// Time complexity: O(n)
// Space Complexity: O(1)
// Leetcode: Yes , it runs on leetcode
// Problems faced: No





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer max, Integer min){
        if(root == null){
            return true;
        }

        if((min != null && min >= root.val) || (max != null && max <= root.val)){
            return false;
        }

       return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
}