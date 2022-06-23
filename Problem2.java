// Time Complexity : O (N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

//Problem statement: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
class Problem2 {

    int preIdx;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        preIdx = 0;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildingTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildingTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preIdx++];
        TreeNode root = new TreeNode(rootValue);

        root.left = buildingTree(preorder, left, map.get(rootValue) - 1);
        root.right = buildingTree(preorder, map.get(rootValue) + 1, right);
        return root;
    }
}