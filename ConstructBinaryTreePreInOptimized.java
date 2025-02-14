// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

public class ConstructBinaryTreePreInOptimized {
    int idx; // for preorder array
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, map, 0, len - 1);
    }

    private TreeNode helper(int[] preorder, HashMap<Integer, Integer> map, int start, int end) {
        if (start > end) return null;

        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx = map.get(rootVal);

        root.left = helper(preorder, map, start, rootIdx-1);
        root.right = helper(preorder, map, rootIdx+1, end);
        return root;
    }
}
