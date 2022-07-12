public class ValidateBST {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        
        return inorder(root);
    }
    
    // TC is O(n) where n is the number of nodes
    // SC is O(h) height of tree
    private boolean inorder(TreeNode root){
        //base 
        if(root == null) return true;
        
        //left
        boolean b1 = inorder(root.left);
        if(prev != null && prev.val >= root.val){
            return false;
        }
        prev=root;
        boolean b2 = inorder(root.right);
        return b1 && b2;
    }
}
