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

    //Time complexity: O(N) N is size of array
    //Space complexity: O(N) N is size of array

    //Steps:
    /*
    1.
    */


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length-1, 0, inorder.length-1, inorder, postorder);
    }
    
    private TreeNode helper(int postStart, int inStart, int inEnd, int[] inorder, int[] postorder) {
        
        if(postStart < 0 || inStart > inEnd)
            return null;
        
        TreeNode node = new TreeNode(postorder[postStart]);
        
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == postorder[postStart])
                inIndex = i;
        }
        
        node.left = helper(postStart + inIndex - inEnd - 1, inStart, inIndex - 1, inorder, postorder);
        node.right = helper(postStart - 1, inIndex + 1, inEnd, inorder, postorder);
        
        return node;
        
    }

}