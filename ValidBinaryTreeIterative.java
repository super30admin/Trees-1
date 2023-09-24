import java.util.Stack;

// TC - O(n);
//SC - O(n);

public class ValidBinaryTreeIterative {
    public static void main(String[] args) {
        // Create a binary tree (you can replace this with your own tree)
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        // Create an instance of the Solution class
        ValidBinaryTreeIterative solution = new ValidBinaryTreeIterative();

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
        Stack<TreeNode> s = new Stack<>();

        while(root != null || !s.isEmpty()){

            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev != null && prev.val >= root.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
    return true;
    }
}