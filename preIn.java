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

//Time Complexity: O(m + n) m = preorder.length, n = inorder.length
//Space Complexity: O(n)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        
        int rootVal = preorder[0];
        int index = -1;
        TreeNode root = new TreeNode(preorder[0]);
        
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal)
            {
                index = i;
                break;
            }
        }
        
        int[] inorderleft = Arrays.copyOfRange(inorder, 0, index);
        int[] inorderright = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] preorderleft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] preorderright = Arrays.copyOfRange(preorder, index+1, preorder.length);
        
        root.left = buildTree(preorderleft, inorderleft);
        root.right = buildTree(preorderright,inorderright);
        
        
        return root;
    }
}