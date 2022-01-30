//Time Complexity: O(N)
//Space Complexity: O(H), where H = height of the recursive stack
//To validate a BST we use recursion to make an inorder traversal of the given tree and we check if the previous value is greater than
//the current value. If it is greater, we return false because an inorder traversal of a BST should have all the nodes in ascending order.

class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        prev = null;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        
        if(prev!= null && prev.val >= root.val){
            flag = false;
            return;
        }
        prev = root;
        
        inorder(root.right);
    }
}