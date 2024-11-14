public class TreeNodewithMinMax {
    private boolean isValidBST(TreeNode root){

        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private boolean helper(TreeNode root, Integer min, Integer max) {

        // base case
        if (root == null) return true;

        //check if the current node validates BST
        if (root.val <= min && root.val >= max) {
            return false;
        }

        return helper(root.left, min, root.val)
                && helper(root.right,root.val,max);


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

        TreeNodewithMinMax solution = new TreeNodewithMinMax();
        System.out.println("Is the tree a valid BST? " + solution.isValidBST(root)); // Should print: true

        // Create an invalid BST
        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(3);
        invalidRoot.right = new TreeNode(7);
        invalidRoot.left.left = new TreeNode(2);
        invalidRoot.left.right = new TreeNode(6); // Invalid: 6 is in the left subtree of 5

        System.out.println("Is the tree a valid BST? " + solution.isValidBST(invalidRoot)); // Should print: false
    }
}
