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
// TC : O(n)
// SC : O(n)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if (preorder == null || preorder.length == 0 || inorder == null ||
           inorder.length == 0) return null;
        
        int rootval = preorder[0];
        TreeNode tn = new TreeNode(rootval);
        int rootidx = -1;
        
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootval) {
                rootidx = i;
                break;
            }
        }
        
        int [] inLeft = Arrays.copyOfRange(inorder, 0, rootidx);
        int [] inRight = Arrays.copyOfRange(inorder, rootidx+1, inorder.length);
        int [] preLeft = Arrays.copyOfRange(preorder, 1, rootidx+1);
        int [] preRight = Arrays.copyOfRange(preorder, rootidx+1, preorder.length);
        
        tn.left = buildTree(preLeft, inLeft);
        tn.right= buildTree(preRight, inRight);
        
        return tn;
        
    }
}
