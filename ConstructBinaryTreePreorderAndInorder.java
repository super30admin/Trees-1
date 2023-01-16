// Time Complexity : O(N)
// Space Complexity : O(N) + O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

class ConstructBinaryTreePreorderAndInorder {
    HashMap<Integer, Integer> inOrderMap;
    int btIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = preorder[btIndex];
        btIndex++;
        int rootIdx = inOrderMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHelper(preorder, start, rootIdx - 1);
        root.right = buildTreeHelper(preorder, rootIdx + 1, end);
        return root;
    }
}