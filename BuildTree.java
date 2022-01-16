class Solution {
    int preIndex;
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return binaryTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode binaryTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        root.left = binaryTree(preorder, left, inorderMap.get(rootValue) - 1);
        root.right = binaryTree(preorder, inorderMap.get(rootValue) + 1, right);
        return root;
    }
}

//Time complexity - O(n)
// Space complexity- O(n)