// Time Complexity: O(n)
// Space Complexity: O(n)

class ValidBinaryTree {
    public boolean isValidBST(TreeNode root) {
        return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    boolean valid(TreeNode root, long min, long max){
        if(root==null) return true;
        
        if(min<root.val && root.val<max){
            return valid(root.left,min,root.val) && valid(root.right,root.val,max);
        }
        
        return false;
    }
}