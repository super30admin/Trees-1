public class ValidBST{
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    
    public boolean isValid(TreeNode node, TreeNode low, TreeNode high) {
        
        if(node == null)
            return true;
        
        if(high != null && node.val >= high.val 
           || low != null && node.val <= low.val)
            return false;
        
        return isValid(node.left, low, node) &&
            isValid(node.right, node, high);
    }
    
}