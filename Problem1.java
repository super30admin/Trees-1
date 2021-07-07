// Time Complexity - O(n) where n is the number of elements in the tree
// Space Complexity - O(1) since we are not using any extra space
// This solution worked on LeetCode
// For this problem, we would be using the property of BST that all the left subtrees values will be smaller than the root value and all the right subtree values will be greater than the root value. This will be taken care using min and max value where min for the left subtree will be same as the min of root and the max value will be the root value. Similarly for right subtree the min value will be root value and the max will be same max as that of the root. Below solution is the recursive solution where null is used as min and max for the root. 


class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max){ 
        if(root == null)    
            return true;
        if( min != null && root.val <= min) 
            return false;
        if(max != null && root.val >= max)   
            return false;
        return helper(root.left, min, root.val) && helper(root.right,root.val,max);
    }
}
