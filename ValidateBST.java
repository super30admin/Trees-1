/**
## Problem 1: https://leetcode.com/problems/validate-binary-search-tree/
 
Time Complexity :   O (N)    - N->no of nodes in tree
Space Complexity :  O (H)    - H->height of tree
Did this code successfully run on Leetcode :    Yes (98. Validate Binary Search Tree)
Any problem you faced while coding this :       No
 */

 // Input: root = [2,1,3]
 // Logic: recursive approach
class ValidateBST {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inOrder(root);
        return flag;
    }
    public void inOrder(TreeNode root){
        // base case
        if( root == null)
            return;
        if(flag)
            inOrder(root.left);

        // check if previous element is greater than root, then not a valid BST
        if(prev != null && prev.val >= root.val){
            flag = false;
            return;
        }
        prev = root;
        if(flag)
            inOrder(root.right);
    }
}