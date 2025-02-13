/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BuildTreeSolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = -1;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                // index of root in inorder
                rootIndex = i;
                break;
            }
        }
        // Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7] Output:
        // [3,9,20,null,null,15,7]
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);

        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);

        return root;
    }

}