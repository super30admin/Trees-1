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
        if(preorder.length==0) return null;

        int rootval = preorder[0];
        TreeNode root = new TreeNode(rootval);
        int rootidx = -1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootval){
                rootidx = i;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder,0,rootidx);
        int[] inRight = Arrays.copyOfRange(inorder,rootidx+1,inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder,1,1+inLeft.length);
        int[] preRight = Arrays.copyOfRange(preorder,1+inLeft.length,preorder.length);
        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);
        return root;


    }
}