// Time Complexity :
//      n is the number of elements
//      buildTree() - O(n*n)
//      
// Space Complexity :
//      buildTree() - O(n)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) 
            return null;
        
        return helper(preorder, inorder);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder)
    {
        if(preorder.length == 0)
            return null;
        
        int idx = -1;
        
        TreeNode root = new TreeNode(preorder[0]);
        
        for(int i=0; i< inorder.length; ++i)
        {
            if(inorder[i] == root.val)
            {
                idx = i;
                break;
            }
        }
        
        int[] inLeft = Arrays.copyOfRange(inorder, 0, idx);
        int[] inRight = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, idx+1);
        int[] preRight = Arrays.copyOfRange(preorder, idx+1, preorder.length);
        
        root.left = helper(preLeft, inLeft);
        root.right = helper(preRight, inRight);
        return root;
    }
}