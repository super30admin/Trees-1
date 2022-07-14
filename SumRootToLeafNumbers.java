/**
 * Time Complexity: O(N)
 * Space Complexity : O(h) : where h is the height of the tree
 */

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

public class SumRootToLeafNumbers {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        preOrderTraversal(root, 0);
        return sum;
    }

    private void preOrderTraversal(TreeNode root, int num) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            sum = sum + num * 10 + root.val;
        }

        preOrderTraversal(root.left, num * 10 + root.val);
        preOrderTraversal(root.right, num * 10 + root.val);
    }
}
