## Problem 1

https://leetcode.com/problems/validate-binary-search-tree/

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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, null, null);        
    }
    private boolean helper (TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        boolean case1 = helper(root.left, min, root.val);
        boolean case2 = helper(root.right, root.val, max);
        return case1 && case2;
    }
}

## Problem 2

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

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
    private HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || inorder.length == 0 || preorder.length == 0) {
            return null;
        }
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal);
        int root_index = map.get(rootVal);
        root.left = helper(preorder, start, root_index - 1);
        root.right = helper(preorder, root_index + 1, end);
        return root;
    }
}