//Time Complexity is O(n)
//Space Complexity is O(h) => height of tree => logn
class Solution {
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isBST(root, null, null);

    }

    private boolean isBST(TreeNode root, Integer min, Integer max) {
        // base

        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }

        if (max != null && root.val >= max) {
            return false;
        }

        boolean case1 = isBST(root.left, min, root.val);
        boolean case2 = isBST(root.right, root.val, max);

        return case1 && case2;

    }
}