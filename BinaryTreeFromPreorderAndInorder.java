import java.util.HashMap;
import java.util.Map;

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

public class BinaryTreeFromPreorderAndInorder {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right)
            return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        System.out.print("BEFORE: " + rootValue + ", ");
        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        // System.out.println();
        System.out.print("After: " + rootValue + " , ");
        // System.out.print("After: " + rootValue + root + " , ");
        return root;
    }

    public static void main(String[] args) {

        int[] preOrder = { 3, 9, 20, 15, 7 };
        int[] inOrder = { 9, 3, 15, 20, 7 };
        BinaryTreeFromPreorderAndInorder obj = new BinaryTreeFromPreorderAndInorder();
        TreeNode root = obj.buildTree(preOrder, inOrder);

        // Display the resulting tree using inorder traversal
        System.out.println("Inorder Traversal:");
        inorderTraversal(root);
    }

    private static void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.val + " ");
            inorderTraversal(node.right);
        }
    }
}
