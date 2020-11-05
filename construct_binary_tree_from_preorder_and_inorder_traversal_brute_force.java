// Time Complexity : O(n^2), where n is the size of the tree
// Space Complexity : O(n^2), where n is the size of the tree (space required to create n copies of array of size n (asymptomatically))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain english
//1. assign root as the first element in the preorder array and find the index (idx) of root value in the inorder array.
//2. then the left sub-tree and the right sub-tree in both preorder and inorder arrays
//3. Recursively keep finding the root in the left subtree and the right subtree, till the elements in both the inorder and preorder 
    //become empty

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length ==0 && inorder.length ==0) return null;
        
        int preIdx = 0;
        int inIdx =0;
        
        //assign the element at current index in preorder array as root
        int rootVal = preorder[preIdx];
        //find the root in the inorder array
        for(int i =0; i<inorder.length; i++){
            if(inorder[i] == rootVal){
                inIdx = i;
            } 
        }
        
        TreeNode root = new TreeNode(rootVal);
        
        //form the 4 subarrays --> preorderLeft, preorderRight, inorderLeft, inorderRight
        
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inIdx+1);
        int[] preRight = Arrays.copyOfRange(preorder, inIdx+1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, inIdx);
        int[] inRight = Arrays.copyOfRange(inorder, inIdx +1, inorder.length);
        
        //find the left child
        root.left = buildTree(preLeft, inLeft);
        //find the right child
        root.right = buildTree(preRight, inRight);
        
        //return root, that holds the tree
        return root;
    }
}