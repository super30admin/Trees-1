//Problem 1: https://leetcode.com/problems/validate-binary-search-tree/

// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:  I have used the recursive approach to solve this problem. I have passed the root node, min and max values to the helper function.

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}

// Problem 2:
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/1250412513/
// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I used a HashMap to store the indices
// of elements in the inorder array for efficient lookup during tree
// construction. Then, I recursively built the tree nodes based on the
// preorder and inorder traversal sequences, using the indices to determine the
// boundaries of each subtree.

class Solution {
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        this.idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        if (start > end)
            return null;
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, inorder, start, rootIdx - 1);
        root.right = helper(preorder, inorder, rootIdx + 1, end);
        return root;
    }
}
