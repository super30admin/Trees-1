// T - O(N)
// S - O(N)
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
        if(preorder == null || preorder.length==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1) return root;

        int rootIndex = findRootIndex(inorder, root.val);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length+1);
        int[] rightPreorder = Arrays.copyOfRange(preorder,leftPreorder.length+1, preorder.length);
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }
    public int findRootIndex(int[] inorder, int val){
        for(int i = 0; i<inorder.length;i++){
            if(inorder[i] == val) return i;
        }
        return 0;
    }
}