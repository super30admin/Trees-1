
    /**
    Time Complexity : O(N)
    Explanation:
    - We traverse preorder once.
    - Each node lookup in inorder is O(1) using HashMap.
    So overall linear time.

    Space Complexity : O(N)
    Explanation:
    - HashMap stores inorder indices.
    - Recursion stack can go up to N in worst case (skewed tree).

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about how to split left and right subtrees.
    Later understood:
        - Preorder gives root first
        - Inorder gives left | root | right
    Used a global index for preorder and a HashMap to quickly
    find root position in inorder to divide subtrees correctly.
    */
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

    int idx;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        idx = 0;
        map = new HashMap<>();

        // Store inorder value -> index mapping
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {

        // Base case
        if (start > end) return null;

        // Root from preorder
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = map.get(rootVal);
        idx++;

        // Build left and right subtree
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);

        return root;
    }
}