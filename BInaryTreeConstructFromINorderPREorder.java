
import java.util.*;

// Time and Space - O(n)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BInaryTreeConstructFromINorderPREorder {

    TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++)
            inOrderIndexMap.put(inOrder[i], i);

        return splitTree(preOrder, inOrderIndexMap, 0, 0, inOrder.length - 1);
    }

    private TreeNode splitTree(int[] preOrder, Map<Integer, Integer> inOrderIndexMap,
                               int rootIndex, int left, int right) {

        TreeNode root = new TreeNode(preOrder[rootIndex]);

        int mid = inOrderIndexMap.get(preOrder[rootIndex]);
        if (mid > left)
            root.left = splitTree(preOrder, inOrderIndexMap,
                    rootIndex + 1, left, mid - 1);
        if (mid < right)
            root.right = splitTree(preOrder, inOrderIndexMap,
                    rootIndex + mid - left + 1, mid + 1, right);
        return root;
    }


    void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        BInaryTreeConstructFromINorderPREorder solution = new BInaryTreeConstructFromINorderPREorder();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = solution.buildTree(preorder, inorder);

        System.out.println("Inorder traversal of constructed tree:");
        solution.printInorder(root);
    }
}
