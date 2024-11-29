// Time Complexity : O(n). n is the number of nodes in a tree
// Space Complexity : O(n).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    TreeNode prevNode;
    public boolean isValidBST(TreeNode root) {
       return binaryTree(root);
    }
    
    private boolean binaryTree(TreeNode root){
        if(root==null) return true;
        
       if(binaryTree(root.left)==false) return false;
        if(prevNode!=null && root.val<=prevNode.val) return false;
        prevNode=root;
        return binaryTree(root.right);
        
    }
}
