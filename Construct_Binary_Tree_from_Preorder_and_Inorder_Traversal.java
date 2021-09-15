// Time Complexity : O(n^2), at every node, we are traversing the arrays once to find the nodes.
// Space Complexity : O(n^2), created new arrays(deep copy) at every node
// This is an easy but inefficient solution
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        if(preorder.length==0)return null;
        //initializing index of root in inorder
        int rootIdx = 0;
        //root in preorder is at 0th index
        TreeNode root = new TreeNode(preorder[0]);
        //Now find actual root in inorder using preorder root
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                rootIdx = i;
            }
        }
        //create seperate arrays containing left and right nodes for preorder and inorder 
        int[] preleft = Arrays.copyOfRange(preorder,1,rootIdx+1);
        int[] preright = Arrays.copyOfRange(preorder,rootIdx+1,preorder.length);
        int[] inleft = Arrays.copyOfRange(inorder,0,rootIdx);
        int[] inright = Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
        //The above arrays are created basedon the calcularted root index of inorder
        
        //Finally we buildthe tree recursively using the new preorder and inorder traversals
        root.left = buildTree(preleft, inleft);
        root.right = buildTree(preright, inright);
        
        //Finally we return the root node of the tree from which entire tree is built
        return root;
        
        
    }
}