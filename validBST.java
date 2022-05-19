// Time Complexity : O(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
traverse through evry node in inorder traversal and return false if the previous
// value is greater than or equal to the root value

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev=null;
        return helper(root);   
    }
    private boolean helper(TreeNode root){
        if(root==null) return true;
        if(helper(root.left)==false) return false;
        if(prev!=null && prev.val >= root.val) return false;
        prev=root;
        return helper(root.right);
        
    }
}