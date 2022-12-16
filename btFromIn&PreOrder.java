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

// Time Complexity : O(n)
// Space Complexity : O(n) + O(h)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
/*
 * Reduce the search space complexity by creating a map , and ans to using a 2
 * pointer apporach to generate the left and right subtree
 */
class Solution {

    HashMap<Integer, Integer> map;
    // mapping to preorder array
    int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        map = new HashMap<>();
        // map to add the indexes of the nodes in inorder array
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1, -1);

    }

    private TreeNode helper(int[] preorder, int start, int end, int rootIdx) {
        // base condition
        if (start > end)
            return null;

        // logic
        // get the root node from preorder array
        int rootVal = preorder[index];
        index++;
        // get index of the root element in inorder array
        // index of root in inorder
        rootIdx = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        // left and right recursive call
        root.left = helper(preorder, start, rootIdx - 1, rootIdx);
        root.right = helper(preorder, rootIdx + 1, end, rootIdx);

        return root;

    }
}