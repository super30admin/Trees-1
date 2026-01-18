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
class Solution {
    Map<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        this.idx = 0;
        for (int i = 0; i < preorder.length; i++) {
            this.map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
        // return null;

    }

    private TreeNode helper(int[] preorder, int start, int end) {
        // Base
        if (start > end)
            return null; // When leaf node is reached.

        // Logic
        int val = preorder[idx]; // get value from the preorder index
        idx++; // increment index so we fetch next element from the preorder
        TreeNode node = new TreeNode(val); // add to a node
        int rootIdx = map.get(val); // get the root index to get value of next root from the map.

        // Left Subtree start and end positions
        int leftStart = start;
        int leftEnd = rootIdx - 1;

        // Right Sub Tree start and end positions
        int rightStart = rootIdx + 1;
        int rightEnd = end;

        // Left
        node.left = helper(preorder, leftStart, leftEnd);

        // Right
        node.right = helper(preorder, rightStart, end);

        return node;

    }
}