/**
 * Definition for a binary tree node.
 * */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }


// Time Complexity : O(number of nodes)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// Here we will be doing inorder traversal and comparing each node with previous.
// Previous node should be smaller than current node. I its not the case the BST is not valid

class ValidateBST {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;
    }

    public void helper(TreeNode root){
        // for in-order traversal is Left -> root -> right
        if(root == null){
            return;
        }

        helper(root.left);

        // For a BST to be valid, previous element should be smaller than root.
        if(prev != null && prev.val >= root.val) {
            flag = false;
        }
        prev = root;
        helper(root.right);
    }
}