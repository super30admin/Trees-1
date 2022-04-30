// Time Complexity :O(n)
// Space Complexity :O(h) - h is height of the BT - worst case it will be O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class ValidBST{
    public boolean isValidBST(TreeNode root) {
        return valid(root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
    }
    
    public boolean valid(TreeNode root, long left, long right){
        if(root == null) return true;
        
        if(!((long)root.val < right && (long)root.val > left)) return false;
        
        return (valid(root.left, left, (long)root.val) && (valid(root.right, (long)root.val, right)));
    }
}