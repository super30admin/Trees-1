// Time Complexity : O(N)
// Space Complexity : O(H) h is height of the tree
// Did this code successfully run on Leetcode : Yes

class Solution {
    boolean isValid = true;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return isValid;
    }
    void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        if(prev !=null && prev.val>= node.val){
            isValid = false;
            return;
        }
        prev = node;
        inorder(node.right);
    }
}