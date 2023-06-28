class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // TreeNode() {}
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

    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        this.flag = true;

        inorder(root);
        return flag;
    }

    public void inorder(TreeNode root) {
        // base
        if (root == null)
            return;
        // logic
        if (flag) {
            inorder(root.left);
        }
        if (prev != null && prev.val >= root.val) {
            flag = false;
        }
        prev = root;
        if (flag) {
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        ValidateBST validator = new ValidateBST();
        System.out.println(validator.isValidBST(root1)); // Output: true

        // Test case 2: Invalid BST
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println(validator.isValidBST(root2)); // Output: false
    }
}