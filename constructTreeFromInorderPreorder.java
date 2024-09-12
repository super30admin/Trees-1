/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class constructTreeFromInorderPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        int idx = -1;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                idx = i;
                break;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder, 0, idx);
        int[] inRight = Arrays.copyOfRange(inorder, idx + 1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length + 1);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length + 1, preorder.length);
        root.right = buildTree(preRight, inRight);
        root.left = buildTree(preLeft, inLeft);
        return root;
    }
}