public class ConstructBinaryTreeFromPreorderAndInorder {
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
    Map<Integer, Integer> inorderMap = new HashMap<>();

    // TC: O(N) where N is number of nodes
    // SC: O(N + H) where N is max height of tree and H is max height of tree
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int rootIndex = inorderMap.get(rootVal);
        int leftTreeLen = rootIndex - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, preStart + 1, preStart + leftTreeLen, inorder, inStart, rootIndex - 1);
        root.right = helper(preorder, preStart + leftTreeLen + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}
