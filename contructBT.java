/*
Author: Akhilesh Borgaonkar
Problem: LC 105. Construct Binary Tree from Preorder and Inorder Traversal (Trees-1)
Approach: Using recursive approach here to build the binary tree. First, find the root in inorder array and then we get the left sub-tree to the
    left of the root value and right sub-tree to the right of the root node. Call the buildTree method recursively on the sub-trees. 
Time Complexity: O(n^2) where n is number of total nodes in the resultant Binary Tree.
Space complexity: O(n) where n is number of total nodes in the resultant Binary Tree.
LC verified.
*/

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        
        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==root.val){
                index = i;
                break;
            }
        }
        
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] preRight = Arrays.copyOfRange(preorder, index+1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
        
    }
}