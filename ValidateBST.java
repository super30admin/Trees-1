// Time Complexity: O(n)
// Space Complexity: O(1). But, since this is a recursion, it could be considered O(n) depending on how big the stack is
// Solved on Leetcode successfully: Yes
// Approach: Use Recursion
// On the left side return false if the root's value is greater than previous root, which is passed as max to helper function
// On the right side return false if the root's value is smaller than previous root, which is passed as min to helper function


class ValidateBST {
    public boolean isValidBST(TreeNode node) {
        return helper(node,null,null);
    }
    
    private boolean helper (TreeNode root, Integer min, Integer max) {
        //Base case
        if(root == null) return true;
        
        if (min !=null && root.val <= min) return false;
        
        if  (max != null && root.val >= max) return false;
        //Logic
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}