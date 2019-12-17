/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/*
Time Complexity: O(n)
Space Complexity: O(1)
Did the code run on leetcode? Yes
Approach: make the min and max as null initially and update the min max values when calling the helper recursively
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max){
        //Base Case

        if(root==null) return true;

        if((min!=null && root.val<=min) || (max!=null && root.val>=max))return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
} 