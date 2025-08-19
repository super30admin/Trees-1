//105. Construct Binary Tree from Preorder and Inorder Traversal

// TC: O(N)
// SC : O(N)

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
class Solution {
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; ++i) {
            map.put(inorder[i], i);
        }
        this.idx = 0;
        return helper(preorder, 0, n - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        // base case
        if (start > end)
            return null;

        // logic
        int rootVal = preorder[idx++];

        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);

        return root;
    }
}
