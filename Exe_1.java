class Solution {
    private long p;
    public boolean isValidBST(TreeNode root) {
        p = Long.MIN_VALUE;
        return valid(root);
    }
    private boolean valid(TreeNode node){
        if(node == null){
            return true;
        }
        
        boolean l = valid(node.left);
        
        boolean c = node.val > p;
        
        p = node.val;
        
        boolean r = valid(node.right);
        
        return l && c && r;
    }
}
//tc=O(n)
//sc=O(1)
