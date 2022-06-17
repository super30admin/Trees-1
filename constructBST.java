// Time Complexity: O(N)
// Space Complexity: O(N^2)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Yes, took reference of the lecture video to understand again

// Approach-1: Making deepcopy of all elements in the array and constructing BST
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // Null case 
        if(preorder.length == 0) return null;
        
        // Logic
        // The rootIdx in inorder
        int rootval = preorder[0];
        TreeNode root = new TreeNode(rootval);
        int rootIdx = -1; // Root idx in inorder
        
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootval) {
                rootIdx = i;
            }
        }
      
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1 + inLeft.length);
        int[] preRight = Arrays.copyOfRange(preorder, 1 + inLeft.length, preorder.length);
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
    }
}

//------------------------------------ *** ------------------------------------------------

// Approach-2: Optimal way (WIP)