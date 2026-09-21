
public class Sample {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidateBinarySearchTree searchTree = new ValidateBinarySearchTree();

        boolean result = searchTree.isValidBST(root);

        System.out.println("Is valid BST? " + result);

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        BinaryTreePreAndInOrder binaryTree = new BinaryTreePreAndInOrder();

        TreeNode root1 = binaryTree.buildTree(preorder, inorder);

        System.out.println("Tree constructed successfully!");

        // Print the tree using preorder traversal
        System.out.print("Preorder: ");
        printPreorder(root1);

        System.out.println();

        // Print the tree using inorder traversal
        System.out.print("Inorder: ");
        printInorder(root1);

        System.out.println();
        
    }

    
    // Preorder: Root -> Left -> Right
    private static void printPreorder(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        printPreorder(root.left);
        printPreorder(root.right);
    }

    // Inorder: Left -> Root -> Right
    private static void printInorder(TreeNode root) {

        if (root == null) {
            return;
        }

        printInorder(root.left);

        System.out.print(root.val + " ");

        printInorder(root.right);
    }
}

