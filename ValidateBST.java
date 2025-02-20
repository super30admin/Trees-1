//TC: O(n), n=number of nodes
//SC: O(h), h=height of tree
//approach: inorder tree traversal results in sorted list

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

public class ValidateBST {
    TreeNode previous;
    boolean valid;

    public boolean isValidBST(TreeNode root) {
        valid = true;
        inOrder(root);
        return valid;
    }

    public void inOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        inOrder(root.left);

        if (null != previous && root.val <= previous.val) {
            valid = false;
        }
        previous = root;
        inOrder(root.right);
    }
}
