// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    int i = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return helper(preorder, inorder, 0, preorder.length - 1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        
        if(start > end || i >= preorder.length)
            return null;
        
        TreeNode root = new TreeNode(preorder[i++]);
        int pos = findPos(inorder, root.val);
        root.left = helper(preorder, inorder, start, pos - 1);
        root.right = helper(preorder, inorder, pos + 1, end);
        
        return root;
        
    }
    
    public int findPos(int[] inorder, int val) {
        
        for(int i = 0; i < inorder.length; i++)
            if(inorder[i] == val)
                return i;
        
        return -1;        
    }
    
}