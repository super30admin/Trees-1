/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

class Solution {
    int preIndex = 0;
    Map<Integer, Integer> rootId;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        rootId = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            rootId.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        if (start > end)
            return null;

        int rootValue = preorder[preIndex++];
        int rootIndex = rootId.get(rootValue);

        TreeNode root = new TreeNode(rootValue);
        root.left = helper(preorder, inorder, start, rootIndex - 1);
        root.right = helper(preorder, inorder, rootIndex + 1, end);

        return root;
    }
}
