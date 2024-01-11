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
 //TC: O(n^2)
 //SC: O(n^2)
 class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;  //base case
        int rootval = preorder[0];
        int rootIndex = -1;
        
         TreeNode root = new TreeNode(rootval);
        //find the root in inorder

        for(int i = 0; i < inorder.length; i++)
        {
            if(inorder[i] == rootval) rootIndex = i;
        }

        int [] inLeft = Arrays.copyOfRange(inorder, 0 , rootIndex);
        int [] inRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);

        int [] preLeft = Arrays.copyOfRange(preorder, 1 , 1 + inLeft.length);
        int [] preRight = Arrays.copyOfRange(preorder, 1 + inLeft.length, preorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);


        return root;
    }
}