// TC - O(n);
//SC - O(n);

public class ValidBinaryTreeRecursive {
    public static void main(String[] args) {
        // Create a binary tree (you can replace this with your own tree)
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        // Create an instance of the Solution class
        ValidBinaryTreeRecursive solution = new ValidBinaryTreeRecursive();

        // Check if the tree is a valid BST
        boolean isValidBST = solution.isValidBST(root);

        // Print the result
        if (isValidBST) {
            System.out.println("The tree is a valid BST.");
        } else {
            System.out.println("The tree is not a valid BST.");
        }
    }

    boolean isValid;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        isValid = true;
        inorder(root);
        return isValid;
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);

        if(prev != null && prev.val >= root.val){
            isValid = false;
            return;
        }

        prev = root;
        inorder(root.right);
    }

}