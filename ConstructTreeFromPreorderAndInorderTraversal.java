
// Time Complexity : O(n)
// Space Complexity : O(n)
import java.util.*;

class TreeNode {
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

public class ConstructTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        buildTree(preorder, inorder);
    }

    private static int preIndex = 0;
    static Map<Integer, Integer> hmap;

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        int start = 0;
        int end = preorder.length - 1;
        hmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            hmap.put(inorder[i], i);
        }
        return constructTree(preorder, inorder, start, end);
    }

    private static TreeNode constructTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end)
            return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int index = hmap.get(root.val);
        root.left = constructTree(preorder, inorder, start, index - 1);
        root.right = constructTree(preorder, inorder, index + 1, end);
        return root;
    }

}
