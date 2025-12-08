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
        //base
        if(preorder.length==0) return null;
        //logic
        int rootVal = preorder[0];
        int rootIdx = -1; //idx in inorder array
        for(int i=0;i<inorder.length;i++){
            if(rootVal==inorder[i]){
                rootIdx = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, preorder.length);
        //left
        root.left = buildTree(preLeft, inLeft);
        //right
        root.right = buildTree(preRight, inRight);

        return root;


    }
}