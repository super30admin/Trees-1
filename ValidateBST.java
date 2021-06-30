// Time Complexity : O(n)
// Space Complexity : O(h), h - height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

 
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

class ValidateBST {
    TreeNode prev;
    boolean result;
    public boolean isValidBST(TreeNode root) {
        result = true;
        inorder(root);
        return result;
    }
    
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            result = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}