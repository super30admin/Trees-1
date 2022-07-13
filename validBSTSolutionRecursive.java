// Time Complexity : O(n), As it traverses through all the nodes present in the tree
// Space Complexity : O(h) height of the tree, as we store only left nodes until the end of the tree in the stack, we used a space equal to the height of the tree
// Did this code successfully run on Leetcode : yes

public class validBSTSolutionRecursive {
    public class TreeNode {
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

    public TreeNode arrayToTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return arrayToTree(array, 0);
    }

    private TreeNode arrayToTree(Integer[] array, int root) {
        if (root >= array.length) {
            return null;
        }
        return new TreeNode(array[root], arrayToTree(array, (root * 2) + 1), arrayToTree(array, (root * 2) + 2));
    }

    TreeNode prev = null;
    boolean isValid; // declaring a variable initially, with this we'll check if the Binary tree is
                     // BST or not

    public boolean isValidBST(TreeNode root) {
        isValid = true;
        prev = null;
        inorder(root); // Calling the recursive method
        return isValid;
    }

    public void inorder(TreeNode root) {
        // base case
        // while traversing, when end of the tree is reached, the recursion is stopped
        if (root == null || isValid == false)
            return;
        // recursive case
        // first it will traverse all the left nodes till the end of the tree
        inorder(root.left);
        // once the end of left nodes is reached, the top node is popped and
        // it will be compared with the prev node,to check if its greater
        // if so, then it is not a valid BST
        if (prev != null && prev.val >= root.val) {
            isValid = false;
        }
        // if prev node is smaller than current,
        // then prev variable will be over written with current node value
        prev = root;
        // then recursion is called again from immediate right node,
        // where all the the left nodes of that right node is traverse until end
        inorder(root.right);
    }

    public static void main(String[] args) {
        validBSTSolutionRecursive vbr = new validBSTSolutionRecursive();

        Integer[] inputArray = { 5, 1, 4, 3, 6 };
        TreeNode inputBinaryTree = vbr.arrayToTree(inputArray);
        System.out.println("For Input1: " + vbr.isValidBST(inputBinaryTree));

        Integer[] inputArray2 = { 2, 1, 3 };
        TreeNode inputBinaryTree2 = vbr.arrayToTree(inputArray2);
        System.out.println("For Input2: " + vbr.isValidBST(inputBinaryTree2));

    }
}
