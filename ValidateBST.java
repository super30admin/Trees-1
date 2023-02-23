/*
 * Time Complexity : O(n)
 * Space Complexity :  O(h)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - We use recursion to iterate over the tree. For the BST To be valid, each node must be within the "Limits" for that node. We iterate over the tree and check if each node satisfies 
 * this criteria. The limits for each node is - If left child then min - root's min, max - root. For right child min - root and max - root's max.
 */

//https://leetcode.com/problems/validate-binary-search-tree/

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
class ValidateBST {
    Boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag=true;
        helper(root,null,null);
        return flag;
    }

    private void helper(TreeNode root, Integer min, Integer max){
        if(root==null){
            return;
        }
        if(min!=null && root.val<=min || max!=null && root.val>=max)flag=false;
        helper(root.left,min,root.val);
        helper(root.right,root.val,max);
    }
}