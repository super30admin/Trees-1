// Time complexity : O(n)
// Space complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Logic: Perform an in-order traversal of the tree, which visits nodes in ascending order.
//Check if each node's value is greater than the previous node's value to ensure the BST property.
//If any node violates this condition, set isValid to false and stop further traversal.

class Solution {
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root == null ){
            return true;
        }
        prev = null;
        isValid = true;

        inOrder(root);
        return isValid;
    }
    private void inOrder(TreeNode root){
        if(root == null ){
            return ;
        }
        inOrder(root.left);
        if(prev != null && prev.val >= root.val){
            isValid = false;
            return ;
        }
        prev = root;
        inOrder(root.right);
    }
}