package S30.exercises;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No
// Approach: Travel from root and apply inorder traversal by visiting the left and then right trees recursively.  If
// left tree is not valid then return false and if the left tree is valid then only check the right tree.
  // Definition for a binary tree node.
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
public class ValidateBinarySearchTree {
    boolean valid;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        valid = true;
        inorder(root);
        return valid;
    }
    private void inorder(TreeNode root){

        if(root == null) return;
        if(valid){
            inorder(root.left);
        }
        if(prev !=null && prev.val >= root.val){
            valid = false;
        }
        prev = root;
        if(valid){
            inorder(root.right);
        }

    }
}
