// Time Complexity : O(n) 
// Space Complexity: O(n)

import java.util.HashMap;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int idx; // idx need not be initialized as the default value is 0.
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        // base
        if (start > end)
            return null;

        // logic
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        int rootidx = map.get(rootVal);
        idx++;

        root.left = helper(preorder, start, rootidx - 1);
        root.right = helper(preorder, rootidx + 1, end);

        return root;
    }
}