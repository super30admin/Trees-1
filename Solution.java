import java.util.HashMap;

/**
 * Definition for a binary tree node.
 **/
class TreeNode {
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
    // TC: O(n) //SC: O(n)
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return validateBST(root, null, null);
    }

    private boolean validateBST(TreeNode root, Integer min, Integer max) {
        // base
        if (root == null) {
            return true;
        }
        boolean case1 = validateBST(root.left, min, root.val);
        boolean case2 = validateBST(root.right, root.val, max);
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return case1 && case2;
    }

    HashMap<Integer, Integer> map;
    int idx;

    // Using hashmap to store the idx of inorder to find root idx
    // recursion : local : preorder,inorder,start,end ; global : map,idx
    // TC: O(n) SC: O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        this.idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        // base case
        if (start > end)
            return null;
        // logic
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, inorder, start, rootIdx - 1);
        root.right = helper(preorder, inorder, rootIdx + 1, end);
        return root;
    }
}