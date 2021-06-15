// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    boolean valid = true;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        inOrder(root);
        return valid;
    }
    // we could make use of the property of BST:
    // in order traversal will get ascending order 
    // of BST
    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        // here we need pay attention to the null pointer 
        // of prev
        if(prev != null && root.val <= prev.val)
            valid = false;
        prev = root;
        inOrder(root.right);
    }
}