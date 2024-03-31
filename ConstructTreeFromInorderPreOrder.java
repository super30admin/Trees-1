// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
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
    int i = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, map, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, HashMap<Integer, Integer> map, int s, int e) {
        if (s > e) {
            return null;
        }

        int rootVal = preorder[i];
        i++;
        TreeNode root = new TreeNode(rootVal);

        int ridx = map.get(rootVal);

        root.left = buildTreeHelper(preorder, map, s, ridx - 1);
        root.right = buildTreeHelper(preorder, map, ridx + 1, e);
        return root;
    }
}
