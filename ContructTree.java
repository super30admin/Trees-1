import java.util.HashMap;

public class ContructTree {
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootVal = preorder[idx];
        int rootidx = map.get(rootVal);
        idx++;
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, start, rootidx - 1);
        root.right = helper(preorder, rootidx + 1, end);
        return root;

    }

    public static void main(String[] args) {
        ContructTree constructTree = new ContructTree();

        // Example input arrays for preorder and inorder traversals
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        // Call the buildTree method to construct the binary tree
        TreeNode root = constructTree.buildTree(preorder, inorder);

        // call a print method on the tree
        printTree(root);
    }

    // Example print method for the tree
    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        // Perform any desired operation with the current node value
        System.out.print(root.val + " ");

        // Recursively print left and right subtrees
        printTree(root.left);
        printTree(root.right);
    }
}
