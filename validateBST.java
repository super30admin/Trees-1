//Time Complexity: O(N)
//Space Complexity: O(N)
class Solution {
    boolean result;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        result = true;
        inorder(root);
        return result;
        
    }
    
    private void inorder(TreeNode root) {
        //base
        //if root is null we will return (it will return to the next recursive call)
        if(root == null) {
            return;
        }
        inorder(root.left);
        //When prev.val will be greater than root.val we will return false
        if(prev != null && prev.val >= root.val) {
            result = false;
        }
        prev = root;
        inorder(root.right);
    }
}