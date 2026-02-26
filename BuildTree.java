public class BuildTree {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int preorderIndex = 0;
    // Time complexity: O(n)
    // Space complexity: O(h)
    // Ran on Leetcode: yes
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = preorder[preorderIndex];
        preorderIndex++;
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = inorderMap.get(rootVal);

        root.left = helper(preorder, left, inorderIndex - 1);

        root.right = helper(preorder, inorderIndex + 1, right);

        return root;
    }
}