/*
    LC - 105. Construct Binary Tree from Preorder and Inorder Traversal
    TC - O(n)
    SC - O(2n) ~ O(n)
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
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        map = new HashMap<>();
        idx = 0;
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recurse(preorder, 0, inorder.length - 1);
    }
    public TreeNode recurse(int[] preorder, int start, int end) {
        // base
        if(start > end) {
            return null;
        }

        // logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.left = recurse(preorder, start, rootIdx - 1);
        root.right = recurse(preorder, rootIdx + 1, end);

        return root;
    }
}