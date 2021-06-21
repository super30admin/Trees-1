
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

class ValidateBST {

    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    public boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        //check left node
        if (inorder(root.left) == false) {
            return false;
        }
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return inorder(root.right);
    }
}
