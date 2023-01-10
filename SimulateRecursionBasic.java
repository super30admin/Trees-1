class SimulateRecursionBasic {
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return true;
    }

    // To Trace the Recursion Stack
    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        // When return is called Stack.pop() under the hood
        System.out.print("UP - ");

        System.out.println(root.val);

        inorder(root.right);
        // When return is called Stack.pop() under the hood
        System.out.print("DOWN - ");
        System.out.println(root.val);

    }
}