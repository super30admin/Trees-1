public class SumRootRec {
    int result = 0;

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int num) {
        if (root == null) {
            result += num;
            return result;
        }
        num = num * 10 + root.val;
        helper(root.left, num);
        helper(root.right, num);

        return result;
    }

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
}
