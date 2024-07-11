// Time Complexity : o(N)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


class Solution {
    int[] preorder;
    int index = 0;
    HashMap<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        this.preorder = preorder;
        return helper(0, inorder.length - 1);
    }


    private TreeNode helper(int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex)
            return null;

        int rootVal = preorder[index];
        TreeNode root = new TreeNode(rootVal);
        index++;
        int rootIndex = inorderMap.get(rootVal);

        root.left = helper(leftIndex, rootIndex - 1);
        root.right = helper(rootIndex + 1, rightIndex);

        return root;
    }
}