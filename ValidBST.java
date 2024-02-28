//Definition for a binary tree node.
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

    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inorder(root);
        return flag;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        // Simulating the step to check the sorted order of the nodes in inorder.
        if (prev != null && prev.val >= root.val) {
            flag = false;
        }

        // Before Moving right update the pointer to the current
        prev = root;

        inorder(root.right);

    }
}