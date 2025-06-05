// Time Complexity: O(n)
// Space Complexity: O(h + n)
// Runs on LeetCode: YES
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
class BSTFromInOrderPreOrder {
    int idx=0;
    Map<Integer, Integer> inorderLookup = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i<inorder.length; i++) {
            inorderLookup.put(inorder[i], i);
        }

        return helper(preorder, inorderLookup, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder,Map<Integer, Integer> inorderLookup, int start, int end) {

        if (end < start) {
            return null;
        }

        int rootValue = preorder[idx];
        TreeNode root = new TreeNode(rootValue);
        idx++;
        int rootIndex = inorderLookup.get(rootValue);


        int startLeft = start;
        int endLeft = rootIndex - 1;
        int startRight = rootIndex + 1;
        int endRight = end;

        root.left = helper(preorder, inorderLookup, startLeft, endLeft);
        root.right = helper(preorder, inorderLookup, startRight, endRight);

        return root;
    }
}