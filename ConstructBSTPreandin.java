import java.util.Arrays;
// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
       if(preorder.length ==0 || inorder.length ==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootidx= -1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]== root.val){
                rootidx= i;
                break; //optimisation to exit, since the value would never repeat, we can exit from the loop
            }
        }

        int[] inorderleft = Arrays.copyOfRange(inorder,0,rootidx);
        int[] inorderright = Arrays.copyOfRange(inorder,rootidx+1,inorder.length);

        int[] preorderleft = Arrays.copyOfRange(preorder,1,rootidx+1);
        int[] preorderright = Arrays.copyOfRange(preorder,rootidx+1,preorder.length);

        root.left= buildTree(preorderleft,inorderleft);
        root.right= buildTree(preorderright,inorderright);

        return root;
    }
}