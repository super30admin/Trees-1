// TC : O(N) -> maximum number of nodes in the tree
// all nodes are visited once

// SC : O(H) -> Height of the tree
// In recursion one must always keep track of the space
// needed and here it is O(H) worst case

class Solution {
    public boolean isValidBST(TreeNode root) {
        // In the initial case we don't 
        // know the values, hence we pass
        // null. That null represents
        // -infinity and + infinity
        return validate(root, null, null);
    }
    
    // to validate the binary tree we will check the root value
    // with the left side node (lowest possible value) and
    // with the right side node (highest possible value)
    
    // We use wrapper class of int (Integer) as that can 
    // take the value null but int cannot
    private boolean validate(TreeNode node, Integer low, Integer high) {
        
        // Check Node
        if (node == null) return true;
        
        // Check Node Value
        if((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }
        
        // Check for left subtree and right subtree (Left ST, Right ST)
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}