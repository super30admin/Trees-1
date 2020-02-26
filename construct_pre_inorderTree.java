// Time Complexity : O(N^2)
// Space Complexity : O(log N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldnt solve before class


// Your code here along with comments explaining your approach
//Do base checks
//Find the root from preorder 0 index
//find the corresponding root index from inorder for loop
//initialize the tree
//find the range of left and right inorder and preorder separately
//then do recursive calls for left tree and right tree

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        //base checks
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        
        if(preorder.length != inorder.length){
            return null;
        }
        
        //find root value
        int rootValue = preorder[0];
        int rootIndex = 0;
        
        //find root index in inorder
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == rootValue){
                rootIndex = i;
                break;
            }
        }
        
        //declare the root
        TreeNode root = new TreeNode(rootValue);
        
        //find the ranges for inorder based on rootIndex
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        
        
        //get pre-order
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIndex+1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIndex+1, preorder.length);
        
        //start building trees with recursive calls
        root.left = buildTree(preorderLeft,inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        
        return root;
    }
}