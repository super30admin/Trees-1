/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
Algorithm: 
    1. Take the root value that is the first value from the preorder array, locate this in inorder array and call the location as index. 
    2. The number of elements which are there to the left of the found index in inorder are the number of elements from the root element in preorder forward which form the left subtree.
    3.The number of elements which are there to the right of the found index in inorder are the number of elements from the index element in preorder forward which form the right subtree.
    
    
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    Did the code run on leetcode? Yes

*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length==0 || inorder.length == 0)
            return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        for(int i =0; i<inorder.length; i++){
            if(root.val==inorder[i]){
                index = i;
            break; }
        }
        
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] preRight =  Arrays.copyOfRange(preorder, index+1, preorder.length);
        int[] inoLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inoRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        root.left = buildTree(preLeft, inoLeft);
        root.right = buildTree(preRight, inoRight);
        
        return root;
        
    }
}