// TC: O(n) => number of nodes
// SC: O(n+h) => space of HashMap + height of the tree

// 1: We use a HashMap to store the indexes of each number in the Inorder array
// 2: Using the Preorder array, we can locate the root by maintaining an index value that increases with every traversal
// 3: We use this root value to get the index from the Inorder array from which we can generate our left and right side of the tree
class Solution {
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.idx = 0;
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end)
            return null;

        // logic
        int rootVal = preorder[idx];
        idx++;
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);
        return root;
    }
}