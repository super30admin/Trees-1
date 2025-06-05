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

public class Solution {

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++)
            inOrderIndexMap.put(inOrder[i], i);

        return splitTree(preOrder, inOrderIndexMap, 0, 0, inOrder.length - 1);
    }

    private TreeNode splitTree(int[] preOrder, Map<Integer, Integer> inOrderIndexMap,
            int rootIndex, int left, int right) {
        if (rootIndex >= preOrder.length)
            return null; // Explicit base case

        TreeNode root = new TreeNode(preOrder[rootIndex]);

        int mid = inOrderIndexMap.get(preOrder[rootIndex]);
        if (mid > left)
            root.left = splitTree(preOrder, inOrderIndexMap, rootIndex + 1, left, mid - 1);
        if (mid < right) {
            int leftSize = mid - left;
            root.right = splitTree(preOrder, inOrderIndexMap, rootIndex + leftSize + 1, mid + 1, right);
        }
        return root;
    }
}


//////////
/// 
/// 