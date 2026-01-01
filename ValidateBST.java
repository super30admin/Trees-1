// Time Complexity : O(n).
// Space Complexity : O(h) recursive stack space for height of tree.
// Did this code successfully run on Leetcode : Yes
// Approach : The basic idea is to perform an inorder traversal and check if the root values are sorted or not to determine if it's a valid BST. Here, we performed a boolean based
// recursion by returning false as we find a breach and not continue with the further recursion steps.

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root){
        //base case
        if(root == null){
            return true;
        }

        //left node
        if(!inorder(root.left)){
            return false;
        }

        if(prev != null && prev.val >= root.val){ //condition check
            return false;
        }
        prev = root;
        //right node
        return inorder(root.right);
    }
}