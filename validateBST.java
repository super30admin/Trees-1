// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree    
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : only little in making the recursive function and keeping track of the previous node

// Your code here along with comments explaining your approach: flag is used to keep track of whether the tree is a valid BST or not. prev is used to keep track of the previous node in the inorder traversal. Inorder traversal of a BST should give us a sorted sequence of values. So, we can compare the current node's value with the previous node's value to check if the BST property is violated.

class Solution {
    boolean flag;
    TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;
    }

    private void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);

        if(prev != null && prev.val >= root.val){
            flag = false;
        }

        prev = root;
        helper(root.right);
    }
}

