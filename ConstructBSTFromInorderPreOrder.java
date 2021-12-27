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
/*
TC: O(n) n as we are traversing array
SC: O(n) hasmap and stack
*/
class Solution {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int indexRoot;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = preorder[indexRoot];
        TreeNode root = new TreeNode(rootVal);
        indexRoot++;
        int rootIndexInInorder = inorderMap.get(rootVal);

        root.left = buildTree(preorder, start, rootIndexInInorder - 1);
        root.right = buildTree(preorder, rootIndexInInorder + 1, end);

        return root;
    }
}