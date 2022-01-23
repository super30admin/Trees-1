// Time Complexity : O(N)
// Space Complexity : O(1)
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
        
        if(preorder == null || preorder.length == 0) return null;
        int preMain = preorder[0];
        TreeNode root = new TreeNode(preMain);
        int indexMain = -1;
        //Find main root in Inorder 
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == preMain){
                indexMain = i;
                break;
            }
        }        
        int[] inLeft = Arrays.copyOfRange(inorder, 0, indexMain);
        int[] inRight = Arrays.copyOfRange(inorder, indexMain+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, indexMain+1);
        int[] preRight = Arrays.copyOfRange(preorder,indexMain+1, preorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root; 
    }
}