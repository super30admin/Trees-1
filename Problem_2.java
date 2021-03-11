// Time Complexity : O(n), n= no. of nodes in tree
// Space Complexity : O(2n + h), h = height of tree
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder == null || preorder.length == 0) return null;
        TreeNode tree = new TreeNode(preorder[0]);
        
        int root = -1;
        for(int i = 0; i< inorder.length; i++){
            root++;
            if(inorder[i] == preorder[0]) break;
        }
        int[] inLeft = Arrays.copyOf(inorder, root);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, root+1);
        
        int[] inRight = Arrays.copyOfRange(inorder, root+1, preorder.length);
        int[] preRight = Arrays.copyOfRange(preorder, root+1, preorder.length);
        
        tree.left = buildTree(preLeft, inLeft);
        tree.right = buildTree(preRight, inRight);
        return tree;
    }
}
