class Sample {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Problem 1:
     * Time complexity : O(N) where N is number of nodes
     * Space complexity : O(N) where N is number of nodes
     * 
     * Solution
     * 1. Check for every node, if it's left child has less value and right child has greater value.
     * 2. To check all the left children of node less than node and right children greater than node, 
     * maintain min (lower) and max (upper limit)
     */

    public boolean isValidBST(TreeNode root) {
        
        if(root == null)
            return true;
        
        return isBST(root, null, null);
        
    }
    
    private boolean isBST(TreeNode node, Integer min, Integer max) {
        
        if(node == null)
            return true;
        
        if((min != null && node.val <= min) || (max != null && node.val >= max))
            return false;
        
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }

}