// Time Complexity: O(N)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


// Approach-1: returning validate flag from stack recurssion
class Solution {
    public boolean isValidBST(TreeNode root) {
       return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max){
        // Base
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        
        // Logic
        boolean left = helper(root.left, min, root.val);
        
        boolean right = helper(root.right, root.val, max);
        
        return left && right;
    }
}   

//------------------------------------ *** ------------------------------------------------

// Approach-2: taking flag outside of class and checking 
class Solution {
    boolean isNotValid = true;
    TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return isNotValid;
    }
    
    private void helper(TreeNode root){
        // Base
        if(root == null) return;
        
        // Logic
        // Left Traversal
        helper(root.left);
        // st.pop()
        
        // if prev val is bigger than the root val then tree is not valid
        if(prev != null && prev.val >= root.val){
            isNotValid = false;
        }
        
        // Assigning current root as prev
        prev = root;
        
        // if BST is not valid so don't need to go for right traversal
        if(isNotValid)
            helper(root.right);
    }
}