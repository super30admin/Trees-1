// Problem2 -
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Time Complexity : O(n^2) [Provided optimal solution in Tree-2,Problem-1]
// Space Complexity : O(n^2) [Provided optimal solution in Tree-2,Problem-1]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int idx = -1;
        //finding root in order
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == rootVal){
                idx=i;
                break;    
            }
        }
        
        int [] inLeft = Arrays.copyOfRange(inorder, 0, idx);
        int [] preLeft = Arrays.copyOfRange(preorder, 1, idx+1);
        int [] inRight = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int [] preRight = Arrays.copyOfRange(preorder, idx+1, preorder.length);
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
    }
}