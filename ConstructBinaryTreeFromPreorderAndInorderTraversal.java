import java.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    //  Definition for a binary tree node.
    public class TreeNode {
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

    Map<Integer, Integer> map;
    int preOrderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {

        // base
        if (start > end) {
            return null;
        }

        int rootVal = preorder[preOrderIndex];
        preOrderIndex++;

        TreeNode root = new TreeNode(rootVal);

        //  Find root index in inorder array
        int rootIndex = map.get(rootVal);

        root.left = helper(preorder, start, rootIndex - 1);
        root.right = helper(preorder, rootIndex + 1, end);

        return root;
    }
}
