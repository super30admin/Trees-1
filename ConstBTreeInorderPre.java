/**
Running Time Complexity: O(n^2)
Space Complexity: O(n^2)
Successfully Run and Compiled on leetcode
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
        if(preorder.length==0||inorder.length==0) return null;
        int idx = -1;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                idx = i;
                break;
            }
        }
        int[] preLeft = Arrays.copyOfRange(preorder,1,idx+1);
        int[] preRight = Arrays.copyOfRange(preorder,idx+1,preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder,0,idx);
        int[] inRight = Arrays.copyOfRange(inorder,idx+1,inorder.length);
        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);
        return root;
    }
}