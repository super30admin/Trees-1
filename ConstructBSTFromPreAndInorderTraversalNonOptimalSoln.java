package Nov4;

import java.util.Arrays;

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

/*
 * Time complexity = O(n^2) because FOR loop is executed for each node to determine index of root node in inorder array, so nested loops 
 * cause time complexity of O(n^2).
 * 
 * Space complexity = O(n^2)
 * because in each recursive call, we are creating 4 arrays additional space. So, for n recursive calls, space would be O(n^2) asymptotically.
 * 
 */

class ConstructBSTFromPreAndInorderTraversalNonOptimalSoln {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // edge condition
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        
        // root element identified is first element in preorder array 
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = -1;
         
        // finding index of root element(identified from preorder array) in inorder array
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
            }
        }
        
       
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIndex+1 );
        int[] preRight = Arrays.copyOfRange(preorder, rootIndex+1, preorder.length );
        
      root.left=  buildTree(preLeft, inLeft);
      root.right= buildTree(preRight, inRight);
        
        return root;
        
    }
}