import java.util.*;

// Recursion, O(n) time, O(h) space
class Solution {
    private int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length-1, map);
    }

    private TreeNode helper(int[] preorder, int start, int end, Map<Integer, Integer> map) {
        if (start > end) return null;

        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;

        int mid = map.get(root.val);
        
        root.left = helper(preorder, start, mid-1, map);
        root.right = helper(preorder, mid+1, end, map);

        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 