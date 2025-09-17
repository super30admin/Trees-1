// 98. Validate Binary Search Tree
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
/*
Ran on leetcode : Yes
Traverse in DFS manner and at each point check if min and max value of the element is valid
TC: O(N)
SC: O(H)
*/
class Solution {

    //Flag to track if the tree is valid
    private boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        helper(root, null, null);
        return flag;
    }

    private void helper(TreeNode root, Integer min, Integer max){
        if(root == null) return;

        // check if negative infinity or val is less than min
        if(min != null && root.val <= min){
            flag = false;
        }
        // check if infinity or val is greater than max
        if(max != null && root.val >= max){
            flag = false;
        }

        if(flag == true){
            // left val min should be greater than root min and max should be less than root val
            helper(root.left, min, root.val);
        }

        if(flag == true){
            // right val min should be greater than root val and max should be less than root max
            helper(root.right, root.val, max);
        }
    }
}