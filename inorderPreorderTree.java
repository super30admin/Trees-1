    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    Time Complexity for operators : o(n) .. number of  elements in the matrix
    Extra Space Complexity for operators : o(n) ... recursive stack in case of recusrin and normal stack for iterative 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach 

        # Optimized approach same like basic approach: Recursion or Iterative.
                              
              # - Iterative approach
                    A. if we compare arrays of inorder and preorder, we can see that first element of preorder
                       will be the topmost element in the tree. First we will find that first element in inorder array to get the root.
                    B. So by keeping that in mind, we will make a copy's of arrays inLeft, inRight, preLeft, preRight
                    C. inLeft will be from 0 to that of index.
                    D. preLeft will be from 1 to iondex+1. next subtrre is required for further interatiopn
                    E. inRight will be from index+1 till the end of inorder array
                    F. preRight also from index+1 till the end of preorder array.
       */


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

   class validateBST {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)// || inorder.length ==0)
            return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        
        int index = -1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == root.val){
                index = i;
            }
        }
        
        int[] inLeft = Arrays.copyOfRange(inorder,0,index);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1);
        
        int[] preRight = Arrays.copyOfRange(preorder,index+1,preorder.length);
        int[] inRight = Arrays.copyOfRange(inorder,index+1,inorder.length);
        
        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);
        
        return root;
            
    }
}