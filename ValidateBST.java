// Time Complexity =  O(n) where n is the number of nodes
// Space Complexity = O(1)

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        boolean result = inOrder(root);
        return result;
    }
    public boolean inOrder(TreeNode root) {
        if(root == null) return true;
        
        boolean left = inOrder(root.left);
        if(prev!=null && prev.val >= root.val){
            return false;
        }
        prev = root;
        System.out.println(root.val);
        boolean right = inOrder(root.right);
        return left && right;
    }
    
}