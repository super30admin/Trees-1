// Time Complexity: O(n)
// Space Complexity: O(n)

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
    int idx = 0; // we use idx global variable to place our next root element from preorder
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        Map<Integer, Integer> idxMap = new HashMap<>();

        for (int i=0 ;i<inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, idxMap, 0, preorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, Map<Integer, Integer> idxMap, int start, int end) {
        if (start > end) return null;

        int index = idx;

        int rootIdx = idxMap.get(preorder[idx]);

        TreeNode root = new TreeNode(preorder[idx]);

        idx++;

        root.left = buildTreeHelper(preorder, idxMap, start, rootIdx - 1);

        root.right = buildTreeHelper(preorder, idxMap, rootIdx + 1, end);

        return root;
    }
}
