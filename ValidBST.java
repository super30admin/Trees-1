public class ValidBST {
    TreeNode prev;
    public boolean isValidBST(TreeNode root){

        return helper(root);


    }

    private boolean helper(TreeNode root){
        // base case
        if(root == null) return true;
        if(helper(root.left) ==false) return false;

        if(prev!=null && prev.val>=root.val){
            return false;
        }
        prev = root;
        return helper(root.right);
    }

    public static void main(String[] args) {
        // Create a valid BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        ValidBST validator = new ValidBST();
        System.out.println("Is the tree a valid BST? " + validator.isValidBST(root)); // Should print: true

        // Create an invalid BST
        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(3);
        invalidRoot.right = new TreeNode(7);
        invalidRoot.left.left = new TreeNode(2);
        invalidRoot.left.right = new TreeNode(6); // Invalid: 6 is in the left subtree of 5

        ValidBST invalidValidator = new ValidBST();
        System.out.println("Is the tree a valid BST? " + invalidValidator.isValidBST(invalidRoot)); // Should print: false
    }

}


